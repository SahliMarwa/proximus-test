package service;

import java.util.List;

import org.springframework.stereotype.Service;
import model.Canal;

@Service
public interface CanalService {
	List<Canal> getAllCanals();
	Canal validateCanal(Canal canal);
	Canal disValidateCanal(Canal canal);
}
