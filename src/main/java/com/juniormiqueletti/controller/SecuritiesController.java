package com.juniormiqueletti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juniormiqueletti.model.Securities;

@Controller
@RequestMapping("/securities")
public class SecuritiesController {

	@RequestMapping("/new")
	public String newRegister(){
		return "SecuritiesRegister";
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public String save(Securities securities){
		
		System.out.println("securities:"+ securities.getDescription());
		
		return "SecuritiesRegister";
	}
}
