package test.weather.domain.openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Json class used to parse wind data from api.openweathermap.org
 * 
 * @author William Dong
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherDataWindJson {

	private Long speed;

	public Long getSpeed() {
		return speed;
	}

	public void setSpeed(Long speed) {
		this.speed = speed;
	}
	
	
}
