package model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Study {
	@Id
	@Column(name="study_id")
	private int studyId;
	
	@Column(name="study_name")
	private String studyName;
	
	private String topic;
	
	@Column(name="leader_id")
	private int leaderId;  
	
	@Column(name="meeting_date")
	private String meetingDate;
	
	@OneToMany(mappedBy="studyId")   
	List<Student> students = new ArrayList<Student>();

	@Override
	public String toString() {
		return "Study [studyId=" + studyId + ", studyName=" + studyName + ", topic=" + topic + ", leaderId=" + leaderId
				+ ", meetingDate=" + meetingDate + "]";
	}

	
	

}
