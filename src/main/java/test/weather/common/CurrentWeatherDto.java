package test.weather.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * it's used to support RESTful API to return current weather informatin in JSON format 
 * 
 * @author William Dong
 *
 */
public class CurrentWeatherDto {
	
	private String name;
	
	private String time;
	
	private String weather;
	
	private String temperature;
	
	private String wind;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}
	
	

}
