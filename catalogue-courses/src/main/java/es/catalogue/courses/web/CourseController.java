package es.catalogue.courses.web;

import org.springframework.web.bind.annotation.RestController;

import es.catalogue.courses.service.CourseService;
import es.catalogue.courses.web.dto.CourseDTO;

@RestController
public class CourseController {

	private final CourseService courseService;
		
	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}



	public CourseDTO add(CourseDTO course) {
		return courseService.add(course);
	}


}
