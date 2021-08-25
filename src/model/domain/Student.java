package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@NamedQuery(query = "select e from Student e order by e.studentId", name = "getAllStudent")
@NamedQuery(query = "select e from Student e where e.studentId=:studentId order by e.studentId", name = "Student.findBystudentId")
@NamedQuery(query = "select e from Student e where e.studentName=:studentName order by e.studentId", name = "getStudentByName")
@NamedQuery(query = "select e from Student e where e.major=:major order by e.studentId", name = "getStudentBymajor")
@NamedQuery(query = "select e from Student e where e.studyId=:studyId order by e.studentId", name = "getStudentBystudyId")
@Entity
@SequenceGenerator(name = "student_seq", sequenceName = "student_idx", initialValue = 1, allocationSize = 1)
public class Student {
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	private int studentId;

	@Column(name = "student_name")
	private String studentName;

	private String address;

	private String major;

	@ManyToOne
	@JoinColumn(name = "study_id")
	private Study studyId;

}
