package es.catalogue.courses.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.catalogue.courses.entity.Course;
import es.catalogue.courses.repository.CourseRepository;
import es.catalogue.courses.service.CourseService;
import es.catalogue.courses.web.dto.CourseDTO;


@Service
public class CourseServiceImpl implements CourseService {

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

	
	public Page<CourseDTO> findAll(Pageable pageRequest, boolean active) {
		List<CourseDTO> result = new ArrayList<CourseDTO>();
		
		Page<Course> listCourses = courseRepository.findAllByActive(pageRequest, active);		
				
//		listCourses = StreamSupport.stream(courseRepository.findAll(pageRequest).spliterator(), false)
//					.filter(course -> course.getAccountIban().contains(accountIban))
//					.sorted(Comparator.comparing Double(TransactionPayload::getAmount))
//					.collect(Collectors.toList());
		
		
		
		listCourses.forEach(p -> result.add(new CourseDTO(p)));
				
		return new PageImpl<CourseDTO>(result, listCourses.getPageable(), listCourses.getTotalElements());
		
	}
}
