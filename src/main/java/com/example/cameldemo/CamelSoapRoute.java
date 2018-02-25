package com.example.cameldemo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelSoapRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		from("cxf:bean:orderEndpoint")
				.transform(constant("OK"))
				.process(exchange -> {
					System.out.println();
				});
	}
}
