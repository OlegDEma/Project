package flowers.controller;

import org.hibernate.service.internal.ProvidedService;
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

import flowers.entity.Flowers;
import flowers.entity.Providers;
import flowers.entity.VudOfFlower;
import flowers.service.FlowersService;
import flowers.service.ProvidersService;
import flowers.service.VudOfFlowerService;

@Controller
public class ProvidersController {
	
	@Autowired
	private ProvidersService providersService;
	
//	@Autowired 
//	private VudOfFlowerService vudOfFlowerService;
//	
//	@InitBinder
//	public void InitBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(VudOfFlower.class, new AuthorEditor(authorService));
//	}
	
	@RequestMapping(value = "/newProviders", method = RequestMethod.GET)
	public String newFlowers(Model model) {
		model.addAttribute("providers",providersService.findAll());
		model.addAttribute("provider", new Providers());
		return "views-admin-newProviders";
	}
	@RequestMapping(value = "/saveProviders", method = RequestMethod.POST)
	public String saveFlowers(@ModelAttribute Providers provider) {

		providersService.save(provider);

		return "redirect:/newProviders";
	}
	
	@RequestMapping(value = "/deleteProviders/{id}", method = RequestMethod.GET)
	public String deleteFlowers(@PathVariable int id ) {


		providersService.delete(id);

		return "redirect:/newProviders";
	}


}
