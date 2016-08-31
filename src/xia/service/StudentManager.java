package xia.service;

import java.util.List;

import xia.model.Student;

public interface StudentManager {
	public abstract void add(Student student) throws Exception;
	
	public abstract boolean exists(Student s) throws Exception;	
	
	public List<Student> getUsers();
	
	public Student getById(int id);
	
	public boolean verifyPassword(String p1,String p2);
	
	public boolean verifyIdentity(String name,String password);

}
