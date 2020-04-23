package com.video.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner((System.in));
	static ArrayList<Video> videoList = new ArrayList<Video>();
	static ArrayList<User> userList = new ArrayList<User>();

	public static void main(String[] args) {

		// Add Preload User

		if (userList.size() == 0) {
			try {
				userList.add(new User("admin", "admin", "admin"));
				userList.add(new User("test", "test", "test"));
			} catch (Exception e) {
				writeToLog(new Exception("Something wrong with preloaded user data"));
				e.printStackTrace();
			}

		}

		System.out.println(
				"Welcome to Future Videos! What do you want to do?" + "\n 1 - Sign In. \n 2 - Sign Up. \n 3 - Exit.");

		// Used to hold the instance of a user who successfully logged in
		User loggedInUser = null;

		String initialInput = scanner.next();

		// Switch Main.

		switch (initialInput) {
		case "1":
			// Sign In.
			System.out.println("You chosed enter in your profile!");
			// Iterate through list of users to see if we have a match

			System.out.println("Please introduce your name without blank spaces.");
			String askName = (scanner.next().toLowerCase());

			System.out.println("Please introduce your Password.");
			String askUserPassword = (scanner.next().toLowerCase());

			for (User User : userList) {
				if (User.getName().equals(askName) && (User.getPassword().equals(askUserPassword)))
					;
				{
					loggedInUser = User;
				}
			}

			// if loggedInUser was changed from null, it was successful
			if (loggedInUser != null) {
				System.out.println("User successfully logged in: " + askName);
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

			System.out.println("Please introduce your name without blank spaces.");
			String name = (scanner.next().toLowerCase());

			System.out.println("Please introduce your surname without blank spaces.");
			String surname = (scanner.next().toLowerCase());

			System.out.println("Please introduce your Password.");
			String password = (scanner.next().toLowerCase());

			try {
				newUser = new User(name, surname, password);
			} catch (Exception e) {
				writeToLog(new Exception("Something wrong with create a new user"));
				e.printStackTrace();
			}
			userList.add(newUser);
			System.out.println("The new User has been created!" + newUser.toString());

			Main.main(args);
			break;

		case "3":
			// Exit.
			System.out.println("Good  Bye! We hope to see you again soon!");
			break;

		default:
			System.out.println("ERROR! Please choose a number between 1 and 3!");
			Main.main(args);
		}

	}

	public static void writeToLog(Exception exception) {}

	public static void userConsole() {

		System.out.println("What do you want to do?" + "\n 1 - Create a new video. "
				+ "\n 2 - See your list of videos. \n 3 - Exit.");
		String signInOption = (scanner.next());

		// Switch Sign In Options.

		switch (signInOption) {
		case "1":
			System.out.println("You chosed create a new video!");

			System.out.println("Please introduce the title of your video without blank spaces.");
			String title = (scanner.next().toLowerCase());

			System.out.println("Please introduce the URL of the video without blank spaces.");
			String URL = (scanner.next().toLowerCase());

			System.out.println("Please introduce the tags separated by a comma without blank spaces.");
			String tags = (scanner.next().toLowerCase());

			Video newVideo = new Video(title, URL, tags);
			videoList.add(newVideo);
			System.out.println("The new Video has been created! \n" + newVideo.toString());
			Main.userConsole();
			break;
		case "2":
			System.out.println("Your videos are:");
			System.out.println(videoList.toString());
			Main.userConsole();
			break;
		case "3":
			System.out.println("Good Bye! We hope to see you again soon!");
			break;
		default:
			System.out.println("ERROR! Please choose a number between 1 and 3!");
			Main.userConsole();
		}
	}
}
