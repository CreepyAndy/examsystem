package xia.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="t_testpaper")
public class TestPaper {
	private int id;
	private Set<QuestionBankChoice> qcs;
	private Set<QuestionBankReading> qrs;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="paper_choicequestion")
	public Set<QuestionBankChoice> getQcs() {
		return qcs;
	}
	public void setQcs(Set<QuestionBankChoice> qcs) {
		this.qcs = qcs;
	}
	@ManyToMany
	@JoinTable(name="paper_readingquestion")
	public Set<QuestionBankReading> getQrs() {
		return qrs;
	}
	public void setQrs(Set<QuestionBankReading> qrs) {
		this.qrs = qrs;
	}
}
