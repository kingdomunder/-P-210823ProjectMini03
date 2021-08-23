// JPA 사용하는 코드들이 공통적으로 사용하는 로직
// 자원반환도 고려
/*
 * EntityManager는 메소드별 개별 생성 및 활용 후에 자원 반환
 * 	- Connection 공유 금지와 동일한 개념
 * 
 * EntityManagerFactory는 실행되는 서버 내부에 한개의 객체 생성 및 활용
 */

package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PublicCommon {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDB");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();
		emf = null;
	}

}
