package view;

import controller.Controller;

public class StartView {	
	private static Controller controller = Controller.getInstance();

	public static void main(String[] args) {

		/** 모든 수강생 검색 */
//		controller.getAllStudent();
		
		
		
//		System.out.println("** 모든 스터디 검색 **");
//		controller.getAllStudy();
		
//		System.out.println("** 스터디 id로 스터디 검색 **");
//		controller.getStudyById(2);

		System.out.println("** 스터디 주제로 스터디 검색 **");
		controller.getStudyByTopic("알고리즘");
		
	}

}
			
		
	

