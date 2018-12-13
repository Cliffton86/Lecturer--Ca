package sg.iss.caps.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.iss.caps.model.Studentcourse;
import sg.iss.caps.model.StudentcoursePK;
import sg.iss.caps.repo.StudentCourseRepository;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	@Resource
	StudentCourseRepository screpo;
	
	@Override
	public ArrayList<Studentcourse> Viewcoursebycourseindex(String CourseIndex) {
		
		return (ArrayList<Studentcourse>) screpo.Viewcoursebycourseindex(CourseIndex);
		
	}

	@Override
	public Studentcourse findStudentcoursebyID(String id, String ci) {
		return screpo.findStudentcoursebyID(id, ci);
		
	}

	@Override
	public Studentcourse updateGrade(Studentcourse stu) {
		// TODO Auto-generated method stub
		return screpo.saveAndFlush(stu);
	}

	@Override
	public ArrayList<Studentcourse> findall() {
		// TODO Auto-generated method stub
		return (ArrayList<Studentcourse>) screpo.findAll();
	}

}
