package test.weather.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import test.weather.TestConstants;
import test.weather.WeatherApplication;
import test.weather.common.Constants;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WeatherApplication.class })
@WebAppConfiguration
public class CityControllerTest {
	
	private MockMvc mvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testGetCityList() throws Exception {

		mvc.perform(get(Constants.CITY_LIST_URI))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(TestConstants.CONTENT_TYPE_JSON))
				.andExpect(jsonPath("$[0].name").exists());
	}

}
