package com.bridgelabz.controller;

import java.io.IOException;

import com.bridgelabz.utiltiy.Utility;
/**
 * class to print stock report
 * @author bridgeit
 *
 */
public class StockAccount
{

	public static void main(String[] args) throws IOException 
	{
		
		System.out.println("1. Buy shares.");
		System.out.println("2. Sell shares.");
		System.out.println("3. Print report.");
		System.out.println();
		System.out.println(" Enter your choice : ");
		int ch = Utility.readInt();
		switch(ch)
		{
		
		case 1: System.out.println("Enter no of shares : ");
		        int no_of_shares = Utility.readInt();
				System.out.println("Enter customer id : ");
				Utility.readString();
		   		String customer_id = Utility.readString();
		   		System.out.println("Enter symbol");
		   		String company_symbol = Utility.readString();
			try 
			{
				Utility.buy(no_of_shares, company_symbol, customer_id);
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    break;
		case 2: System.out.println("Enter no of shares : ");
			    no_of_shares = Utility.readInt();
				System.out.println("customer id: ");
				Utility.readString();
   				customer_id = Utility.readString();
   				System.out.println("Enter symbol");
   			    company_symbol = Utility.readString();
   				Utility.sell(company_symbol, no_of_shares, customer_id);
				break;
	
		case 3: Utility.printStockValue();
				break;
		
		}
	}

}
