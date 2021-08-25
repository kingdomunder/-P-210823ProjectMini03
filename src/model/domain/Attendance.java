package model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@NamedQuery(query = "select e from Attendance e where e.studentId=:studentId order by e.studentId", name = "Attendance.findBystudentId")
@NamedQuery(query = "select e from Attendance e order by e.studentId", name = "Attendance.findStudentAll")
@Entity
public class Attendance implements Serializable {

	@Id
	@JoinColumn(name = "student_id")
	@OneToOne
	private Student studentId;

	private int present;
	
	private int late;
	
	private int absent;

}
