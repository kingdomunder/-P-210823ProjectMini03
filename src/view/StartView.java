package view;

import controller.Controller;
import model.domain.Student;

public class StartView {
	
	private static Controller controller = Controller.getInstance();

	public static void main(String[] args) {

		/** 모든 수강생 검색 */
//		controller.getAllStudent();
		
		/** 검색조건으로 수강생 검색 */ 
		/** (1,수강생ID입력), (2,수강생이름입력), (3,전공입력), (4,스터디ID입력) */ 
		controller.getSearchedStudent(4,1);
		
		/** 수강생 하나 검색 - 전공으로 */
//		controller.getOneStudent();
		
		/** 모든 스터디 검색 */	
//		controller.getAllStudy();

	
		
	}

}
