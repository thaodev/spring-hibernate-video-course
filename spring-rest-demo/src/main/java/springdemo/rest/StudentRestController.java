package springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> theStudents;

	// define @PostConstruct to load the student data
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();

		theStudents.add(new Student("Thao", "Nguyen"));
		theStudents.add(new Student("Rachel", "Nguy"));
		theStudents.add(new Student("Michelle", "Green"));
		theStudents.add(new Student("Joe", "Tribiani"));
		theStudents.add(new Student("Ross", "Geller"));
	}

	// define endpoint for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
	}

	// define endpoint for "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		return theStudents.get(studentId);
	}
}
