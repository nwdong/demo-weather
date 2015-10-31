package test.weather.service;

import test.weather.common.CurrentWeatherDto;

public interface CurrentWeatherService {
	
	/**
	 * return current weather information based on city id
	 * 
	 * @param cityId
	 * @return
	 */
	CurrentWeatherDto getCurrentWeather(Long cityId);

}
