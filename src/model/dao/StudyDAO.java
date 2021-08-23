package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import model.domain.Student;
import model.domain.Study;
import util.PublicCommon;

@Slf4j
public class StudyDAO {
	@Test
	public void init() {   
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			
			/** 모든 스터디 검색 */	
			String jpql = "select s from Study s";  
			List<Study> allStudyList = em.createQuery(jpql).getResultList();
			allStudyList.forEach(System.out::println);
				
			/** 스터디 주제 키워드로 스터디 검색 */
			List<Study> studyListByTopic = em.createNamedQuery("Study.findByTopic").setParameter("topicKeyword", "%파이썬%").getResultList();
			studyListByTopic.forEach(System.out::println);
			
			/** 스터디 리더로 스터디 검색 */
			Study study = (Study)em.createNamedQuery("Study.findByLeader").setParameter("leader", 1).getSingleResult();
			System.out.println(study);
			
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();   
		}finally {
			em.close();
		}
	}
	
	
	//스터디 1개 정보 select
//	@Test
	void getOneStudy() {
		EntityManager em = PublicCommon.getEntityManager();
		
		Study s = (Study) em.createNamedQuery("Study.findBystudyId").setParameter("studyId", 1).getSingleResult();
		System.out.println(s);
		
		em.close();
		em = null;
	
	}	
		
	
	//스터디 정보 전부 select
	@Test
	void getAllStudy() {
		EntityManager em = PublicCommon.getEntityManager();
		
		List<Study> all = em.createNamedQuery("Study.findStudentAll").getResultList();
		all.forEach(v -> System.out.println(v));
		
		em.close();
		em = null;
		
	}	
	
	
	
}
