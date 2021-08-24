package model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

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
	public static List<Student> getAllStudent() throws SQLException{
		EntityManager em = PublicCommon.getEntityManager();
		List<Student> allStudentList = null;
		
		try {
			allStudentList = em.createNamedQuery("Student.findStudentAll").getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			em = null;
		}
		return allStudentList;
	}

	//수강생 1명 정보 select
//	@Test
//	public static Student getOneStudent(int studentId) {
//		EntityManager em = PublicCommon.getEntityManager();
//		
//
//		/** 수강생 하나 검색 - 스터디ID로 */
//		public static Student getOneStudent() {
//			EntityManager em = PublicCommon.getEntityManager();
//			
//			Student student = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", 1).getSingleResult();
//			System.out.println(student);
//			
//
//
//		}
//		return allStudentList;
//	}

  
}

