package com.video.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	
	private static int ID_COUNTER = 1; 
	
	private int Id;
	private String Name;
	private String Surname;
	private String Password ="";
	private Date registerDate;
	List<Video> videoList;
		
	public User(String name, String surname, String password) throws Exception {
		
		if(name.equals(""))
			throw new Exception("Name field not filled! Please fill it in!");
		if(surname.equals(""))
			throw new Exception("Surname field not filled! Please fill it in!");
		if(password.equals(""))
			throw new Exception("Password field not filled! Please fill it in!");
		
		Id = ID_COUNTER;
		ID_COUNTER++;

		this.setName(name);
		this.setSurname(surname); 
		this.setPassword(password);
		this.setRegisterDate(new Date());
		
		this.videoList = new ArrayList<Video>();
		
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getSurname() {
		return Surname;
	}


	public void setSurname(String surname) {
		Surname = surname;
	}


	public String getPassword() {
		
		String hiddenPassword="";
				
		for (int i = 0; i < Password.length(); i++) {
			hiddenPassword+="*";
		}
		
		hiddenPassword+="**";
		
		return hiddenPassword;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public List<Video> getVideoList() {
		return videoList;
	}


	public void setVideoList(List<Video> videoList) {
		this.videoList = videoList;
	}

	public void addVideo(Video newVideo) {
		this.getVideoList().add(newVideo);
	}
	
	public void addVideos(List<Video> newVideo) {

		for (Video video : newVideo) {
			this.getVideoList().add(video);
		}
	}
	
	public boolean CheckPassword(String pwd) {
		return (this.Password.equals(pwd));
	}


	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", Surname=" + Surname + ", Password=" + getPassword()
				+ ", registerDate=" + registerDate + ", videoList=" + videoList + "]";
	}
}
