package flowers.serviceImpl;


import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import flowers.dao.FlowersDao;
import flowers.entity.Flowers;
import flowers.entity.User;
import flowers.service.FlowersService;

@Service("flowersService")
public class FlowersServiceImpl implements FlowersService {

	@Autowired
	private FlowersDao flowersDao;
	
	public void save(Flowers flowers) {
		flowersDao.save(flowers);
		
	}

	public List<Flowers> findAll() {
		return flowersDao.findAll();
	}



	@Override
	public Flowers findOne(int id) {
		return flowersDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		flowersDao.delete(id);
		
	}
	@Transactional
	public void saveFlowerImage(Principal principal,MultipartFile multipartFile,int id) {

		 Flowers flower = flowersDao.findOne(id);

		String path = System.getProperty("catalina.home") + "/resources/" + flower.getName() + "/"
				+ multipartFile.getOriginalFilename();

		flower.setpImage("resources/" + flower.getName() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + flower.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
	}
	
	@Override
	public List<Flowers> findAllByPriceESC() {
		List<Flowers> flowers = flowersDao.findAll();
		Collections.sort(flowers,new Comparator<Flowers>() {
			@Override
			public int compare(Flowers o1, Flowers o2) {				
				return (int) (o1.getPrice() - o2.getPrice());
			}
		});		
		return flowers;
	}

	@Override
	public List<Flowers> findAllByPriceDESC() {
		List<Flowers> flowers = flowersDao.findAll();
		Collections.sort(flowers,new Comparator<Flowers>() {
			@Override
			public int compare(Flowers o1, Flowers o2) {				
				return (int) (o2.getPrice() - o1.getPrice());
			}
		});		
		return flowers;
	}



	


}
