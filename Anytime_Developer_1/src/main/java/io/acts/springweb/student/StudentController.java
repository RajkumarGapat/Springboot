package io.acts.springweb.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/student")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudent();
	}
	
	@RequestMapping("/student/{id}")
	public Optional<Student> getEmpData(@PathVariable("id") long id)
	{
		return studentService.getStudent(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/student")
	public void addStudent(@RequestBody Student student)
	{
		studentService.addStudent(student);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/student")
	public void updateStudent(@RequestBody Student student)
	{
		studentService.updateStudent(student);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/student/{id}")
	public void deleteStudent(@PathVariable("id") long id)
	{
		studentService.deleteStudent(id);
	}

}