package model.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Attendance {
	@Id
//	@JoinColumn(name="student_id")
//	@OneToOne
	@Column(name="student_id")
	private int studentId;

	private int present;
	private int late;
	private int absent;

	
}
