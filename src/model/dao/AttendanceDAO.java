package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Attendance;
import model.domain.Student;
import util.PublicCommon;

public class AttendanceDAO {
	public static AttendanceDAO instance = new AttendanceDAO();
	
	public AttendanceDAO(){}
	public static AttendanceDAO getInstance() {
		return instance;
	}
	
	
		//수강생 1명 출석정보 select
//		@Test
		void getOneAttendance() {
			EntityManager em = PublicCommon.getEntityManager();
			
//			Student x = new Student(2, null, null, null, null);
			Student x = new Student();
			x.setStudentId(2);
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
		
//		@Test
		void addStudent() {
			EntityManager em = PublicCommon.getEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			try {
			Student student = new Student();
//			student.setStudentId(7);
			student.setStudentName("aa");
			student.setAddress("bb");
			student.setMajor("cc");
//			student.setStudyId(null);
			System.out.println("1");
			
			Attendance attendance = new Attendance();
			attendance.setStudentId(student);
			attendance.setPresent(5);
			attendance.setLate(5);
			attendance.setAbsent(5);
			System.out.println("2");
			
			em.persist(student);
			em.persist(attendance);
			System.out.println("3");
			
			tx.commit();
			System.out.println("4");
			
			}catch(Exception e) {
				tx.rollback();
			}finally {
				em.close();
				em = null;
			}
		}
		
	
	
}
