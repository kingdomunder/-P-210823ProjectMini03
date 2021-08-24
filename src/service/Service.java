package service;

import java.sql.SQLException;
import java.util.List;

import model.dao.AttendanceDAO;
import model.dao.StudentDAO;
import model.dao.StudyDAO;
import model.domain.Attendance;
import model.domain.Student;
import model.domain.Study;

public class Service {
	
	private static Service instance = new Service();
	
	private static AttendanceDAO getAttendanceDAO = AttendanceDAO.getInstance();
	private static StudentDAO getStudentDAO = StudentDAO.getInstance();
	private static StudyDAO getStudyDAO = StudyDAO.getInstance();
	
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
		
		/** 수강생 하나 검색 */
//		public static Student getOneStudents(int searchNo, Object student) throws SQLException{
//			if (searchNo == 1) {
//				Object serach = (int)student;
//				
//			}
//			if (searchNo == 2) {
//				Object serach = (String)student;
//				
//			}
//			if (searchNo == 3) {
//				Object serach = (Study)student;
//				
//			}
//			
//			Student oneStudent = getStudentDAO.getOneStudent();
//			if (oneStudent == null) {
//				throw new NullPointerException();
//			}
//			return oneStudent;
//		}
//		
		
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
    
    /** 새로운 수강생 정보와 출석 정보 함께 추가
     * @param name, address, major */
    public void addStudent(String name, String address, String major) throws SQLException {
    	 getAttendanceDAO.addStudent(name, address, major);
    }
    
    /** 출석 체크 */
    public Attendance addPresent(int studentId) {
    	return getAttendanceDAO.addPresent(studentId);
    }
}