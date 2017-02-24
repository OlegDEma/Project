package flowers.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import flowers.entity.Sale;
import flowers.entity.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {
	

}
