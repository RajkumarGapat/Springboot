package io.acts.springweb.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudent()
	{
		List<Student> student = new ArrayList<>();
		studentRepository.findAll().forEach(student::add);
		return student;
	}
	
	public Optional<Student> getStudent(long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}
	
	public void addStudent(Student student)
	{
		studentRepository.save(student);
	}
	
	public void updateStudent(Student student)
	{
		studentRepository.save(student);
	}
	
	public void deleteStudent(long id)
	{
		studentRepository.deleteById(id);
	}
}