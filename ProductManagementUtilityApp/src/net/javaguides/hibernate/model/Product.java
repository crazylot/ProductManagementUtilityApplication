package net.javaguides.hibernate.model;


import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
//import javax.servlet.annotation.MultipartConfig;


@Entity
//@MultipartConfig(maxFileSize=1000*1000) 
@Table(name="product")
public class Product {
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="id")
 protected int id;
 
 @Column(name="title")
 protected String title;
 
 @Column(name="quantity")
 protected String quantity;
 
 @Column(name="size")
 protected String size;
 
 @Lob
 @Column(name="image")
 private byte[] image;
 
 @Column(name="imagename")
 private String imagename;
 
 @Column(name="username")
 private String username;
 
 public Product() {
	 
 }
 public Product(String title, String quantity, String size ,byte [] image, String imagename,String username) {
  super();
  this.title = title;
  this.quantity = quantity;
  this.size = size;
  this.image = image;
  this.imagename = imagename;
  this.username = username;
 }
public Product(int id2, String title2, String quantity2, String size2,byte [] image2) {
	this.id = id2;
	this.title = title2;
	this.quantity = quantity2;
	this.size = size2;
	this.image=image2;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}
public String getImagename() {
	//extra
	imagename = Base64.getEncoder().encodeToString(this.image);
    return imagename;
}
public void setImagename(String imagename) {
    this.imagename = imagename;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

}