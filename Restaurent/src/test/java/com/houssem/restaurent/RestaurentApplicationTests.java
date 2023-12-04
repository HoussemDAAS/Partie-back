package com.houssem.restaurent;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.houssem.restaurent.entitites.Menu;
import com.houssem.restaurent.entitites.Plat;
import com.houssem.restaurent.repos.PlatRepository;

@SpringBootTest
class RestaurentApplicationTests {

	@Autowired
	private PlatRepository PlatRepository;

	/*@Test
	public void testCreatePlat() {
		Plat mus = new Plat("omokhouriya",5000.00);
		PlatRepository.save(mus);
	}*/

	@Test
	public void testFindPlat() {
		Plat m = PlatRepository.findById(1L).get();
		System.out.println(m);
	}

	@Test
	public void testUpdatePlat() {
		Plat m = PlatRepository.findById(1L).get();
		m.setPrix(1000.0);
		PlatRepository.save(m);
	}

	@Test
	public void testDeletePlat() {
		PlatRepository.deleteById(2L);
		;
	}

	@Test
	public void testListerTousPlats() {
		List<Plat> Plats = PlatRepository.findAll();
		for (Plat p : Plats) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomPlat() {
		List<Plat> Plats = PlatRepository.findByNomPlat("omokhouriya");
		for (Plat p : Plats) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomPlatContains() {
		List<Plat> Plats = PlatRepository.findByNomPlatContains("omokh");
		for (Plat p : Plats) {
			System.out.println(p);
		}
	}

	
	@Test
	public void testFindByMenu() {
		Menu menu = new Menu();
		menu.setIdMenu(1L);
		List<Plat> Plat = PlatRepository.findByMenu(menu);
		for (Plat p : Plat) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByMenuIdMenu() {
		List<Plat> Plats = PlatRepository.findByMenuIdMenu(1L);
		for (Plat m : Plats) {
			System.out.println(m);
		}
	}

	@Test
	public void testFindByOrderByNomPlatAsc() {
		List<Plat> Plats = PlatRepository.findByOrderByNomPlatAsc();
		for (Plat m : Plats) {
			System.out.println(m);
		}
	}

	@Test
	public void testTrierPlatsNomsPrix() {
		List<Plat> Plats = PlatRepository.trierPlatsNomsPrix();
		for (Plat m : Plats) {
			System.out.println(m);
		}
	}
}
