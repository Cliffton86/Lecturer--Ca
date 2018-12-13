package sg.iss.caps.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.caps.model.Course;
import sg.iss.caps.model.Lecturercourse;
import sg.iss.caps.model.LecturercoursePK;

public interface LecturerCourseRepository extends JpaRepository<Lecturercourse, LecturercoursePK>{
	
	
	@Query(value = "SELECT * FROM lecturercourse where lecturercourse.Lecturer_LecturerID = ?1",nativeQuery = true)
	ArrayList<Lecturercourse> ViewcoursebylectureID(String lid);
	
}