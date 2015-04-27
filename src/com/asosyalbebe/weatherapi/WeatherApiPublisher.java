package com.asosyalbebe.weatherapi;

import javax.xml.ws.Endpoint;

/**
 * Main class of the project. Publishes the Weather Api
 * 
 * @author sedrik
 * 
 */
public class WeatherApiPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/weatherapi", new WeatherApiEndpointImpl());
	}
}
