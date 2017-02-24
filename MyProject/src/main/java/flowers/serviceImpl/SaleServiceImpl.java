package flowers.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import flowers.dao.SaleDao;
import flowers.entity.Sale;
import flowers.service.SaleService;

@Service("saleService")
public class SaleServiceImpl implements SaleService{

	@Autowired
	private SaleDao saleDao;
	
	public void save(Sale sale) {
		saleDao.save(sale);
		
	}

	public List<Sale> findAll() {
		return saleDao.findAll();
	}

	public Sale findOne(int number) {
		return saleDao.findOne(number);
	}

	@Transactional
	public void delete(int number) {
		saleDao.delete(number);
		
	}

}
