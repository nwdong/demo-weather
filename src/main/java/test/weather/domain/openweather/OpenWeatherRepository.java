package test.weather.domain.openweather;

public interface OpenWeatherRepository {
	
	/**
	 * api.openweathermap.org RESTful API consumer
	 * 
	 * @param openWeatherCityId
	 * @return
	 */
	OpenWeatherDataJson getWeather(Long openWeatherCityId);

}
