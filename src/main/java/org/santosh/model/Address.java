/**
 * 
 */
package org.santosh.model;


import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Address description")
public class Address {
	String streetName;
	String city; 
	int pincode;

	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}

}
