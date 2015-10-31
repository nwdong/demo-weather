package test.weather.domain.openweather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import test.weather.common.Constants;

@Component
@PropertySource(value={"classpath:application.properties"})
public class OpenWeatherRepositoryImpl implements OpenWeatherRepository {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${openweather.api.url}")
    private String url;
	
	@Value("${openweather.api.key}")
    private String key;
	
	@Override
	public OpenWeatherDataJson getWeather(Long openWeatherCityId) {
		
		// generate RESTful API URL
		String apiUrl = url
				+ "?"
				+ key
				+ "&"
				+ "id=" + openWeatherCityId;
		
		log.debug("URL visited: " + apiUrl);

		// retrieve RESTful API
		RestTemplate restTemplate = new RestTemplate();
		
		OpenWeatherDataJson data = restTemplate.getForObject(apiUrl, OpenWeatherDataJson.class);
		
		return data;
	}

}
