package test.weather.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import test.weather.TestConstants;
import test.weather.WeatherApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WeatherApplication.class })
@WebAppConfiguration
public class OpenWeatherRepositoryTest {
	
	@Autowired
	OpenWeatherRepository openWeatherDao;
	
	@Test
	public void testGetWeather() {
		
		OpenWeatherDataJson data = openWeatherDao.getWeather(TestConstants.OPEN_WEATHER_CITY_ID_MELBOURNE);
		
		// time is retrieved
		assertNotNull(data.getDt());
		
		// main weather info is retrieved
		assertNotEquals(0, data.getWeather().size());
		
		// temperature is retrieved
		assertNotNull(data.getMain().getTemp());
		
		// wind speed is retrieved
		assertNotNull(data.getWind().getSpeed());
	}

}
