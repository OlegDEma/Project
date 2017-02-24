package flowers.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import flowers.dao.FlowersDao;
import flowers.dao.UserDao;
import flowers.entity.Flowers;
import flowers.entity.Role;
import flowers.entity.User;
import flowers.service.UserService;
import flowers.validator.Validator;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private FlowersDao flowersDao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void save(User user) throws Exception {

		validator.validate(user);

		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);

	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return userDao.findByName(name);
	}

	@Transactional
	public void buyFlowers(Principal principal, String id) {
		User user = userDao.findOne(Integer.parseInt(principal.getName()));

		Flowers flowers = flowersDao.findOne(Integer.parseInt(id));

		user.getFlowers().add(flowers);
//		flowers.getUsers().add(user);
		
		
	}

	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {

		User user = userDao.findOne(Integer.parseInt(principal.getName()));

		String path = System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"
				+ multipartFile.getOriginalFilename();

		user.setPathImage("resources/" + user.getName() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
	}

//	public User fetchUserWithBook(int id) {
//		return userDao.fetchUserWithBook(id);
//	}

	public User findByUUID(String uuid) {
		return userDao.findByUUID(uuid);
	}

	public void update(User user) {
		userDao.save(user);
	}

//	public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response) {
//
//		request.getSession(false);
//		Book book = bookDao.findOne(id);
//
//		Cookie cookieBook = new Cookie(book.getTitle(), String.valueOf(book.getId()));
//		cookieBook.setMaxAge(24 * 60 * 60 * 60);
//		cookieBook.setHttpOnly(true);
//		cookieBook.setPath("/");
//
//		response.addCookie(cookieBook);
//		return cookieBook;
//
//	}

//	public List<Book> userBooksCookie(HttpServletRequest request) {
//
//		request.getSession(false);
//		List<Book> books = new ArrayList<>();
//		for (Cookie cookie : request.getCookies()) {
//			if (cookie.getName().equals("JSESSIONID")) {
//				
//			} else {
//				books.add(bookDao.findOne(Integer.parseInt(cookie.getValue())));
//			}
//		}
//		return books;
//
//	}

//	@Transactional
//	@Override
//	public void getOrder(Principal principal, String id, HttpServletRequest request, 
//			HttpServletResponse response) {
//
//		User user = userDao.fetchUserWithBook(Integer.parseInt(principal.getName()));
//		Book book = bookDao.findOne(Integer.parseInt(id));
//		user.getBooks().add(book);
//
//		Cookie[] cookies = request.getCookies();
//		sortCookie(cookies, id, response);
//
//	}
	
	
		


	public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response) {
        for (int i = 0; i < cookies.length; i++) {
            if (id.equals(cookies[i].getValue())) {
                Cookie cookie = new Cookie(cookies[i].getName(), null);
                cookie.setPath("/");
                cookie.setValue(null);
                cookie.setHttpOnly(true);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
	}
//
//	@Override
//	public void setUser(int id) {
//		userDao.setUser(id);
//		
//	}

	
	
	
	
	
	
	
	
	
	
}
