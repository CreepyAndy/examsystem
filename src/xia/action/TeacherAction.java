package xia.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.Student;
import xia.service.AdminManager;
import xia.service.StudentManager;
import xia.service.TeacherManager;
import xia.service.impl.StudentManagerImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Component("teacherAction")
public class TeacherAction extends ActionSupport {
	private TeacherManager tm ;
	
	@Resource(name="TeacherManager")
	public void setTm(TeacherManager tm) {
		this.tm = tm;
	}
	public TeacherManager getTm() {
		return tm;
	}
	
	
}
