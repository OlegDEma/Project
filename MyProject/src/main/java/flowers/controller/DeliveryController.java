package flowers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import flowers.entity.Delivery;
import flowers.entity.VudOfFlower;
import flowers.service.DeliveryService;
import flowers.service.VudOfFlowerService;

@Controller
public class DeliveryController {
	
	@Autowired
	private  DeliveryService deliveryService;
	
	
	@RequestMapping(value="/newDelivery",  method = RequestMethod.GET)
	public String newDelivery(Model model) {
		model.addAttribute("deliverys",deliveryService.findAll());
		model.addAttribute("delivery",new Delivery());
		return "views-admin-newDelivery";
	}
	
	@RequestMapping(value="/saveDelivery",method= RequestMethod.POST)
	public String saveDelivery(@ModelAttribute Delivery delivery){
		
		
		deliveryService.save(delivery);
		
		return "redirect:/newDelivery";		
	}
	
	@RequestMapping(value="/deleteDelivery/{id}",method= RequestMethod.GET)
	public String delete(@PathVariable int id){
		
		deliveryService.delete(id);
		
		return "redirect:/newDelivery";
		
	}
	

}
