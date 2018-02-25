package com.example.cameldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	private DemoServiceSoapClient demoServiceSoapClient;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String restIt() {
		return "heipparallaa !!";
	}

	@RequestMapping(value = "/soap", method = RequestMethod.POST)
	public String getSoapService(@RequestBody DemoPayloadObject requestObject) {
		System.out.println("0. DemoController :: req :: " + requestObject.getName());
		String o = demoServiceSoapClient.getSoapService(requestObject);
		return o;
	}
}
