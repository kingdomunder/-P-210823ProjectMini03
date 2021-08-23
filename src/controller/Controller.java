package controller;

import service.Service;

public class Controller {
	
	
	private static Controller instance = new Controller();
	
	public Controller() {
	}
	
	
	public static Controller getInstance() {
		
		return instance;
	}
	
	
	
	public static void getAllStudent() {
		Service.getAllStudents();
		
		
		
	}
	
	
	
	
	
}
