package es.catalogue.teachers.service.impl;

import org.springframework.stereotype.Service;

import es.catalogue.teachers.entity.Teacher;
import es.catalogue.teachers.repository.TeacherRepository;
import es.catalogue.teachers.service.TeacherService;
import es.catalogue.teachers.web.dto.TeacherDTO;

@Service
public class TeacherServiceImpl implements TeacherService {

	private final TeacherRepository teacherRepository;
	
	//Dependency injection with constructor.
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}



	public TeacherDTO add(TeacherDTO teacherDTO) {
		Teacher teacher = new Teacher(teacherDTO);

		teacher = teacherRepository.save(teacher);
		return new TeacherDTO(teacher);
	}

}
