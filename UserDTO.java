package com.brainmentors.chatapp.dto;

public class UserDTO {
private String userid, city, email,phone;
private char [] password;


public UserDTO(String userid,char[] password,String city,String email,String phone ) {
	this.userid=userid;
	this.password=password;
	this.city=city;
	this.email=email;
	this.phone=phone;
	
}
public UserDTO(String userid,char[] password ) {
	this.userid=userid;
	this.password=password;
	
	
}


public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public char[] getPassword() {
	return password;
}

public void setPassword(char[] password) {
	this.password = password;
}




}
