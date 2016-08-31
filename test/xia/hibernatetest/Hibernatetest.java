package xia.hibernatetest;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Test;


import xia.model.*;

public class Hibernatetest {
	private static SessionFactory sessionFactory;
	private Session s;
	
	@BeforeClass
	public static void beforeClass(){
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	@Test
	public void testSaveStudent() {
		s=sessionFactory.openSession();
		s.beginTransaction();
		Student stu1=new Student();
		Student stu2=new Student();
		ClassRoom c221 = new ClassRoom();
		c221.setName("2013221");
		s.save(c221);
		stu1.setPassword("123");
		stu1.setStudentName("zhangsan");
		stu2.setPassword("123");
		stu2.setStudentName("lisi");
		stu1.setCr(c221);
		stu2.setCr(c221);
		Teacher t1 = new Teacher();
		t1.setName("zhouping");
		t1.getStudents().add(stu1);
		t1.getStudents().add(stu2);
		
		s.save(t1);
		s.save(stu1);
		s.save(stu2);
		s.getTransaction().commit();
		s.close();
	}
	@Test
	public void testSchemaExport(){
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}
	
	
	
	@AfterClass
    public static void afterClass(){
		sessionFactory.close();
	}

}
