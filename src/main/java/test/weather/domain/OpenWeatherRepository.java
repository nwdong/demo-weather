package test.weather.domain;

public interface OpenWeatherRepository {
	
	OpenWeatherDataJson getWeather(Long openWeatherCityId);

}
