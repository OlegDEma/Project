package flowers.service;

import java.util.List;

import flowers.entity.Purchase;

public interface PurchaseService {
	
	void save(Purchase purchase);
	List<Purchase> findAll();
	Purchase findOne(int id);
	void delete(int id);


}
