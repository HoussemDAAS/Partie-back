package com.houssem.restaurent.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.houssem.restaurent.entitites.Menu;
import com.houssem.restaurent.entitites.Plat;

@RepositoryRestResource(path = "rest")
public interface PlatRepository extends JpaRepository <Plat, Long>{
	List<Plat> findByNomPlat(String nom);
	List<Plat> findByNomPlatContains(String nom);
	
	@Query("select m from Plat m where m.menu = ?1") 
	List<Plat> findByMenu (Menu menu);
	
	List<Plat> findByMenuIdMenu(Long id);
	
	List<Plat> findByOrderByNomPlatAsc();
	
	@Query("select m from Plat m order by m.nomPlat ASC, m.prix DESC")
	List<Plat> trierPlatsNomsPrix ();
	
}
