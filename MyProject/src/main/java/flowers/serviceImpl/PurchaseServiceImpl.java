package flowers.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import flowers.dao.PurchaseDao;
import flowers.entity.Purchase;
import flowers.service.PurchaseService;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	private PurchaseDao purchaseDao;
	
	public void save(Purchase purchase) {
		purchaseDao.save(purchase);
	}

	public List<Purchase> findAll() {
		return purchaseDao.findAll();
	}

	public Purchase findOne(int id) {
		return purchaseDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {
		purchaseDao.delete(id);
		
	}

}
