package com.bridgelabz.model;



public class Customer 
{
	private String customer_id;
	private int no_of_Shares;
	private float balance;
	private String customer_name;
	
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public int getNo_of_Shares() {
		return no_of_Shares;
	}
	public void setNo_of_Shares(int no_of_Shares) {
		this.no_of_Shares = no_of_Shares;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", no_of_Shares=" + no_of_Shares + ", balance=" + balance
				+ ", customer_name=" + customer_name + "]";
	}
	
}
