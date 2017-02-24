package flowers.service;

import java.util.List;

import flowers.entity.Delivery;


public interface DeliveryService {

	void save(Delivery delivery);
	List<Delivery> findAll();
	Delivery findOne(int price);
	void delete(int price);

	
}
