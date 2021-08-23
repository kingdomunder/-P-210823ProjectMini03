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
	void getOneStudent() {
		EntityManager em = PublicCommon.getEntityManager();
		
		Student s = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", 1).getSingleResult();
		System.out.println(s);
		
		em.close();
		em = null;
		
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
	
	
	
	
	
	//스터디 1개 정보 select
//	@Test
	void getOneStudy() {
		EntityManager em = PublicCommon.getEntityManager();
		
		Study s = (Study) em.createNamedQuery("Study.findBystudyId").setParameter("studyId", 1).getSingleResult();
		System.out.println(s);
		
		em.close();
		em = null;
	
	}	
		
	
	//스터디 정보 전부 select
	@Test
	void getAllStudy() {
		EntityManager em = PublicCommon.getEntityManager();
		
		List<Study> all = em.createNamedQuery("Study.findStudentAll").getResultList();
		all.forEach(v -> System.out.println(v));
		
		em.close();
		em = null;
		
	}		
	
	
}
