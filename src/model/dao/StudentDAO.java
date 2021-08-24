package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.domain.Student;
import model.domain.Study;
import util.PublicCommon;

public class StudentDAO {
	public static StudentDAO instance = new StudentDAO();

	public StudentDAO() {
	}

	public static StudentDAO getInstance() {
		return instance;
	}
	
	
		/** 모든 수강생 검색 */	
		public List<Student> getAllStudent() throws SQLException{
			EntityManager em = PublicCommon.getEntityManager();
			List<Student> allStudentList = null;
			
			try {
				allStudentList = em.createNamedQuery("getAllStudent").getResultList();
			}catch(Exception e) {
			}finally {
				em.close();
				em = null;

			}
			return allStudentList;
		}	
		
		/** 검색조건으로 수강생 검색 - 수강생ID로 - 언제나 1명만 출력*/
		public Student getStudentById(int studentId) {
			EntityManager em = PublicCommon.getEntityManager();
			
			Student result = (Student)em.createNamedQuery("getStudentById").setParameter("studentId", studentId).getSingleResult();
			
			em.close();
			em = null;
			
			return result;
		}	
		
		/** 검색조건으로 수강생 검색 - 이름으로 */
		public List<Student> getStudentByName(String studentName) {
			EntityManager em = PublicCommon.getEntityManager();
			List<Student> result = null;
			
			result = (List<Student>)em.createNamedQuery("getStudentByName").setParameter("studentName", studentName).getResultList();
			
			em.close();
			em = null;
			
			return result;
		}	

		
		
		/** 검색조건으로 수강생 검색 - 전공으로 */
		public List<Student> getStudentByMajor(String major) {
			EntityManager em = PublicCommon.getEntityManager();
			List<Student> result = new ArrayList<>();
			result = (List<Student>)em.createNamedQuery("getStudentBymajor").setParameter("major", major).getResultList();
			
			em.close();
			em = null;
			
			return result;
		}
		
		/** 검색조건으로 수강생 검색 - 스터디ID로 */
		public List<Student> getStudentByStudyId(Study studyId) {
			EntityManager em = PublicCommon.getEntityManager();
			List<Student> result = new ArrayList<>();
			result = (List<Student>)em.createNamedQuery("getStudentBystudyId").setParameter("studyId", studyId).getResultList();
			
			em.close();
			em = null;
			
			return result;
		}

}

