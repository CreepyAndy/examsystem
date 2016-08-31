package xia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_wronganswer")
public class WrongAnswer {
	private int id;
	private String sname;
	private QuestionBankChoice qc;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@OneToOne
	public QuestionBankChoice getQc() {
		return qc;
	}
	public void setQc(QuestionBankChoice qc) {
		this.qc = qc;
	}
}
