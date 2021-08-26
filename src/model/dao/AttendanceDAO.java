package model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import exception.InsertException;
import exception.NotExistException;
import model.domain.Attendance;
import model.domain.Student;
import util.PublicCommon;

public class AttendanceDAO {
	public static AttendanceDAO instance = new AttendanceDAO();

	public AttendanceDAO() {
	}

	public static AttendanceDAO getInstance() {
		return instance;
	}

	// 출석정보 추가
	public void addPresent(int studentId) throws SQLException, NotExistException, InsertException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Attendance attendance = new Attendance();
		
		try {
			Student student = em.find(Student.class, studentId);
			attendance.setStudentId(student);
			attendance.setPresent(0);
			attendance.setLate(0);
			attendance.setAbsent(0);
			
			em.persist(attendance);
			tx.commit();
		} catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			throw new InsertException();
		}finally{
			em.close();
			em = null;
		}
	}
	
	// 출석 체크
	public Student updatePresent(int studentId) throws SQLException, NotExistException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		int present = 0;
		Attendance attendance = null;
		Student student = new Student();

		try {
			student = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", studentId)
					.getSingleResult();
			attendance = (Attendance) em.createNamedQuery("Attendance.findBystudentId")
					.setParameter("studentId", student).getSingleResult();
			present = attendance.getPresent();
			attendance.setPresent(present + 1);

			tx.commit();

		} catch (NoResultException e) {
			e.printStackTrace();
			throw new NotExistException();
		} finally {
			em.close();
			em = null;
		}
		return student;
	}

	// 지각 체크
	public Student updateLate(int studentId) throws SQLException, NotExistException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		int late = 0;
		Attendance attendance = null;
		Student student = new Student();

		try {
			student = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", studentId)
					.getSingleResult();
			attendance = (Attendance) em.createNamedQuery("Attendance.findBystudentId")
					.setParameter("studentId", student).getSingleResult();
			late = attendance.getLate();
			attendance.setLate(late + 1);

			tx.commit();

		} catch (NoResultException e) {
			e.printStackTrace();
			throw new NotExistException();
		} finally {
			em.close();
			em = null;
		}
		return student;
	}

	// 결석 체크
	public Student updateAbsent(int studentId) throws SQLException, NotExistException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		int absent = 0;
		Attendance attendance = null;
		Student student = new Student();

		try {
			student = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", studentId)
					.getSingleResult();
			attendance = (Attendance) em.createNamedQuery("Attendance.findBystudentId")
					.setParameter("studentId", student).getSingleResult();
			absent = attendance.getAbsent();
			attendance.setAbsent(absent + 1);

			tx.commit();

		} catch (NoResultException e) {
			e.printStackTrace();
			throw new NotExistException();
		} finally {
			em.close();
			em = null;
		}
		return student;
	}

	// 학생 한명의 출석정보 검색
	public Attendance getOneAttendance(int studentId) throws SQLException, NotExistException {
		EntityManager em = PublicCommon.getEntityManager();

		Attendance attendance = null;
		Student student = null;

		try {
			student = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", studentId)
					.getSingleResult();
			attendance = (Attendance) em.createNamedQuery("Attendance.findBystudentId")
					.setParameter("studentId", student).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			throw new NotExistException();
		} finally {
			em.close();
			em = null;
		}
		return attendance;
	}

	// 출석 정보 전부 검색
	public List<Attendance> getAllAttendance() throws SQLException, NotExistException {
		EntityManager em = PublicCommon.getEntityManager();

		List<Attendance> allAttendanceList = null;

		try {
			allAttendanceList = em.createNamedQuery("Attendance.findStudentAll").getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
			throw new NotExistException();
		} finally {
			em.close();
			em = null;
		}
		return allAttendanceList;
	}
}