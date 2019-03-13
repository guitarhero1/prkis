package service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import model.Student;

@Service
public class StudentService {
	Hashtable<String, Student> students = new Hashtable<String, Student>();
	
	public StudentService() {
		Student s0 = new Student();
		s0.setId("0");
		s0.setFirstName("Petro");
		s0.setLastName("Poroshenko");
		s0.setGroup("0");
		students.put(s0.getId(), s0);
		
		Student s1 = new Student();
		s1.setId("1");
		s1.setFirstName("Yuri");
		s1.setLastName("Dud");
		s1.setGroup("0");
		students.put(s1.getId(), s1);

		Student s2 = new Student();
		s2.setId("2");
		s2.setFirstName("Thomas");
		s2.setLastName("Anders");
		s2.setGroup("1");
		students.put(s2.getId(), s2);
	}
	
	public Student getStudent(String id) {
		if (students.containsKey(id)) {
			return students.get(id);
		} else {
			return null;
		}
	}
	
	public Student addStudent(String ...a) {
		Student s = new Student();
		s.setId(a[0]);
		s.setFirstName(a[1]);
		s.setLastName(a[2]);
		s.setGroup(a[3]);
		students.put(a[0], s);
		
		return s;
	}
	
	public Hashtable<String, Student> getAll() {
		return students;
	}
}
