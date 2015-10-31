package test.weather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherDataMainJson {
	
	private Long temp;

	public Long getTemp() {
		return temp;
	}

	public void setTemp(Long temp) {
		this.temp = temp;
	}
	
	

}
