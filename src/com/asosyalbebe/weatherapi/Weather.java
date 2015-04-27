package com.asosyalbebe.weatherapi;

import java.util.Date;

public class Weather {
	private Double low;
	private Double high;
	private String icon;
	private String iconPath;
	private Date date;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Weather [low=");
		builder.append(low);
		builder.append(", high=");
		builder.append(high);
		builder.append(", icon=");
		builder.append(icon);
		builder.append(", iconPath=");
		builder.append(iconPath);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
