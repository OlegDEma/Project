package flowers.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import flowers.entity.Flowers;
import flowers.entity.VudOfFlower;
import flowers.service.FlowersService;
import flowers.service.VudOfFlowerService;

@Controller
public class FlowersController {
	
	@Autowired
	private FlowersService flowersService;
	@Autowired
	private VudOfFlowerService vudService;
	
//	@Autowired 
//	private VudOfFlowerService vudOfFlowerService;
//	
//	@InitBinder
//	public void InitBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(VudOfFlower.class, new AuthorEditor(authorService));
//	}
	
	@RequestMapping(value = "/newFlowers", method = RequestMethod.GET)
	public String newFlowers(Model model) {
		model.addAttribute("flowers",flowersService.findAll());
		model.addAttribute("flower", new Flowers());
		model.addAttribute("vuds",vudService.findAll());
		return "views-admin-newFlowers";
	}
	@RequestMapping(value = "/saveFlowers", method = RequestMethod.POST)
	public String saveFlowers(@ModelAttribute Flowers flower,@RequestParam int id) {
		VudOfFlower vudOfFlower = vudService.findOne(id);
		flower.setVudOfFlower(vudOfFlower);
		flowersService.save(flower);

		return "redirect:/newFlowers";
	}
	
	@RequestMapping(value = "/deleteFlowers/{id}", method = RequestMethod.GET)
	public String deleteFlowers(@PathVariable int id ) {


		flowersService.delete(id);
		

		return "redirect:/newFlowers";
	}
	
	@RequestMapping(value = "/saveFlowerImage", method = RequestMethod.POST)
    public String saveFlowerImage(Principal principal,@RequestParam MultipartFile image,@RequestParam("id") int id) {
		flowersService.saveFlowerImage(principal,image, id);
//		
        return "redirect:/newFlowers";
    }


}
