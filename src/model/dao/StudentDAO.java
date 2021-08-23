package model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import model.domain.Student;
import util.PublicCommon;

public class StudentDAO {
	public static StudentDAO instance = new StudentDAO();
			
	public StudentDAO(){}
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
			}finally {
				em.close();
				em = null;
				PublicCommon.close();

			}
			return allStudentList;
		}	
		
		/** 수강생 id로 수강생 검색 */
		public static Student getOneStudent() {
			EntityManager em = PublicCommon.getEntityManager();
			
			Student student = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", 1).getSingleResult();
			System.out.println(student);
			
			PublicCommon.close();
			
			return student;
		}	
	
	
	
	
}
