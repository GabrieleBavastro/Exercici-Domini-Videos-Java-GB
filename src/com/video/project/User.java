package com.video.project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

	private static String name;
	private String surname;
	private static String userName;
	private static String pswd;
	private static LocalDate dateOfSignUp;
	static List<Video> videos = new ArrayList<Video>();
	

	public User(String name, String surname, String pswd, LocalDate dateOfSignUp, String userName) throws Exception {
		
		
		if(name.equals(""))
			throw new Exception("Please introduce the requested data without blank spaces.");
		if(surname.equals(""))
			throw new Exception("Please introduce the requested data without blank spaces.");
		if(pswd.equals(""))
			throw new Exception("Please introduce the requested data without blank spaces.");
		
		this.setName(name);
		this.setSurname(surname);
		this.setPswd(pswd);
		this.setDateOfSignUp(LocalDate.now());
		this.setUserName(name + "." + surname);
	}
		
	public static String getName() {
		return name;
	}


	public void setName(String name) {
		User.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public static String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		User.userName = userName;
	}

	public static String getPswd() {
		
		String hiddenPassword="";
				
		for (int i = 0; i < pswd.length(); i++) {
			hiddenPassword+="*";
		}
		
		hiddenPassword+="**";
		
		return hiddenPassword;
	}

	public void setPswd(String pswd) {
		User.pswd = pswd;
	}


	public static LocalDate getDateOfSignUp() {
		return dateOfSignUp;
	}


	public void setDateOfSignUp(LocalDate dateOfSignUp) {
		User.dateOfSignUp = dateOfSignUp;
	}
	
	public List<Video> getVideo() {
		return videos;
	}

	public void setVideo(List<Video> videos) {
		User.videos = videos;
	}
}