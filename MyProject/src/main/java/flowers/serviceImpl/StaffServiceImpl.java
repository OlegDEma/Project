package flowers.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flowers.dao.StaffDao;
import flowers.entity.Staff;
import flowers.service.StaffService;

@Service("staffService")
public class StaffServiceImpl implements StaffService{

	@Autowired
	private StaffDao staffDao;
	
	public void save(Staff staff) {
		staffDao.save(staff);
		
	}

	public List<Staff> findAll() {
		return staffDao.findAll();
	}

	public Staff findOne(int id) {
		return staffDao.findOne(id);
	}

	public void delete(int id) {
		staffDao.delete(id);
		
	}

}
