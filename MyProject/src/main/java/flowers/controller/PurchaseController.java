package flowers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import flowers.entity.Purchase;
import flowers.entity.VudOfFlower;
import flowers.service.PurchaseService;
import flowers.service.VudOfFlowerService;

public class PurchaseController {
	
	@Autowired
	private  PurchaseService purchaseService;
	
	
	@RequestMapping(value="/newPurchase",  method = RequestMethod.GET)
	public String newPurchase(Model model) {
		model.addAttribute("purchases",purchaseService.findAll());
		model.addAttribute("purchase",new Purchase());
		return "views-admin-newPurchase";
	}
	
	@RequestMapping(value="/savePurchase",method= RequestMethod.POST)
	public String savePurchase(@ModelAttribute Purchase purchase){
		
		
		purchaseService.save(purchase);
		
		return "redirect:/newPurchase";		
	}
	
	@RequestMapping(value="/deletePurchase/{id}",method= RequestMethod.GET)
	public String delete(@PathVariable int id){
		
		purchaseService.delete(id);
		
		return "redirect:/newPurchase";
		
	}

}
