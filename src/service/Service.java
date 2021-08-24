package service;

import model.dao.StudentDAO;
import model.dao.StudyDAO;
import model.domain.Student;
import model.domain.Study;

public class Service {
	
	private static Service instance = new Service();
	
	private static StudentDAO getStudentDAO = StudentDAO.getInstance();
	private static StudyDAO getStudytDAO = StudyDAO.getInstance();
	
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
		public static Student getOneStudents(int searchNo, Object student) throws SQLException{
			if (searchNo == 1) {
				Object serach = (int)student;
				
			}
			if (searchNo == 2) {
				Object serach = (String)student;
				
			}
			if (searchNo == 3) {
				Object serach = (Study)student;
				
			}
			
			Student oneStudent = getStudentDAO.getOneStudent();
			if (oneStudent == null) {
				throw new NullPointerException();
			}
			return oneStudent;
		}
		
		
		/** 모든 스터디 검색 */	
		public static List<Study> getAllStudy() throws SQLException{
			List<Study> allStudyList = getStudytDAO.getAllStudy();
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
=======
