package xia.dao;

import java.util.List;

import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.QuestionComposedReading;
import xia.model.Student;
import xia.model.WrongAnswer;
public interface QuestionDao {
	//录入一道选择题
	public void saveChoiceQuestion(QuestionBankChoice choiceQuestion);	
	//以知识点获取选择题集合
	public List<QuestionBankChoice> getchoiceQuestions(String knowledgePoint);
	//以某个学生做错的题获取选择题集合
	public List<WrongAnswer> getWrongAnswers(Student name);

	
	
	//以知识点获取文章集合
	public List<QuestionBankReading> getreadingQuestions(String knowledgePoint);
	//录入一篇readingQuestion（类名取article更合适）
	public void saveReadingQuestion(QuestionBankReading readingQuestion);
	//合成一道阅读题
	public QuestionComposedReading composeReadingQuestion(QuestionBankReading readingQuestion);
}
