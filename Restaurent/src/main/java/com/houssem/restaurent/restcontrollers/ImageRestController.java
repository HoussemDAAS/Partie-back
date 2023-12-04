package com.houssem.restaurent.restcontrollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.houssem.restaurent.entitites.Image;
import com.houssem.restaurent.entitites.Plat;
import com.houssem.restaurent.service.ImageService;
import com.houssem.restaurent.service.PlatService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	 ImageService imageService ;
	 
	@Autowired
	 PlatService platService ;
	 
	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;
	 }
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException 
	{
	 return imageService.getImage(id);
	 }
	 
	 
	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);
	 }
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 @PostMapping(value = "/uplaodImagePlat/{idPlat}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
	 @PathVariable("idPlat") Long idProd) 
	throws IOException {
	 return imageService.uplaodImagePlat(file,idProd);
	 }
	@RequestMapping(value = "/getImagesPlat/{idPlat}" , 
	 method = RequestMethod.GET)
	 public List<Image> getImagesProd(@PathVariable("idPlat") Long idPlat) 
	throws IOException {
	 return imageService.getImagesParPlat(idPlat);
	 }
	
	@RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile 
	file,@PathVariable("id") Long id) throws IOException {
	 Plat p = platService.getPlat(id);
	 p.setImagePath(id+".jpg");
	 
	Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath())
	, file.getBytes());
	 platService.savePlat(p);
	 
	 }
	 @RequestMapping(value = "/loadfromFS/{id}" , 
			 method = RequestMethod.GET,
			 produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
			 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {
			 
			 Plat p = platService.getPlat(id);
			 return
			Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
			 }
}
