/**
 * 
 */
package org.santosh.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"employeeName", "employeeDept", "dateOfBirth", "employeeAddress", "empHobby" })
@ApiModel(description = "Employee Description")
public class Employee {
	@JsonProperty("EmployeeName")
	private String employeeName;
	
	private String employeeDept;
	
	@JsonProperty("Date Of Birth")
	@ApiModelProperty(notes = "Date should be before current date", dataType = "java.util.Date")
	private Date dateOfBirth;
	
	private Address employeeAddress;
	
	@Size(min=2, max=20)
	@ApiModelProperty(allowableValues = "min = 2, max = 20", dataType = "String")
	private String empHobby;

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeDept="
				+ employeeDept + ", dateOfBirth=" + dateOfBirth
				+ ", employeeAddress=" + employeeAddress + ", empHobby="
				+ empHobby + "]";
	}
	
	
	

}
