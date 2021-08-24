package view;

import java.util.ArrayList;
import java.util.List;

import model.domain.Attendance;
import model.domain.Student;
import model.domain.Study;

public class EndView {
	/** 모든 스터디 내역 출력 */
	public static void showAllStudy(List<Study> list) {		
		int length = list.size();
		if (length != 0) {					
			for (Study study : list) {
				System.out.println(study.getStudyId() + ". [" + study.getStudyName() + "] " + study.getTopic() + " (매주 " + study.getMeetingDate() + " 진행)");
			} 
		} else {
			System.out.println("해당 내역이 없습니다.");
		}
	}
			
	/** 특정 스터디 출력 */
	public static void showOneStudy(Study study) {
		System.out.println(study.getStudyId() + ". [" + study.getStudyName() + "] " + study.getTopic() + " (매주 " + study.getMeetingDate() + " 진행)");
	}
	
	
// toString 사용해야 하는 메소드 - 사용안하는게 좋을듯.. 힘듬...
	public static void showAllList(List list) {
		System.out.println("list:"+list.getClass());
		Student a = new Student();
		Study b = new Study();
		Attendance c = new Attendance();
		
		if(list.get(0).getClass() == a.getClass()) {
			System.out.println(a.getClass());
			System.out.println("print1");
		}
		if(list.get(0).getClass() == b.getClass()) {
			System.out.println(b.getClass());
			System.out.println("print2");
		}
		if(list.get(0).getClass() == c.getClass()) {
			System.out.println(c.getClass());
			System.out.println("print3");
		}
		
	} 

//	/** 모든 리스트 내역 출력 */
//	public static void showAllList(List list) {
//		int length = list.size();
//		if (length != 0) {
//			list.forEach(v -> System.out.println(v));
//		} else {
//			System.out.println("해당 내역이 없습니다.");
//		}
//	} 
	
	/** 1개 row 출력 */
	public static void showOne(Object oneRow) {
		System.out.println(oneRow);
	}
	

	/** 에러메세지 출력 */
	public static void showError(String message) {
		System.out.println(message);
	}

	

}
