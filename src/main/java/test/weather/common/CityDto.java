package test.weather.common;

/**
 * it's used to support RESTful API to return city informatin in JSON format 
 * 
 * @author William Dong
 *
 */
public class CityDto {

	private Long id;
	
	private String name;

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
	
	
	
}
