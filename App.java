package com.skilldistillery.filmquery.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class App {
	
	public static Scanner input;
	public static DatabaseAccessorObject db;
	public static int choice;
	public static int id;
	public static String str;
	public static String sql;
	public static Connection conn;
	public static PreparedStatement stmt;
	public static ResultSet rs;
	public static String[] parts;
	public static int count = 0;
	public static Boolean exit = false;
	
	public void menu() throws SQLException {
		while(exit == false) {
		db = new DatabaseAccessorObject();
		input = new Scanner(System.in);	
		System.out.println();
		System.out.println("1. Look up a film by id");
		System.out.println("2. Look up a film by a search keyword");
		System.out.println("3. Exit the application");
		System.out.println();
		System.out.println("Enter an integer choice");
		choice = input.nextInt();
		if(choice == 1) {
			choice_1();
		}
		if(choice == 2) {
			choice_2();
		}
		if(choice == 3) {
			choice_3();
		}
		else {
			choice_4();
		}
		}//while
	}//menu
	
	public void choice_1() throws SQLException {
		while(exit == false) {
		System.out.println("Enter a film id");
		id = input.nextInt();
		db.findFilmById(id);
		menu();
		}//while
	}//choice_1
	
	public void choice_2() throws SQLException {
		while(exit == false) {
		System.out.println();	
		System.out.println("Enter a search keyword"); 
		str = input.next();
		db.findFilmBySearch(str);
		menu();
		}//while
	}//choice_2
	
	public void choice_3() {
		while(exit == false) {
		System.out.println("Exiting Application");
		exit = true;
		}
	}//choice_3
	
	public void choice_4() throws SQLException {
		System.out.println("Enter an integer 1, 2, or 3");
		menu();
	}
	
	//story 1
	public static void main(String[] args) throws SQLException {
		
		App app = new App();
		app.menu();
		
	}//main
}//class
