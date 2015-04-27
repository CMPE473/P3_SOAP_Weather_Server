package com.asosyalbebe.weatherapi;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.asosyalbebe.weatherapi.service.WeatherService;

/**
 * Implementation of the WeatherApi endpoint.
 * 
 * @author sedrik
 * 
 */
@WebService(endpointInterface = "com.asosyalbebe.weatherapi.WeatherApiEndpoint")
public class WeatherApiEndpointImpl implements WeatherApiEndpoint {

	private WeatherService weatherService;
	private Logger log = Logger.getLogger(getClass());

	@PostConstruct
	public void init() {
		weatherService = new WeatherService();
		log.info("WeatherApiEndpointImpl created!");
	}

	@Override
	public List<Weather> getWeather(String city) {
		log.info("getting forecast for " + city);
		return weatherService.getForecast(city);
	}

}
