package com.asosyalbebe.weatherapi.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getWeather", namespace = "http://weatherapi.asosyalbebe.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWeather", namespace = "http://weatherapi.asosyalbebe.com/")
public class GetWeather {

	@XmlElement(name = "city", namespace = "")
	private String city;

	/**
	 * 
	 * @return returns String
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * 
	 * @param arg0 the value for the arg0 property
	 */
	public void setCity(String city) {
		this.city = city;
	}

}
