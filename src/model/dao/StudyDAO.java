package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import model.domain.Study;
import util.PublicCommon;

@Slf4j
public class StudyDAO {
	/** 모든 스터디 검색 */	
	public void getAllStudy() {   
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			List<Study> allStudyList = em.createNamedQuery("Study.findStudentAll").getResultList();
			allStudyList.forEach(System.out::println);
				
			tx.commit();
		}catch(Exception e) {
			tx.rollback();   
		}finally {
			em.close();
		}
	}
	
	/** 스터디 id로 스터디 검색 */
	public void getStudyById(int studyId) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			Study study = (Study)em.createNamedQuery("Study.findBystudyId").setParameter("studyId", studyId).getSingleResult();
			System.out.println(study);
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();   
		}finally {
			em.close();
		}
	}
	
	/** 스터디 주제 키워드로 스터디 검색 */
	public void getStudyByTopic() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			List<Study> studyListByTopic = em.createNamedQuery("Study.findByTopic").setParameter("topicKeyword", "%파이썬%").getResultList();
			studyListByTopic.forEach(System.out::println);
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();   
		}finally {
			em.close();
		}		
	}
}