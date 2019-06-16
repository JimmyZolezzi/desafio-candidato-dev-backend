package com.srmasset.thcepdetails;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ThCepDetailsApplicationTests {

	 @Autowired
	 private MockMvc mvc;
	
	@Test
	public void contextLoads() {
	
	}
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testeHystric() throws Exception {
		
		mvc.perform(get("/buscar-endereco-hystrix/01311000")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}

}
