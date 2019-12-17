package es.catalogue.courses.web;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.catalogue.courses.service.CourseService;
import es.catalogue.courses.web.dto.CourseDTO;

@RestController //Replace @Controller and @ResponseBody
public class CourseController {

	@Autowired
	private final CourseService courseService;
		
	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	//courses -> sustantivo, plural 
	@RequestMapping(value = "/courses", method = RequestMethod.POST)
	public CourseDTO add(CourseDTO course) {
		return courseService.add(course);
	}


	@RequestMapping(value = "/courses", method=RequestMethod.GET)
	public Page<CourseDTO> findAll(@QueryParam("page") int page, @QueryParam("size") int size, 
								   @QueryParam("active") boolean active) {
		Pageable pageRequest = PageRequest.of(page, size);
		return courseService.findAll(pageRequest, active);
	}
}
