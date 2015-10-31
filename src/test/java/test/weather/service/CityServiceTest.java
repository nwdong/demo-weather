package test.weather.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import test.weather.WeatherApplication;
import test.weather.common.CityDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WeatherApplication.class })
@WebAppConfiguration
public class CityServiceTest {
	
	@Autowired
	CityService cityService;
	
	@Test
	public void testGetCityList() {
		
		List<CityDto> list = cityService.getCityList();
		
		assertTrue(list.size()>2);
		
	}

}
