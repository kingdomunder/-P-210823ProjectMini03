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

	// 출석 체크
	public Student updatePresent(int studentId) throws SQLException{
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		int present = 0;
		Attendance attendance = null;
		Student student = new Student();

		try {
			student = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", studentId).getSingleResult();
			attendance = (Attendance) em.createNamedQuery("Attendance.findBystudentId").setParameter("studentId", student)
					.getSingleResult();
			present = attendance.getPresent();
			attendance.setPresent(present + 1);
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return student;
	}

	// 학생 한명의 출석정보 검색
	public Attendance getOneAttendance(int studentId) throws SQLException{
		EntityManager em = PublicCommon.getEntityManager();
		
		Attendance attendance = null;
		Student student = null;
		
		try {
			student = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", studentId)
					.getSingleResult();
			attendance = (Attendance) em.createNamedQuery("Attendance.findBystudentId").setParameter("studentId", student)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return attendance;
	}

	// 출석 정보 전부 검색
	public List<Attendance> getAllAttendance() throws SQLException{
		EntityManager em = PublicCommon.getEntityManager();
		
		List<Attendance> allAttendanceList = null;

		try {
			allAttendanceList = em.createNamedQuery("Attendance.findStudentAll").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return allAttendanceList;
	}
}