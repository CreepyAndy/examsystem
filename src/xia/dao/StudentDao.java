package xia.dao;

import java.util.List;

import xia.model.Student;

public interface StudentDao {
	public void save(Student stu);
	public boolean checkStudentExistsWithName(String stuname);  
	public List<Student> getStudents();
	public Student getById(int id);
	public Student getByName(String name);
}
