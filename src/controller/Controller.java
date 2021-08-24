package controller;

import java.sql.SQLException;

import service.Service;
import view.EndView;

public class Controller {

	public static void getAllStudy() {		
		try {
			
			EndView.showAllList(Service.getAllStudy());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
				
	}

}
