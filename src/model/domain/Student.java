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

@NamedQuery(query="select e from Student e where e.studentId=:studentId", name="Student.findBystudentId") 
//@NamedQuery(query="select e from Emp e where e.empId=:empId", name="Emp.findByEmpId") 
//@NamedQuery(query="select e from Student e where e.deptId=:deptId", name="Student.findByDeptId")

@Entity
@SequenceGenerator(name="stu_seq", sequenceName="student_id_seq", initialValue=1, allocationSize=1)
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stu_seq")  
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	private String adderess;
	
	private String major;
	
	@ManyToOne
	@JoinColumn(name="study_id")
	private int studyId;
	
	
}
