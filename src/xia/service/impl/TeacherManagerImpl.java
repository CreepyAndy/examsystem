package xia.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import xia.dao.AdminDao;
import xia.dao.StudentDao;
import xia.dao.TeacherDao;
import xia.model.AdminSchool;
import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.Student;
import xia.model.Teacher;
import xia.model.TestPaper;
import xia.service.AdminManager;
import xia.service.TeacherManager;
@Component("teacherManager")
public class TeacherManagerImpl implements TeacherManager{
	private TeacherDao teacherDao;
	

	public TeacherDao getAdminDao() {
		return teacherDao;
	}
	@Resource(name="t")
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	@Override
	public void synthesizeChoicePaper (Set<QuestionBankChoice> qcs)
			throws Exception {
		TestPaper p = new TestPaper();
		p.setQcs(qcs);
		teacherDao.savePaper(p);
	}
	@Override
	public boolean verifyIdentity(String name, String password) {
		Teacher t;
		try {
			t = teacherDao.getByName(name);
		} catch (Exception e) {
			return false;
		}
		if(t.getPassword().equals(password))
			return true;
		return false;
	}









	
}
