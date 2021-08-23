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
	void getOneAttendance() {
		EntityManager em = PublicCommon.getEntityManager();
		
		Student x = new Student(2, null, null, null, null);
		
		Attendance s = (Attendance) em.createNamedQuery("Attendance.findBystudentId").setParameter("studentId", x).getSingleResult();
		System.out.println(s);
		
		
		em.close();
		em = null;
	}
	
	
	//출석 정보 전부 select
//	@Test
	void getAllAttendance() {
		EntityManager em = PublicCommon.getEntityManager();
		
		List<Attendance> all = em.createNamedQuery("Attendance.findStudentAll").getResultList();
		all.forEach(v -> System.out.println(v));
		
		em.close();
		em = null;
		
	}	
	
	
}
