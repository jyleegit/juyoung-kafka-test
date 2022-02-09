package com.developery.azure;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	int count = 0;	
	
	public String insert(ParaVO data) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("hub1", data.toString());
		future.addCallback(successCallback -> {
			log.info("[producer] successCallback. partition: {},  offset: {}",
					successCallback.getRecordMetadata().partition(),
					successCallback.getRecordMetadata().offset());
			}, 
		errorCallback -> {
			log.error("[producer] errorCallback. msg: " + errorCallback.getMessage());
			}
		);
		return "Produced";
	}
}
