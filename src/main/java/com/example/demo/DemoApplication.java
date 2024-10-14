package com.example.demo;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

	@RequestMapping(value = "/echo", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Map<String, Object> echoJson(@RequestBody Map<String, Object> input) {
        return input;
    }

}
