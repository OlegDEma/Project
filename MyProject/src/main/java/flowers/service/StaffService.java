package flowers.service;

import java.util.List;

import flowers.entity.Staff;

public interface StaffService {
	
	void save(Staff staff);
	List<Staff> findAll();
	Staff findOne(int id);
	void delete(int id);


}
