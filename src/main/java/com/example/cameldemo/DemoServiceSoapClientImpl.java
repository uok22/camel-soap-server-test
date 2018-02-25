package com.example.cameldemo;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DemoServiceSoapClientImpl implements DemoServiceSoapClient {

	@Override
	public String getSoapService(DemoPayloadObject demoPayloadObject) {

		RestTemplate restTemplate = new RestTemplate();
		Object object2 = restTemplate.postForObject("http://localhost:57575/kappas",
													"posti: katitmukaan", String.class);

		System.out.println("1. ----  ::  SOAP SERVICE :: CLIENT :: q :: " + demoPayloadObject.getName());
		return "5. soap service returned : " + object2.toString();
	}

}
