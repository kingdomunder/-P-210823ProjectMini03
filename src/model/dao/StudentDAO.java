package model.dao;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import model.domain.Student;
import util.PublicCommon;

public class StudentDAO {

	@Test
	void getAllStudent() {
		EntityManager em = PublicCommon.getEntityManager();
		
		Student s = (Student) em.createNamedQuery("student.findBystudent_Id").setParameter("student_Id", 1).getSingleResult();
		System.out.println(s);
		
		
		em.close();
		em = null;
		
		
	}
}
