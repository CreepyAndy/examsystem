package xia.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xia.dao.impl.AdminDaoImpl;
import xia.dao.impl.StudentDaoImpl;
import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.Student;

public class AdminDaoTest {

	@Test
	public void testGetbyId() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AdminDaoImpl dao =(AdminDaoImpl)ctx.getBean("a");
		System.out.print(dao.getById(1).getName());
		ctx.close();
	}
	@Test
	public void testReadingArticle() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AdminDaoImpl dao =(AdminDaoImpl)ctx.getBean("a");
		QuestionBankReading qr = new QuestionBankReading();
		qr.setKnowledgePoint("3");
		qr.setStem("skills, tmpany, Nike. Nike was searching for an athlete with a disability to represent its trademark. A handful of superstar athletes with disabilities came to audition for the role, but the company picked Scott to star in the 30-second commercial.");
		dao.insertQuestionReading(qr);
		ctx.close();
	}
	@Test
	public void testGetChoiceQuestion() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AdminDaoImpl dao =(AdminDaoImpl)ctx.getBean("a");
		QuestionBankChoice qr = new QuestionBankChoice();
		qr=dao.getChoiceQuestionById(3);
		System.out.println(qr.getAnswer());
		ctx.close();
	}
	@Test
	public void testListPaper() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AdminDaoImpl dao =(AdminDaoImpl)ctx.getBean("a");
		System.out.println(dao.listPapers().get(3).getId());
		ctx.close();
	}
	@Test
	public void testOneToPaper() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AdminDaoImpl dao =(AdminDaoImpl)ctx.getBean("a");
		dao.saveOneQuestionToPaper(3, 2);
		ctx.close();
	}
	@Test
	public void testListChosenQuestions() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AdminDaoImpl dao =(AdminDaoImpl)ctx.getBean("a");
		List<QuestionBankChoice> qcs = dao.listChosenQuestions(3);
		//System.out.println(qcs.get(0).getId()+" "+qcs.get(1).getId());
		ctx.close();
	}
	
	@Test
	public void testdelPaper() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AdminDaoImpl dao =(AdminDaoImpl)ctx.getBean("a");
		dao.delPaper(4);
		ctx.close();
	}

	@Test
	public void testdelQuestionInPaper() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AdminDaoImpl dao =(AdminDaoImpl)ctx.getBean("a");
		dao.delQuestionInPaper(12, 3);
		ctx.close();
	}
}
