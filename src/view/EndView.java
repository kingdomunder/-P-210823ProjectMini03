package view;

import java.util.List;

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
		int length = list.size();
		if (length != 0) {
			list.forEach(v -> System.out.println(v));
		} else {
			System.out.println("해당 내역이 없습니다.");
		}
	} 
	

	/** 에러메세지 출력 */
	public static void showError(String message) {
		System.out.println(message);
	}

	

}
