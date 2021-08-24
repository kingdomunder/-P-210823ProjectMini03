package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import model.domain.Attendance;
import model.domain.Student;
import util.PublicCommon;

public class AttendanceDAO {
	
	//수강생 1명 출석정보 select
//	@Test
	void getOneAttendance(int studentId) {
		EntityManager em = PublicCommon.getEntityManager();
		
		Student student = new Student(studentId, null, null, null, null);
		
		Attendance attendance = (Attendance) em.createNamedQuery("Attendance.findBystudentId").setParameter("studentId", student).getSingleResult();
		System.out.println(attendance);
		
		em.close();
		em = null;
//		PublicCommon.close();
	}
	
	//출석 정보 전부 select
//	@Test
	void getAllAttendance() {
		EntityManager em = PublicCommon.getEntityManager();
		
		List<Attendance> all = em.createNamedQuery("Attendance.findStudentAll").getResultList();
		all.forEach(v -> System.out.println(v));
		
		em.close();
		em = null;
//		PublicCommon.close();
	}	
}