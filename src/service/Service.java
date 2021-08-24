package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

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
		public List<Student> getAllStudents() throws SQLException{
			List<Student> allStudentList = getStudentDAO.getAllStudent();
			if (allStudentList == null){
				throw new NullPointerException();
			}
			return  allStudentList;
		}
		
		
		/** 검색조건으로 수강생 검색 - 수강생ID로 한명만 검색 */ 
		public Object getOneStudents(Object info) throws SQLException{
			int studentId = (int)info;
			Student result = getStudentDAO.getStudentById(studentId); 
			if(result == null){
				throw new NullPointerException();
			}
			return result;
		}
		
		/** 검색조건으로 수강생 검색 - 검색조건으로 여러명 검색*/ 
		public List<Student> getSearchedStudents(int searchNo, Object info) throws SQLException{
			List<Student> result = null;
			if (searchNo == 2){
				String studentName = (String)info;
				result = getStudentDAO.getStudentByName(studentName); 
			}else if (searchNo == 3){
				String major = (String)info;
				result = getStudentDAO.getStudentByMajor(major); 
			}else if (searchNo == 4){
				Study studyId = new Study();
				studyId.setStudyId((int)info);
				result = getStudentDAO.getStudentByStudyId(studyId); 
			}
			if (result == null || result.size() == 0){
				throw new NullPointerException();
			}
			return result;
		}
  
  /** 지각, 결석 없는 모범생 검색 */
	@Test
	public List<Attendance> getPerfectPresent() {
		List<Attendance> attendanceList = getAttendanceDAO.getAllAttendance();
		List<Attendance> attendance = new ArrayList<>();

		if (attendanceList != null) {
			for (Attendance a : attendanceList) {
				if (a.getLate() == 0 && a.getAbsent() == 0) {
					attendance.add(a);
				}
  
           
 /** 결석 3번 이상인 수강생 검색 */
// 	@Test
	public List<Attendance> getAbsentStudent() {

		List<Attendance> attendanceList = getAttendanceDAO.getAllAttendance();
		List<Attendance> attendance = new ArrayList<>();

		if (attendanceList != null) {
			for (Attendance a : attendanceList) {
				if (a.getAbsent() >= 3) {
					attendance.add(a);
				}
			}
		}
		
  /** 학생 한명의 출석정보 검색
     * @param studentId */
    public Attendance getOneAttendance(int studentId) {
    	Attendance attendance = getAttendanceDAO.getOneAttendance(studentId);
    	if(attendance == null) {
    		throw new NullPointerException();
    	}
    	return attendance;
    	}
    
    /** 모든 출석 정보 검색*/
    public List<Attendance> getAllAttendance() throws SQLException{
    		List<Attendance> allAttendanceList = getAttendanceDAO.getAllAttendance();
			if (allAttendanceList == null) {
				throw new NullPointerException();
			}
			return allAttendanceList;
    }
  
  
  /** 모든 스터디 검색 */
	public List<Study> getAllStudy() throws SQLException {
		List<Study> allStudyList = getStudyDAO.getAllStudy();
		if (allStudyList == null) {
			throw new NullPointerException();
		}
		return allStudyList;
	}

	/**
	 * 스터디 id로 검색
	 * 
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
	 * 
	 * @param keyword
	 */
	public static List<Study> getStudyByTopic(String keyword) throws SQLException {
		List<Study> studyList = getStudyDAO.getStudyByTopic(keyword);
		if (studyList == null) {
			throw new NullPointerException();
		}
		return studyList;
	}
    
   // INSERT
	/**
	 * 새로운 수강생 정보와 출석 정보 함께 추가
	 * 
	 * @param name, address, major
	 */
	public void addStudent(String name, String address, String major) {
		try {
			service.addStudent(name, address, major);
			EndView.showMessage("반갑습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("입력 정보를 확인해 주세요.");
		}

	}
   
	/**
	 * 스터디 추가
	 * 
	 * @param keyword
	 */
	public void addStudy(String studyName, String topic, int studentId, String meetingDate) throws SQLException {
		Student student = getStudentDAO.getStudentById(studentId);
		getStudyDAO.insertStudy(studyName, topic, student, meetingDate);
	}
        
        
  // UPDATE  
  /** 수강생정보 업데이트 */ 
		public boolean updateStudent(int searchNo, int studentId, Object info) throws SQLException, NullPointerException{
			boolean result = false;
			if (searchNo == 1){
				result = getStudentDAO.updateStudentAddress(studentId, info); 
			}else if (searchNo == 2){
				result = getStudentDAO.updateStudentMajor(studentId, info); 
			}else if (searchNo == 3){
				result = getStudentDAO.updateStudentStudyId(studentId, info); 
			}
			return result;
		}
        
  /** 출석 체크
	 * @param studentId */   
	public void addPresent(int studentId) {
		try {
			EndView.showOne(service.addPresent(studentId));
			EndView.showMessage("출석 체크 완료.");
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("출석 체크 실패?!");
		}
	}

   /**
	 * 스터디 정보 업데이트
	 * @param keyword
	 */
	public void updateStudy(int id, String meetingDate) throws SQLException {
		getStudyDAO.updateStudy(id, meetingDate);
	}     
		
		
    // DELETE
		/** 수강생ID로 수강생정보+출석정보 삭제 */ 
		public boolean deleteStudent(int studentId) throws SQLException, NullPointerException{
			EntityManager em = PublicCommon.getEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			boolean result = false;
			Student student = null;
			Attendance attendance = null;

			try {
				student = (Student)em.createNamedQuery("getStudentById").setParameter("studentId", studentId).getSingleResult();
				attendance = (Attendance)em.createNamedQuery("Attendance.findBystudentId").setParameter("studentId", student).getSingleResult();
				
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
	 */
	public void deleteStudy(int id) throws SQLException {
		getStudyDAO.deleteStudy(id);
	}
    
  }
		
        
   

	
 
    

	


  

	
  
    
	
	

	
	
	
	
	
	
	

	
	
    
	
