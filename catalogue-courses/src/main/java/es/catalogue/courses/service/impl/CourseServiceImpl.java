package es.catalogue.courses.service.impl;

import org.springframework.stereotype.Service;

import es.catalogue.courses.entity.Course;
import es.catalogue.courses.repository.CourseRepository;
import es.catalogue.courses.service.CourseService;
import es.catalogue.courses.web.dto.CourseDTO;


@Service
public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository;
	
	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository; 
	}



	public CourseDTO add(CourseDTO courseDto) {
		Course course = courseRepository.save(new Course(courseDto));

		return new CourseDTO(course);
	}

}
