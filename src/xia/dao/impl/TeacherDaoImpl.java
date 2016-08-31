package xia.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import xia.dao.AdminDao;
import xia.dao.TeacherDao;
import xia.model.AdminSchool;
import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.Student;
import xia.model.Teacher;
import xia.model.TestPaper;
@Component("t")
public class TeacherDaoImpl implements TeacherDao{
	private HibernateTemplate hibernateTemplate; 
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public void savePaper(TestPaper p) {
		hibernateTemplate.save(p);
	}
	@Override
	public Teacher getById(int id) {
		return (Teacher)this.hibernateTemplate.get(Teacher.class, id);
	}
	@Override
	public Teacher getByName(String name) {
		List<Teacher> stus = hibernateTemplate.find("from Teacher t where t.name=?", name);
		
		   return stus.get(0);
	}
	
	
}
