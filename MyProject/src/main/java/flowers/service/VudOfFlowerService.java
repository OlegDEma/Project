package flowers.service;

import java.util.List;

import flowers.entity.VudOfFlower;

public interface VudOfFlowerService {
	
	void save(VudOfFlower vudOfFlower);
	List<VudOfFlower> findAll();
	VudOfFlower findOne(int id);
	void delete(int id);


}
