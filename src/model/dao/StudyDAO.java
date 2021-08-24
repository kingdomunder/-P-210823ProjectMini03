package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import lombok.extern.slf4j.Slf4j;
import model.domain.Study;
import util.PublicCommon;

//@Slf4j
public class StudyDAO {
	public static StudyDAO instance = new StudyDAO();
	
	public StudyDAO(){}
	public static StudyDAO getInstance() {
		return instance;
	}
	
		/** 모든 스터디 검색 */	
		public List<Study> getAllStudy() throws SQLException{   
			EntityManager em = PublicCommon.getEntityManager();
//			EntityTransaction tx = em.getTransaction();
//			tx.begin();
			
			List<Study> allStudyList = null;
			
			try {
				allStudyList = em.createNamedQuery("Study.findStudentAll").getResultList();
//				tx.commit();
			}catch(Exception e) {
//				tx.rollback();   
			}finally {
				em.close();
			}
			
			return allStudyList;
		}
		
		/** 스터디 id로 스터디 검색 */
		public static void getStudyById() {
			EntityManager em = PublicCommon.getEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			try {
				Study study = (Study)em.createNamedQuery("Study.findBystudyId").setParameter("studyId", 1).getSingleResult();
				System.out.println(study);
				
				tx.commit();
			}catch(Exception e) {
				tx.rollback();   
			}finally {
				em.close();
			}
		}
		
		/** 스터디 주제 키워드로 스터디 검색 */
		public static void getStudyByTopic() {
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
