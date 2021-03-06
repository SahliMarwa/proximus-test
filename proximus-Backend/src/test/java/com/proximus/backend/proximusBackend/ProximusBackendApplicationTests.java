package com.proximus.backend.proximusBackend;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.proximus.backend.proximusBackend.model.Canal;
import com.proximus.backend.proximusBackend.service.CanalService;

@SpringBootTest
class ProximusBackendApplicationTests {

	@Test
	void contextLoads() {
	}

    @MockBean
    private CanalService canalService;
	
	private List<Canal> canals =  new ArrayList<Canal>();
	

	@BeforeEach
	void init() {
		Canal canal1 = new Canal(1L, "Canal+ films", false);
		Canal canal2 = new Canal(1L, "Canal+ Series", true);
        canals.add(canal1);
        canals.add(canal2);	
	}
	
	@Test
	void getSizeOfListCanalsGTest() {
       when(canalService.getAllCanals()).thenReturn(canals);
       assertEquals(canalService.getAllCanals().size(),2);
	}
	
	@Test
	void validateCanalTest() {
	   canals.get(0).setAvailability(true);
	   when(canalService.getAllCanals()).thenReturn(canals);
	   when(canalService.validateCanal(canals.get(0))).thenReturn(canals.get(0));
	   assertEquals(canalService.validateCanal(canals.get(0)).isAvailability(), true);
	   

	}
	
	@Test
	void disValidateCanalTest() {
	   canals.get(1).setAvailability(false);
	   when(canalService.getAllCanals()).thenReturn(canals);
	   when(canalService.disValidateCanal(canals.get(1))).thenReturn(canals.get(1));
	   assertEquals(canalService.disValidateCanal(canals.get(1)).isAvailability(), false);
	   

	}
	
	
}
