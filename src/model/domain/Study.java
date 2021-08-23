package model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@SequenceGenerator(name="study_seq", sequenceName="study_id_seq", initialValue=1, allocationSize=1)
public class Study {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="study_seq")  
	@Column(name="study_id")
	private int studyId;
	
	@Column(name="study_name")
	private String studyName;
	
	private String topic;
	
//	@JoinColumn(name="leader_id")
//	@OneToOne
	@Column(name="leader")
	private int leaderId;  // student_id 1번학생
	
	@Column(name="meeting_date")
	private String meetingDate;
	
//	@JoinColumn
//	@OneToMany(mappedBy="studyId")   
//	List<Student> students = new ArrayList<Student>();

	

}
