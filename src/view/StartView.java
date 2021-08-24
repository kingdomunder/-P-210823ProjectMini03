package view;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import controller.Controller;
import util.PublicCommon;

public class StartView {
	@Test
	public void run() {
		
		System.out.println("===== 모든 스터디 조회 =====");
		Controller.getAllStudy();
	}
}
			
		
	

