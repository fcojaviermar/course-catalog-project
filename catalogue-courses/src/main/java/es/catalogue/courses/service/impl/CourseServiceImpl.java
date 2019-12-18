package es.catalogue.courses.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.catalogue.courses.entity.Course;
import es.catalogue.courses.repository.CourseRepository;
import es.catalogue.courses.service.CourseService;
import es.catalogue.courses.web.dto.CourseDTO;


@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private Environment env;
	
	@Autowired
	private final CourseRepository courseRepository;
	
	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository; 
	}



	public CourseDTO add(CourseDTO courseDto) {
		Course course = courseRepository.save(new Course(courseDto));
		return new CourseDTO(course);
	}

	
	
	public Page<CourseDTO> findAll(Integer page, Integer size, Boolean active) {
		Page<Course> listCourses = null;
		
		Pageable pageRequest = page(page, size);
		
		if (null != active) {
			listCourses = courseRepository.findAllByActive(pageRequest, active);
		} else {
			listCourses = courseRepository.findAll(pageRequest);
		}
	
		List<CourseDTO> result = listCourses.stream().map(course -> new CourseDTO(course)).collect(Collectors.toList());
	
		return new PageImpl<CourseDTO>(result, listCourses.getPageable(), listCourses.getTotalElements());
	}
	
	
	private Pageable page(Integer page, Integer size) {
		if  (null == page || size == null) {
			page = Integer.valueOf(env.getProperty("page"));
			size = Integer.valueOf(env.getProperty("size"));
		}
		return  PageRequest.of(page, size);
	}
}
