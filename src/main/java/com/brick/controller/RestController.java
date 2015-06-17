package com.brick.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1/encode")
public class RestController {

	@RequestMapping("")
	ResponseEntity<?> generateMd5Password(@RequestParam(value="password", required=true) String password ) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.encode(password);
		boolean matched=encoder.matches( password, "$2a$10$gUdwhYZ.zQertM89TdKVberb54XeCQ/XO/fsqJgR1JRJWcXG/SlSi");
		return new ResponseEntity<>(result, null, HttpStatus.OK);
	}
	
}
