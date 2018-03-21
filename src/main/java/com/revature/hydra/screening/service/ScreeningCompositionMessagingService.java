package com.revature.hydra.screening.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.revature.beans.SimpleTrainee;

@Service	
public class ScreeningCompositionMessagingService {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;

	private static final String SINGLE_TRAINEE_ROUTING_KEY = "JyoH3uRmktGn9MnW";
	
	private static final Logger log = LoggerFactory.getLogger(ScreeningCompositionMessagingService.class);
	
	/**
	 * RabbitMQ Exchange Name
	 * 
	 */
	private static final String RABBIT_REPO_EXCHANGE = "revature.hydra.repos";
	
	@Scheduled(fixedDelay = 3000L)
	public SimpleTrainee sendSingleTraineeRequest(Integer traineeId) {
		JsonObject traineeRequest = new JsonObject();
		
		traineeRequest.addProperty("methodName", "findOne");
		traineeRequest.addProperty("traineeId", traineeId);
		
		SimpleTrainee st =  (SimpleTrainee)rabbitTemplate.convertSendAndReceive(RABBIT_REPO_EXCHANGE,
				SINGLE_TRAINEE_ROUTING_KEY,
				traineeRequest.toString());
		log.info(st.toString());
		return st;
	}
	
}

