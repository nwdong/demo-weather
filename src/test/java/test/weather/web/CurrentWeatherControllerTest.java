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
public class CurrentWeatherControllerTest {
	
	private MockMvc mvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testGetCurrentWeather() throws Exception {

		// 2 is the id of Melbourne, 1 for Sydney and 3 for Wollongong
		mvc.perform(get(Constants.CURRENT_WEATHER_URI_ROOT + "/2"))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(TestConstants.CONTENT_TYPE_JSON))
				.andExpect(jsonPath("name").value("Melbourne"))
				.andExpect(jsonPath("time").exists())
				.andExpect(jsonPath("weather").exists())
				.andExpect(jsonPath("temperature").exists())
				.andExpect(jsonPath("wind").exists());
	}

}
