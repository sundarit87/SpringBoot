package com.unimoni.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unimoni.DTO.User;

@FeignClient("kafka-email-producer")
public interface KafkaNotificationFeignClient {
	
	 @RequestMapping(method = RequestMethod.POST, path = "/notify")
	    public ResponseEntity<User> notify(@RequestBody User input);

}
