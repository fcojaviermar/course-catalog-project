package es.catalogue.courses.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import es.catalogue.courses.CatalogueCoursesApplication;
import es.catalogue.courses.web.dto.CourseDTO;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = CatalogueCoursesApplication.class)
public class FindCoursesIT {

	@Autowired
	CourseController courseController;
	
	@Test
	@Sql("/courses.sql")
	public void shouldFindAll() {
		Page<CourseDTO> result = courseController.findAll(0, 10, true);
		assertEquals(result.getContent().size(), 5);
	}
	
	

	@Test
	@Sql("/courses.sql")
	public void shouldFindFirstPageThreeCourses() {
		Page<CourseDTO> result = courseController.findAll(0, 3, true);
		assertEquals(result.getContent().size(), 3);
	}

	
	@Test
	@Sql("/courses.sql")
	public void shouldFindTwoPageLastPageTwoCourses() {
		Page<CourseDTO> result = courseController.findAll(0, 3, true);
		result = courseController.findAll(result.nextPageable().getPageNumber(), 
										  result.nextPageable().getPageSize(),
										  true);
		assertEquals(result.getContent().size(), 2);
	}
	
	
	@Test
	@Sql("/coursesFalse.sql")
	public void shouldNotFindCourses() {
		Page<CourseDTO> result = courseController.findAll(0, 3, true);
		assertEquals(result.getContent().size(), 0);
	}
}
