package view;

import java.util.List;

public class EndView {
	/** 모든 리스트 내역 출력 */
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
