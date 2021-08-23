package model.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@SequenceGenerator(name="student_seq", sequenceName="student_idx", initialValue=1, allocationSize=1)
public class Student {
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq")
	private int studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	private String address;
	
	private String major;
	
	@JoinColumn(name="study_id")
	@ManyToOne
	private Study studyId;

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", address=" + address + ", major="
				+ major + "]";
	}
	
}
