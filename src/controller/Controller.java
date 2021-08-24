package controller;

import java.sql.SQLException;

import service.Service;
import view.EndView;

public class Controller {
	private static Controller instance = new Controller();
	private static Service service = Service.getInstance();
			
	public Controller() {}
	public static Controller getInstance() {
		return instance;
	}
	
	
	
		/** 모든 수강생 검색 */
		public static void getAllStudent(){
			
			try {
				EndView.showAllList(service.getAllStudents());
			}catch(SQLException e){
				e.printStackTrace();
				EndView.showError("잘못된 정보를 입력하셨습니다");
			}catch(NullPointerException e){
				e.printStackTrace();
				EndView.showError("잘못된 정보를 입력하셨습니다");
			}
		}

		/** 검색조건으로 수강생 검색 */ 
		public void getSearchedStudent(int searchNo, Object student){
			try {
				if(searchNo == 1) {
					EndView.showOne(service.getOneStudents(student));
				}else{
					System.out.println(service.getSearchedStudents(searchNo, student));
//					EndView.showAllList(service.getSearchedStudents(searchNo, student));
				}
			}catch(SQLException e){
				e.printStackTrace();
				EndView.showError("잘못된 정보를 입력하셨습니다");
			}catch(NullPointerException e){
				e.printStackTrace();
				EndView.showError("잘못된 정보를 입력하셨습니다");
			}
		}
		
	
	/** 모든 스터디 검색 */	
	public static void getAllStudy() {		
		try {
			EndView.showAllStudy(service.getAllStudy());
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		}

	}
	
	/** 스터디 id로 스터디 검색 
	 * @param id */	
	public void getStudyById(int id) {
		try {
			EndView.showOneStudy(service.getStudyById(id));
		}catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		}
		
	}
	
	/** 스터디 주제로 스터디 검색 */
	public void getStudyByTopic(String keyword) {
		try {
			EndView.showAllStudy(service.getStudyByTopic(keyword));
		}catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		}
		
	}	
	
}
