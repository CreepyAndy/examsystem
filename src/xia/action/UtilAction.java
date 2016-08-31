package xia.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import xia.model.Student;
import xia.service.AdminManager;
import xia.service.StudentManager;
import xia.service.TeacherManager;

import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Component("utilAction")
public class UtilAction extends ActionSupport implements SessionAware{
	private String username;
	private String password;
	private String loginType;
	private Map session;
	private StudentManager sm;
	private TeacherManager tm;
	private AdminManager am;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public StudentManager getSm() {
		return sm;
	}
	@Resource(name="studentManager")
	public void setSm(StudentManager sm) {
		this.sm = sm;
	}
	public TeacherManager getTm() {
		return tm;
	}
	@Resource(name="teacherManager")
	public void setTm(TeacherManager tm) {
		this.tm = tm;
	}
	public AdminManager getAm() {
		return am;
	}
	@Resource(name="adminManager")
	public void setAm(AdminManager am) {
		this.am = am;
	}
	@Override
	public String execute() throws Exception {
        if (loginType.equals("student")) {
			if(sm.verifyIdentity(username, password)){
				session.put("student", username);
				return "student";
			};
		}
		if (loginType.equals("teacher")) {
			if(tm.verifyIdentity(username, password)){
				session.put("teacher", username);
				return "teacher";
			}
		}
		if (loginType.equals("admin")) {
			if(am.verifyIdentity("1", password)){
				
				return "admin";
			};
		}
		return "fail";
	}
	public String logout() throws Exception{
		ServletActionContext.getRequest().getSession().invalidate();
		return "index";
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
