package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(query="select e from Student e where e.stuNo=:stuNo", name="Student.findBystuNo") 
//@NamedQuery(query="select e from Emp e where e.empId=:empId", name="Emp.findByEmpId") 
//@NamedQuery(query="select e from Student e where e.deptId=:deptId", name="Student.findByDeptId")

@Entity
public class Student {
	@Id
	@Column(name="student_Id")
	private int stuNo;
	
	@Column(name="student_name")
	private String name;
	
	private String adderess;
	
	private String major;
	
	@Column(name="study_Id")
	private int studyNo;

	
	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", name=" + name + ", adderess=" + adderess + ", major=" + major
				+ ", studyNo=" + studyNo + "]";
	}

}
