package xia.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xia.dao.impl.StudentDaoImpl;
import xia.model.Student;
import xia.service.StudentManager;

public class StudentDaoTest {

	@Test
	public void testGetbyId() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl dao =(StudentDaoImpl)ctx.getBean("s");
		System.out.print(dao.getById(1).getStudentName());
		ctx.close();
	}
	@Test
	public void testGetSet() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl dao =(StudentDaoImpl)ctx.getBean("s");
		List<Student> stus = dao.getStudents();
		for(Student s : stus){
			System.out.print(s.getStudentName());
		}
		ctx.close();
	}
	@Test
	public void testSave() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl dao =(StudentDaoImpl)ctx.getBean("s");
		Student s = new Student();
		s.setStudentName("teng");
		dao.save(s);
		ctx.close();
	}
	
	@Test
	public void checkStudentExistsWithName(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl dao =(StudentDaoImpl)ctx.getBean("s");
		Student s = new Student();
		assertTrue(dao.checkStudentExistsWithName("teng"));
		ctx.close();
	}
	@Test
	public void testGetbyname() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl dao =(StudentDaoImpl)ctx.getBean("s");
		Student s = new Student();
		s=dao.getByName("aac");
		System.out.print(s.getPassword());
		ctx.close();
	}
}
