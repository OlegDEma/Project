package flowers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import flowers.entity.VudOfFlower;
import flowers.service.VudOfFlowerService;


@Controller
public class VudOfFlowerController {

	@Autowired
	private VudOfFlowerService vudOfFlowerService;
	
	
	@RequestMapping(value="/newVudOfFlower",  method = RequestMethod.GET)
	public String newVudOfFlower(Model model) {
		model.addAttribute("vuds",vudOfFlowerService.findAll());
		model.addAttribute("vud",new VudOfFlower());
		return "views-admin-newVudOfFlower";
	}
	
	@RequestMapping(value="/saveVudOfFlower",method= RequestMethod.POST)
	public String saveVudOfFlower(@ModelAttribute VudOfFlower vud){
		
		
		vudOfFlowerService.save(vud);
		
		return "redirect:/newVudOfFlower";		
	}
	
	@RequestMapping(value="/deleteVudOfFlower/{id}",method= RequestMethod.GET)
	public String delete(@PathVariable int id){
		
		vudOfFlowerService.delete(id);
		
		return "redirect:/newVudOfFlower";
		
	}
}
