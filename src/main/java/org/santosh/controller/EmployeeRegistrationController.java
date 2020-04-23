/**
 * 
 *//*

package org.santosh.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.santosh.model.Employee;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

*/
/**
 * @author Santosh
 * @dat30-Mar-2018
 *//*


@Controller
public class EmployeeRegistrationController {
	
	@RequestMapping(value = "/registrationForm.html", method = RequestMethod.GET)
	public ModelAndView registerEmployee() throws Exception {
		String sException = "IOException";
		
		if(sException.equalsIgnoreCase("IOException"))
			throw new IOException();
		
		ModelAndView registerFormView = new ModelAndView("RegistrationForm");
		
		return registerFormView;
	}
	
	*/
/*@RequestMapping(value = "/submitRegistrationForm.html", method = RequestMethod.POST)
	public ModelAndView submitRegistrationForm(@RequestParam("employeeName") String empName, @RequestParam("employeeDept") String empDept) {
		
		ModelAndView submitView = new ModelAndView("RegistrationForm");
		submitView.addObject("msg", "Employee " + empName + " of " + empDept + " is registered successfully");
		
		return submitView;
		
	}*//*

	
	*/
/*@RequestMapping(value = "/submitRegistrationForm.html", method = RequestMethod.POST)
	public ModelAndView submitRegistrationForm(@RequestParam(value ="employeeName") String empName,
			@RequestParam(value = "employeeDept") String empDept) {
		
		Employee employee = new Employee();
		employee.setEmployeeName(empName);
		employee.setEmployeeDept(empDept);
		
		ModelAndView submitView = new ModelAndView("RegistrationSuccess");
		submitView.addObject("msg", "Registration Complete. Below are the details");
		submitView.addObject("employeeDetails", employee);
		
		return submitView;
		
	}*//*

	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		//dataBinder.setDisallowedFields(new String [] {"employeeDept"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy--MM--dd");
		dataBinder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormat, false));
		dataBinder.registerCustomEditor(String.class, "employeeName", new EmployeeNameEditor());
	}
	
	@ModelAttribute
	public void addCommonObject(Model model) {
		model.addAttribute("headerMsg", "Chal Mohan Ranga");
		
	}
	
	@RequestMapping(value = "/submitRegistrationForm.html", method = RequestMethod.POST)
	public ModelAndView submitRegistrationForm(
			@Valid @ModelAttribute(value = "employeeDetails") Employee employee, BindingResult result) {
		
		if(result.hasErrors()) {
			ModelAndView registrationView = new ModelAndView("RegistrationForm");
			System.out.println(result.getFieldErrors());
			return registrationView;
			
		}

		ModelAndView submitView = new ModelAndView("RegistrationSuccess");
		submitView.addObject("msg", "Registration Complete. Below are the details");

		return submitView;
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException() {
		System.out.println("NullPointerException occurred");
		return "NullPointerException";
		
	}
}
*/
