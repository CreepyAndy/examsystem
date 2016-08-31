package xia.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import xia.dao.QuestionDao;
import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.QuestionComposedReading;
import xia.model.Student;
import xia.model.WrongAnswer;
@Component("q")
public class QuestionDaoImpl implements QuestionDao{
	private HibernateTemplate hibernateTemplate; 
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@Override
	public void saveChoiceQuestion(QuestionBankChoice choiceQuestion) {
		hibernateTemplate.save(choiceQuestion);
	}

	@Override
	public List<QuestionBankChoice> getchoiceQuestions(String knowledgePoint) {
		List<QuestionBankChoice> qs = hibernateTemplate.find("from QuestionBankChoice q where q.knowledgePoint=?", knowledgePoint);
		return null;
	}

	@Override
	public List<WrongAnswer> getWrongAnswers(Student name) {
		List<WrongAnswer> qs = hibernateTemplate.find("from WrongAnswer q where q.sname=?", name);
		return qs;
	}

	@Override
	public List<QuestionBankReading> getreadingQuestions(String knowledgePoint) {
		List<QuestionBankReading> qs = hibernateTemplate.find("from QuestionBankReading q where q.knowledgePoint=?", knowledgePoint);
		return qs;
	}

	@Override
	public void saveReadingQuestion(QuestionBankReading readingQuestion) {
		hibernateTemplate.save(readingQuestion);
	}

	@Override
	public QuestionComposedReading composeReadingQuestion(
			QuestionBankReading readingQuestion) {
		QuestionComposedReading qComposed = new QuestionComposedReading();
		qComposed.setArticle(readingQuestion);
		List<QuestionBankChoice> qs = hibernateTemplate.find("from QuestionBankChoice q where q.isReading=?", ""+readingQuestion.getId());
		qComposed.setQuestions(new HashSet(qs));
		return null;
	}

}
