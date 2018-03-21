package com.revature.hydra.screening.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.SimpleTrainee;
import com.revature.hydra.screening.service.ScreeningCompositionService;

@RestController
@CrossOrigin
public class ScreeningController {

	private ScreeningCompositionService scs;

	@Autowired
	public void setScreeningCompositionService(ScreeningCompositionService scs) {
		this.scs = scs;
	}

	/*
	 * Screening controller endpoints
	 */
	
	/**
	 * Test to get one trainee
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/single", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimpleTrainee> getSingleTrainee(){
		SimpleTrainee trainee = scs.getOneTrainee(1);
		return new ResponseEntity<SimpleTrainee>(trainee, HttpStatus.OK);
	}
}
