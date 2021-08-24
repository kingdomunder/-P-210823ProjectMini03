package controller;

import java.sql.SQLException;
import java.util.List;

import model.domain.Attendance;
import service.Service;
import view.EndView;

public class Controller {
	private static Controller instance = new Controller();
	private static Service service = Service.getInstance();
			
	public Controller() {}
	public static Controller getInstance() {
		return instance;
	}
	
	
//	/** 모든 수강생 검색 */
//	public static void getAllStudent() {		
//		try {
//			EndView.showAllList(service.getAllStudents());
//		} catch (SQLException e) {
//			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
//		}
//	}

//		/** 수강생 하나 검색 */
//		public void getOneStudent(int searchNo, Object student) {
//			try {
//				EndView.showOne(service.getOneStudents(searchNo, student));
//			} catch (SQLException e) {
//				e.printStackTrace();
//				EndView.showError("잘못된 정보를 입력하셨습니다");
//			} catch (NullPointerException e) {
//				e.printStackTrace();
//				EndView.showError("잘못된 정보를 입력하셨습니다");
//			}
//		}
//		
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
	
	/** 학생 한명의 출석정보 검색
     * @param studentId */
//    public Attendance getOneAttendance(int studentId) {
//    	Attendance attendance = service.getOneAttendance(studentId);
//    	if(attendance == null) {
//    		throw new NullPointerException();
//    	}
////    	return attendance;
//    	System.out.println(attendance);
//    	}
    
    /** 모든 출석 정보 검색*/
    public void getAllAttendance() {
    	try {
    		List<Attendance> allAttendanceList = service.getAllAttendance();
//			EndView.showAllList(service.getAllStudents());
    		System.out.println(service.getAllAttendance());
		} catch (SQLException e) {
			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NullPointerException e) {
			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
		}
    }
    
    /** 새로운 수강생 정보와 출석 정보 함께 추가
     * @param name, address, major */
    public void addStudent(String name, String address, String major) {
    	try {
			service.addStudent(name, address, major);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    /** 출석 체크
     * @param studentId */
    public void addPresent(int studentId) {
    	try {
    	System.out.println(service.addPresent(studentId));
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}