package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attendance {
	@Id
	@Column(name="student_no")
	private int studentNo;
	
	private Short present;
	
	private Short tardy;
	
	private Short absent;

}
