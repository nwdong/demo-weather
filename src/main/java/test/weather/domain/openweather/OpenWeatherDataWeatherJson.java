package test.weather.domain.openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Json class used to parse main weather information from api.openweathermap.org
 * 
 * @author William Dong
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherDataWeatherJson {

	private Long id;
	
	String main;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}
	
}
