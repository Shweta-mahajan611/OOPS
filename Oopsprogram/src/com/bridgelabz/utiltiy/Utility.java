package com.bridgelabz.utiltiy;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.bridgelabz.model.Company;
import com.bridgelabz.model.Customer;
import com.bridgelabz.model.StockModel;
import com.bridgelabz.model.StockPortfolio;

public class Utility 
{
	static Scanner sc = new Scanner(System.in);
	static ObjectMapper mapper = new ObjectMapper();
	static StockModel model = new StockModel();
	static List<Company> companylist = new ArrayList<>();
	static List<Customer> customerlist = new ArrayList<>();
	
	/**
	 * read value from user
	 * @return
	 */
	public static int readInt()
	{
		return sc.nextInt();
	
	}
	/**
	 * read value from user
	 * @return
	 */
	public static float readFloat()
	{
		return sc.nextFloat();
	
	}
	public static long readlong()
	{
		return sc.nextLong();
	
	}
	
	/**
	 * to write into json file
	 * @param path
	 * @param filedata
	 */
	public static void jsonfilewrite(String path, Map filedata)
	{
		try 
		{
			FileWriter writer = new FileWriter(path);
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File(path),filedata );
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * to read from json file
	 * @param path
	 * @param filedata
	 */
	public static StockModel jsonfilereader(String path, Map filedata)
	{
		ObjectMapper mapper = new ObjectMapper();

		try 
		{
			mapper.writeValue(new File(path), filedata);
		} 
		catch (JsonGenerationException e) 
		{
			e.printStackTrace();
		} 
		catch (JsonMappingException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return model;
	}
	/**
	 * to calculate total value of share stock
	 * @param stock
	 * @return
	 */
	public static long stockDetails(StockPortfolio stock[])
	{
		try
		{
			String path ="/home/bridgeit/bootcamp/Oopsprogram/src/com/bridgelabz/repository/stock.json";
		
		long total=0;
		for(int i=0; i<stock.length; i++)
		{
			stock[i] = new StockPortfolio();
			
			System.out.println("Enter stock name :");
			String stockName = sc.next();
			stock[i].setStock_name(stockName);
			
			System.out.println("Enter no of shares :");
			int noOfShares = sc.nextInt();
			stock[i].setNumber_of_share(noOfShares);
			
			System.out.println("Enter share price :");
			float price = sc.nextFloat();
			stock[i].setShare_price(price);
			
			long stockValue = (long) (noOfShares * price);
			stock[i].setTotal_value(stockValue);
			
			total = total + stockValue;
			stockValue = 0;
		}
		Map<String, StockPortfolio> map = new HashMap<String, StockPortfolio>();

		for (int i = 0; i < stock.length; i++) 
		{
			map.put("stock" + (i + 1) + "", stock[i]);
		}

		Utility.jsonfilewrite(path, map);
		return total;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}
	/**
	 * to take string input
	 * @return
	 */
	public static String readString()
	{
		return sc.nextLine();
	}
	/**
	 * read data from json file
	 * @return
	 * @throws IOException
	 */
	public static StockModel read(String path) throws IOException 
	{
		
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(path);
		StockModel stockAccount = mapper.readValue(file, StockModel.class);
		
		return stockAccount;

	}
	/**
	 * function to save records in file
	 * @return
	 * @throws IOException
	 */
	public static StockModel write(String path) throws IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			mapper.writeValue(new File("/home/bridgeit/bootcamp/Oopsprogram/src/com/bridgelabz/repository/commercialdata.json"), model);
			System.out.println("\nSaved");
		} 
		catch (JsonGenerationException e)
		{
			e.printStackTrace();
		} 
		catch (JsonMappingException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return model;
		
	}
	/**
	 * function buy to add shares of stock to account
	 * @param  
	 * @param amount
	 * @param symbol
	 * @throws IOException 
	 */
	public static void buy(int no_of_shares, String company_symbol,String customer_id) throws IOException 
	{    
		String path = "/home/bridgeit/bootcamp/Oopsprogram/src/com/bridgelabz/repository/data.json";
		model = read(path);
		companylist = model.getCompanylist();
	    Company result = companylist.stream().filter(c->company_symbol.equals(c.getCompany_symbol())).findAny().orElse(null);
	    //System.out.println("result---->"+result);
	    int shares = result.getShare() - no_of_shares;
	    result.setShare(shares);
	    int price = result.getShare_price();
	       
		customerlist = model.getCustomerlist();
		System.out.println(customerlist);
		Customer result2 = customerlist.stream().filter(cust->customer_id.equals(cust.getCustomer_id())).findAny().orElse(null);
		System.out.println(result2);	
		float bal = result2.getBalance() - price;	
		result2.setBalance(bal);
		int customer_shares = result2.getNo_of_Shares() + no_of_shares;
		result2.setNo_of_Shares(customer_shares);
		write(path);    
		
	}
	
	/**
	 * function sell to subtract shares of stock from account
	 * @param sell_amount
	 * @param sell_symbol
	 * @throws IOException 
	 */
	public static void sell(String company_symbol,int no_of_shares, String customer_id ) throws IOException
	{
		String path = "/home/bridgeit/bootcamp/Oopsprogram/src/com/bridgelabz/repository/data.json";
		model = read(path);
		companylist = model.getCompanylist();
	    Company result = companylist.stream().filter((c)->company_symbol.equals(c.getCompany_symbol())).findAny().orElse(null);
		System.out.println(result);
		int shares = result.getShare() + no_of_shares;
		result.setShare(shares);
		long price = result.getShare_price();
	    long bal = shares * price;
	    result.setCompany_bal(result.getCompany_bal() - bal);
	    //write(path);
	  
	    customerlist = model.getCustomerlist();
	    Customer result2 = customerlist.stream().filter((cust)->customer_id.equals(cust.getCustomer_id())).findAny().orElse(null);
	    int cust_shares = result2.getNo_of_Shares() - no_of_shares;
	    result2.setNo_of_Shares(cust_shares);
	    long cust_bal = (long) (result2.getBalance() + bal);
	    result2.setBalance(cust_bal);
		write(path);
		
	}
	/**
	 * function to print stock report
	 * @throws IOException 
	 * 
	 */
	public static void printStockValue() throws IOException
	{
		String path = "/home/bridgeit/bootcamp/Oopsprogram/src/com/bridgelabz/repository/commercialdata.json";
		model = read(path);
		System.out.println("---------------Stock Report-------------------");
		System.out.println("Company list....");
		System.out.println(	model.getCompanylist());
		System.out.println("Customer list.....");
		System.out.println(model.getCustomerlist());
	}
	
}
