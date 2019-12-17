package es.catalogue.teachers.repository;

import org.springframework.data.repository.CrudRepository;

import es.catalogue.teachers.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>{

}
