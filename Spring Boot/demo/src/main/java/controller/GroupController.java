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
@RequestMapping("/groups")
public class GroupController {
	@Autowired
	StudentService ss;

	@Autowired
	GroupService gs;
	
	@RequestMapping("add")
	public Group addGroup(
			@RequestParam(name="id") String id,
			@RequestParam(name="code") String code,
			@RequestParam(name="entry") String entry
		) {
		
		gs.addGroup(id, code, entry);
		return gs.getGroup(id);
	}

	@RequestMapping("/all")
	public Hashtable<String, Group> getAll() {
		return gs.getAll();
	}
	
	@RequestMapping("{id}")
	public Group getGroup(@PathVariable("id") String id) {
		return gs.getGroup(id);
	}
	
	@RequestMapping("{id}/students")
	public Hashtable<String, Student> getStudents(@PathVariable("id") String id) {
		Hashtable<String, Student> students = new Hashtable<String, Student>();
		ss.getAll().forEach((k, v) -> {
			if (v.getGroup().equals(id)) {
				students.put(v.getId(), v);
			}
		});
		
		return students;
	}
}
