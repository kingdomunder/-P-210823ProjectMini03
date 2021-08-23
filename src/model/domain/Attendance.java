package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Attendance {
	@Id
	@JoinColumn(name="student_id")
	@OneToOne
	private int studentId;

	private int present;
	private int late;
	private int absent;

}
