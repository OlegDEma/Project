package flowers.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import flowers.entity.Delivery;
import flowers.entity.Flowers;

public interface DeliveryDao extends JpaRepository<Delivery, Integer>{


}
