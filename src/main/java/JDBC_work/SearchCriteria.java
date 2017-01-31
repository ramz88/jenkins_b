package JDBC_work;

public class SearchCriteria {
	enum SearchType {
		ORDERBY, WHERE
	}
	
	
	private String course;
	private String address;
	private String name;
	private int grade;
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	private String orderByColumn;
	private SearchType searchType;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderByColumn() {
		return orderByColumn;
	}
	public void setOrderByColumn(String orderByColumn) {
		this.orderByColumn = orderByColumn;
	}
	public SearchType getSearchType() {
		return searchType;
	}
	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}
	@Override
	public String toString() {
		return "SearchCriteria [course=" + course + ", address=" + address + ", name=" + name + ", orderByColumn="
				+ orderByColumn + ", searchType=" + searchType + "]";
	}

}
