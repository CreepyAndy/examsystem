package xia.dao;

import java.util.List;

import xia.model.AdminSchool;
import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.Student;
import xia.model.TestPaper;

public interface AdminDao {
	public void insertQuestionChoice(QuestionBankChoice qc);
	public AdminSchool getById(int id);
	public void insertQuestionReading(QuestionBankReading qr);
	public void updateReading(QuestionBankReading qr);
	public void updateChoice(QuestionBankChoice qc);
	public QuestionBankReading getReadingQuestionById(int id);
	public QuestionBankChoice getChoiceQuestionById(int id);
	public List<QuestionBankChoice> getQuestions();
	public void delQuestion(QuestionBankChoice qc);
	public List<TestPaper> listPapers();
	public void insertBySql(final String sql,final Object[] values);
	public void saveOneQuestionToPaper(int qid, int paperId);
	public List<QuestionBankChoice> listChosenQuestions(int paperId);
	public void delPaper(int paperId);
	public int createPaper();
	public void delQuestionInPaper(int paperId, int qid);
	public void deleteBySql(final String sql,final Object[] values);
}
