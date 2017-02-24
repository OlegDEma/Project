package flowers.service;

import java.util.List;

import flowers.entity.Sale;

public interface SaleService {
	
	void save(Sale sale);
	List<Sale> findAll();
	Sale findOne(int id);
	void delete(int id);


}
