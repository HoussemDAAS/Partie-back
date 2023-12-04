package com.houssem.restaurent.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.houssem.restaurent.entitites.Menu;

@RepositoryRestResource(path = "menu")
@CrossOrigin("http://localhost:4200/")
public interface MenuRepository extends JpaRepository<Menu, Long>{

	List<Menu> findAll();
	
	
	
}
