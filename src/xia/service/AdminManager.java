package xia.service;

import java.util.List;

import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.Student;
import xia.model.TestPaper;

public interface AdminManager {
	public abstract void add(QuestionBankChoice qc) throws Exception;
	public abstract void addReading(QuestionBankReading qr) throws Exception;
	public boolean verifyIdentity(String id, String password);
	public void updateReading(QuestionBankReading qr) throws Exception;
	public void updateChoice(QuestionBankChoice qc) throws Exception;
	public List<QuestionBankChoice> listQuestion();
	public void delQuestion(QuestionBankChoice qc);
	public void addQuestionToPaper(int qid,int paperId);
	public List<TestPaper> listPapers();
	public List<QuestionBankChoice> listChosenQuestionsInOnePaper(int paperId);
	public void delPaper(int paperId);
	public int createPaper();
	public void delQuestionInPaper(int paperId,int qid);
}
