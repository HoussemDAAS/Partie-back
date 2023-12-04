package com.houssem.restaurent.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.houssem.restaurent.entitites.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
	 @Modifying
	  @Query("DELETE FROM Image i WHERE i.plat.idPlat = ?1") 
	  void deleteImagesByPlatId(long idPlat);
}