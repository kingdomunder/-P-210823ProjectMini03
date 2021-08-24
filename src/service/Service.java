package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.dao.StudentDAO;
import model.domain.Attendance;
import model.domain.Student;
import util.PublicCommon;

public class Service {
	
	//수강생 정보 추가시 출석 정보 추가 int studentId, int present, int late, int absent
	@Test
	void addStudent() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
		Student student = new Student();
//		student = StudentDAO.getOneStudent(7);
		System.out.println("2");
		
		Attendance attendance = new Attendance();
		attendance.setStudentId(student);
		attendance.setPresent(5);
		attendance.setLate(5);
		attendance.setAbsent(5);
		System.out.println("3");
		
		em.persist(student);
		em.persist(attendance);
		System.out.println("4");
		
		tx.commit();
		System.out.println("1");
		
		}catch(Exception e) {
			tx.rollback();
		}finally {
			em.close();
			em = null;
		}
	}
}