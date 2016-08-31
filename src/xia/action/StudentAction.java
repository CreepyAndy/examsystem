package xia.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import xia.model.Student;
import xia.service.StudentManager;
import xia.service.impl.StudentManagerImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Component("studentAction")
public class StudentAction extends ActionSupport {
	private StudentManager sm ;
	private String stuname;
	private String password;
	private String password2;
	/*public StudentAction(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		sm = (StudentManager)ctx.getBean("studentManager");
	}*/
	public String getstuname() {
		return stuname;
	}
	public void setstuname(String username) {
		this.stuname = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String add() throws Exception {
		Student s = new Student();
		s.setStudentName(stuname);
		s.setPassword(password);
		if(sm.exists(s)||sm.verifyPassword(password2, password)){
			return "fail";
		}
		System.out.println(stuname+" "+password+" "+password2);
		sm.add(s);
		return this.SUCCESS;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public StudentManager getSm() {
		return sm;
	}
	@Resource(name="studentManager")
	public void setSm(StudentManager sm) {
		this.sm = sm;
	}
	
}
