/**
 * 
 */
package org.santosh.model;

import java.util.Date;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"employeeName", "employeeDept", "dateOfBirth", "employeeAddress", "empHobby" })
public class Employee {
	@JsonProperty("EmployeeName")
	private String employeeName;
	
	private String employeeDept;
	
	@JsonProperty("Date Of Birth")
	private Date dateOfBirth;
	
	private Address employeeAddress;
	
	@Size(min=2, max=20)
	private String empHobby;

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeDept="
				+ employeeDept + ", dateOfBirth=" + dateOfBirth
				+ ", employeeAddress=" + employeeAddress + ", empHobby="
				+ empHobby + "]";
	}
	
	
	

}
