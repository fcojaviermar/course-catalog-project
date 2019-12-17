package es.catalogue.courses.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.catalogue.courses.web.dto.CourseDTO;

public interface CourseService {

	public CourseDTO add(CourseDTO courseDto);

	public Page<CourseDTO> findAll(Pageable pageRequest, boolean active);
}
