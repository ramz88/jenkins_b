package JDBC_work;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import JDBC_work.SearchCriteria.SearchType;

public class StudentJdbcOperation implements StudentDAO {

	@Override
	public boolean addStudent(Student s) throws SQLException {
		Connection con = null;
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
			con.createStatement().executeUpdate("INSERT INTO student (id, name, address, course, grade) VALUES (" + s.getId() + ",'"
							+ s.getName() + "','" + s.getAddress() + "','" + s.getCourse() + "'," + s.getGrade() + ")");
		} catch (SQLException e) {
			System.out.println("Null pointer exception");
			e.printStackTrace();
		}

		con.close();
		return false;

	}

	@Override
	public boolean updateStudent(Student s) {

		try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root","root")) {
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("update student set name = ?," + "address = ?,course = ?,grade = ? where id = ?");
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getAddress());
			pstmt.setString(3, s.getCourse());
			pstmt.setInt(4, s.getGrade());
			pstmt.setInt(5, s.getId());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Null pointer");
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean deleteStudent(int id) {

		try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root","root")) {

			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("delete from student where id = " + id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public Student findStudent(int id) {

		String sql = "select * from student where id = " + id + ";";
		try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root","root")) {
			ResultSet rs = con.createStatement().executeQuery(sql);
			while (rs.next()) {
				return new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Map<String, Integer> getCourseDetails() {
		Map<String, Integer> mapp = new HashMap<>();
		String sql = "select course,count(*) from student group by course";
		try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root","root")) {
			ResultSet rs = con.createStatement().executeQuery(sql);
			while (rs.next()) {
				mapp.put(rs.getString(1), rs.getInt(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mapp;

	}

	@Override
	public List<Student> findByCriteria(SearchCriteria criteria) throws SQLException {
		List<Student> std = new ArrayList<>();
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
		int count = 0;
		ResultSet rs = null;
		String c1 = null; // first column
		String c2 = null; // second column
		String v1 = null; // first column value
		String v2 = null; // second column value
		String sql = null;
		if (criteria.getSearchType() == SearchType.WHERE) {
			if (criteria.getName() != null) {
				c1 = "name";
				v1 = criteria.getName();
				count++;
			}
			if (criteria.getCourse() != null) {
				c1 = "course";
				v1 = criteria.getCourse();
				count++;
			}
			if (criteria.getGrade() > 0) {
				if (count == 1) {
					c2 = "grade";
					v2 = Integer.toString(criteria.getGrade());
					count++;
				} else {
					c1 = "grade";
					v1 = Integer.toString(criteria.getGrade());
					count++;
				}
			}
			if (count == 1) {
				sql = "select * from student where " + c1 + "=" + "'"+v1+"'" + ";";
			}
			if (count == 2) {
				sql = "select * from student where " + c1 + "=" + "'"+v1+"'" + " and " + c2 + "=" + v2 + ";";
			}
			System.out.println(sql);
			rs = con.createStatement().executeQuery(sql);
			while (rs.next()) {
				std.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}

		} else if (SearchType.ORDERBY == criteria.getSearchType()) {
			String orderby = "order by";
			String orderByColumn = criteria.getOrderByColumn();
			String sql2 = "select * from student " + orderby + " " + orderByColumn+";";
			System.out.println(sql2);
			rs = con.createStatement().executeQuery(sql2);
			while (rs.next()) {
				std.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}

		}
		return std;

	}

	@Override
	public List<Student> displayAll() {
		List<Student> stdList = new ArrayList<>();
		String sql = "select * from student;";
		try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root",
				"root")) {
			ResultSet rs = con.createStatement().executeQuery(sql);
			while (rs.next()) {
				stdList.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));

			}
			return stdList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public int countStudents() {
		String sql = "select count(*) from student;";
		try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root","root")) {
			ResultSet rs = con.createStatement().executeQuery(sql);
			while(rs.next()){
			int x=rs.getInt(1);
			return x;
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
