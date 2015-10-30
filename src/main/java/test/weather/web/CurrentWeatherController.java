package test.weather.web;

import java.security.Principal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.weather.common.Constants;
import test.weather.common.CurrentWeatherDto;


@RestController
public class CurrentWeatherController {
	
	@RequestMapping(value = Constants.CURRENT_WEATHER_URI_ROOT + "/{cityId}", method = RequestMethod.GET)
	CurrentWeatherDto readAccountByAccountId(Principal principal,
			@PathVariable long accountId) {

		return null;

	}
}
