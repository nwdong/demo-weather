package test.weather.service;

import java.util.List;

import test.weather.common.CityDto;

public interface CityService {
	
	/**
	 * return list of CityDto for all cities in database
	 * 
	 * @return
	 */
	public List<CityDto> getCityList();

}
