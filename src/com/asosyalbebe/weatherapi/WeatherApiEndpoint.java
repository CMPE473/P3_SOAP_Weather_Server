package com.asosyalbebe.weatherapi;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

/**
 * Definition of our little lovely weather api.
 * 
 * @author sedrik
 * 
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface WeatherApiEndpoint {

	@WebMethod(action = "GetWeather")
	public List<Weather> getWeather(String city);

}
