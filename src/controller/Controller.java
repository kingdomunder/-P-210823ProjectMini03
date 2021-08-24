package controller;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.NoResultException;

import model.domain.Attendance;
import service.Service;
import view.EndView;

public class Controller {
	private static Controller instance = new Controller();
	private static Service service = Service.getInstance();

	public Controller() {
	}

	public static Controller getInstance() {
		return instance;
	}

	/** 모든 수강생 검색 */
	public static void getAllStudent() {

		try {
			EndView.showAllList(service.getAllStudents());
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NoResultException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		}
	}

	/** 검색조건으로 수강생 검색 */
	public void getSearchedStudent(int searchNo, Object student) {
		try {
			if (searchNo == 1) {
				EndView.showOne(service.getOneStudents(student));
			} else {
				EndView.showAllList(service.getSearchedStudents(searchNo, student));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NoResultException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		}
	}
//	
//	/** 모든 스터디 검색 */	
//	public static void getAllStudy() {		
//		try {
//			EndView.showAllStudy(service.getAllStudy());
//		} catch (SQLException e) {
//			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
//		}
//  }
//	
//	/** 스터디 id로 스터디 검색 
//	 * @param id */	
//	public void getStudyById(int id) {
//		try {
//			EndView.showOneStudy(service.getStudyById(id));
//		}catch (SQLException e) {
//			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
//		}
//		
//	}
//	
//	/** 스터디 주제로 스터디 검색 */
//	public void getStudyByTopic(String keyword) {
//		try {
//			EndView.showAllStudy(service.getStudyByTopic(keyword));
//		}catch (SQLException e) {
//			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
//		}
//	}

	/** 스터디 추가 */
	public void addStudy(String studyName, String topic, int studentId, String meetingDate) {
		try {
			service.addStudy(studyName, topic, studentId, meetingDate);
			EndView.showMessage("스터디 저장에 성공했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("스터디 저장에 실패했습니다.");
		} catch (NullPointerException e) {
			EndView.showError("스터디 저장에 실패했습니다.");
		}

	}

	/**
	 * 새로운 수강생 정보와 출석 정보 함께 추가
	 * 
	 * @param name, address, major
	 */
	public void addStudent(String name, String address, String major) {
		try {
			service.addStudent(name, address, major);
			EndView.showMessage("반갑습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("입력 정보를 확인해 주세요.");
		}

	}

	/**
	 * 출석 체크
	 * 
	 * @param studentId
	 */
	public void addPresent(int studentId) {
		try {
			EndView.showOne(service.addPresent(studentId));
			EndView.showMessage("출석 체크 완료.");
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("출석 체크 실패?!");
		}
	}

	/** 지각, 결석 없는 모범생 검색 */
	public void getPerfectPresent() {
		try {
			EndView.showAllList(service.getPerfectPresent());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	/** 결석 3번 이상인 수강생 검색 */
	public void getAbsentStudent() {
		try {
			EndView.showAllList(service.getAbsentStudent());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 학생 한명의 출석정보 검색
	 * 
	 * @param studentId
	 */
	public void getOneAttendance(int studentId) {
		try {
			EndView.showOne(service.getOneAttendance(studentId));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("학생 아이디를 다시 확인해 주세요.");
		}
	}

	/** 모든 출석 정보 검색 */
	public void getAllAttendance() {
		try {
			List<Attendance> allAttendanceList = service.getAllAttendance();
			System.out.println(service.getAllAttendance());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
