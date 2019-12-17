package es.catalogue.teachers.web;

import es.catalogue.teachers.service.TeacherService;
import es.catalogue.teachers.web.dto.TeacherDTO;

public class TeacherController {
	
	private final TeacherService teacherService;
	
	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}



	public TeacherDTO add(TeacherDTO teacher) {
		return teacherService.add(teacher);
	}
}
