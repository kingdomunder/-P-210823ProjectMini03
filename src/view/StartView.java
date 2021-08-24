package view;

import controller.Controller;

public class StartView {
	
	private static Controller controller = Controller.getInstance();

	public static void main(String[] args) {

		/** 모든 수강생 검색 */
//		controller.getAllStudent();
		
		/** 수강생 하나 검색 */
//		controller.getOneStudent(1,2);
		
		/** 수강생 하나 검색 - 전공으로 */
//		controller.getOneStudent();
		

//		System.out.println("** 모든 스터디 검색 **");
//		controller.getAllStudy();
		
//		System.out.println("** 스터디 id로 스터디 검색 **");
//		controller.getStudyById(2);

//		System.out.println("** 스터디 주제로 스터디 검색 **");
//		controller.getStudyByTopic("알고리즘");
		
//		System.out.println("*** 수강생 한명의 출석 정보 검색 ***");
//		controller.getOneAttendance(1);
		
//		System.out.println("*** 모든 출석 정보 검색 ***");
//		controller.getAllAttendance();
		
//		System.out.println("*** 새로운 수강생 정보와 출석 정보 함께 추가 ***");
//		controller.addStudent("11", "11", "11");
		
//		System.out.println("*** 출석 체크 ***");
		controller.addPresent(3);
		
//		System.out.println("*** 결석3회 이상 학생 조회 ***");
//		controller.getAbsentStudent();
		
	}

}
			
		
	

