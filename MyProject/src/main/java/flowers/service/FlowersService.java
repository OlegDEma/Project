package flowers.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import flowers.entity.Flowers;

public interface FlowersService {
	
	void save(Flowers flowers);
	List<Flowers> findAll();
	void delete(int id);
	Flowers findOne(int id);
	public void saveFlowerImage(Principal principal,MultipartFile multipartFile,int id);
	List<Flowers> findAllByPriceDESC();
    List<Flowers> findAllByPriceESC();
	

}
