package flowers.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import flowers.entity.Purchase;
import flowers.entity.Sale;

public interface SaleDao extends JpaRepository<Sale, Integer>{
	

}
