package es.catalogue.courses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import es.catalogue.courses.dto.CourseDTO;
import es.catalogue.courses.entity.Course;
import es.catalogue.courses.repository.CourseRepository;
import es.catalogue.courses.service.impl.CourseServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

	@InjectMocks //The service I want to test.
	private CourseServiceImpl courseService;

	
	@Mock //The service dependencies
	CourseRepository courseRepository;
	
	@Test
	public void shouldCreateCourse() {
		Course input = new Course(1, false, 1, "Servicios", 40, 3);
		Course expectedResult = new Course(2, true, 5, "Micro", 45, 3);
		
		when(courseRepository.save(input)).thenReturn(expectedResult);
		
		CourseDTO result = courseService.add(new CourseDTO(input));
		
		assertSame(new CourseDTO(expectedResult), result);
	}
}
