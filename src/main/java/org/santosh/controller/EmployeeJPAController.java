package org.santosh.controller;

import org.santosh.model.Employee;
import org.santosh.model.Project;
import org.santosh.repository.EmployeeJpaRepository;
import org.santosh.repository.ProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeJPAController {

	@Autowired
	private EmployeeJpaRepository employeeJpaRepository;

	@Autowired
	private ProjectJpaRepository projectJpaRepository;
	
	@GetMapping(value = "/jpa/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeeList() {
		return employeeJpaRepository.findAll();
	}

	@GetMapping(value = "/jpa/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Employee> getEmployeeById(@PathVariable("id") int id) {
		return employeeJpaRepository.findById(id);
	}

	//Default response type is XML
	@GetMapping(value = "jpa/employees/{name}")
	public Employee getEmployeeDetails(@PathVariable("name") String employeeName) {
		
		Employee employee = new Employee();
		employee.setEmployeeName(employeeName);
		employee.setEmpHobby("Gaming");
		
		return employee;
	}
	
	@PutMapping(value = "jpa/employees/{name}")
	public ResponseEntity<Boolean> updateEmployeeDetails(
			@PathVariable("name") String employeeName, @RequestBody Employee employee) {

		System.out.println("Employee Name: "+ employee.getEmployeeName());
		System.out.println("Employee Department: "+ employee.getEmployeeDept());

		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@PostMapping(value = "jpa/employees")
	public ResponseEntity<Boolean> addEmployeeDetails(@RequestBody Employee employee) {

		System.out.println("Employee Name: " + employee.getEmployeeName());
		System.out.println("Employee Department: " + employee.getEmployeeDept());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{name}")
				.buildAndExpand(employee.getEmployeeName()).toUri().toString());

		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "jpa/employees/{id}")
	public void addEmployeeDetails(@PathVariable("id") int id) {
			employeeJpaRepository.deleteById(id);
	}

	@GetMapping(value = "jpa/employees/{id}/projects", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Project> getProjectDetails (@PathVariable("id") int id) throws Exception {
			Optional<Employee> empOptional = employeeJpaRepository.findById(id);
			if(!empOptional.isPresent()) {
				throw new Exception("id- " + id);
			}
			return empOptional.get().getProjectList();
	}

	@PostMapping(value = "jpa/employees/{id}/project", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addProjectDetails(@PathVariable("id") int id, @RequestBody Project project) throws Exception {
		Optional<Employee> empOptional = employeeJpaRepository.findById(id);
		if (empOptional.isPresent()) {
			Employee emp = empOptional.get();
			project.setEmployee(emp);
			projectJpaRepository.save(project);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(project.getId()).toUri();
			return ResponseEntity.created(location).build();
		}
		else {
			throw new Exception("id -" + id);
		}
	}

}
