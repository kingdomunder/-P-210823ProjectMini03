package view;

import controller.Controller;
import model.domain.Student;
import model.domain.Study;

public class StartView {
	
	private static Controller controller = Controller.getInstance();

	public static void main(String[] args) {

//		/** 모든 수강생 검색 */
//		controller.getAllStudent();
//		
//		/** 검색조건으로 수강생 검색 */ 
//		/** (1,수강생ID입력-int), (2,수강생이름입력-String), (3,전공입력-String), (4,스터디ID입력-int) */ 
//		controller.getSearchedStudent(1,1);

//		/** 수강생정보 업데이트 */ 
//		/** (1,수강생ID,변경할 주소), (2,수강생ID,변경할 전공), (3,수강생ID,변경할 스터디ID) */ 
//		controller.updateStudent(3, 1, 3);
		
//		
//		System.out.println("\n** 스터디 정보 업데이트 - 스터디 날짜 수정**");
//		controller.updateStudy(1, "일");
//		System.out.println("\n 변경 후 조회");
//		controller.getStudyById(1);
//				
//		System.out.println("\n** 스터디 삭제 **");
//		controller.deleteStudy(1);
	
	
	
		
		
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
			
		
	

