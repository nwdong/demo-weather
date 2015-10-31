package test.weather.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.weather.common.Constants;
import test.weather.common.CurrentWeatherDto;
import test.weather.service.CurrentWeatherService;


@RestController
public class CurrentWeatherController {
	
	@Autowired
	CurrentWeatherService currentWeatherService;
	
	@RequestMapping(value = Constants.CURRENT_WEATHER_URI_ROOT + "/{cityId}", method = RequestMethod.GET)
	CurrentWeatherDto getCurrentWeather(@PathVariable long cityId) {

		return currentWeatherService.getCurrentWeather(cityId);

	}
}
