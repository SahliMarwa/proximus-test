package service;

import java.util.List;
import model.Canal;

public class CanalServiceImpl implements CanalService {

	@Override
	public List<Canal> getAllCanals() {
		// TODO Auto-generated method stub
		return null;
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
