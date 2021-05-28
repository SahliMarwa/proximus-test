package com.proximus.backend.proximusBackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proximus.backend.proximusBackend.model.Canal;
import com.proximus.backend.proximusBackend.service.CanalService;

@RestController
@RequestMapping("/proximus/canal")
public class CanalController {
	
	@Autowired
	private CanalService canalService;
	//public CanalController(CanalService canalService) {
	//	this.canalService = canalService;
	//}
	
	@RequestMapping(value = "/all", produces = "application/json", method = RequestMethod.GET)	
	public List<Canal> getAllCanals(){
		return this.canalService.getAllCanals();
	}
	@RequestMapping(value = "/validate/{canalId}", produces = "application/json", method = RequestMethod.PUT)	
	public  Canal validateCanal(@PathVariable Long canalId){
		List<Canal> listCanal =  this.canalService.getAllCanals();
		Optional<Canal> canalToUpdate = listCanal.stream().filter(x->x.getId()==canalId).findFirst();
		if(canalToUpdate.isPresent()) {
			canalToUpdate.get().setAvailability(true);
		}
		
		return canalToUpdate.get();
 
	}
	@RequestMapping(value = "/disvalidate/{canalId}", produces = "application/json", method = RequestMethod.PUT)	
	public Canal disValidateCanal(@PathVariable Long canalId){
		List<Canal> listCanal =  this.canalService.getAllCanals();
		Optional<Canal> canalToUpdate = listCanal.stream().filter(x->x.getId()==canalId).findFirst();
		if(canalToUpdate.isPresent()) {
			canalToUpdate.get().setAvailability(false);
		}
		
		return canalToUpdate.get();	}
}
