package xia.service;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xia.model.QuestionBankChoice;

public class TeacherManagerTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		TeacherManager m = (TeacherManager)ctx.getBean("teacherManager");
		Set<QuestionBankChoice> qcs = new HashSet<QuestionBankChoice>();
		QuestionBankChoice qc = new QuestionBankChoice();
		qc.setId(5);
		QuestionBankChoice qc2 = new QuestionBankChoice();
		qc2.setId(4);
		qcs.add(qc);
		qcs.add(qc2);
		try {
			m.synthesizeChoicePaper(qcs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testLogin() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		TeacherManager m = (TeacherManager)ctx.getBean("teacherManager");
		
		Assert.assertTrue(m.verifyIdentity("zhou", "1234"));
	}

}
