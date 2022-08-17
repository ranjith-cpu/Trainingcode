 package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DbsPersons;
import com.example.demo.repo.Personrepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 


@Service
public class Personservice {
	
@Autowired
Personrepo pr;

public List<DbsPersons> getAllPersons(){
	return pr.fetchAllPersons();
	
}

public String addPd(DbsPersons dp) {
	// TODO Auto-generated method stub
	 return pr.addaNewTuple(dp);
	
	
}

public String updaterow(DbsPersons dp) {
	// TODO Auto-generated method stub
	return pr.updateTupleName(dp);
}

	
	
	

}
