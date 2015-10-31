package test.weather.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import test.weather.common.Constants;

@Component
public class OpenWeatherRepositoryImpl implements OpenWeatherRepository {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public OpenWeatherDataJson getWeather(Long openWeatherCityId) {
		
		String apiUrl = Constants.OPEN_WEATHER_API_URL
				+ "?"
				+ Constants.OPEN_WEATHER_API_KEY
				+ "&"
				+ "id=" + openWeatherCityId;
		
		log.debug("URL visited: " + apiUrl);

		RestTemplate restTemplate = new RestTemplate();
		
		OpenWeatherDataJson data = restTemplate.getForObject(apiUrl, OpenWeatherDataJson.class);
		
		return data;
	}

}
