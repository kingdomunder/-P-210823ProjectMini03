package view;

import java.util.List;

import model.domain.Study;

public class EndView {
	/** 모든 리스트 내역 출력 */
	public static void showAllList(List<Study> list) {
//		System.out.println(list);
		
		System.out.println("--------------------------------");
		
		int length = list.size();
		if (length != 0) {
//			System.out.println(1);
//			System.out.println(list);
//			list.forEach(v -> System.out.println(v));
			
			for (int i=0 ; i<length ; i++) {
				System.out.println(list.get(i).getStudyId() + list.get(i).getStudyName());
			}
			
			System.out.println(2);
		} else {
			System.out.println("해당 내역이 없습니다.");
		}
	} 
	

	/** 에러메세지 출력 */
	public static void showError(String message) {
		System.out.println(message);
	}

}
