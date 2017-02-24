package flowers.service;

import java.util.List;

import flowers.entity.Providers;

public interface ProvidersService {
	
	void save(Providers providers);
	List<Providers> findAll();
	Providers findOne(int id);
	void delete(int id);


}
