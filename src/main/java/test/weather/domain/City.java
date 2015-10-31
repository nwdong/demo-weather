package test.weather.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import test.weather.common.Constants;
import test.weather.domain.openweather.OpenWeatherCityMap;

@Entity
@Table(name="cities")
public class City {
	
	// city id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	// city name
	// it's city name in English but can be used as I18N message key later if required
	@Column(name="name", nullable=false, length=Constants.CITY_NAME_LENGTH_MAX)
	private String name;
	
	// mapping to city id used by api.openweathermap.org
	@OneToOne(mappedBy="city", optional=false)
	OpenWeatherCityMap openWeatherCity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OpenWeatherCityMap getOpenWeatherCity() {
		return openWeatherCity;
	}

	public void setOpenWeatherCity(OpenWeatherCityMap openWeatherCity) {
		this.openWeatherCity = openWeatherCity;
	}

}
