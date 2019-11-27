package com.bridgelabz.model;

public class Stock
{
	String stock_name;
	int number_of_share;
	float share_price;
	long total_value;
	
	public int getNumber_of_share() {
		return number_of_share;
	}
	public void setNumber_of_share(int number_of_share) {
		this.number_of_share = number_of_share;
	}
	public String getStock_name() {
		return stock_name;
	}
	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public float getShare_price() {
		return share_price;
	}
	public void setShare_price(float share_price) {
		this.share_price = share_price;
	}
	public long getTotal_value() {
		return total_value;
	}
	public void setTotal_value(long total_value) {
		this.total_value = total_value;
	}
	@Override
	public String toString() {
		return "Stock [stock_name=" + stock_name + ", number_of_share=" + number_of_share + ", share_price="
				+ share_price + ", total_value=" + total_value + "]";
	}	
}
