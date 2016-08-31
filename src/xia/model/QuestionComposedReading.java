package xia.model;

import java.util.Set;

public class QuestionComposedReading {
	private QuestionBankReading article;
	private Set<QuestionBankChoice> questions;
	public QuestionBankReading getArticle() {
		return article;
	}
	public void setArticle(QuestionBankReading article) {
		this.article = article;
	}
	public Set<QuestionBankChoice> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<QuestionBankChoice> questions) {
		this.questions = questions;
	}
}
