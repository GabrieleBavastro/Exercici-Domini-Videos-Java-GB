package com.video.project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<User> userList = new ArrayList<User>();
	static ArrayList<String> userArrayList = new ArrayList<String>();

	public static Scanner scanner = new Scanner((System.in));

	public static void main(String[] args) throws Exception {

		// Add Preload User

		if (userList.size() == 0) {
			userList.add(new User("admin", "test", "1234", LocalDate.now(), "admin.test"));
			userArrayList.add(User.getUserName());
			userList.add(new User("test", "admin", "1234", LocalDate.now(), "test.admin"));
			userArrayList.add(User.getUserName());
		}

		System.out.println("Welcome to Future Videos! What do you want to do?"
				+ "\n 1 - Sign In. \n 2 - Sign Up. \n 3 - Show User List \n 4 - Exit.");

		// Used to hold the instance of a user who successfully logged in
		User loggedInUser = null;

		String initialInput = scanner.next();

		// Switch Main.

		switch (initialInput) {
		case "1":
			// Sign In.
			System.out.println("You chosed enter in your profile!");
			// Iterate through list of users to see if we have a match
			String askUserName = askUserName();
			String askUserPassword = askUserPassword();

			for (User User : userList) {
				if (com.video.project.User.getUserName() == (askUserName)
						&& (com.video.project.User.getPswd() == (askUserPassword)))
					;
				{
					loggedInUser = User;
				}
			}

			// if loggedInUser was changed from null, it was successful
			if (loggedInUser != null) {
				System.out.println("User successfully logged in: " + User.getUserName());
				Main.userConsole();
			} else {
				System.out.println("Invalid username/password combination! Please try again!");
				Main.main(args);
			}

			break;
		case "2":
			// Sign Up.
			System.out.println("You chosed create a new profile!");
			User newUser = null;
			newUser = new User(askName(), askSurname(), askPswd(), User.getDateOfSignUp(), User.getUserName());

			userArrayList.add(User.getUserName());
			userList.add(newUser);
			System.out.println("The new User has been created! \n" + "User Name: " + User.getUserName() + "\nPassword: "
					+ User.getPswd() + "\nDate of Sign Up: " + User.getDateOfSignUp());
			Main.main(args);
			break;

		case "3":
			// Show the UserList.
			System.out.println("The User List is:");
			System.out.println(userArrayList);
			Main.main(args);
			break;

		case "4":
			// Exit.
			System.out.println("Good  Bye! We hope to see you again soon!");
			break;

		default:
			System.out.println("ERROR! Please choose a number between 1 and 4!");
			Main.main(args);
		}

	}
	// Case 2 - Sign Up.

	public static String askName() {
		System.out.println("Please introduce your name without blank spaces.");
		return (scanner.next().toLowerCase());
	}

	public static String askSurname() {
		System.out.println("Please introduce your surname without blank spaces.");
		return (scanner.next().toLowerCase());
	}

	public static String askPswd() {
		System.out.println("Please introduce your Password.");
		return (scanner.next());
	}

	// Case 1 - Sign In.
	public static String askUserName() {
		System.out.println("Please introduce your User Name.");
		return (scanner.next());
	}

	public static String askUserPassword() {
		System.out.println("Please introduce your Password.");
		return (scanner.next());
	}

	// Sign in options.
	public static String signInOption() {
		// System.out.println("Please choose one of the options.");
		return (scanner.next());
	}

	public static void userConsole() {

		System.out.println("What do you want to do?" + "\n 1 - Create a new video. "
				+ "\n 2 - See your list of videos. \n 3 - Exit.");
		
		// Switch Sign In Options.
		ArrayList<String> videoArrayList = new ArrayList<String>();
		
		switch (signInOption()) {
		case "1":
			System.out.println("You chosed create a new video!");
			Video newVideo = new Video(askVideoTitle(), Video.getUrl(), askVideoTags());
			
			User.videos.add(newVideo);
			videoArrayList.add(Video.getUrl());
			
			System.out.println("The new Video has been created! \n" + "Title: " + Video.getTitle() + "\nURL: "
					+ Video.getUrl() + "\nTag List: " + Video.getTags());
			
			Main.userConsole();
			break;
		case "2":
			System.out.println("Your videos are:");
			System.out.println(User.videos.toString());
			Main.userConsole();
			break;
		case "3":
			System.out.println("Good Bye " + User.getUserName() + "! We hope to see you again soon!");
			break;
		default:
			System.out.println("ERROR! Please choose a number between 1 and 3!");
			Main.userConsole();
		}
	}

	public static String askVideoTitle() {
		System.out.println("Please introduce the title of your video without blank spaces.");
		return (scanner.next().toLowerCase());
	}

	public static String askVideoTags() {
		System.out.println("Please introduce the tags separated by a comma without blank spaces.");
		return (scanner.next().toLowerCase());
	}
}
