package xia.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.Student;
import xia.model.TestPaper;

public class AdminManagerTest {

	@Test
	public void testAddQuestion() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		AdminManager manager = (AdminManager)ctx.getBean("adminManager");
		QuestionBankChoice qc = new QuestionBankChoice();
		qc.setAnswer("B");
		qc.setChoiceA("apple");
		qc.setChoiceB("banna");
		qc.setChoiceC("cat");
		qc.setIsReading("n");
		qc.setKnowledgePoint("5.1");
		qc.setStem("Which is banna ?");
		manager.add(qc);
	}
	@Test
	public void testVerifyId() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		AdminManager manager = (AdminManager)ctx.getBean("adminManager");
		Assert.assertTrue(manager.verifyIdentity("1", "1234"))
		;
	}
	@Test
	public void testAddReadingQuestion() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		AdminManager manager = (AdminManager)ctx.getBean("adminManager");
		QuestionBankReading qr = new QuestionBankReading();
		qr.setKnowledgePoint("2");
		qr.setStem("fdsfddf dcfdfic dfjsjjjjjjjjjjjjjjjj cxccxoi  cxoivcx cioxcxc icoxci eni");
		Set<QuestionBankChoice> qs = new HashSet<QuestionBankChoice>();
		QuestionBankChoice qc = new QuestionBankChoice();
		qc.setId(2);
		qs.add(qc);
		qr.setQuestionChoice(qs);
		manager.addReading(qr);
	}
	@Test
	public void testUpdateReadingQuestion() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		AdminManager manager = (AdminManager)ctx.getBean("adminManager");
		QuestionBankReading qr = new QuestionBankReading();
		qr.setKnowledgePoint("2");
		qr.setStem("aa");
		qr.setId(1);
		Set<QuestionBankChoice> qs = new HashSet<QuestionBankChoice>();
		QuestionBankChoice qc = new QuestionBankChoice();
		qc.setId(3);
		qs.add(qc);
		
		qr.setQuestionChoice(qs);
		manager.updateReading(qr);
	}
	@Test
	public void testUpdateChoiceQuestion() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		AdminManager manager = (AdminManager)ctx.getBean("adminManager");
		QuestionBankChoice qc = new QuestionBankChoice();
		qc.setId(3);
		qc.setChoiceA("aaa");
		qc.setChoiceB("bbb");
		qc.setChoiceC("ccc");
		qc.setIsReading("n");
		qc.setKnowledgePoint("2");
		qc.setStem("fdsfzdd");
		qc.setAnswer("a");
		//qr.setQuestionChoice(qs);
		manager.updateChoice(qc);
	}
	@Test
	public void testList() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		AdminManager m = (AdminManager)ctx.getBean("adminManager");
		List<QuestionBankChoice> qc = m.listQuestion();
		System.out.println(qc.get(0).getAnswer());
		
	}
	@Test
	public void testDelQuestion() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		AdminManager m = (AdminManager)ctx.getBean("adminManager");
		QuestionBankChoice qc = new QuestionBankChoice();
		qc.setId(5);
		m.delQuestion(qc);
		
	}
	@Test
	public void testListPapers() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		AdminManager m = (AdminManager)ctx.getBean("adminManager");
		List<TestPaper> ps = new ArrayList<TestPaper>();
		ps = m.listPapers();
		System.out.println(ps.get(2).getId());
		
	}
	@Test
	public void testListChosenQustionInAPaper() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		AdminManager m = (AdminManager)ctx.getBean("adminManager");
		List<QuestionBankChoice> qcs = m.listChosenQuestionsInOnePaper(3);
		for(int i=0;i<qcs.size();i++){
			System.out.println(qcs.get(i).getId()+" ");
		}
		
	}
	
	@Test
	public void testcreatePaper() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		AdminManager m = (AdminManager)ctx.getBean("adminManager");
		System.out.println(m.createPaper());
		ctx.close();
		
	}

}
