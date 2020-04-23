/**
 * 
 */
package org.santosh.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
