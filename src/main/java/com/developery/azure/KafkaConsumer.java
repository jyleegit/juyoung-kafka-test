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

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

	@Autowired
	private final TestClient client;
	
	@KafkaListener(topics = "hub1", groupId = "myGroup1")
    public void consume(ParaVO data) {
		
		log.info("end1");
		
		ResponseEntity<String> resp = client.sendMailApp(data);
		log.info("end11");
    }
	
	
	@KafkaListener(topics = "hub1.dlt", groupId = "myGroup1")
    public void dltConsume(ParaVO data) {
		
		log.info("end2");
		
		ResponseEntity<String> resp = client.sendMailApp(data);
		log.info("end22");
    }
}
