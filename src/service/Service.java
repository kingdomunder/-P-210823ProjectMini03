package service;

import java.sql.SQLException;
import java.util.List;

import model.dao.StudyDAO;
import model.domain.Study;
import model.domain.Study;

public class Service {
	public static List<Study> getAllStudy() throws SQLException{
		List<Study> allStudyList = StudyDAO.getAllStudy();
		System.out.println("service");
		
		
//		System.out.println("---- " + allStudyList);
		if (allStudyList == null) {
			throw new NullPointerException();
		}
		return allStudyList;
	}

}
