package xia.hibernatetest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xia.dao.AdminDao;
import xia.dao.TeacherDao;
import xia.model.QuestionBankChoice;
import xia.service.AdminManager;
import xia.service.TeacherManager;

public class UpdateTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		//TeacherManager m = (TeacherManager)ctx.getBean("teacherManager");
		//TeacherDao d = (TeacherDao)ctx.getBean("t");
		AdminDao ad = (AdminDao)ctx.getBean("a");
		QuestionBankChoice qc = new QuestionBankChoice();
		qc.setAnswer("ans");
		qc.setId(5);
		ad.updateChoice(qc);
		
	}

}
