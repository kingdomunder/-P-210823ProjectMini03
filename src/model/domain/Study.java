package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Study {
	@Id
	@Column(name="study_no")
	private int studyNo;
	
	private String studyName;
	
	private String member;
	
	@Column(name="meeting_date")
	private String meetingDate;

}
