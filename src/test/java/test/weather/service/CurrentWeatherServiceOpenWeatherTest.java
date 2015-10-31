package test.weather.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import test.weather.WeatherApplication;
import test.weather.common.CurrentWeatherDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WeatherApplication.class })
@WebAppConfiguration
public class CurrentWeatherServiceOpenWeatherTest {
	
	@Autowired
	CurrentWeatherService currentWeatherService;
	
	@Test
	public void testGetCurrentWeather() {
		
		CurrentWeatherDto dto = currentWeatherService.getCurrentWeather(2L);
		
		assertNotNull(dto.getName());
		
		assertNotNull(dto.getTemperature());
		
		assertNotNull(dto.getTime());
		
		assertNotNull(dto.getWeather());
		
		assertNotNull(dto.getWind());
		
	}

}
