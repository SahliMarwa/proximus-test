package com.proximus.backend.proximusBackend.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.net.URISyntaxException;
import java.net.URL;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.TypeDescription;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.proximus.backend.proximusBackend.model.Canal;

@Service
public class CanalServiceImpl implements CanalService {

	@Autowired
	ObjectMapper objectMapper;
	
	@Override
	public List<Canal> getAllCanals() {
		// TODO Auto-generated method stub
		List<Canal>  canalList= new ArrayList<Canal>();
		 URL resource = getClass().getClassLoader().getResource("ListCanals.json"); 
		try {
			JSONParser parser = new JSONParser();
			Object obj= parser.parse(new FileReader(resource.getPath()));
			
			canalList = objectMapper.readValue(obj.toString(), new TypeReference<List<Canal>>(){}) ;
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
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
