package es.catalogue.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.catalogue.courses.entity.Course;

//@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	 
}
