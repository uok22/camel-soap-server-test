package com.example.cameldemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping
	public String restIt() {
		return "heipparallaa !!";
	}
}
