package view;

import controller.Controller;
import model.domain.Study;

public class StartView {	
	private static Controller controller = Controller.getInstance();

	public static void main(String[] args) {

		/** 모든 수강생 검색 */
//		controller.getAllStudent();
		
		/** 수강생 하나 검색 */
//		controller.getOneStudent(1,2);
		
		/** 수강생 하나 검색 - 전공으로 */
//		controller.getOneStudent();
		

//		System.out.println("\n** 모든 스터디 검색 **");
//		controller.getAllStudy();
		
//		System.out.println("\n** 스터디 id로 스터디 검색 **");
//		controller.getStudyById(2);

//		System.out.println("\n** 스터디 주제로 스터디 검색 **");
//		controller.getStudyByTopic("알고리즘");
//		
//		System.out.println("\n** 스터디 추가 **");
//		controller.addStudy("SQLD 대비", "꼭 따고 만다 SQLD 자격증!", 3, "목");
//		
		System.out.println("\n** 스터디 정보 업데이트 - 스터디 날짜 수정**");
		controller.updateStudy(1, "일");
		System.out.println("\n 변경 후 조회");
		controller.getStudyById(1);
				
		System.out.println("\n** 스터디 삭제 **");
		controller.deleteStudy(8);
	}

}
			
		
	

