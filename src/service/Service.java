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
	
	public Service() {}
	public static Service getInstance() {
		return instance;
	}
	
	
	
		/** 모든 수강생 검색 */
		public List<Student> getAllStudents() throws SQLException{
			List<Student> allStudentList = getStudentDAO.getAllStudent();
			if (allStudentList == null) {
				throw new NullPointerException();
			}
			return  allStudentList;
		}
		
		/** 검색조건으로 수강생 검색 - 수강생ID로 한명만 검색 */ 
		public Object getOneStudents(Object student) {
			int studentId = (int)student;
			Student result = getStudentDAO.getStudentById(studentId); 
			if(result == null) {
				throw new NullPointerException();
			}
			return result;
		}
		
		
		
		/** 검색조건으로 수강생 검색 - 검색조건으로 여러명 검색*/ 
		public Student getSearchedStudents(int searchNo, Object student) throws SQLException{
			Student result = null;
			
			if (searchNo == 2) {
				String studentName = (String)student;
				result = getStudentDAO.getStudentByName(studentName); 
			}
			if (searchNo == 3) {
				String major = (String)student;
				result = getStudentDAO.getStudentByMajor(major); 
			}
			if (searchNo == 4) {
//				Study studyId = new Study();
//				studyId.setStudyId((int)student);
				int studyId = (int)student;
				
				result = getStudentDAO.getStudentByStudyId(studyId); 
			}
			if (result == null) {
				throw new NullPointerException();
			}
			return result;
		}
		
		/** 모든 스터디 검색 */	
		public List<Study> getAllStudy() throws SQLException{
			List<Study> allStudyList = getStudyDAO.getAllStudy();
			if (allStudyList == null) {
				throw new NullPointerException();
			}
			return allStudyList;
		}
		
		
	
	
}
