package test.weather.service;

import test.weather.common.CurrentWeatherDto;

public interface CurrentWeatherService {
	
	CurrentWeatherDto getCurrentWeather(Long cityId);

}
