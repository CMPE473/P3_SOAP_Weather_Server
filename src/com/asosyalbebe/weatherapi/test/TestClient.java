package com.asosyalbebe.weatherapi.test;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.asosyalbebe.weatherapi.WeatherApiEndpoint;

/**
 * Test class to see if the server works.
 * 
 * @author sedrik
 * 
 */
public class TestClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:9999/ws/weatherapi?wsdl");
		QName qname = new QName("http://weatherapi.asosyalbebe.com/", "WeatherApiEndpointImplService");

		Service service = Service.create(url, qname);

		WeatherApiEndpoint weatherEndpoint = service.getPort(WeatherApiEndpoint.class);

		System.out.println(weatherEndpoint.getWeather("istanbul"));
	}
}
