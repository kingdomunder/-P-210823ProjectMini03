package model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Attendance;
import model.domain.Student;
import util.PublicCommon;

public class AttendanceDAO {
	public static AttendanceDAO instance = new AttendanceDAO();

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
//		void getAllAttendance() {
//			EntityManager em = PublicCommon.getEntityManager();
//			
//			List<Attendance> all = em.createNamedQuery("Attendance.findStudentAll").getResultList();
//			all.forEach(v -> System.out.println(v));
//			
//			em.close();
//			em = null;
//			
//		}	
		
//		@Test
//		void addStudent() {
//			EntityManager em = PublicCommon.getEntityManager();
//			EntityTransaction tx = em.getTransaction();
//			tx.begin();
//			
//			try {
	// 새로운 수강생 정보와 출석 정보 함께 추가
//	@Test
	public void addStudent(String name, String address, String major) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Student student = new Student();
			student.setStudentName(name);
			student.setAddress(address);
			student.setMajor(major);
			
			Attendance attendance = new Attendance();
			attendance.setStudentId(student);
			attendance.setPresent(10);
			attendance.setLate(10);
			attendance.setAbsent(10);
			
			em.persist(student);
			em.persist(attendance);
			
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
			em = null;
		}
	}

	// 출석 체크
//	@Test
	public Attendance addPresent(int studentId) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Attendance attendance = null;
		Student student = new Student();
		int present = 0;
		try {
			student.setStudentId(studentId);
			attendance = (Attendance) em.createNamedQuery("Attendance.findBystudentId")
					.setParameter("studentId", student).getSingleResult();
			present = attendance.getPresent();
			attendance.setPresent(present + 1);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
			em = null;
		}
		return attendance;
	}
	
	//결석 3번 이상인 수강생 검색
//	@Test
	public void getAbsentStudent() {
		EntityManager em = PublicCommon.getEntityManager();
		List<Attendance> attendanceList = null;
		attendanceList = em.createNamedQuery("Attendance.findStudentAll").getResultList();
		try {
				if (attendanceList != null) {
					attendanceList.stream().filter(absent -> absent.getAbsent() >= 3).forEach(absent -> System.out.println(absent));
				} else {
					System.out.println("현재까지 결석 3번 이상인 수강생이 없습니다.");
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			em = null;
		}
	}
	
	// 학생 한명의 출석정보 검색
//	@Test
	public Attendance getOneAttendance(int studentId) {

		EntityManager em = PublicCommon.getEntityManager();
		Attendance attendance = null;
		try {
			Student student = (Student) em.createNamedQuery("Student.findBystudentId")
					.setParameter("studentId", studentId).getSingleResult();

			attendance = (Attendance) em.createNamedQuery("Attendance.findBystudentId")
					.setParameter("studentId", student).getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return attendance;
	}

	// 출석 정보 전부 검색
//	@Test
	public List<Attendance> getAllAttendance() {
		EntityManager em = PublicCommon.getEntityManager();
		List<Attendance> allAttendanceList = null;
		try {
			allAttendanceList = em.createNamedQuery("Attendance.findStudentAll").getResultList();
		} catch (Exception e) {
		} finally {
			em.close();
			em = null;
		}
		return allAttendanceList;
	}
}