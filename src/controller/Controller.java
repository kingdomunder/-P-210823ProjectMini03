package controller;

import java.sql.SQLException;

import org.hibernate.PersistentObjectException;

import exception.InsertException;
import exception.NotExistException;
import lombok.extern.slf4j.Slf4j;
import model.domain.Student;
import service.Service;
import view.EndView;

@Slf4j
public class Controller {
	private static Controller instance = new Controller();
	private static Service service = Service.getInstance();

	public Controller() {
	}

	public static Controller getInstance() {
		return instance;
	}

	// SELECT
	/** 모든 수강생 검색 */
	public void getAllStudent(){
		
		try {
			EndView.showAllList(service.getAllStudents());
		}catch(SQLException e){
			e.printStackTrace();
			EndView.showError("수강생 정보가 존재하지 않습니다");
		}catch(NullPointerException e){
			e.printStackTrace();
			EndView.showError("수강생 정보가 존재하지 않습니다");
		}catch(NotExistException e){
			e.printStackTrace();
			EndView.showError("수강생 정보가 존재하지 않습니다");
		}
	}
	
	/** 검색조건으로 수강생 검색 */
	public void getSearchedStudent(int searchNo, Object info) {
		try {
			if (searchNo == 1) {
				EndView.showOne(service.getOneStudents(info));
			} else {
				EndView.showAllList(service.getSearchedStudents(searchNo, info));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("수강생 정보가 존재하지 않습니다");
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("수강생 정보가 존재하지 않습니다");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("수강생 정보가 존재하지 않습니다");
		}
	}

	/**
	 * 학생 한명의 출석정보 검색
	 * @param studentId
	 */
	public void getOneAttendance(int studentId) {
		try {
			EndView.showOne(service.getOneAttendance(studentId));
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("학생 번호를 다시 확인해 주세요.");
		}
	}

	/** 지각, 결석 없는 모범생 검색 */
	public void getPerfectPresent() {
		try {
			EndView.showAllList(service.getPerfectPresent());
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("출결 모범 수강생이 없습니다.");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("출결 모범 수강생이 없습니다.");
		}
	}
	
	/** 지각 3번 이상인 수강생 검색 */
	public void getLateStudent() {
		try {
			EndView.showAllList(service.getAbsentStudent());
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("지각 3번 이상인 수강생이 없습니다.");
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("지각 3번 이상인 수강생이 없습니다.");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("지각 3번 이상인 수강생이 없습니다.");
		}
	}

	/** 결석 3번 이상인 수강생 검색 */
	public void getAbsentStudent() {
		try {
			EndView.showAllList(service.getAbsentStudent());
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("결석 3번 이상인 수강생이 없습니다.");
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("결석 3번 이상인 수강생이 없습니다.");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("결석 3번 이상인 수강생이 없습니다.");
		}
	}

	/** 모든 출석 정보 검색 */
	public void getAllAttendance() {
		try {
			EndView.showAllList(service.getAllAttendance());
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("출석 정보가 없습니다.");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("출석 정보가 없습니다.");
		}

	}

	/** 모든 스터디 검색 */
	public void getAllStudy() {
		try {
			EndView.showAllList(service.getAllStudy());
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		}
	}

	/**
	 * 스터디 id로 스터디 검색
	 * @param id
	 */
	public void getStudyById(int id) {
		try {
			EndView.showOne(service.getStudyById(id));
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다.");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("해당 스터디가 존재하지 않습니다.");
		}

	}

	/** 스터디 주제로 스터디 검색 */
	public void getStudyByTopic(String keyword) {
		try {
			EndView.showAllList(service.getStudyByTopic(keyword));
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("해당 스터디가 존재하지 않습니다.");
		}
	}

	// INSERT
	/**
	 * 새로운 수강생 정보와 출석 정보 함께 추가
	 * @param name, address, major
	 */
	public void addStudent(String name, String address, String major) {
		try {
			service.addStudent(name, address, major);
				EndView.showMessage("반갑습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("수강생정보 생성에 실패했습니다");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("수강생정보 생성에 실패했습니다");
		}
	}

	/** 스터디 추가 */
	public void addStudy(String studyName, String topic, int studentId, String meetingDate) {
		try {
			service.addStudy(studyName, topic, studentId, meetingDate);
			EndView.showMessage("스터디 저장에 성공했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("스터디 저장에 실패했습니다.");
		} catch (InsertException e) {
			EndView.showError("스터디 저장에 실패했습니다.");
		}

	}

	// UPDATE
	/** 수강생정보 업데이트 */
	public void updateStudent(int searchNo, int studentId, Object info) {
		try {
			service.updateStudent(searchNo, studentId, info);
			EndView.showMessage("업데이트 성공했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("수강생정보 업데이트 실패했습니다");
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("수강생정보 업데이트 실패했습니다");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("수강생정보 업데이트 실패했습니다");
		} 
	}

	/**
	 * 출석 체크
	 * @param studentId
	 */
	public void updatePresent(int studentId) {
		Student student = null;
		try {
			student = service.updatePresent(studentId);
			if (student == null) {
				EndView.showError("출석 체크 실패?!");
			} else {
				log.error(student.getStudentName()+" 출석체크 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("출석 체크 실패?!");
		} catch(NotExistException e){
				e.printStackTrace();
				EndView.showError("출석 체크 실패?!");
			}
		}
	
	/**
	 * 지각 체크
	 * @param studentId
	 */
	public void updateLate(int studentId) {
		Student student = null;
		try {
			student = service.updateLate(studentId);
			if (student == null) {
				EndView.showError("지각 체크 실패?!");
			} else {
				log.error(student.getStudentName()+" 지각 체크 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("지각 체크 실패?!");
		}catch(NotExistException e){
			e.printStackTrace();
			EndView.showError("지각 체크 실패?!");
		}
	}
	
	/**
	 * 결석 체크
	 * @param studentId
	 */
	public void updateAbsent(int studentId) {
		Student student = null;
		try {
			student = service.updateAbsent(studentId);
			if (student == null) {
				EndView.showError("결석 체크 실패?!");
			} else {
				log.error(student.getStudentName()+" 결석 체크 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("결석 체크 실패?!");
		}catch(NotExistException e){
			e.printStackTrace();
			EndView.showError("결석 체크 실패?!");
		}
	}

	/** 스터디 정보 변경 - 날짜 변경 */
	public void updateStudy(int id, String meetingDate) {
		try {
			service.updateStudy(id, meetingDate);
			EndView.showMessage("변경에 성공했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("변경에 실패했습니다.");
		} catch (NotExistException e) {
			EndView.showError("해당 스터디는 존재하지 않습니다.");
		} catch (InsertException e) {
			e.printStackTrace();
			EndView.showError("변경에 실패했습니다. 입력정보를 확인하세요.");
		}
	}

	// DELETE
	/** 스터디 삭제 */
	public void deleteStudy(int id) {
		try {
			service.deleteStudy(id);
			EndView.showMessage("삭제에 성공했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("변경에 실패했습니다.");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("해당 스터디는 존재하지 않습니다.");
		} 
	}

	/** 수강생ID로 수강생정보+출석정보 삭제 */
	public void deleteStudent(int studentId) {
		boolean result = false;
		try {
			result = service.deleteStudent(studentId);
			if (result == false) {
				EndView.showError("삭제하려는 학생이 존재하지 않습니다");
			} else {
				EndView.showMessage("삭제 성공했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("삭제하려는 학생이 존재하지 않습니다");
		} catch (PersistentObjectException e) {
			e.printStackTrace();
			EndView.showError("삭제하려는 학생이 존재하지 않습니다");
		}
	}
}