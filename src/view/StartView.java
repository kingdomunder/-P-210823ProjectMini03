package view;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import controller.Controller;
import util.PublicCommon;

public class StartView {
	@Test
	public void run() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			System.out.println("===== 모든 스터디 조회 =====");
			Controller.getAllStudy();
			
		}catch(Exception e) {
			tx.rollback();   
		}finally {
			em.close();
		}
	}
	
}
