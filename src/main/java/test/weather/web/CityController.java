package test.weather.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.weather.common.CityDto;
import test.weather.common.Constants;
import test.weather.service.CityService;

/**
 * RESTful API controller for city information
 * 
 * @author William Dong
 *
 */
@RestController
public class CityController {
	
	@Autowired
	CityService cityService;
	
	@RequestMapping(value = Constants.CITY_LIST_URI, method = RequestMethod.GET)
	List<CityDto> getCityList() {

		return cityService.getCityList();

	}


}
