package com.houssem.users.restControllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.houssem.users.entities.User;
import com.houssem.users.services.UserService;

@RestController

@CrossOrigin(origins = "*")
public class UserRestController {

		@Autowired
		UserService userService;
		
		@RequestMapping(path = "all", method = RequestMethod.GET)
		public List<User> getAllUsers() {
		return userService.findAllUsers();
		}
}
