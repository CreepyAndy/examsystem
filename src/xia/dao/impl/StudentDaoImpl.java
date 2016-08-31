package xia.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;


import xia.dao.StudentDao;
import xia.model.Student;
@Component("s")
public class StudentDaoImpl implements StudentDao{
	private HibernateTemplate hibernateTemplate; 
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(Student stu) {
		hibernateTemplate.save(stu);
	}

	@Override
	public boolean checkStudentExistsWithName(String stuname) {
List<Student> stus = hibernateTemplate.find("from Student s where s.studentName = '" + stuname + "'");
		
		
		if(stus != null && stus.size() > 0) {
			return true;
		}
		return false;
	}
	@Override
	public Student getById(int id) {
		return (Student)this.hibernateTemplate.get(Student.class, id);
	}
	@Override
	public List<Student> getStudents() {
		return (List<Student>)this.hibernateTemplate.find("from Student");
	}
	@Override
	public Student getByName(String name){		
		List<Student> stus = hibernateTemplate.find("from Student s where s.studentName=?", name);
		
		   return stus.get(0);
		
	}

	
	
}
