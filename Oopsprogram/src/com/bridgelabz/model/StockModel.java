package com.bridgelabz.model;

import java.util.List;

public class StockModel
{
	List<Customer> customerlist;
	List<Company> companylist;
	public List<Customer> getCustomerlist() {
		return customerlist;
	}
	public void setCustomerlist(List<Customer> customerlist) {
		this.customerlist = customerlist;
	}
	public List<Company> getCompanylist() {
		return companylist;
	}
	public void setCompanylist(List<Company> companylist) {
		this.companylist = companylist;
	}

	@Override
	public String toString() {
		return "StockModel [customerlist=" + customerlist + ", companylist=" + companylist + "]";
	}
}
