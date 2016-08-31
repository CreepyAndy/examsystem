package xia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import xia.dao.StudentDao;
import xia.model.Student;
import xia.service.StudentManager;
@Component("studentManager")
public class StudentManagerImpl implements StudentManager{
	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}
	@Resource(name="s")
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	} 
	public void add(Student student) {
		studentDao.save(student);
	}
	@Override
	public boolean exists(Student s) throws Exception {
		return studentDao.checkStudentExistsWithName(s.getStudentName());
	}
	@Override
	public List<Student> getUsers() {
		return this.studentDao.getStudents();
	}
	@Override
	public Student getById(int id) {
		return this.studentDao.getById(id);
	}
	@Override
	public boolean verifyPassword(String p1,String p2) {
		if(p1.equals(p2))
		   return false;
		return true;
	}
	@Override
	public boolean verifyIdentity(String name, String password) {
		Student s;
		try {
			s = studentDao.getByName(name);
		} catch (Exception e) {
			return false;
		}
		if(s.getPassword().equals(password))
			return true;
		return false;
	}
	
}
