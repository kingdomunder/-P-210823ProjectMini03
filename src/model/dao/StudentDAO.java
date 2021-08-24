package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import model.domain.Attendance;
import model.domain.Student;
import model.domain.Study;
import util.PublicCommon;

public class StudentDAO {

	//수강생 1명 정보 select
//	@Test
	public static Student getOneStudent(int studentId) {
		EntityManager em = PublicCommon.getEntityManager();
		
		Student student = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", 1).getSingleResult();
		System.out.println(student);
		
		em.close();
		em = null;
		return student;
	}	
	
	//수강생 정보 전부 select
//	@Test
	void getAllStudent() {
		EntityManager em = PublicCommon.getEntityManager();
		
		List<Student> all = em.createNamedQuery("Student.findStudentAll").getResultList();
		all.forEach(v -> System.out.println(v));
		
		em.close();
		em = null;
	}		
}