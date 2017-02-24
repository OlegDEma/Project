package flowers.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import flowers.dao.DeliveryDao;
import flowers.entity.Delivery;
import flowers.service.DeliveryService;

@Service("deliveryService")
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired
	private DeliveryDao deliveryDao;

	public void save(Delivery delivery) {
		deliveryDao.save(delivery);
		
	}

	public List<Delivery> findAll() {
		return deliveryDao.findAll();
	}

	public Delivery findOne(int price) {
		return findOne(price);
	}
	@Transactional
	public void delete(int price) {
		deliveryDao.delete(price);
		
	}

}
