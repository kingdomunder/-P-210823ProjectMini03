package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.domain.Student;
import util.PublicCommon;

public class StudentDAO {

	
	//수강생 1명 정보 select
	public static Student getOneStudent() {
		EntityManager em = PublicCommon.getEntityManager();
		
		Student student = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", 1).getSingleResult();
		System.out.println(student);
		
		PublicCommon.close();
		
		return student;
	}	
	
	//수강생 정보 전부 select
	public static List<Student> getAllStudent() {
		EntityManager em = PublicCommon.getEntityManager();
		
		List<Student> all = em.createNamedQuery("Student.findStudentAll").getResultList();
		all.forEach(v -> System.out.println(v));
		
		PublicCommon.close();
		
		return all;
		
	}	
	
	
}
