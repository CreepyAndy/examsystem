package xia.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import xia.dao.AdminDao;
import xia.dao.TeacherDao;
import xia.model.AdminSchool;
import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.Student;
import xia.model.TestPaper;

@Component("a")
public class AdminDaoImpl implements AdminDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void insertQuestionChoice(QuestionBankChoice qc) {
		hibernateTemplate.save(qc);
	}

	@Override
	public AdminSchool getById(int id) {
		return (AdminSchool) this.hibernateTemplate.get(AdminSchool.class, id);
	}

	@Override
	public void insertQuestionReading(QuestionBankReading qr) {
		hibernateTemplate.save(qr);
	}

	@Override
	public void updateReading(QuestionBankReading qr) {

		hibernateTemplate.update(qr);
	}

	@Override
	public QuestionBankReading getReadingQuestionById(int id) {
		return (QuestionBankReading) this.hibernateTemplate.get(
				QuestionBankReading.class, id);
	}

	@Override
	public void updateChoice(QuestionBankChoice qc) {
		hibernateTemplate.update(qc);
	}

	@Override
	public QuestionBankChoice getChoiceQuestionById(int id) {
		return (QuestionBankChoice) this.hibernateTemplate.get(
				QuestionBankChoice.class, id);
	}

	@Override
	public List<QuestionBankChoice> getQuestions() {
		return (List<QuestionBankChoice>) this.hibernateTemplate
				.find("from QuestionBankChoice");
	}

	@Override
	public void delQuestion(QuestionBankChoice qc) {
		hibernateTemplate.delete(qc);
	}

	@Override
	public List<TestPaper> listPapers() {
		return (List<TestPaper>) this.hibernateTemplate.find("from TestPaper");
	}

	@Override
	public void insertBySql(final String sql, final Object[] values) {
		List list = (List) getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createSQLQuery(sql);
						for (int i = 0; i < values.length; i++) {
							query.setParameter(i, values[i]);
						}
						query.executeUpdate();
						Object o = null;
						return o;
					}
				});
	}

	public static void executeSQL(HibernateTemplate hibernateTemplate,
			String sql) {
		final String tempsql = sql;
		hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				session.createQuery(tempsql).executeUpdate();
				return null;
			}
		});
	}

	public void deleteBySql(final String sql, final Object[] values) {
		List list = (List) getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = (Query) session.createSQLQuery(sql);
						for (int i = 0; i < values.length; i++) {
							query.setParameter(i, values[i]);
						}
						query.executeUpdate();
						Object o = null;
						return o;
					}
				});
	}

	public void saveOneQuestionToPaper(int qid, int paperId) {
		String sql = "insert into paper_choicequestion(qcs_id,t_testpaper_id) values(?,?)";
		Object[] o = { qid, paperId };
		insertBySql(sql, o);
	}

	@Override
	public List<QuestionBankChoice> listChosenQuestions(int paperId) {
		TestPaper p = (TestPaper) hibernateTemplate.get(TestPaper.class,
				paperId);
		return new ArrayList(p.getQcs());
	}

	@Override
	public void delPaper(int paperId) {
		TestPaper p = new TestPaper();
		p.setId(paperId);
		hibernateTemplate.delete(p);
	}

	@Override
	public int createPaper() {
		TestPaper p = new TestPaper();
		hibernateTemplate.save(p);
		return p.getId();
	}

	@Override
	public void delQuestionInPaper(int paperId, int qid) {
		String sql = "delete from paper_choicequestion where qcs_id=? and t_testpaper_id=?";
		Object[] o = { qid, paperId };
		deleteBySql(sql, o);

	}

}
