package dao;

import java.util.List;
import model.student;

public interface studentDao 
{
	//C->create
	void add(student s);
	
	//R->Read
	String queryAll1();
	List<student> queryAll2();
	//U->update
	
	
	//D->Delete
}
