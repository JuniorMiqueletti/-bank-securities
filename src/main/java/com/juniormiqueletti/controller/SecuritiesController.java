package com.juniormiqueletti.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.juniormiqueletti.model.Securities;
import com.juniormiqueletti.model.Status;
import com.juniormiqueletti.repository.SecuritiesRepository;

@Controller
@RequestMapping("/securities")
public class SecuritiesController {

	@Autowired
	private SecuritiesRepository securitiesRespository;
	
	@RequestMapping("/new")
	public ModelAndView newRegister(){
		ModelAndView mv = new ModelAndView("SecuritiesRegister");
		mv.addObject(new Securities());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated Securities securities, Errors errors, RedirectAttributes attributes){
		
		if(errors.hasErrors()){
			return "SecuritiesRegister";
		}
		
		securitiesRespository.save(securities);
		
		attributes.addFlashAttribute("message","Successfully saved!!!");
		
		return "redirect:/securities/new";
	}
	
	@RequestMapping
	public ModelAndView search(){
		List<Securities> allSecurities = securitiesRespository.findAll();
		
		ModelAndView modelAndView = new ModelAndView("SecuritiesSearch");
		modelAndView.addObject("allSecurities", allSecurities);
		
		return modelAndView;
	}
	
	@ModelAttribute(name = "allStatus")
	public List<Status> status(){
		return Arrays.asList(Status.values());
	}
	
}
