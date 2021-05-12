package com.smartevo.SmartEvo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table //per adesso ometto perchè inline
public class Customer {
	
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	  private String firstName;
	  private String lastName;

	  protected Customer() {}

	  public Customer(String firstName, String lastName) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	  }

	  @Override
	  public String toString() {
	    return String.format(
	        "Customer[id=%d, Nome='%s', Cognome='%s']",
	        id, firstName, lastName);
	  }

	  public Long getId() {
	    return id;
	  }

	  public String getFirstName() {
	    return firstName;
	  }

	  public String getLastName() {
	    return lastName;
	  }

}
