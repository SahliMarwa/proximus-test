package service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Canal;

public class CanalServiceImpl implements CanalService {

	@Override
	public List<Canal> getAllCanals() {
		// TODO Auto-generated method stub
		List<Canal>  canalList= new ArrayList<Canal>();
		final ObjectMapper objectMapper = new ObjectMapper();
		try {
			canalList = objectMapper.readValue(new File("ListCanals.json"), new TypeReference<List<Canal>>(){}) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return canalList;
	}

	@Override
	public Canal validateCanal(Canal canal) {
		// TODO Auto-generated method stub
		canal.setAvailability(true);
		return canal;
	}

	@Override
	public Canal disValidateCanal(Canal canal) {
		// TODO Auto-generated method stub
		canal.setAvailability(false);
		return canal;
	}

}
