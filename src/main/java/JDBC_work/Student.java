package JDBC_work;

public class Student {
	private String name;
	private int id;
	private String address;
	private String course;
	private int grade;
	
	


	public Student(int id, String name, String address, String course, int grade ){
	
		this.id=id;
		this.name=name;
		this.address=address;
		this.course=course;
		this.grade=grade;
		
	}
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", address=" + address + ", course=" + course + ", grade="
				+ grade + "]";
	}
	
	
	

}
