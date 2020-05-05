/**
 * 
 */
package org.santosh.model;


import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@ApiModel(description = "Address description")
@JsonFilter("Filter Pincode")
public class Address {
	private String streetName;
	private String city;
	private int pincode;

	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}

}
