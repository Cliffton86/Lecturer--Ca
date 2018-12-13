package sg.iss.caps.services;

import java.util.ArrayList;

import sg.iss.caps.model.Studentcourse;

public interface StudentCourseService {

	ArrayList<Studentcourse> Viewcoursebycourseindex(String CourseIndex);
	
	ArrayList<Studentcourse> findall();
	
	Studentcourse findStudentcoursebyID(String id, String ci);
	
	Studentcourse updateGrade (Studentcourse stu);
}
