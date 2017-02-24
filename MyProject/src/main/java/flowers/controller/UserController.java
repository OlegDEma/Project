package flowers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import flowers.dto.DtoUtilMapper;
import flowers.entity.Delivery;
import flowers.entity.Flowers;
import flowers.entity.Role;
import flowers.entity.User;
import flowers.service.FlowersService;
import flowers.service.MailSenderService;
import flowers.service.UserService;
import flowers.validator.UserValidationMessages;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;
    
    @Autowired
    FlowersService flowersService;

	private Role ROLE_USER;
	
	String Norm = "true";
	
	String Bad = "error";

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("userDTOs", DtoUtilMapper.usersToUsersDTO(userService.findAll()));
        model.addAttribute("user", new User());
        return "views-user-registration";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String newUser(@PathVariable int id) {

        userService.delete(id);

        return "redirect:/users";
    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Principal principal, Model model) {

        User user = userService.findOne(Integer.parseInt(principal.getName()));

        model.addAttribute("user", user);

        return "views-user-profile";
    }

   

    @RequestMapping(value = "/saveImage", method = RequestMethod.POST)
    public String saveImage(Principal principal,@RequestParam MultipartFile image) {

        userService.saveImage(principal, image);
        
        return "redirect:/profile"; 
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user, Model model) {

        String uuid = UUID.randomUUID().toString();

        user.setUuid(uuid);

        try {
            userService.save(user);
        } catch (Exception e) {
            if (e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.NAME_ALREADY_EXIST)) {
                model.addAttribute("usernameException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_EMAIl_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)) {
                model.addAttribute("emailException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)) {
                model.addAttribute("passwordException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_PHONE_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.PHONE_ALREADY_EXIST)) {
                model.addAttribute("phoneException", e.getMessage());
            }
            return "views-user-registration";
        }

        String theme = "thank's for registration";
        String mailBody =
                "gl & hf       http://localhost:8080/17_OrderWithCookie/confirm/" + uuid;

        mailSenderService.sendMail(theme, mailBody, user.getEmail());

        return "redirect:/";
    }

    @RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
    public String confirm(@PathVariable String uuid) {

        User user = userService.findByUUID(uuid);
        user.setEnabled(true);
        

        userService.update(user);

        return "redirect:/";
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String Users(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("user", new User());
        return "views-admin-users";
    }
    @RequestMapping(value = "/setUser", method = RequestMethod.GET)
    public String setUser(String id) throws Exception {


    	User user = userService.findOne(Integer.parseInt(id));
    	user.setRole(Role.ROLE_USER);
    	user.setEnabled(true);
    	userService.update(user);

        return "redirect:/users";
    }   
    @RequestMapping(value = "/setAdmin", method = RequestMethod.GET)
    public String setAdmin(String id) throws Exception {

    	User user = userService.findOne(Integer.parseInt(id));
    	user.setRole(Role.ROLE_ADMIN);
    	userService.update(user);

        return "redirect:/users";
    }
    @RequestMapping(value = "/ban", method = RequestMethod.GET)
    public String ban(String id) throws Exception {

    	User user = userService.findOne(Integer.parseInt(id));
    	user.setBan(true);
    	userService.update(user);

        return "redirect:/users";
    }
    @RequestMapping(value = "/unban", method = RequestMethod.GET)
    public String unban(String id) throws Exception {

    	User user = userService.findOne(Integer.parseInt(id));
    	user.setBan(false);
    	userService.update(user);

        return "redirect:/users";
    }
    
    @RequestMapping(value = "/checkPas", method = RequestMethod.GET)
    public @ResponseBody String checkPas(String password) {

        if(password.length()<=3){
        	return "Low";
        }else if(password.length() > 3 & password.length()<=5){
        	return "Mild";
        }else if(password.length()>5){
        	return "HARD";
        }
   
        return "";
    }
    
    @RequestMapping(value = "/checkName", method = RequestMethod.GET)
    public @ResponseBody String checkname(String name) {
    	List<User> users = userService.findAll();
    	for (User user : users) {
			if(user.getName().equals(name)){
				return Bad;
			}else{
				return Norm;
			}
		}
    	
    	
    	
        return "";
    }
    	
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public @ResponseBody String buy(Principal principal,@PathVariable String id){  
    	userService.buyFlowers(principal, id);
    	User user = userService.findOne(Integer.parseInt(principal.getName()));
    	List<Flowers> flowers = user.getFlowers();
    	for (Flowers flowers2 : flowers) {
			System.out.println(flowers2);
		}
    	
    	
    	return "redirect:/home";
    }
    
    
    


}
