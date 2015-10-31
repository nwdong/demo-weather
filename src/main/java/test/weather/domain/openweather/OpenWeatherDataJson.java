package test.weather.domain.openweather;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Json class used to parse data from api.openweathermap.org
 * 
 * @author William Dong
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherDataJson {

	// Time of data calculation, unix, UTC
	Long dt;
	
	//
	List<OpenWeatherDataWeatherJson> weather;
	
	OpenWeatherDataMainJson main;
	
	OpenWeatherDataWindJson wind;

	public Long getDt() {
		return dt;
	}

	public void setDt(Long dt) {
		this.dt = dt;
	}

	public List<OpenWeatherDataWeatherJson> getWeather() {
		return weather;
	}

	public void setWeather(List<OpenWeatherDataWeatherJson> weather) {
		this.weather = weather;
	}

	public OpenWeatherDataMainJson getMain() {
		return main;
	}

	public void setMain(OpenWeatherDataMainJson main) {
		this.main = main;
	}

	public OpenWeatherDataWindJson getWind() {
		return wind;
	}

	public void setWind(OpenWeatherDataWindJson wind) {
		this.wind = wind;
	}
	
	
	
	
	
}
