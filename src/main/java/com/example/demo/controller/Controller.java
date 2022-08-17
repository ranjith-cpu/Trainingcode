package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DbsPersons;
import com.example.demo.service.Personservice;

@Component
@RestController
public class Controller {
	
	@Autowired
	Personservice ps;
	
	@RequestMapping("/all")
	public List<DbsPersons> getPersondetails()
	{
		return ps.getAllPersons();
	}
		
	@PostMapping("/add")
	public String addPersondetails(@RequestBody DbsPersons Dp ) {
	return ps.addPd(Dp);
	//return "Successfully added a tuple";
}
	@PutMapping("/update")
	public String updateATuple(@RequestBody DbsPersons Dp) {
		return ps.updaterow(Dp);
		
	}
}