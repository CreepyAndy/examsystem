package xia.action;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.Student;
import xia.model.TestPaper;
import xia.service.AdminManager;
import xia.service.StudentManager;
import xia.service.impl.StudentManagerImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Component("adminAction")
public class AdminAction extends ActionSupport implements SessionAware{
	private AdminManager am ;
	private QuestionBankChoice qc = new QuestionBankChoice();
	private QuestionBankReading qr = new QuestionBankReading();
	private List<QuestionBankChoice> qcs = new ArrayList<QuestionBankChoice>();
	private List<TestPaper> papers = new ArrayList<TestPaper>();
	private Map session;
	private int qid;
	private int paperId;
	private TestPaper testPaper;
	public List<QuestionBankChoice> getQcs() {
		return qcs;
	}
	public void setQcs(List<QuestionBankChoice> qcs) {
		this.qcs = qcs;
	}
	public QuestionBankReading getQr() {
		return qr;
	}
	public void setQr(QuestionBankReading qr) {
		this.qr = qr;
	}
	public String addquestion() throws Exception{
		//System.out.println(qc.getChoiceA());
		am.add(qc);
		return this.SUCCESS;
		
	}
	public String chosenList(){
		int paperId = (Integer) session.get("paperId");
		qcs = am.listChosenQuestionsInOnePaper(paperId);
		//System.out.println(qcs.get(0).getChoiceA());
		return this.SUCCESS;
	}
	public String addToPaper(){
		am.addQuestionToPaper(qid, paperId);
		qcs=am.listQuestion();
		return this.SUCCESS;
	}
	public String QuestionBankList(){
		qcs=am.listQuestion();
		session.put("paperId", paperId);
		return this.SUCCESS;
	}
	public String delQuesionInPaper(){
		am.delQuestionInPaper(paperId, qid);
		return this.SUCCESS;
	}
	
	public String del(){
		am.delPaper(paperId);
		return this.SUCCESS;
	}
	public String list(){
		qcs = am.listQuestion();
		System.out.println(qcs.get(0).getAnswer());
		return this.SUCCESS;
	}
	public String addReadingQuestion() throws Exception{
		am.addReading(qr);
		return "readingSuccess";
		
	}
	public String listPapers(){
		papers=am.listPapers();
		return this.SUCCESS;
	}
	public String addPaper(){
		session.put("paperId", am.createPaper());
		return this.SUCCESS;
	}
	public QuestionBankChoice getQc() {
		return qc;
	}
	public void setQc(QuestionBankChoice qc) {
		this.qc = qc;
	}
	public AdminManager getAm() {
		return am;
	}
	@Resource(name="adminManager")
	public void setAm(AdminManager am) {
		this.am = am;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map getSession() {
		return session;
	}

	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public List<TestPaper> getPapers() {
		return papers;
	}
	public void setPapers(List<TestPaper> papers) {
		this.papers = papers;
	}
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}
	
	
}
