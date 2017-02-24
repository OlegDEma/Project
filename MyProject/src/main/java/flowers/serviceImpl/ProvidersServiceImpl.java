package flowers.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import flowers.dao.ProvidersDao;
import flowers.entity.Providers;
import flowers.service.ProvidersService;

@Service("providersService")
public class ProvidersServiceImpl implements ProvidersService {

	@Autowired
	private ProvidersDao providersDao;
	
	public void save(Providers providers) {
		providersDao.save(providers);
		
	}

	public List<Providers> findAll() {
		return providersDao.findAll();
	}

	public Providers findOne(int id) {
		return providersDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {
		providersDao.delete(id);
		
	}

}
