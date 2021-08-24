package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
			}catch(Exception e){
			}finally {
				em.close();
				em = null;

			}
			return allStudentList;
		}	
		
		/** 검색조건으로 수강생 검색 - 수강생ID로 - 언제나 1명만 출력*/
		public Student getStudentById(int studentId) throws SQLException{
			EntityManager em = PublicCommon.getEntityManager();
			
			Student result = (Student)em.createNamedQuery("getStudentById").setParameter("studentId", studentId).getSingleResult();
			
			em.close();
			em = null;
			
			return result;
		}	
		
		/** 검색조건으로 수강생 검색 - 이름으로 */
		public List<Student> getStudentByName(String studentName) throws SQLException{
			EntityManager em = PublicCommon.getEntityManager();
			List<Student> result = null;
			
			result = (List<Student>)em.createNamedQuery("getStudentByName").setParameter("studentName", studentName).getResultList();
			
			em.close();
			em = null;
			
			return result;
		}	
		
		/** 검색조건으로 수강생 검색 - 전공으로 */
		public List<Student> getStudentByMajor(String major) throws SQLException{
			EntityManager em = PublicCommon.getEntityManager();
			List<Student> result = new ArrayList<>();
			result = (List<Student>)em.createNamedQuery("getStudentBymajor").setParameter("major", major).getResultList();
			
			em.close();
			em = null;
			
			return result;
		}
		
		/** 검색조건으로 수강생 검색 - 스터디ID로 */
		public List<Student> getStudentByStudyId(Study studyId) throws SQLException{
			EntityManager em = PublicCommon.getEntityManager();
			List<Student> result = new ArrayList<>();
			result = (List<Student>)em.createNamedQuery("getStudentBystudyId").setParameter("studyId", studyId).getResultList();
			
			em.close();
			em = null;
			
			return result;
		}

		/** 수강생정보 업데이트 - 주소변경 */ 
		public boolean updateStudentAddress(int studentId, Object info) throws SQLException{
			EntityManager em = PublicCommon.getEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			boolean result = false;
			String address = (String)info;
			Student student = null;
			
			tx.begin();
			try {
				student = (Student)em.createNamedQuery("getStudentById").setParameter("studentId", studentId).getSingleResult();
				student.setAddress(address);
				tx.commit();
				result = true;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				em.close();
				em = null;
			}
			return result;
		}
		
		/** 수강생정보 업데이트 - 전공변경 */ 
		public boolean updateStudentMajor(int studentId, Object info) throws SQLException{
			EntityManager em = PublicCommon.getEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			boolean result = false;
			String major = (String)info;
			Student student = null;
			
			tx.begin();
			try {
				student = (Student)em.createNamedQuery("getStudentById").setParameter("studentId", studentId).getSingleResult();
				student.setMajor(major);;
				tx.commit();
				result = true;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				em.close();
				em = null;
			}
			return result;
		}
		
		/** 수강생정보 업데이트 - 스터디ID변경 */ 
		public boolean updateStudentStudyId(int studentId, Object info) throws SQLException, NullPointerException{
			EntityManager em = PublicCommon.getEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			boolean result = false;
			Study study = new Study();
			study.setStudyId((int)info);
			Student student = null;
			
			tx.begin();
			try {
				student = (Student)em.createNamedQuery("getStudentById").setParameter("studentId", studentId).getSingleResult();
				student.setStudyId(study);
				tx.commit();
				result = true;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				em.close();
				em = null;
			}
			return result;
		}
		

		
}
