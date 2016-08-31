package xia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import xia.dao.AdminDao;
import xia.dao.StudentDao;
import xia.model.AdminSchool;
import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.Student;
import xia.model.TestPaper;
import xia.service.AdminManager;
@Component("adminManager")
public class AdminManagerImpl implements AdminManager{
	private AdminDao adminDao;
	
	@Override
	public void add(QuestionBankChoice qc) throws Exception {
		adminDao.insertQuestionChoice(qc);
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}
	@Resource(name="a")
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public boolean verifyIdentity(String id, String password) {
		AdminSchool a;
		a = adminDao.getById(Integer.parseInt(id));
		if(a.getPassword().equals(password))
			return true;
		return false;
	}

	@Override
	public void addReading(QuestionBankReading qr) throws Exception {
		adminDao.insertQuestionReading(qr);
	}

	@Override
	public void updateReading(QuestionBankReading qr) throws Exception {
		/*QuestionBankReading t = adminDao.getReadingQuestionById(qr.getId());
		t.setKnowledgePoint(qr.getKnowledgePoint());
		t.setStem(qr.getStem());
		t.setQuestionChoice(qr.getQuestionChoice());*/
		adminDao.updateReading(qr);
	}

	@Override
	public void updateChoice(QuestionBankChoice qc) throws Exception {
		adminDao.updateChoice(qc);
	}

	@Override
	public List<QuestionBankChoice> listQuestion() {
		return adminDao.getQuestions();
	}

	@Override
	public void delQuestion(QuestionBankChoice qc) {
		adminDao.delQuestion(qc);
	}

	@Override
	public void addQuestionToPaper(int qid, int paperId) {
		System.out.println(qid+" "+paperId);
		adminDao.saveOneQuestionToPaper(qid, paperId);
	}

	@Override
	public List<TestPaper> listPapers() {
		return adminDao.listPapers();
	}

	@Override
	public List<QuestionBankChoice> listChosenQuestionsInOnePaper(int paperId) {
		return adminDao.listChosenQuestions(paperId);
		
	}

	@Override
	public void delPaper(int paperId) {
		adminDao.delPaper(paperId);
	}

	@Override
	public int createPaper() {
		return adminDao.createPaper();
	}

	@Override
	public void delQuestionInPaper(int paperId, int qid) {
		adminDao.delQuestionInPaper(paperId, qid);
	}
	
}
