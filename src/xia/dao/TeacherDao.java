package xia.dao;

import java.util.List;

import xia.model.AdminSchool;
import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;
import xia.model.Student;
import xia.model.Teacher;
import xia.model.TestPaper;

public interface TeacherDao {
	public void savePaper(TestPaper p);
	public Teacher getById(int id);
	public Teacher getByName(String name);
}
