package view;

import controller.Controller;
import model.domain.Student;
import model.domain.Study;

public class StartView {
	
	private static Controller controller = Controller.getInstance();

	public static void main(String[] args) {
		// SELECT
		System.out.println("*** 1. 모든 수강생 검색 ***");
		controller.getAllStudent();
		
		System.out.println("\n========== 2. 검색 조건으로 수강생 검색 ==========");
		/** (1,수강생ID입력-int), (2,수강생이름입력-String), (3,전공입력-String), (4,스터디ID입력-int) */ 
		
		System.out.println("========== 2-1. 수강생 id로 검색 ==========");
		controller.getSearchedStudent(1, 1);
		
		System.out.println("\n========== 2-2. 수강생 이름으로 검색 ==========");
		controller.getSearchedStudent(2, "장혜민");
		
		System.out.println("\n========== 2-3. 전공으로 검색 ==========");
		controller.getSearchedStudent(3, "경찰행정학과");
		
		System.out.println("\n========== 2-4. 참여 스터디로 검색 ==========");
		controller.getSearchedStudent(4, 1);
		
		System.out.println("\n========== 3. 모든 출석 정보 검색 ==========");
		controller.getAllAttendance();
		
		System.out.println("\n========== 4. 수강생 한명의 출석 정보 검색 ==========");
		controller.getOneAttendance(1);
    					
		System.out.println("\n========== 5. 결석3회 이상 학생 조회 ==========");
		controller.getAbsentStudent();
		
		System.out.println("\n========== 6. 모든 스터디 검색 ==========");
		controller.getAllStudy();

		System.out.println("\n========== 7. 스터디 id로 특정 스터디 검색 ==========");
		controller.getStudyById(2);
		
		System.out.println("\n========== 8. 스터디 주제로 특정 스터디 검색 ==========");
		controller.getStudyByTopic("알고리즘");
		
		// INSERT
		System.out.println("\n========== 9. 새로운 수강생 정보와 출석 정보 함께 추가 ==========");
		controller.addStudent("류현진", "미국", "야구학과");
		System.out.println("\n========== 9-1. 추가 후 조회 ==========");
		controller.getAllStudent();  // 여기에 출석일수도 같이 나왔음 좋겠다
		
		System.out.println("\n========== 10. 스터디 추가 ==========");
		controller.addStudy("SQLD 대비", "꼭 따고 만다 SQLD 자격증!", 3, "목");
		
		// UPDATE
		System.out.println("\n========== 11. 수강생 정보 변경 ==========");
		/** (1,수강생ID,변경할 주소), (2,수강생ID,변경할 전공), (3,수강생ID,변경할 스터디ID) */ 
		System.out.println("========== 11-1. 주소 정보 변경 ==========");
		controller.updateStudent(1, 1, "평양");
		System.out.println("========== 11-2. 주소 정보 변경 ==========");
		controller.updateStudent(2, 1, "물리학과");
		System.out.println("========== 11-3. 주소 정보 변경 ==========");
		controller.updateStudent(3, 1, 3);
		

		System.out.println("========== 출석 체크 ==========");
		controller.addPresent(4);		
		
		/** 스터디 정보 업데이트 - 스터디 날짜 수정*/
		controller.updateStudy(1, "일");
		System.out.println("\n 변경 후 조회");
		controller.getStudyById(1);
		
	
		// DELETE				
		System.out.println("\n** 스터디 삭제 **");
		controller.deleteStudy(8);
	}
}
			
		
