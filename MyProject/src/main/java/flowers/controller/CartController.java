package flowers.controller;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import flowers.entity.Flowers;
import flowers.entity.User;
import flowers.service.UserService;

@Controller
public class CartController {
	@Autowired
    private UserService userService;


		@RequestMapping(value = "/cart", method = RequestMethod.GET)
		public String cart(Principal principal,Model model) {
//			model.addAttribute("users",userService.findOne());
//			System.out.println(principal.getName());
			int a =0;
			List<Flowers> flowers = userService.findOne(Integer.parseInt(principal.getName())).getFlowers();
			for (Flowers flowers2 : flowers) {
				a += flowers2.getPrice();
			}
			model.addAttribute("carts",userService.findOne(Integer.parseInt(principal.getName())).getFlowers());
			model.addAttribute("price",a);
			return "views-base-cart";
		}
		
		@RequestMapping(value = "/deleteCart/{id}", method = RequestMethod.GET)
		public String deleteFlowers(@PathVariable int id ,Principal principal) throws Exception {

			User user = userService.findOne(Integer.parseInt(principal.getName()));
			
			List<Flowers> flowers = user.getFlowers();
			
				Iterator<Flowers> iterator = flowers.iterator();
				while (iterator.hasNext()) {
					Flowers flowers2 = (Flowers) iterator.next();
					if(flowers2.getId()==id){
						iterator.remove();
					}
					
				}
				
				userService.update(user);
				
			

			return "redirect:/cart";
		}
		


}
