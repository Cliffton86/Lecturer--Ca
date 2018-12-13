package sg.iss.caps.controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.caps.model.Course;
import sg.iss.caps.model.Lecturercourse;
import sg.iss.caps.model.Student;
import sg.iss.caps.model.Studentcourse;
import sg.iss.caps.model.StudentcoursePK;
import sg.iss.caps.services.LectureCourseService;
import sg.iss.caps.services.StudentService;
import sg.iss.caps.services.StudentcourseService;

@RequestMapping(value = "/lecturer")
@RestController
@Controller
public class LecturerController {

	@RequestMapping(value = "/index")
	public String index() {

		return "Hello there!";
	}
	
	@Autowired
	StudentcourseService scservice;
	 
	@Autowired
	LectureCourseService lservice;
	
	/*@RequestMapping(value = "/course/{lecturerID}", method = RequestMethod.GET)
	public ModelAndView viewcoursepg(@PathVariable String lecturerID ) {
		ModelAndView mav = new ModelAndView("LecturerCourseDetails");
		mav.addObject("lecturercourse", lservice.ViewcoursebylectureID(lecturerID) );
		return mav;
	}*/
	
	
	@RequestMapping(value = "/courses/{lid}", method = RequestMethod.GET)
	public ModelAndView listlecturercourse(@PathVariable String lid) {
		ModelAndView mav = new ModelAndView("LecturerCourseDetails");
		mav.addObject("Lecturercourse", lservice.ViewcoursebylectureID(lid));
		return mav;
	}
	
	
	@RequestMapping(value = "/course/{courseindex}", method = RequestMethod.GET)
	public ModelAndView viewscbyindexpg(@PathVariable String courseindex) {
		ModelAndView mav = new ModelAndView("StudentbyCourseIndex");
		mav.addObject("studentcourse", scservice.Viewcoursebycourseindex(courseindex));
		return mav;
	}
	
	
	@RequestMapping(value = "/course/edit/{studentid}/{courseindex}", method = RequestMethod.GET)
	public ModelAndView editstudentgradePage(@PathVariable String studentid, @PathVariable String courseindex ) {
		Optional<Studentcourse> studentcoursedetails = scservice.findStudentCourse(scservice.findStudentcoursePK(studentid, courseindex));
		ModelAndView mav = new ModelAndView("StudentGradeEdit", "studentcoursedetails", studentcoursedetails);
		return mav;
	}
	
	@RequestMapping(value="/edit/{studentid}/{courseindex}", method = RequestMethod.POST)
	public ModelAndView editUserPage(@PathVariable String studentid, @PathVariable String courseindex , @ModelAttribute Studentcourse studentcoursedetails) {
		scservice.updateStudentCourse(studentcoursedetails);
		ModelAndView mav = new ModelAndView("StudentbyCourseIndex");
		mav.addObject("studentcourse", scservice.Viewcoursebycourseindex(courseindex));
		return mav;
	}
	
	
	
}