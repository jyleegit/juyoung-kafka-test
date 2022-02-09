package com.developery.azure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import com.developery.azure.TestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

	@Autowired
	private final TestClient client;
	
	@KafkaListener(topics = "hub1", groupId = "myGroup1")
    public void consume(String data) throws JsonMappingException, JsonProcessingException {
		
		log.info("end1");
		ObjectMapper mapper = new ObjectMapper();
		ParaVO paraObject = mapper.readValue(data, ParaVO.class);
		
		ResponseEntity<String> resp = client.sendMailApp(paraObject);
		log.info("end11");
    }
	
	/*
	@KafkaListener(topics = "hub1.dlt", groupId = "myGroup1")
    public void dltConsume(String data) throws JsonMappingException, JsonProcessingException {
		
		log.info("end2");
		ObjectMapper mapper = new ObjectMapper();
		ParaVO paraObject = mapper.readValue(data, ParaVO.class);
		
		ResponseEntity<String> resp = client.sendMailApp(paraObject);
		log.info("end22");
    }
    */
}
