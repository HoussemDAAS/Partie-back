package com.houssem.restaurent.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.houssem.restaurent.entitites.Image;
import com.houssem.restaurent.entitites.Menu;
import com.houssem.restaurent.entitites.Plat;
import com.houssem.restaurent.repos.ImageRepository;
import com.houssem.restaurent.repos.PlatRepository;

@Service
public class PlatServiceImpl implements PlatService {

	@Autowired
	PlatRepository platRepository;
@Autowired
	ImageRepository imageRepository;
	@Override
	public Plat savePlat(Plat m) {
		return platRepository.save(m);
	}

	@Override
	public Plat updatePlat(Plat m) {
		return platRepository.save(m);
	}
	/*@Override
	public Plat updatePlat(Plat m) {
	Long oldProdImageId = 
	this.getPlat(m.getIdPlat()).getImage().getIdImage();
	Long newProdImageId = m.getImage().getIdImage();
	Plat platUpdated = platRepository.save(m);
	if (oldProdImageId != newProdImageId) //si l'image a été modifiée
	imageRepository.deleteById(oldProdImageId);
	return platUpdated;
	}*/
	/*@Override
	public Plat updatePlat(Plat m) {
	    List<Image> oldProdImages = this.getPlat(m.getIdPlat()).getImages();
	    List<Image> newProdImages = m.getImages();
	    
	    Plat platUpdated = platRepository.save(m);
	    
	    // Compare and update images
	    for (Image oldImage : oldProdImages) {
	        if (!newProdImages.contains(oldImage)) {
	            imageRepository.deleteById(oldImage.getIdImage());
	        }
	    }
	    
	    return platUpdated;
	}*/


	@Override
	public void deletePlat(Plat m) {
		
		platRepository.delete(m);
	}

	/*@Override
	public void deletePlatById(Long id) {
		Plat p =getPlat(id);
		try {
			Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
			platRepository.deleteById(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	@Override
	public void deletePlatById(long id) {
	    Plat plat = platRepository.findById(id).orElse(null);

	    if (plat != null) {
	        // Iterate over the list of images and delete each one
	        List<Image> images = plat.getImages();
	        if (images != null) {
	            for (Image image : images) {
	                // Delete the image from the database
	                imageRepository.deleteById(image.getIdImage()); // Assuming Image entity has an id field
	            }
	        }

	        // Finally, delete the Plat
	        platRepository.deleteById(id);
	    }
	}

	/*@Override
	public void deletePlatById(Long id) {
		platRepository.deleteById(id);
	}*/
	
	@Override
	public Plat getPlat(Long id) {
		return platRepository.findById(id).get();
	}

	@Override
	public List<Plat> getAllPlat() {
		return platRepository.findAll();
	}

	@Override
	public List<Plat> findByNomPlat(String nom) {
		return platRepository.findByNomPlat(nom);
	}

	@Override
	public List<Plat> findByNomPlatContains(String nom) {
		return platRepository.findByNomPlatContains(nom);
	}

	@Override
	public List<Plat> findByMenu(Menu menu) {
		return platRepository.findByMenu(menu);
	}

	@Override
	public List<Plat> findByMenuIdMenu(Long id) {
		return platRepository.findByMenuIdMenu(id);
	}

	@Override
	public List<Plat> findByOrderByNomPlattAsc() {
		return platRepository.findByOrderByNomPlatAsc();
	}

	@Override
	public List<Plat> trierPlatsNomsPrix() {
		return platRepository.trierPlatsNomsPrix();
	}

}
