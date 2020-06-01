package cst438.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.persistence.JoinColumn;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private int courseId;
	private String title;
	private String semester;
	private int year;
	private int credits;
	private String grade;
	@Version
    private int version;

	@ManyToOne 
	@JoinColumn(name = "studentid")
	private Transcript transcript;
	
	public Course() { }
	
	public Course(String title, String semester, int year, int credits, String grade, Transcript t) {
		this.title = title;
		this.semester = semester;
		this.year = year;
		this.credits = credits;
		this.grade = grade;
		this.transcript = t;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	

}
