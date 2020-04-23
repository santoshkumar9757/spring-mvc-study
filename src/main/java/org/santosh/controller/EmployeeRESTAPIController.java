package org.santosh.controller;

import java.util.ArrayList;

import org.santosh.model.Employee;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeRESTAPIController {
	
	@GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Employee> getEmployeeList() {

		ArrayList<Employee> alEmployeeList = new ArrayList<Employee>();

		Employee e1 = new Employee();
		e1.setEmployeeName("Santosh");

		Employee e2 = new Employee();
		e2.setEmployeeName("Shiva");

		Employee e3 = new Employee();
		e3.setEmployeeName("Vinayak");

		alEmployeeList.add(e1);
		alEmployeeList.add(e2);
		alEmployeeList.add(e3);

		return alEmployeeList;
	}

	@GetMapping(value = "/employees/{name}", produces = MediaType.APPLICATION_XML_VALUE)
	public Employee getEmployeeDetails(@PathVariable("name") String employeeName) {
		
		Employee employee = new Employee();
		employee.setEmployeeName(employeeName);
		
		return employee;
	}
	
	@PutMapping(value = "/employees/{name}")
	public ResponseEntity<Boolean> updateEmployeeDetails(
			@PathVariable("name") String employeeName, @RequestBody Employee employee) {
		
		System.out.println("Employee Name: "+ employee.getEmployeeName());
		System.out.println("Employee Department: "+ employee.getEmployeeDept());
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@PostMapping(value = "/employees")
	public ResponseEntity<Boolean> addEmployeeDetails(@RequestBody Employee employee) {

		System.out.println("Employee Name: " + employee.getEmployeeName());
		System.out.println("Employee Department: " + employee.getEmployeeDept());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{name}")
				.buildAndExpand(employee.getEmployeeName()).toUri().toString());

		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/employees/{name}")
	public ResponseEntity<Boolean> addEmployeeDetails(
			@PathVariable("name") String employeeName) {

		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
}
