package com.houssem.users.services;

import java.util.List;
import java.util.Random;

import java.util.Optional;
import com.houssem.users.services.register.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Calendar;

import com.houssem.users.entities.Role;
import com.houssem.users.entities.User;
import com.houssem.users.repos.RoleRepository;
import com.houssem.users.repos.UserRepository;
import com.houssem.users.services.exceptions.EmailAlreadyExistsException;
import com.houssem.users.services.register.RegistationRequest;
import com.houssem.users.services.register.VerificationTokenRepository;
import com.houssem.users.util.EmailSender;
import com.houssem.users.services.exceptions.*;
@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRep;
	@Autowired
	RoleRepository roleRep;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	VerificationTokenRepository verificationTokenRepo;

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);
	}

	@Override
	public User addRoleToUser(String username, String rolename) {
		User usr = userRep.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		usr.getRoles().add(r);
		return usr;
	}

	@Override
	public Role addRole(Role role) {
		return roleRep.save(role);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRep.findByUsername(username);
	}

	@Override
	public List<User> findAllUsers() {

		return userRep.findAll();
	}

	@Override
	public User registerUser(RegistationRequest request) {
		Optional<User> optionaluser = userRep.findByEmail(request.getEmail());
		if (optionaluser.isPresent())
			throw new EmailAlreadyExistsException("email déjà existant!");
		User newUser = new User();
		newUser.setUsername(request.getUsername());
		newUser.setEmail(request.getEmail());

		newUser.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
		newUser.setEnabled(false);
		userRep.save(newUser);
		// ajouter à newUser le role par défaut USER
		Role r = roleRep.findByRole("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(r);
		newUser.setRoles(roles);
		String code = this.generateCode();
		 
		 VerificationToken token = new VerificationToken(code, newUser);
		 verificationTokenRepo.save(token); 
		 
		 sendEmailUser(newUser,token.getToken());

		return userRep.save(newUser);
		
		
		
	}

	public String generateCode() {
		  Random random = new Random();
		 Integer code = 100000 + random.nextInt(900000); 
		 
		 return code.toString();
		}
	public void sendEmailUser(User u, String code) {
		 String emailBody ="Bonjour "+ "<h1>"+u.getUsername() +"</h1>" +
		 " Votre code de validation est "+"<h1>"+code+"</h1>"; 
		EmailSender.sendEmail(u.getEmail(), emailBody);
		}
	@Override
	public User validateToken(String code) {
	VerificationToken token = verificationTokenRepo.findByToken(code);
	 if(token == null){
	 throw new InvalidTokenException("Invalid Token");
	 }
	 
	 User user = token.getUser();
	 Calendar calendar = Calendar.getInstance();
	if ((token.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0){
	 verificationTokenRepo.delete(token);
	 throw new ExpiredTokenException("expired Token");
	 }
	 user.setEnabled(true);
	 userRep.save(user);
	 return user;
	}

}