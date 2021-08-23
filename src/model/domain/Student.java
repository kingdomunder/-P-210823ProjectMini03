package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@Column(name="student_no")
	private int stuNo;
	
	private String name;
	
	private String adderess;
	
	private String major;
	
	@Column(name="study_no")
	private int studyNo;
	
	@Column(name="blog_info")
	private String blogInfo;

}
