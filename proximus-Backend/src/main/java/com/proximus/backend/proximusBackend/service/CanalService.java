package com.proximus.backend.proximusBackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.proximus.backend.proximusBackend.model.Canal;

public interface CanalService {
	List<Canal> getAllCanals();
	Canal validateCanal(Canal canal);
	Canal disValidateCanal(Canal canal);
}
