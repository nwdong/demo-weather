package test.weather.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="open_weather_cities")
public class OpenWeatherCityMap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(optional=false)
	@JoinColumn(name="city_id", unique=true, nullable=false)
	private City city;
	
	@Column(name="open_weather_city_id")
	private Long openWeatherCityId;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Long getOpenWeatherCityId() {
		return openWeatherCityId;
	}

	public void setOpenWeatherCityId(Long openWeatherCityId) {
		this.openWeatherCityId = openWeatherCityId;
	}
	
	

}
