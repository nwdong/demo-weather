package test.weather.domain.openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Json class used to parse temeprature data from api.openweathermap.org
 * 
 * @author William Dong
 *
 */
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
