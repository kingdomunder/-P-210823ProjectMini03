package view;

import controller.Controller;

public class StartView {
	
	private static Controller controller = Controller.getInstance();

	public static void main(String[] args) {

		/** 모든 수강생 검색 */
//		controller.getAllStudent();
		
		
		
		/** 모든 스터디 검색 */	
		controller.getAllStudy();

	}

}
