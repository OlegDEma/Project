package flowers.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import flowers.entity.Delivery;
import flowers.entity.Providers;

public interface ProvidersDao extends JpaRepository<Providers, Integer>{
	

}
