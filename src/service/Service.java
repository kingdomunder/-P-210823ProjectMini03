package service;

import java.sql.SQLException;
import java.util.List;

import model.dao.AttendanceDAO;
import model.dao.StudentDAO;
import model.dao.StudyDAO;
import model.domain.Student;
import model.domain.Study;

public class Service {

	private static Service instance = new Service();

	private static StudentDAO getStudentDAO = StudentDAO.getInstance();
	private static StudyDAO getStudyDAO = StudyDAO.getInstance();
	private static AttendanceDAO getAttendanceDAO = AttendanceDAO.getInstance();

	public Service() {
	}

	public static Service getInstance() {
		return instance;
	}

	/** 모든 수강생 검색 */
	public static List<Student> getAllStudents() throws SQLException {
		List<Student> allStudentList = getStudentDAO.getAllStudent();
		if (allStudentList == null) {
			throw new NullPointerException();
		}
		return allStudentList;
	}

	/** 수강생 하나 검색 */
//	public static Student getOneStudents(int searchNo, Object student) throws SQLException {
//		if (searchNo == 1) {
//			Object serach = (int) student;
//
//		}
//		if (searchNo == 2) {
//			Object serach = (String) student;
//
//		}
//		if (searchNo == 3) {
//			Object serach = (Study) student;
//
//		}
//
//		Student oneStudent = getStudentDAO.getOneStudent();
//		if (oneStudent == null) {
//			throw new NullPointerException();
//		}
//		return oneStudent;
//	}

	
	/** 모든 스터디 검색 */
	public static List<Study> getAllStudy() throws SQLException {
		List<Study> allStudyList = getStudyDAO.getAllStudy();
		if (allStudyList == null) {
			throw new NullPointerException();
		}
		return allStudyList;
	}

	/**
	 * 스터디 id로 검색
	 * @param id
	 */
	public static Study getStudyById(int id) throws SQLException {
		Study study = getStudyDAO.getStudyById(id);
		if (study == null) {
			throw new NullPointerException();
		}
		return study;
	}

	/**
	 * 스터디 주제로 검색
	 * @param keyword
	 */
	public static List<Study> getStudyByTopic(String keyword) throws SQLException {
		List<Study> studyList = getStudyDAO.getStudyByTopic(keyword);
		if (studyList == null) {
			throw new NullPointerException();
		}
		return studyList;
	}
	
		
	// 수강생 번호로 수강생 가져오기
//	public static Student getOneStudent(studentId) {
//		Student student = getStudentDAO.getOneStudent(studentId);
//	}
	/**
	 * 스터디 추가
	 * @param keyword
	 */
	public void addStudy(String studyName, String topic, int studentId, String meetingDate) throws SQLException {
		Student student = getStudentDAO.getOneStudent(studentId);
		getStudyDAO.insertStudy(studyName, topic, student, meetingDate);
	}

	/**
	 * 스터디 정보 업데이트
	 * @param keyword
	 */
	public void updateStudy(int id, String meetingDate) throws SQLException {
		getStudyDAO.updateStudy(id, meetingDate);
	}

	/**
	 * 스터디 정보 업데이트
	 * @param id
	 */
	public void deleteStudy(int id) throws SQLException {
		getStudyDAO.deleteStudy(id);
	}

}
