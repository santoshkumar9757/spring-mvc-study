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
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"employeeName", "employeeDept", "dateOfBirth", "employeeAddress", "empHobby" })
@ApiModel(description = "Employee Description")
@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;

	@JsonProperty("EmployeeName")
	private String employeeName;

	@JsonProperty("Department")
	private String employeeDept;
	
	@JsonProperty("DOB")
	@ApiModelProperty(notes = "Date should be before current date", dataType = "java.util.Date")
	private Date dateOfBirth;

	@JsonProperty("Address")
	private String employeeAddress;
	
	@Size(min=2, max=20)
	@ApiModelProperty(allowableValues = "min = 2, max = 20", dataType = "String")
	@JsonProperty("Hobby")
	private String empHobby;

	@OneToMany(mappedBy = "employee")
	private List<Project> projectList;

}
