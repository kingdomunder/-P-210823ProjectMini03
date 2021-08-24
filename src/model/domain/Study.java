package model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
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
@SequenceGenerator(name="study_seq", sequenceName="study_idx", initialValue=1, allocationSize=1)
@NamedQuery(query="select s from Study s", name="Study.findStudentAll") 
@NamedQuery(query="select s from Study s where s.studyId=:studyId", name="Study.findBystudyId") 
@NamedQuery(query="select s from Study s where s.topic like :topicKeyword", name="Study.findByTopic")
public class Study {
	@Id
	@Column(name="study_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="study_seq")
	private int studyId;
	
	@Column(name="study_name")
	private String studyName;
	
	private String topic;
	
	@OneToOne
	@JoinColumn(name="leader_id")
	private Student leaderId;  
	
	@Column(name="meeting_date")
	private String meetingDate;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="studyId")   
	List<Student> students = new ArrayList<Student>();


}

