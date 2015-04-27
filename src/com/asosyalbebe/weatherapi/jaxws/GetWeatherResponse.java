
package com.asosyalbebe.weatherapi.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getWeatherResponse", namespace = "http://weatherapi.asosyalbebe.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWeatherResponse", namespace = "http://weatherapi.asosyalbebe.com/")
public class GetWeatherResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.asosyalbebe.weatherapi.Weather> _return;

    /**
     * 
     * @return
     *     returns List<Weather>
     */
    public List<com.asosyalbebe.weatherapi.Weather> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.asosyalbebe.weatherapi.Weather> _return) {
        this._return = _return;
    }

}
