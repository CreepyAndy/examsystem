package xia.service;

import java.util.List;
import java.util.Set;

import xia.model.QuestionBankChoice;
import xia.model.QuestionBankReading;

public interface TeacherManager {	
	public void synthesizeChoicePaper(Set<QuestionBankChoice> qcs) throws Exception; 
	public boolean verifyIdentity(String name, String password);
}
