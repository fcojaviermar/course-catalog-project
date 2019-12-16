package es.catalogue.courses.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import es.catalogue.courses.dto.CourseDTO;


@Entity
public class Course {
	
	@Id
	private int id;
	private boolean active;
	private int idTeacher;
	private String title;
	private int hours;
	private int level;
	
	
	public Course(int id, boolean active, int idTeacher, String title, int hours, int level) {
		super();
		this.id = id;
		this.active = active;
		this.idTeacher = idTeacher;
		this.title = title;
		this.hours = hours;
		this.level = level;
	}


	public Course(CourseDTO courseDTO) {
		this.active = courseDTO.isActive();
		this.idTeacher = courseDTO.getIdTeacher();
		this.title = courseDTO.getTitle();
		this.hours = courseDTO.getHours();
		this.level = courseDTO.getLevel();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
