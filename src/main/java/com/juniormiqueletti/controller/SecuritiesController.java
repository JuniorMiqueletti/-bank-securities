package com.juniormiqueletti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecuritiesController {

	@RequestMapping("/securities/new")
	public String newRegister(){
		return "SecuritiesRegister";
	}
}
