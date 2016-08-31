package xia.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="t_questionbank_reading")
public class QuestionBankReading {
	private int id;
	private String knowledgePoint;
	private String stem;
	
	private Set<QuestionBankChoice> questionChoice = new HashSet<QuestionBankChoice>();
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKnowledgePoint() {
		return knowledgePoint;
	}

	public void setKnowledgePoint(String knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}

	public String getStem() {
		return stem;
	}

	public void setStem(String stem) {
		this.stem = stem;
	}
    @OneToMany
    @JoinColumn(name="readingId")
	public Set<QuestionBankChoice> getQuestionChoice() {
		return questionChoice;
	}

	public void setQuestionChoice(Set<QuestionBankChoice> questionChoice) {
		this.questionChoice = questionChoice;
	}
}
