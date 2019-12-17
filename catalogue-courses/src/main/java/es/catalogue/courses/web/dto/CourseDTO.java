package es.catalogue.courses.web.dto;

import java.io.Serializable;

import es.catalogue.courses.entity.Course;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode 
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
	
}
