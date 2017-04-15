package com.juniormiqueletti.controller;


import java.util.Arrays;
import java.util.List;

import com.juniormiqueletti.repository.filter.SecuritiesFilter;
import com.juniormiqueletti.service.SecuritiesRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.juniormiqueletti.model.Securities;
import com.juniormiqueletti.model.Status;
import com.juniormiqueletti.repository.SecuritiesRepository;

@Controller
@RequestMapping("/securities")
public class SecuritiesController {

	private static final String SECURITIES_REGISTER = "SecuritiesRegister";

	@Autowired
	private SecuritiesRepository repository;

	@Autowired
	private SecuritiesRegisterService service;
	
	@RequestMapping("/new")
	public ModelAndView newRegister(){
		ModelAndView mv = new ModelAndView(SECURITIES_REGISTER);
		mv.addObject(new Securities());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated Securities securities, Errors errors, RedirectAttributes attributes){
		
		if(errors.hasErrors()){
			return SECURITIES_REGISTER;
		}
		try {
			service.save(securities);

			attributes.addFlashAttribute("message", "Successfully saved!!!");

			return "redirect:/securities/new";
		}catch (IllegalArgumentException e){
			errors.reject("dueDate",null, e.getMessage());
			return SECURITIES_REGISTER;
		}
	}
	
	@RequestMapping
	public ModelAndView search(@ModelAttribute("filter") SecuritiesFilter filter){

		List<Securities> allSecurities = service.filter(filter);

		ModelAndView modelAndView = new ModelAndView("SecuritiesSearch");
		modelAndView.addObject("allSecurities", allSecurities);
		
		return modelAndView;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edition(@PathVariable("codigo") Securities securities){
		
		ModelAndView modelAndView = new ModelAndView(SECURITIES_REGISTER);

		modelAndView.addObject(securities);
		return modelAndView;
		
	}
	
	@RequestMapping(value ="{codigo}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("codigo") Long codigo, RedirectAttributes attributes){
		service.delete(codigo);
		
		attributes.addFlashAttribute("message","Successfully Deleted!!!");
		
		return "redirect:/securities";
	}
	
	@ModelAttribute(name = "allStatus")
	public List<Status> status(){
		return Arrays.asList(Status.values());
	}

	@RequestMapping(value ="/{codigo}/receive", method = RequestMethod.PUT)
	public @ResponseBody String receive(@PathVariable Long codigo){

		return service.receive(codigo);
	}

}
