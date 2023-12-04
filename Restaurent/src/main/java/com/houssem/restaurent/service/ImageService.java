package com.houssem.restaurent.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.houssem.restaurent.entitites.Image;

public interface ImageService {
	 Image uplaodImage(MultipartFile file) throws IOException;
	 Image getImageDetails(Long id) throws IOException;
	 ResponseEntity<byte[]> getImage(Long id) throws IOException;
	 void deleteImage(Long id) ;
	 Image uplaodImagePlat(MultipartFile file,Long idPlat) throws IOException;
	 List<Image> getImagesParPlat(Long idPlat);
	}