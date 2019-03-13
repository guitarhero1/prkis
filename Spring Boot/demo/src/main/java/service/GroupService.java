package service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import model.Group;
import model.Student;

@Service
public class GroupService {
	public Hashtable<String, Group> groups = new Hashtable<String, Group>();
	
	public GroupService() {
		Group g0 = new Group();
		g0.setId("0");
		g0.setCode("IT-41");
		g0.setEntry("2015");
		groups.put(g0.getId(), g0);

		Group g1 = new Group();
		g1.setId("1");
		g1.setCode("IT-41");
		g1.setEntry("2014");
		groups.put(g1.getId(), g1);
	}
	
	public Group addGroup(String ...a) {
		Group g = new Group();
		g.setId(a[0]);
		g.setCode(a[1]);
		g.setEntry(a[2]);
		groups.put(a[0], g);
		
		return g;
	}
	
	public Group getGroup(String id) {
		if (groups.containsKey(id)) {
			return groups.get(id);
		} else {
			return null;
		}
	}
	
	public Hashtable<String, Group> getAll() {
		return groups;
	}
	
	public Hashtable<String, Student> getStudentsByGroupId(String id) {
		return null;
	}
}