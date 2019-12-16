package es.catalogue.courses.dto;

import java.io.Serializable;

import es.catalogue.courses.entity.Course;

public class CourseDTO implements Serializable {

	private static final long serialVersionUID = -3004363643555780755L;

	private boolean active;
	private int idTeacher;
	private String title;
	private int hours;
	private int level;

	
	public CourseDTO() {
	}
	
	

	
	public CourseDTO(boolean active, int idTeacher, String title, int hours, int level) {
		super();
		this.active = active;
		this.idTeacher = idTeacher;
		this.title = title;
		this.hours = hours;
		this.level = level;
	}




	public CourseDTO(Course course) {
		this.active = course.isActive();
		this.idTeacher = course.getIdTeacher();
		this.title = course.getTitle();
		this.hours = course.getHours();
		this.level = course.getLevel();
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getIdTeacher() {
		return idTeacher;
	}
	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
