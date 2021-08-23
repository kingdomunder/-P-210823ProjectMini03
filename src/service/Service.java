package service;

import java.util.List;

import model.dao.StudentDAO;
import model.domain.Student;

public class Service {
	
private static Service instance = new Service();
	
	public Service() {
	}
	
	
	public static Service getInstance() {
		
		return instance;
	}
	
	
	public static List<Student> getAllStudents(){
		return StudentDAO.getAllStudent();
		
	}
	
	
}
