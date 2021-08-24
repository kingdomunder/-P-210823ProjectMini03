package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

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

	/** 스터디 id로 스터디 검색 */
	public Study getStudyById(int id) {
		EntityManager em = PublicCommon.getEntityManager();

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

	/** 스터디 주제 키워드로 스터디 검색 */
	public List<Study> getStudyByTopic(String keyword) {
		EntityManager em = PublicCommon.getEntityManager();
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
	
	/** 스터디 추가 */
	public void insertStudy(String studyName, String topic, Student student, String meetingDate) {
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
		} finally {
			em.close();
			em = null;
		}
	}

	/** 스터디 정보 변경 
	 * @param study */
	public void updateStudy(int id, String meetingDate) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Study study = null;
		
		try {
			study = (Study) em.createNamedQuery("Study.findBystudyId").setParameter("studyId", id).getSingleResult();
			study.setMeetingDate(meetingDate);
			tx.commit();
			
//			study.setMeetingDate(meetingDate);
//			em.merge(study);   //?????????????????????
//			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		
	}
	
	/** 스터디 삭제
	 * @param id */
	public void deleteStudy(int id) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Study study = null;
		try {
//			study = getStudyById(7);
			study = (Study) em.createNamedQuery("Study.findBystudyId").setParameter("studyId", id).getSingleResult();
			em.remove(study);
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		
	}
}