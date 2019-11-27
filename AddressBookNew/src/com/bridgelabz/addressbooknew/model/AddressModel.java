package com.bridgelabz.addressbooknew.model;

import java.util.List;
/**
 * Address book model
 * @author bridgeit
 *
 */
public class AddressModel
{
	List<Person> personlist ;
	List<Address> addresslist;
	public AddressModel() {};
	public AddressModel(List<Person> personlist, List<Address> addresslist) {
		super();
		this.personlist = personlist;
		this.addresslist = addresslist;
	}
	public List<Person> getPersonlist() {
		return personlist;
	}
	public void setPersonlist(List<Person> personlist) {
		this.personlist = personlist;
	}
	public List<Address> getAddresslist() {
		return addresslist;
	}
	public void setAddresslist(List<Address> addresslist) {
		this.addresslist = addresslist;
	}
	@Override
	public String toString() {
		return "AddressModel [personlist=" + personlist + ", addresslist=" + addresslist + "]";
	}
	
}
