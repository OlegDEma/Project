package flowers.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import flowers.dao.VudOfFlowerDao;
import flowers.entity.VudOfFlower;
import flowers.service.VudOfFlowerService;

@Service("vudOfFlowerService")
public class VudOfFlowerServiceImpl implements VudOfFlowerService {
	
	@Autowired
	private VudOfFlowerDao vudOfFlowerDao;

	public void save(VudOfFlower vudOfFlower) {
		vudOfFlowerDao.save(vudOfFlower);
		
	}

	public List<VudOfFlower> findAll() {
		return vudOfFlowerDao.findAll();
	}

	public VudOfFlower findOne(int id) {
		return vudOfFlowerDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {
		vudOfFlowerDao.delete(id);
		
	}
}
