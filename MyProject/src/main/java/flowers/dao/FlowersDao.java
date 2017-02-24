package flowers.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import flowers.entity.Flowers;
import flowers.entity.User;

public interface FlowersDao extends JpaRepository<Flowers, Integer>{
	


}
