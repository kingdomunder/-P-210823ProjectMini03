package model.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@SequenceGenerator(name="attendance_seq", sequenceName="attendance_idx", initialValue=1, allocationSize=1)
public class Attendance {
	// @Id와 @JoinColumn 동시 사용 안되는듯... attendanceId 생성하는거말고 다른방법이 있을까요?ㅠ
	@Id
	@Column(name="attendance_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="attendance_seq")
	private int attendanceId;
	
	@JoinColumn(name="student_id")
	@OneToOne
	private Student studentId;

	private int present;
	private int late;
	private int absent;
	
	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", studentId=" + studentId + ", present=" + present
				+ ", late=" + late + ", absent=" + absent + "]";
	}
	
}
