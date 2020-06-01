package cst438.domain;

import javax.persistence.OrderBy;
import javax.persistence.Version;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Transcript {
	@Id
	private int studentId;
	private String studentName;
	@Version
    private int version;

	@OneToMany(cascade = {CascadeType.ALL})
	@OrderBy("year asc, semester asc, title asc")
	private List<Course> courses = new ArrayList<>();
	
	public Transcript() {
	}
	
	public Transcript(int studentId, String name) {
		this.studentId = studentId;
		this.studentName = name;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
