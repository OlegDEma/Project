package flowers.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import flowers.entity.Providers;
import flowers.entity.Purchase;

public interface PurchaseDao extends JpaRepository<Purchase, Integer> {
	

}
