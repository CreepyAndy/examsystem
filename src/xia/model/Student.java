package xia.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_student")
public class Student {
	private int id;
	private String studentName;
	private String password;
	
	private Set<Teacher> teachers = new HashSet<Teacher>();
	private ClassRoom cr;
	
	@ManyToMany(mappedBy="students")
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	private Set<WrongAnswer> wrongAnswer = new HashSet<WrongAnswer>();	
	@ManyToOne
	public ClassRoom getCr() {
		return cr;
	}
	public void setCr(ClassRoom cr) {
		this.cr = cr;
	}

	
	@OneToMany
	@JoinColumn(name="stuId")
	public Set<WrongAnswer> getWrongAnswer() {
		return wrongAnswer;
	}
	public void setWrongAnswer(Set<WrongAnswer> wrongAnswer) {
		this.wrongAnswer = wrongAnswer;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentname) {
		this.studentName = studentname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
