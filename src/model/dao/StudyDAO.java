package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Study;
import util.PublicCommon;

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
				
			
//			/** 스터디주제 키워드로 스터디 검색 */
//			jpql = "select s from Study s where study_topic like '%파이썬%'";
//			List<Study> StudyListByTopic = em.createQuery(jpql).getResultList();
			
			/** 스터디 정보 업데이트 - 멤버 변경 */
			
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();   // 혹시나 에러가 발생하면 롤백시킴
		}finally {
			em.close();
		}
	}
}
