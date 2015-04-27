package com.asosyalbebe.weatherapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

/**
 * Implementation of the WeatherApi endpoint.
 * 
 * @author sedrik
 * 
 */
@WebService(endpointInterface = "com.asosyalbebe.weatherapi.WeatherApiEndpoint")
public class WeatherApiEndpointImpl implements WeatherApiEndpoint {

	@Override
	public List<Weather> getWeather(String city) {
		List<Weather> list = new ArrayList<Weather>();
		Weather w = new Weather();
		w.setLow(0d);
		w.setHigh(1d);
		w.setDate(new Date());
		w.setIcon("Rain");
		w.setIconPath("http://icons.wxug.com/i/c/k/rain.gif");
		list.add(w);
		return list;
	}

}
