package es.catalogue.teachers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import es.catalogue.teachers.service.TeacherService;
import es.catalogue.teachers.web.TeacherController;
import es.catalogue.teachers.web.dto.TeacherDTO;

@RunWith(MockitoJUnitRunner.class)
public class TeacherControllerTest {

	@InjectMocks
	TeacherController teacherControler;
	
	@Mock
	TeacherService teacherService;
	
	@Test
	public void shouldCreateTeacher() {
		TeacherDTO input = new TeacherDTO(1, "Pedro");
		TeacherDTO expectedTeacher = new TeacherDTO(2, "Javier");
		
		when(teacherService.add(input)).thenReturn(expectedTeacher);
		
		TeacherDTO result = teacherControler.add(input);
		
		assertEquals(expectedTeacher, result);
	}
}
