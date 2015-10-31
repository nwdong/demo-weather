package test.weather.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.weather.common.CityDto;
import test.weather.domain.City;
import test.weather.domain.CityRepository;

@Component
public class CityServiceImpl implements CityService {
	
	@Autowired
	CityRepository cityDao;

	@Override
	public List<CityDto> getCityList() {
		
		List<CityDto> result = new ArrayList<>();
		
		Iterable<City> cityList = cityDao.findAll();
		
		for(City city : cityList) {
			
			CityDto cityDto = new CityDto();
			
			cityDto.setId(city.getId());
			
			// I18N can be introduced here
			cityDto.setName(city.getName());
			
			result.add(cityDto);
			
		}
		
		return result;
	}

}
