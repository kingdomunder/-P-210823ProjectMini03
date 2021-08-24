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
			attendance.setPresent(0);
			attendance.setLate(0);
			attendance.setAbsent(0);

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

		student.setStudentId(studentId);
		attendance = (Attendance) em.createNamedQuery("Attendance.findBystudentId").setParameter("studentId", student)
				.getSingleResult();
		present = attendance.getPresent();
		attendance.setPresent(present + 1);

		tx.commit();
		em.close();
		em = null;
		
		return attendance;
	}

	// 학생 한명의 출석정보 검색
//	@Test
	public Attendance getOneAttendance(int studentId) {
		EntityManager em = PublicCommon.getEntityManager();
		
		Attendance attendance = null;

		Student student = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", studentId)
				.getSingleResult();
		attendance = (Attendance) em.createNamedQuery("Attendance.findBystudentId").setParameter("studentId", student)
				.getSingleResult();

		em.close();
		em = null;

		return attendance;
	}

	// 출석 정보 전부 검색
//	@Test
	public List<Attendance> getAllAttendance() {
		EntityManager em = PublicCommon.getEntityManager();
		List<Attendance> allAttendanceList = null;

		allAttendanceList = em.createNamedQuery("Attendance.findStudentAll").getResultList();

		em.close();
		em = null;

		return allAttendanceList;
	}
}