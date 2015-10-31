package test.weather.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import test.weather.TestConstants;
import test.weather.WeatherApplication;
import test.weather.common.Constants;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WeatherApplication.class })
@WebAppConfiguration
public class CurrentWeatherControllerTest {

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetCurrentWeather() throws Exception {

		// 2 is the id of Melbourne, 1 for Sydney and 3 for Wollongong
		mvc.perform(get(Constants.CURRENT_WEATHER_URI_ROOT + "/2"))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(TestConstants.CONTENT_TYPE_JSON))
				.andExpect(jsonPath("city").value("Melbourne"))
				.andExpect(jsonPath("time").exists())
				.andExpect(jsonPath("weather").exists())
				.andExpect(jsonPath("temperature").exists())
				.andExpect(jsonPath("wind").exists());
	}

}
