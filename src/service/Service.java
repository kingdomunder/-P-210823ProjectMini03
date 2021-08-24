package service;

import model.dao.StudentDAO;
import model.dao.StudyDAO;

public class Service {
	
	private static Service instance = new Service();
	
	private static StudentDAO getStudentDAO = StudentDAO.getInstance();
	private static StudyDAO getStudytDAO = StudyDAO.getInstance();
	
	public Service() {}
	public static Service getInstance() {
		return instance;
	}
}