package com.asosyalbebe.weatherapi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.asosyalbebe.weatherapi.Weather;

/**
 * Get weather from a JSON API
 * 
 * @author sedrik
 * 
 */
public class WeatherService {
	private static final String FORECAST_API_URL = "http://api.wunderground.com/api/e886fd4c668db4fd/forecast10day/q/CA/%s.json";

	private Logger log = Logger.getLogger(getClass());

	public List<Weather> getForecast(String cityName) {
		List<Weather> forecast = new ArrayList<Weather>();

		String encodedCityName = urlEncode(cityName);
		String url = String.format(FORECAST_API_URL, encodedCityName);

		try {
			JSONObject json = getJSON(url);

			if (json.has("forecast")) {
				JSONObject forecastObj = json.getJSONObject("forecast");
				if (forecastObj.has("simpleforecast")) {
					JSONObject simpleForecast = forecastObj.getJSONObject("simpleforecast");
					if (simpleForecast.has("forecastday")) {
						JSONArray forecastDay = simpleForecast.getJSONArray("forecastday");
						for (int i = 0; i < forecastDay.length(); i++) {
							JSONObject dailyForecastObj = forecastDay.getJSONObject(i);
							Weather weather = new Weather();

							if (dailyForecastObj.has("date")) {
								JSONObject dateObj = dailyForecastObj.getJSONObject("date");

								if (dateObj.has("epoch")) {
									long epoch = 1000L * dateObj.getLong("epoch");
									weather.setDate(new Date(epoch));
								}
							}

							if (dailyForecastObj.has("high")) {
								JSONObject highObj = dailyForecastObj.getJSONObject("high");
								if (highObj.has("celsius")) {
									double celsius = highObj.getDouble("celsius");
									weather.setHigh(celsius);
								}
							}

							if (dailyForecastObj.has("low")) {
								JSONObject lowObj = dailyForecastObj.getJSONObject("low");
								if (lowObj.has("celsius")) {
									double celsius = lowObj.getDouble("celsius");
									weather.setLow(celsius);
								}
							}

							if (dailyForecastObj.has("icon")) {
								String icon = dailyForecastObj.getString("icon");
								weather.setIcon(icon);
							}

							if (dailyForecastObj.has("icon_url")) {
								String iconUrl = dailyForecastObj.getString("icon_url");
								weather.setIconPath(iconUrl);
							}

							forecast.add(weather);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		log.info("Weather forecast for " + cityName + " is " + forecast);
		return forecast;
	}

	private JSONObject getJSON(String urlString) throws IOException {
		URL url = new URL(urlString);
		InputStream stream = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		StringBuilder sb = new StringBuilder();

		int character = -1;
		while ((character = reader.read()) != -1) {
			sb.append((char) character);
		}

		log.debug("json returned = " + sb.toString());
		return new JSONObject(sb.toString());
	}

	@SuppressWarnings("deprecation")
	private String urlEncode(String param) {
		param = param.replace(' ', '_');
		try {
			return URLEncoder.encode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
			return URLEncoder.encode(param);
		}
	}
}
