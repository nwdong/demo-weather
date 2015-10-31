package test.weather.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import test.weather.common.CurrentWeatherDto;
import test.weather.domain.City;
import test.weather.domain.CityRepository;
import test.weather.domain.openweather.OpenWeatherDataJson;
import test.weather.domain.openweather.OpenWeatherDataWeatherJson;
import test.weather.domain.openweather.OpenWeatherRepository;
import test.weather.common.Constants;

@Component
@PropertySource(value={"classpath:application.properties"})
public class CurrentWeatherServiceOpenWeatherImpl implements CurrentWeatherService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CityRepository cityDao;
	
	@Autowired
	OpenWeatherRepository openWeatherDao;
	
	@Value("${openweather.temperature.unit}")
    private String tempUnit;
	
	@Value("${openweather.wind.unit}")
    private String windUnit;
	
	@Value("${time.format}")
    private String timeFormat;

	@Override
	public CurrentWeatherDto getCurrentWeather(Long cityId) {
		
		City city = cityDao.findOne(cityId);
		
		// get the city id used by OpenWeather
		Long openWeatherCityId = city.getOpenWeatherCity().getOpenWeatherCityId();
		
		// retrieve weather information through OpenWeather RESTful API
		OpenWeatherDataJson rawData = openWeatherDao.getWeather(openWeatherCityId);
		
		// build CurrentWeatherDto based on the raw data from OpenWeather
		CurrentWeatherDto data = new CurrentWeatherDto();
		
		// set name
		data.setName(city.getName());
		
		// set temparature
		data.setTemperature(rawData.getMain().getTemp() + tempUnit);
		
		// set update time
		DateFormat formatter = new SimpleDateFormat(timeFormat);
		long milliSeconds= rawData.getDt() * 1000;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		data.setTime(formatter.format(calendar.getTime()));
		
		// set weather
		List<OpenWeatherDataWeatherJson> weatherList = rawData.getWeather();
		data.setWeather(weatherList.get(0).getMain());
		
		// set wind speed
		data.setWind(rawData.getWind().getSpeed() + windUnit);
		
		log.debug("current weather(" + data.getName() + ", " + data.getTime() + ", " + data.getWeather() + ", " + data.getTemperature() + ", " + data.getWind());
		
		return data;
	}

}
