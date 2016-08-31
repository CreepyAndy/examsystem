package xia.service;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xia.model.Student;

public class StudentManagerTest {

	@Test
	public void testSaveStu() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		StudentManager manager = (StudentManager)ctx.getBean("studentManager");
		Student s = new Student();
		s.setStudentName("fdsfds");
		try {
			System.out.print(manager.exists(s));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ctx.destroy();
		
	}
	@Test
	public void testverifyIdentity() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");		
		StudentManager manager = (StudentManager)ctx.getBean("studentManager");
		Assert.assertFalse(manager.verifyIdentity("aac", "fd"));
		ctx.destroy();
		
	}

}
