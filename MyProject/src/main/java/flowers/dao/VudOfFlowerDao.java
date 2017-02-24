package flowers.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import flowers.entity.Staff;
import flowers.entity.VudOfFlower;

public interface VudOfFlowerDao extends JpaRepository<VudOfFlower, Integer> {
	

}
