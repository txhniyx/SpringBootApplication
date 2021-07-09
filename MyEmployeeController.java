package com.example.demo1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyEmployeeController {
	@Autowired
	EmployeeRepo ERepository;
	
	
	@GetMapping("/Employee")
	public List<Employee> getAllEmployee()
	{
		return (List<Employee>) ERepository.findAll();
	}
	
	@GetMapping("/Employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id")Integer id)
	{
		Optional<Employee> emp = ERepository.findById(id);
		if(!emp.isPresent())
			return null;
		return emp;
	}
	
	@PostMapping("/Employee")
	public void addEmployee(@RequestBody Employee e)
	{
		ERepository.save(e);
	}
}
