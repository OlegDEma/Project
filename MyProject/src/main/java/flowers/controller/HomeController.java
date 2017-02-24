package flowers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import flowers.dto.DtoUtilMapper;
import flowers.dto.FlowersDTO;
import flowers.entity.Flowers;
import flowers.entity.User;
import flowers.service.FlowersService;
import flowers.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

	
	@Autowired
	private FlowersService flowersService;
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model,Principal principal) {
		model.addAttribute("flowers", DtoUtilMapper.flowersToflowersDTO(flowersService.findAll()));
		if (principal == null ) {
			model.addAttribute("ban", 2);
		}else if(principal.getName().equalsIgnoreCase("admin")){
			model.addAttribute("ban", 0);
		}else if(userService.findOne(Integer.parseInt(principal.getName())).isBan()){
			model.addAttribute("ban", 1);
		}else{
			model.addAttribute("ban", 0);
		}
		
		
		return "views-base-home";
				
		
	}
	
	@RequestMapping(value = "/about")
	public String about() {
		
		return "views-base-about";
	}
	
	@RequestMapping(value = "/category")
	public String category(Model model) {
		model.addAttribute("flowers",flowersService.findAll());		
		
		return "views-base-category";
	}
	
	@RequestMapping(value = "/cart")
	public String cart() {
		
		return "views-base-cart";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String loginprocesing(@RequestParam String username) {
		if (username.equalsIgnoreCase("admin")) {
			return "redirect:/home";
		} else {
			List<User> users = userService.findAll();
			User user = null;
			for (User user2 : users) {
				if (user2.getName().equalsIgnoreCase(username)) {
					user = user2;
				}
			}
			if (user.isBan()) {
				return "redirect:/loginpage";				
			}else{
				return "redirect:/home";
			}
		}
		
	}

	@RequestMapping("/loginpage")
	public String login() {
		return "views-base-loginpage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {

		return "redirect:/";
	}

	@RequestMapping(value = "/some", method = RequestMethod.GET)
	public String some() {

//		return "redirect:/HTMLpages/some.html";
		return "views-admin-some";
	}
	
	@RequestMapping(value = "/specials", method = RequestMethod.GET)
	public String specials() {
		return "views-base-specials";
	}
	
	@RequestMapping(value = "/price", method = RequestMethod.GET)
	public String price() {
		return "views-base-price";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "views-base-contact";
	}
	
	
	@RequestMapping(value = "/sort", method = RequestMethod.GET)
	public @ResponseBody List<FlowersDTO> sort() {

			return DtoUtilMapper.flowersToflowersDTO(flowersService.findAllByPriceDESC());
				
	}
	
	@RequestMapping(value = "/loadFlowers", method = RequestMethod.GET)
    public @ResponseBody List<FlowersDTO> loadFlowers(String id) {
		if(id.equals("1")){
			return DtoUtilMapper.flowersToflowersDTO(flowersService.findAllByPriceESC());
			
		}else if(id.equals("2")){
			return DtoUtilMapper.flowersToflowersDTO(flowersService.findAllByPriceDESC());
		}else if(id.equals("3")){
			return DtoUtilMapper.flowersToflowersDTO(flowersService.findAll());
		}else{
			
			return DtoUtilMapper.flowersToflowersDTO(flowersService.findAllByPriceDESC());
		}


}
	
	

}
