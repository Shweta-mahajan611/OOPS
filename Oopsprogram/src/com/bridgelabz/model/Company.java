package com.bridgelabz.model;



public class Company 
{
	
	private String company_symbol;
	private int share;
	private int share_price;
	
	
	public long getCompany_bal() {
		return company_bal;
	}
	public void setCompany_bal(long company_bal) {
		this.company_bal = company_bal;
	}
	private long company_bal;
	public String getCompany_symbol() {
		return company_symbol;
	}
	public void setCompany_symbol(String company_symbol) {
		this.company_symbol = company_symbol;
	}
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	public int getShare_price() {
		return share_price;
	}
	public void setShare_price(int share_price) {
		this.share_price = share_price;
	}
	@Override
	public String toString() {
		return "Company [company_symbol=" + company_symbol + ", share=" + share + ", share_price=" + share_price
				  + "]";
	}
	
}
