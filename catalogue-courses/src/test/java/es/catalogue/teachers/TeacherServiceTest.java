package es.catalogue.teachers;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import es.catalogue.teachers.entity.Teacher;
import es.catalogue.teachers.repository.TeacherRepository;
import es.catalogue.teachers.service.impl.TeacherServiceImpl;
import es.catalogue.teachers.web.dto.TeacherDTO;

@RunWith(MockitoJUnitRunner.class)
public class TeacherServiceTest {
	
	@InjectMocks
	private TeacherServiceImpl teacherService;
	
	@Mock
	private TeacherRepository teacherRepository;
	
	
	@Test
	public void shouldCreateTeacher() {
		TeacherDTO resultExpected = new TeacherDTO(1, "Pedro");
		TeacherDTO inputTeacher = new TeacherDTO(2, "Javier");
		
		when(teacherRepository.save(new Teacher(inputTeacher))).thenReturn(new Teacher(1, "Pedro"));
		TeacherDTO result = teacherService.add(inputTeacher);
		
		assertTrue(result.equals(resultExpected));
	}
}
