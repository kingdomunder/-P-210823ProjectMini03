package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import exception.DeleteException;
import exception.InsertException;
import exception.NotExistException;
import model.dao.AttendanceDAO;
import model.dao.StudentDAO;
import model.dao.StudyDAO;
import model.domain.Attendance;
import model.domain.Student;
import model.domain.Study;
import util.PublicCommon;

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

	// SELECT
	/** 모든 수강생 검색 */
	public List<Student> getAllStudents() throws SQLException {
		List<Student> allStudentList = getStudentDAO.getAllStudent();
		if (allStudentList == null) {
			throw new NullPointerException();
		}
		return allStudentList;
	}

	/** 검색조건으로 수강생 검색 - 수강생ID로 한명만 검색 */
	public Object getOneStudents(Object info) throws SQLException {
		int studentId = (int) info;

		Student result = getStudentDAO.getStudentById(studentId);
		if (result == null) {
			throw new NullPointerException();
		}
		return result;
	}

	/** 검색조건으로 수강생 검색 - 검색조건으로 여러명 검색 */
	public List<Student> getSearchedStudents(int searchNo, Object info) throws SQLException {
		List<Student> result = null;
		if (searchNo == 2) {
			String studentName = (String) info;
			result = getStudentDAO.getStudentByName(studentName);
		} else if (searchNo == 3) {
			String major = (String) info;
			result = getStudentDAO.getStudentByMajor(major);
		} else if (searchNo == 4) {
			Study studyId = new Study();
			studyId.setStudyId((int) info);
			result = getStudentDAO.getStudentByStudyId(studyId);
		} else {
			throw new NullPointerException();
		}
		if (result == null || result.size() == 0) {
			throw new NullPointerException();
		}
		return result;
	}

	/** 지각, 결석 없는 모범생 검색 */
	public List<Attendance> getPerfectPresent() throws SQLException{
		List<Attendance> attendanceList = getAttendanceDAO.getAllAttendance();
		List<Attendance> attendance = new ArrayList<>();

		if (attendanceList != null) {
			for (Attendance a : attendanceList) {
				if (a.getLate() == 0 && a.getAbsent() == 0) {
					attendance.add(a);
				}
			}
		}
		return attendance;
	}

	/** 결석 3번 이상인 수강생 검색 
	 * @throws NotExistException */
	public List<Attendance> getAbsentStudent() throws SQLException, NotExistException{
		List<Attendance> attendanceList = getAttendanceDAO.getAllAttendance();
		List<Attendance> attendance = new ArrayList<>();

		if (attendanceList != null) {
			for (Attendance a : attendanceList) {
				if (a.getAbsent() >= 3) {
					attendance.add(a);
				}
			}
		}
		if(attendance.size() == 0) {
			throw new NotExistException();
		}
		return attendance;
	}

	/**
	 * 학생 한명의 출석정보 검색
	 * @param studentId
	 */
	public Attendance getOneAttendance(int studentId) throws SQLException {
		Attendance attendance = getAttendanceDAO.getOneAttendance(studentId);
		if (attendance == null) {
			throw new NullPointerException();
		}
		return attendance;
	}

	/** 모든 출석 정보 검색 */
	public List<Attendance> getAllAttendance() throws SQLException {
		List<Attendance> allAttendanceList = getAttendanceDAO.getAllAttendance();
		if (allAttendanceList == null) {
			throw new NullPointerException();
		}
		return allAttendanceList;
	}

	/** 모든 스터디 검색 
	 * @throws NotExistException */
	public List<Study> getAllStudy() throws SQLException, NotExistException {
		List<Study> allStudyList = getStudyDAO.getAllStudy();
		if (allStudyList.size() == 0) {
			throw new NotExistException();
		}
		return allStudyList;
	}

	/**
	 * 스터디 id로 검색
	 * @param id
	 * @throws NotExistException 
	 */
	public Study getStudyById(int id) throws SQLException, NotExistException {
		Study study = getStudyDAO.getStudyById(id);
		if (study == null) {
			throw new NotExistException();
		}
		return study;
	}

	/**
	 * 스터디 주제로 검색
	 * @param keyword
	 * @throws NotExistException 
	 */
	public List<Study> getStudyByTopic(String keyword) throws SQLException, NotExistException {
		List<Study> studyList = getStudyDAO.getStudyByTopic(keyword);
		if (studyList.size() == 0) {
			throw new NotExistException();
		}
		return studyList;
	}

	// INSERT
	/**
	 * 새로운 수강생 정보와 출석 정보 함께 추가
	 * @param name, address, major
	 */
	public boolean addStudent(String name, String address, String major) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			Student student = new Student();
			student.setStudentName(name);
			student.setAddress(address);
			student.setMajor(major);

			Attendance attendance = new Attendance();
			attendance.setStudentId(student);
			attendance.setPresent(0);
			attendance.setLate(0);
			attendance.setAbsent(0);

			em.persist(student);
			em.persist(attendance);
			tx.commit();
			
			result = true;

		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
			em = null;
		}
		return result;
	}

	/**
	 * 스터디 추가
	 * @param keyword
	 * @throws InsertException 
	 */
	public void addStudy(String studyName, String topic, int studentId, String meetingDate) throws SQLException, InsertException {
		Student student = getStudentDAO.getStudentById(studentId);
		getStudyDAO.insertStudy(studyName, topic, student, meetingDate);
	}

	// UPDATE
	/** 수강생정보 업데이트 */
	public boolean updateStudent(int searchNo, int studentId, Object info) throws SQLException, NullPointerException {
		boolean result = false;
		if (searchNo == 1) {
			result = getStudentDAO.updateStudentAddress(studentId, info);
		} else if (searchNo == 2) {
			result = getStudentDAO.updateStudentMajor(studentId, info);
		} else if (searchNo == 3) {
			result = getStudentDAO.updateStudentStudyId(studentId, info);
		} else {
			return result;
		}
		return result;
	}

	/**
	 * 출석 체크
	 * @param studentId
	 */
	public Student updatePresent(int studentId) throws SQLException{
		return getAttendanceDAO.updatePresent(studentId);
	}

	/**
	 * 스터디 정보 업데이트
	 * @param keyword
	 * @throws InsertException 
	 * @throws NotExistException 
	 */
	public void updateStudy(int id, String meetingDate) throws SQLException, NotExistException, InsertException {
		getStudyDAO.updateStudy(id, meetingDate);
	}

	// DELETE
	/** 수강생ID로 수강생정보+출석정보 삭제 */
	public boolean deleteStudent(int studentId) throws SQLException, NullPointerException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;
		Student student = null;
		Attendance attendance = null;

		try {
			student = (Student) em.createNamedQuery("getStudentById").setParameter("studentId", studentId)
					.getSingleResult();
			attendance = (Attendance) em.createNamedQuery("Attendance.findBystudentId")
					.setParameter("studentId", student).getSingleResult();

			em.remove(attendance);
			em.remove(student);
			tx.commit();

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return result;
	}

	/**
	 * 스터디 삭제
	 * @param id
	 * @throws DeleteException 
	 * @throws NotExistException 
	 */
	public void deleteStudy(int id) throws SQLException, NotExistException {
		getStudyDAO.deleteStudy(id);
	}

}
