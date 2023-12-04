package com.houssem.restaurent.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.houssem.restaurent.entitites.Menu;
import com.houssem.restaurent.repos.MenuRepository;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin("*")
public class MenuRESTController {
	
	@Autowired
	MenuRepository menuRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Menu> getAllMenus() {
		return menuRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Menu getMenuById(@PathVariable("id") Long id) {
		return menuRepository.findById(id).get();
	}
	
}
