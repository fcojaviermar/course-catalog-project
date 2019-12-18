package es.catalogue.courses.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import es.catalogue.courses.entity.Course;
import es.catalogue.courses.repository.CourseRepository;
import es.catalogue.courses.service.impl.CourseServiceImpl;
import es.catalogue.courses.web.dto.CourseDTO;


@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

	@InjectMocks //The service I want to test.
	private CourseServiceImpl courseService;

	
	@Mock //The service dependencies
	private CourseRepository courseRepository;
	
	@Test
	public void shouldCreateCourse() {
		CourseDTO inputCourse = new CourseDTO(false, 5, "Micro", 20, 3);
		
		Course saveResult = new Course(2, true, 5, "Eclipse", 45, 3);
		CourseDTO expectedResult = new CourseDTO(true, 5, "Eclipse", 45, 3);

		when(courseRepository.save(new Course(inputCourse))).thenReturn(saveResult);
		CourseDTO result = courseService.add(inputCourse);
		
		assertTrue(result.equals(expectedResult));
	}
	
	
	@Test
	public void shouldFindCourses() {
		List<Course> listReturn = new ArrayList<>();
		listReturn.add(new Course(1, true, 1, "Micro", 40, 1));
		listReturn.add(new Course(2, true, 2, "Eclipse", 20, 2));
		Page<Course> pagedReturn = new PageImpl<Course>(listReturn);
		
		List<CourseDTO> listResult = new ArrayList<>();
		listResult.add(new CourseDTO(true, 1, "Micro", 40, 1));
		listResult.add(new CourseDTO(true, 2, "Eclipse", 20, 2));

		
		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);		
		when(courseRepository.findAllByActive(firstPageWithTwoElements, true)).thenReturn(pagedReturn);
		Page<CourseDTO> result = courseService.findAll(0, 2, true);
		
		result.forEach(p -> assertTrue(listResult.contains(p)));
	}
}
