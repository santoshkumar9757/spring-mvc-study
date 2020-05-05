/**
 * 
 */
package org.santosh.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"employeeName", "employeeDept", "dateOfBirth", "employeeAddress", "empHobby" })
@ApiModel(description = "Employee Description")
public class Employee {
	@JsonProperty("EmployeeName")
	private String employeeName;

	@JsonProperty("Department")
	private String employeeDept;
	
	@JsonProperty("DOB")
	@ApiModelProperty(notes = "Date should be before current date", dataType = "java.util.Date")
	private Date dateOfBirth;

	@JsonProperty("Address")
	private Address employeeAddress;
	
	@Size(min=2, max=20)
	@ApiModelProperty(allowableValues = "min = 2, max = 20", dataType = "String")
	@JsonProperty("Hobby")
	private String empHobby;

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeDept="
				+ employeeDept + ", dateOfBirth=" + dateOfBirth
				+ ", employeeAddress=" + employeeAddress + ", empHobby="
				+ empHobby + "]";
	}
	
	
	

}
