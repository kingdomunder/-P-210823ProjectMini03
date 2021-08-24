package service;

import java.sql.SQLException;
import java.util.List;

import model.dao.AttendanceDAO;
import model.dao.StudentDAO;
import model.dao.StudyDAO;
import model.domain.Student;
import model.domain.Study;
import model.domain.Study;

public class Service {
	
	private static Service instance = new Service();
	private static StudentDAO getStudentDAO = StudentDAO.getInstance();
	private static StudyDAO getStudyDAO = StudyDAO.getInstance();
	private static AttendanceDAO getAttendanceDAO = AttendanceDAO.getInstance();
	
	public Service() {}	
	public static Service getInstance() {		
		return instance;
	}
	
	
	
	/** 모든 수강생 검색 */
	public static List<Student> getAllStudents() throws SQLException{
		List<Student> allStudentList = getStudentDAO.getAllStudent();
		if (allStudentList == null) {
			throw new NullPointerException();
		}
		return  allStudentList;
	}
		
				
	/** 모든 스터디 검색 */	
	public static List<Study> getAllStudy() throws SQLException{
		List<Study> allStudyList = getStudyDAO.getAllStudy();
		if (allStudyList == null) {
			throw new NullPointerException();
		}
		return allStudyList;
	}
	
	/** 스터디 id로 검색 
	 * @param id */
	public static Study getStudyById(int id) throws SQLException{
		Study study = getStudyDAO.getStudyById(id);
		if (study == null) {
			throw new NullPointerException();
		}
		return study;
	}
	
	/** 스터디 주제로 검색 
	 * @param keyword */
	public static List<Study> getStudyByTopic(String keyword) throws SQLException{
		List<Study> studyList = getStudyDAO.getStudyByTopic(keyword);
		if (studyList == null) {
			throw new NullPointerException();
		}
		return studyList;
	}

}
