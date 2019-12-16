package es.catalogue.courses;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import es.catalogue.courses.dto.CourseDTO;
import es.catalogue.courses.service.CourseService;
import es.catalogue.courses.web.CourseController;


@RunWith(MockitoJUnitRunner.class)
public class CourseControllerTest {
    
	@InjectMocks //The controller I want to test.
	private CourseController courseController;

	
	@Mock //The controller dependencies
    private CourseService courseService;
    
	
	@Test
	public void shouldCreateCourse() {
		
		CourseDTO input = new CourseDTO(false, 1, "Micro", 40, 3);
		CourseDTO expectedResult = new CourseDTO(true, 2, "Servicio", 40, 2);
		
		when(courseService.add(input)).thenReturn(expectedResult);
	
		CourseDTO result = courseController.add(input);
		
		assertEquals(expectedResult, result);
	}
	
	
	
}
