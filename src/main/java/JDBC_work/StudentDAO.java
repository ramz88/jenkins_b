package JDBC_work;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface StudentDAO {

	public boolean addStudent(Student s) throws SQLException;
	public boolean updateStudent(Student s);
	public boolean deleteStudent(int id);
	public Student findStudent(int id);
	public List<Student> displayAll();
	public Map<String, Integer> getCourseDetails();
	public List<Student> findByCriteria(SearchCriteria criteria) throws SQLException;
	public int countStudents();
	
	
}
