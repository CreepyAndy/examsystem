package xia.dao;

import java.util.List;

import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.QuestionComposedReading;
import xia.model.Student;
import xia.model.WrongAnswer;
public interface QuestionDao {
	//¼��һ��ѡ����
	public void saveChoiceQuestion(QuestionBankChoice choiceQuestion);	
	//��֪ʶ���ȡѡ���⼯��
	public List<QuestionBankChoice> getchoiceQuestions(String knowledgePoint);
	//��ĳ��ѧ����������ȡѡ���⼯��
	public List<WrongAnswer> getWrongAnswers(Student name);

	
	
	//��֪ʶ���ȡ���¼���
	public List<QuestionBankReading> getreadingQuestions(String knowledgePoint);
	//¼��һƪreadingQuestion������ȡarticle�����ʣ�
	public void saveReadingQuestion(QuestionBankReading readingQuestion);
	//�ϳ�һ���Ķ���
	public QuestionComposedReading composeReadingQuestion(QuestionBankReading readingQuestion);
}
