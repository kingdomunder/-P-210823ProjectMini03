package model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import model.domain.Student;
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
				allStudentList = em.createNamedQuery("Student.findStudentAll").getResultList();
			}catch(Exception e) {
			}finally {
				em.close();
				em = null;

			}
			return allStudentList;
		}	
		
		/** 검색조건으로 수강생 검색 - 수강생ID로 */
		public Student getStudentById(int studentId) {
			EntityManager em = PublicCommon.getEntityManager();
			
			Student result = (Student)em.createNamedQuery("getStudentById").setParameter("studentId", studentId).getSingleResult();
			
			em.close();
			em = null;
			
			return result;
		}	
		
		/** 검색조건으로 수강생 검색 - 이름으로 */
		public Student getStudentByName(String studentName) {
			EntityManager em = PublicCommon.getEntityManager();
			
			Student result = (Student) em.createNamedQuery("getStudentByName").setParameter("studentName", studentName).getSingleResult();
			
			em.close();
			em = null;
			
			return result;
		}	
		
		/** 검색조건으로 수강생 검색 - 전공으로 */
		public Student getStudentByMajor(String major) {
			EntityManager em = PublicCommon.getEntityManager();
			
			Student result = (Student)em.createNamedQuery("getStudentBymajor").setParameter("major", major).getSingleResult();
			
			em.close();
			em = null;
			return result;
		}
		
		/** 검색조건으로 수강생 검색 - 스터디ID로 */
		public Student getStudentByStudyId(int studyId) {
			EntityManager em = PublicCommon.getEntityManager();
			
			System.out.println(studyId);
			
			Student result = (Student)em.createNamedQuery("getStudentBystudyId").setParameter("studyId", studyId).getSingleResult();
			
			em.close();
			em = null;
			System.out.println(result);
			return result;
		}
		
			
//		@Test
//		void m1() {
//			Student s = instance.getStudentByStudyId(1);
//			System.out.println(s);
//		}
	
	
}
