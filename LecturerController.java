package sg.iss.caps.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.caps.model.Studentcourse;
import sg.iss.caps.services.StudentCourseService;



@RequestMapping(value = "/lecturer")
@RestController
@Controller
public class LecturerController {

	@RequestMapping(value = "/index")
	public String index() {

		return "Hello there!";
	}
	
	@Autowired
	StudentCourseService scservice;
	
	@RequestMapping(value = "/course/{courseindex}", method = RequestMethod.GET)
	public ModelAndView viewscbyindexpg(@PathVariable String courseindex) {
		ModelAndView mav = new ModelAndView("StudentbyCourseIndex");
		mav.addObject("studentcourse", scservice.Viewcoursebycourseindex(courseindex));
		return mav;
	}
	
/*	@RequestMapping(value = "/course/edit/{studentid}/{courseindex}", method = { RequestMethod.GET} )
	public ModelAndView editstudentgradePage(@PathVariable String studentid, @PathVariable String courseindex ) {
		Studentcourse studentcoursedetails = scservice.findStudentcoursebyID(studentid, courseindex );
		ModelAndView mav = new ModelAndView("StudentGradeEdit", "studentcoursedetails", studentcoursedetails);
		return mav;
	}*/
	
	/*@RequestMapping(value = "/course/edit/{studentid}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable String studentid) {
		ModelAndView mav = new ModelAndView("StudentGradeEdit");
		mav.addObject("studentdetailcourse", scservice.findStudentcoursebyID(studentid));
		return mav;
	}
*/
	
	@RequestMapping(value = "/course/edit/{studentid}/{courseindex}", method = { RequestMethod.GET} )
	public ModelAndView editstudentgradePage(@PathVariable String studentid, @PathVariable String courseindex , @ModelAttribute Studentcourse studentcoursedetails) {
		studentcoursedetails = scservice.findStudentcoursebyID(studentid, courseindex );
		ModelAndView mav = new ModelAndView("StudentGradeEdit");
		mav.addObject("studentcoursedetails", studentcoursedetails);
		return mav;
	}
	
	
	
	@RequestMapping(value="/course/edit/{studentid}", method = RequestMethod.POST)
	public ModelAndView editStudGradePage(@PathVariable String studentid, @ModelAttribute Studentcourse studentcoursedetails ) {
		scservice.updateGrade(studentcoursedetails);
		ArrayList<Studentcourse> sc = scservice.findall();
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("sc", sc);
		return mav;
	}
	
	
}
