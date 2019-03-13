package controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Group;
import model.Student;
import service.GroupService;
import service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentService ss;
	
	@Autowired
	GroupService gs;
	
	@RequestMapping("add")
	public Student addStudent(
			@RequestParam(name="id") String id,
			@RequestParam(name="firstName") String firstName,
			@RequestParam(name="lastName") String lastName,
			@RequestParam(name="group") String group
		) {
		
		Group g = gs.getGroup(group);
		ss.addStudent(id, firstName, lastName, g.getId());
		return ss.getStudent(id);
	}
	
	@RequestMapping("/all")
	public Hashtable<String, Student> getAll() {
		return ss.getAll();
	}
	
	@RequestMapping("{id}")
	public Student getStudent(@PathVariable("id") String id) {
		return ss.getStudent(id);
	}
}
