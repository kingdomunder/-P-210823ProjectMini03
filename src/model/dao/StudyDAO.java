package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
	public static List<Study> getAllStudy() throws SQLException {
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

	/** 스터디 id로 스터디 검색 */
	public static Study getStudyById(int id) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		Study study = null;

		try {
			study = (Study) em.createNamedQuery("Study.findBystudyId").setParameter("studyId", id).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}

		return study;
	}

	/**
	 * 스터디 주제 키워드로 스터디 검색
	 * 
	 * @return
	 */
	public static List<Study> getStudyByTopic(String keyword) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<Study> studyList = null;
		
		try {
			studyList = em.createNamedQuery("Study.findByTopic").setParameter("topicKeyword", "%"+keyword+"%").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return studyList;
	}
}