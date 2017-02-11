package com.juniormiqueletti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juniormiqueletti.model.Securities;
import com.juniormiqueletti.repository.SecuritiesRepository;

@Controller
@RequestMapping("/securities")
public class SecuritiesController {

	@Autowired
	private SecuritiesRepository securitiesRespository;
	
	@RequestMapping("/new")
	public String newRegister(){
		return "SecuritiesRegister";
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public String save(Securities securities){
		
		securitiesRespository.save(securities);
		
		return "SecuritiesRegister";
	}
}
