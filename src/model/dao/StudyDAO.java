package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;

import exception.DeleteException;
import exception.InsertException;
import exception.NotExistException;
import model.domain.Student;
import model.domain.Study;
import util.PublicCommon;

public class StudyDAO {
	public static StudyDAO instance = new StudyDAO();

	public StudyDAO() {
	}

	public static StudyDAO getInstance() {
		return instance;
	}

	/** 모든 스터디 검색 */
	public List<Study> getAllStudy() throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();

		List<Study> allStudyList = null;

		try {
			allStudyList = em.createNamedQuery("Study.findStudentAll").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return allStudyList;
	}

	/** 스터디 id로 스터디 검색 
	 * @throws NotExistException */
	public Study getStudyById(int id) throws SQLException, NotExistException {
		EntityManager em = PublicCommon.getEntityManager();

		Study study = null;

		try {
			study = (Study) em.createNamedQuery("Study.findBystudyId").setParameter("studyId", id).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NotExistException();
		} finally {
			em.close();
			em = null;
		}
		return study;
	}

	/** 스터디 주제 키워드로 스터디 검색 */
	public List<Study> getStudyByTopic(String keyword) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		List<Study> studyList = null;

		try {
			studyList = em.createNamedQuery("Study.findByTopic").setParameter("topicKeyword", "%" + keyword + "%")
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return studyList;
	}

	/** 스터디 추가 
	 * @throws InsertException */
	public void insertStudy(String studyName, String topic, Student student, String meetingDate) throws SQLException, InsertException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Study newStudy = new Study();
		try {
			newStudy.setStudyName(studyName);
			newStudy.setTopic(topic);
			newStudy.setLeaderId(student);
			newStudy.setMeetingDate(meetingDate);

			em.persist(newStudy);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new InsertException();
		} finally {
			em.close();
			em = null;
		}
	}

	/**
	 * 스터디 정보 변경
	 * @param study
	 * @throws InsertException 
	 */
	public void updateStudy(int id, String meetingDate) throws SQLException, NotExistException, InsertException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Study study = null;
		 
		try {
			study = (Study) em.createNamedQuery("Study.findBystudyId").setParameter("studyId", id).getSingleResult();
			study.setMeetingDate(meetingDate);
			tx.commit();
		} catch (NoResultException e) {
			e.printStackTrace();
			throw new NotExistException();
		} catch (Exception e) {
			e.printStackTrace();			
			throw new InsertException();	
		} finally {
			em.close();
			em = null;
		}

	}

	/**
	 * 스터디 삭제
	 * @param id
	 * @throws DeleteException 
	 */
	public void deleteStudy(int id) throws SQLException, NotExistException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Study study = null;
		try {
			study = (Study) em.createNamedQuery("Study.findBystudyId").setParameter("studyId", id).getSingleResult();
			em.remove(study);
			tx.commit();
		} catch (NoResultException e) {
			e.printStackTrace();
			throw new NotExistException();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}
}