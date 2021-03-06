package flowers.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import flowers.entity.User;

public interface UserService {

    void save(User user) throws Exception;

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

    void buyFlowers(Principal principal, String id);

    public void saveImage(Principal principal, MultipartFile multipartFile);

//    User fetchUserWithBook(int id);



    User findByUUID(String uuid);

    void update(User user);
//    void setUser(int i);
//    void setAdmin(int i);


    
    // for cookie
//    
//    public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response);
    
//    List<Book> userBooksCookie(HttpServletRequest request);
    
//    public void getOrder(Principal principal, String id, HttpServletRequest request, HttpServletResponse response);
//    
//    public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response);

//	void setUser(int id);
    
    
}
