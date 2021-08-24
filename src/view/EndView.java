package view;

import java.util.ArrayList;
import java.util.List;

import model.domain.Attendance;
import model.domain.Student;
import model.domain.Study;

public class EndView {
	
	/** 모든 리스트 내역 출력 */
	public static void showAllList(List list) {
		if (list.get(0) instanceof Student) {
			for (Object student : list) {
				Student print = (Student) student;
				System.out.println(("ID=" + print.getStudentId() + " [" + print.getStudentName() + "]" + "(주소 = "
						+ print.getAddress() + ")" + "(전공 = " + print.getMajor() + ")" + "(스터디ID = "
						+ print.getStudyId() + ")"));
			}
		} else if (list.get(0) instanceof Study) {
			for (Object study : list) {
				Study print = (Study) study;
				System.out.println((print.getStudyId() + ". [" + print.getStudyName() + "] " + print.getTopic() + "(매주 "
						+ print.getMeetingDate() + " 진행)"));
			}
		} else if (list.get(0) instanceof Attendance) {
			for (Object attendance : list) {
				Attendance print = (Attendance) attendance;
				System.out.println(("ID = " + print.getStudentId() + "(출석 = " + print.getPresent() + ")" + "(지각 = "
						+ print.getLate() + ")" + "(결석 = " + print.getAbsent() + ")"));
			}
		}
	}

	/** 1개 row 출력 */
	public static void showOne(Object oneRow) {
		if (oneRow instanceof Student) {
			Student print = (Student) oneRow;
			System.out.println(("ID = " + print.getStudentId() + " [" + print.getStudentName() + "] " + "(주소 = "
					+ print.getAddress() + ")" + "(전공 = " + print.getMajor() + ")" + "(스터디ID = " + print.getStudentId()
					+ ")"));
		} else if (oneRow instanceof Study) {
			Study print = (Study) oneRow;
			System.out.println((print.getStudyId() + ". [" + print.getStudyName() + "] " + print.getTopic() + " (매주 "
					+ print.getMeetingDate() + " 진행)"));
		} else if(oneRow instanceof Attendance) {
			Attendance print = (Attendance) oneRow;
			System.out.println(("ID = " + print.getStudentId().getStudentId() + " ["
										+ print.getStudentId().getStudentName() + "] " + "(출석 = " + print.getPresent() + ")" + "(지각 = "
										+ print.getLate() + ")" + "(결석 = " + print.getAbsent() + ")"));
		}
	}

	/** 에러메세지 출력 */
	public static void showError(String message) {
		System.out.println(message);
	}

	/** 성공 메세지 출력 */
	public static void showMessage(String message) {
		System.out.println(message);
	}		
}