package es.catalogue.courses.web;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.catalogue.courses.CatalogueCoursesApplication;
import es.catalogue.courses.web.CourseController;
import es.catalogue.courses.web.dto.CourseDTO;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = CatalogueCoursesApplication.class)
public class CreateCourseTest {

	@Autowired
	private CourseController courseController;
	
	@Test
	public void createCourse() {
		CourseDTO input = new CourseDTO(false, 1, "Micro", 40, 3);
		
		CourseDTO result = courseController.add(input);
		
		assertNotNull(result);
	}

}
