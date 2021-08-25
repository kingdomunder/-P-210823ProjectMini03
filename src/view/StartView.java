package view;
import controller.Controller;
import model.domain.Student;
import model.domain.Study;
public class StartView {
	private static Controller controller = Controller.getInstance();
	public static void main(String[] args) {
		// SELECT
		System.out.println("========== 1. 모든 수강생 검색 ==========");
		controller.getAllStudent();
		System.out.println("\n========== 2. 검색 조건으로 수강생 검색 ==========");
		/** (1,수강생ID입력-int), (2,수강생이름입력-String), (3,전공입력-String), (4,스터디ID입력-int) */
		System.out.println("\n========== 2-1. 수강생 id로 검색 ==========");
		controller.getSearchedStudent(1, 1);
		System.out.println("\n========== 2-2. 수강생 이름으로 검색 ==========");
		controller.getSearchedStudent(2, "장혜민");
		System.out.println("\n========== 2-3. 전공으로 검색 ==========");
		controller.getSearchedStudent(3, "경찰행정학과");
		System.out.println("\n========== 2-4. 참여 스터디로 검색 ==========");
		controller.getSearchedStudent(4, 1);
		System.out.println("\n========== 2-4-1. 없는 정보로 검색 ==========");
		controller.getSearchedStudent(3, "컴퓨터공학과");
		System.out.println("\n========== 3. 모든 출석 정보 검색 ==========");
		controller.getAllAttendance();
		System.out.println("\n========== 4. 수강생 한명의 출석 정보 검색 ==========");
		controller.getOneAttendance(1);
		System.out.println("\n========== 4-1. 없는 수강생 출석 정보 검색 ==========");
		controller.getOneAttendance(10);
		System.out.println("\n========== 5. 출결 모범 수강생 검색 ==========");
		controller.getPerfectPresent();
		System.out.println("\n========== 6. 지각3회 이상 학생 조회 ==========");
		controller.getLateStudent();
		System.out.println("\n========== 7. 결석3회 이상 학생 조회 ==========");
		controller.getAbsentStudent();
		System.out.println("\n========== 8. 모든 스터디 검색 ==========");
		controller.getAllStudy();
		System.out.println("\n========== 9. 스터디 id로 특정 스터디 검색 ==========");
		controller.getStudyById(2);
		System.out.println("\n========== 9-1. 없는 id로 특정 스터디 검색 ==========");
		controller.getStudyById(10);
		System.out.println("\n========== 10. 스터디 주제로 특정 스터디 검색 ==========");
		controller.getStudyByTopic("알고리즘");
		System.out.println("\n========== 10-1. 일치하는 키워드 없을 때 ==========");
		controller.getStudyByTopic("팝핀");
		// INSERT
		System.out.println("\n========== 11. 새로운 수강생 정보와 출석 정보 함께 추가 ==========");
		controller.addStudent("류현진", "미국", null);
		System.out.println("\n========== 11-1. 추가 후 조회 ==========");
		controller.getAllStudent();
		System.out.println("\n========== 12. 스터디 추가 ==========");
		controller.addStudy("SQLD 대비", "꼭 따고 만다 SQLD 자격증!", 3, "목");
		System.out.println("\n========== 12-1. null값 입력했을 때 ==========");
		controller.addStudy(null, "스터디주제", 2, "금");
		// UPDATE
		System.out.println("\n========== 13. 수강생 정보 변경 ==========");
		/** (1,수강생ID,변경할 주소), (2,수강생ID,변경할 전공), (3,수강생ID,변경할 스터디ID) */
		
		System.out.println("\n========== 13-1. 주소 정보 변경 ==========");
		controller.updateStudent(1, 1, "평양");
		System.out.println("\n========== 13-1-1. null값 입력해서 주소 변경 시도시 ==========");
		controller.updateStudent(1, 1, null);
		System.out.println("\n========== 13-1-2. 없는 학생의 주소 변경 시도시 ==========");
		controller.updateStudent(1, 10, "개성");
		
		System.out.println("\n========== 13-2. 전공 정보 변경 ==========");
		controller.updateStudent(2, 1, "물리학과");
		
		System.out.println("\n========== 13-3. 스터디 정보 변경 (새로운 스터디 참가)==========");
		controller.updateStudent(3, 2, 3);
		System.out.println("\n========== 13-3-1. 없는 스터디 참가 시도시 ==========");
		controller.updateStudent(3, 2, 100);
		
		System.out.println("\n========== 13-4. 스터디 정보 변경 (스터디 탈퇴)==========");
		controller.updateStudent(3, 2, null);
		System.out.println("\n========== 13-4-1. 원래 스터디 없는데 탈퇴 시도시 ==========");
		controller.updateStudent(2, 2, null);
		
		System.out.println("========== 14. 출석 체크 ==========");
		controller.updatePresent(1);
		System.out.println("\n========== 14-1. 없는 학생 출석 체크 시도 ==========");
		controller.updatePresent(10);
		System.out.println("\n========== 15. 지각 체크 ==========");
		controller.updateLate(4);
		System.out.println("\n========== 16. 결석 체크 ==========");
		controller.updateAbsent(4);
		System.out.println("\n========== 17. 스터디 정보 변경 (날짜 수정) ==========");
		controller.updateStudy(1, "일");
		System.out.println("\n========== 17-1. null값 입력해서 스터디 정보 변경 시도시 ==========");
		controller.updateStudy(1, null);
		System.out.println("\n========== 17-2. 없는 스터디 변경 시도시 ==========");
		controller.updateStudy(10, "일");
		// DELETE
		System.out.println("\n========== 18. 학생 정보 삭제 ==========");
		controller.deleteStudent(1); // 안됨..
		System.out.println("\n========== 18-1. 학생 정보 삭제시 출결정보도 함께 삭제 확인 ==========");
		controller.getOneAttendance(1);
		System.out.println("\n========== 18-2. 없는 학생 삭제 시도시 ==========");
		controller.deleteStudent(100);
		System.out.println("\n========== 19. 스터디 삭제 ==========");
		controller.deleteStudy(1);
		System.out.println("\n========== 19-1. 없는 스터디 삭제 시도시 ==========");
		controller.deleteStudy(100);
	}
}