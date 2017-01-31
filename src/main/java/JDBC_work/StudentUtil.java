package JDBC_work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import JDBC_work.SearchCriteria.SearchType;

public class StudentUtil {

	private static final String DELIMITER = ",";
	private static final String LINE_SEPERATOR = "\n";

	private static List<Student> stdList = new ArrayList<>();

	public static Student readData(Student s) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Add the student to Database");
		System.out.println("Enter the ID ");
		s.setId(sc.nextInt());
		System.out.println("Enter the Name");
		s.setName(sc.next());
		System.out.println("Enter the Address");
		s.setAddress(sc.next());
		System.out.println("Enter the Course");
		s.setCourse(sc.next());
		System.out.println("Enter the Grade");
		s.setGrade(sc.nextInt());

		return s;
	}

	public void createData() throws IOException {
		for (int i = 0; i < 50; i++) {
			stdList.add(new Student(i + 1, "Sai-" + i, "Dallas", "Java", i + 2));

		}

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("/Users/ramz/Downloads/BS.txt");
			for (Student student : stdList) {
				fileWriter.append(String.valueOf(student.getId()));
				fileWriter.append(DELIMITER);
				fileWriter.append(student.getName());
				fileWriter.append(DELIMITER);
				fileWriter.append(student.getAddress());
				fileWriter.append(DELIMITER);
				fileWriter.append(student.getCourse());
				fileWriter.append(DELIMITER);
				fileWriter.append(String.valueOf(student.getGrade()));
				fileWriter.append(DELIMITER);

			}
			System.out.println("CSV created");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fileWriter.flush();
			fileWriter.close();
		}

	}

	public static List<Student> loadData() throws IOException, SQLException {
		Connection con = null;
		BufferedReader bufferedreader = new BufferedReader(new FileReader(new File("/Users/ramz/Downloads/BS.txt")));
		Student student = null;
		con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
		Statement statement = (Statement) con.createStatement();
		DatabaseMetaData DMD = (DatabaseMetaData) con.getMetaData();
		ResultSet rs = (ResultSet) DMD.getTables(null, null, "student", null);
		String sql = "create table student(id int, name varchar(45), address varchar(45), course varchar(45), grade int)";
		if (!rs.next()) {
			statement.executeUpdate(sql);

		}

		String data = "a";
		String words[];
		List<Student> stdload = new ArrayList<>();
		while ((data = bufferedreader.readLine()) != null) {
			words = data.split(",");
			int i = 0;
			stdload.add(new Student(Integer.parseInt(words[i]), words[i + 1], words[i + 2], words[i + 3],
					Integer.parseInt(words[i + 4])));
		}
		
		for (Student students : stdload) {
			System.out.println(students);
			statement.executeUpdate("INSERT INTO student (id, name, address, course, grade) VALUES (" + students.getId()
					+ ",'" + students.getName() + "','" + students.getAddress() + "','" + students.getCourse() + "',"
					+ students.getGrade() + ")");
		}
		statement.close();
		con.close();
		// Connection con = null;
		// List<Student> stdload = new ArrayList<>();
		// String line = "";
		// BufferedReader fileReader = null;
		// fileReader = new BufferedReader(new
		// FileReader("/Users/ramz/Downloads/BS.txt"));
		// fileReader.readLine();
		// con = (Connection)
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","root");
		// Statement statement = (Statement) con.createStatement();
		// DatabaseMetaData MD = (DatabaseMetaData) con.getMetaData();
		// ResultSet rs = (ResultSet) MD.getTables(null, null, "student", null);
		// String query = "create table student(id int, name varchar(45),
		// address varchar(45), course varchar(45), course varchar, grade)";
		// if(!rs.next()){
		// statement.executeUpdate(query);
		// }
		// String data = "dummy";
		// String words[];
		// List<Student> studentList = new ArrayList<>();
		// do {
		// data = fileReader.readLine();
		// if (data == null) {
		// break;
		// } else {
		// words = data.split(",");
		// int i = 0;
		// studentList.add(new Student(Integer.parseInt(words[i]), words[i + 1],
		// words[i + 2], words[i + 3],
		// Integer.parseInt(words[i + 4])));
		// }
		// } while (data != null);
		// for (Student s : stdload) {
		// statement.executeUpdate("INSERT INTO student(id, name, address,
		// course, grade)
		// VALUES("+s.getId()+","+s.getName()+","+s.getAddress()+","+s.getCourse()+","+s.getGrade()+")");
		//
		// }
		// statement.close();
		// con.close();
		return stdload;
	}

	public static int getStudentId() {
		System.out.println("Enter the ID");
		Scanner sc = new Scanner(System.in);
		int id = (sc.nextInt());
		return id;
	}

	public static void displayStudentInfo(Student student) {
		System.out.println(student.getId() + " " + student.getName() + " " + student.getAddress() + " "
				+ student.getCourse() + " " + student.getGrade());

	}

	public static void printCourseDetails(Map<String, Integer> courseDetails) {
		for (Entry<String, Integer> courseCount : courseDetails.entrySet()) {
			System.out.println(courseCount.getKey() + " " + courseCount.getValue());
		}
	}

	public static SearchCriteria select(SearchType value) {
		SearchCriteria search = new SearchCriteria();
		Scanner sc = new Scanner(System.in);
		int sel = 9;
		if (value == SearchType.ORDERBY) {
			search.setSearchType(SearchType.ORDERBY);
			System.out.println("1) By Course\n2) By Name\n3) By Grade\n4) By Id\n5) By Course and Grade\n");
			sel = sc.nextInt();
			if (sel == 1) {
				search.setOrderByColumn("course");
				return search;
			}
			if (sel == 2) {
				search.setOrderByColumn("name");
				return search;
			}
			if (sel == 3) {
				search.setOrderByColumn("grade");
				return search;
			}
			if (sel == 4) {
				search.setOrderByColumn("id");
				return search;
			}
			if (sel == 5) {
				search.setOrderByColumn("course,grade");
				return search;
			}
			return null;
		}
		if (value == SearchType.WHERE) {
			search.setSearchType(SearchType.WHERE);
			System.out.println("1) By Course\n2) By Name\n3) By Grade\n4) By Course and Grade\n");
			sel = sc.nextInt();
			if (sel == 1) {
				System.out.println("ENTER the course");
				search.setCourse(sc.next());
				return search;
			}
			if (sel == 2) {
				System.out.println("ENTER a name");
				search.setName(sc.next());
				return search;
			}
			if (sel == 3) {
				System.out.println("ENTER the grade");
				search.setGrade(sc.nextInt());
				return search;
			}
			if (sel == 4) {
				System.out.println("ENTER the course details");
				search.setCourse(sc.next());
				System.out.println("ENTER the grade");
				search.setGrade(sc.nextInt());
				return search;
			}

		}
		return null;
	}

	public void studentMenu() throws SQLException {

		StudentDAO stdao = new StudentJdbcOperation();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your choice");
		System.out.println(
				"1) Add a student\n2) Update student details\n3) Delete a Student\n4) Display Student details\n5) Display all students\n6) Display course vs number of students\n7) Display student for the selected criteria"
						+ "\n8) Display students order by following \n9) Display total student present in the table");
		int choice = 44;
		while (choice != 0) {

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				stdao.addStudent(readData(new Student()));
				break;
			case 2:
				stdao.updateStudent(readData(new Student()));
				System.out.println("Student updated");
				break;
			case 3:
				stdao.deleteStudent(StudentUtil.getStudentId());
				System.out.println("Student deleted");
				break;
			case 4:
				Student student = stdao.findStudent(getStudentId());
				StudentUtil.displayStudentInfo(student);
				break;
			case 5:
				List<Student> s = stdao.displayAll();
				for (Student student2 : s) {
					StudentUtil.displayStudentInfo(student2);
				}
				break;
			case 6:
				Map<String, Integer> courseDetails = stdao.getCourseDetails();
				StudentUtil.printCourseDetails(courseDetails);
				break;
			case 7:
				List<Student> sc1 = stdao.findByCriteria(select(SearchType.WHERE));
				for (Student student2 : sc1) {
					StudentUtil.displayStudentInfo(student2);
				}
				break;
			case 8:
				List<Student> sc2 = stdao.findByCriteria(select(SearchType.ORDERBY));
				for (Student student2 : sc2) {
					StudentUtil.displayStudentInfo(student2);
				}
				break;
			case 9:
				int x = stdao.countStudents();
				System.out.println("No.of Students :" + x);
				break;

			default:
				System.out.println("Please enter valid choice");
				break;

			}
		}

	}

}
