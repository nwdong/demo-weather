package test.weather.domain;

public interface OpenWeatherRepository {
	
	OpenWeatherDataJson getWeather(long openWeatherCityId);

}
