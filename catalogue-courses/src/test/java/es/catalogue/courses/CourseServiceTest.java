package es.catalogue.courses;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
}
