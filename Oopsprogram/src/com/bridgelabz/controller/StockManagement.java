package com.bridgelabz.controller;

import java.io.File;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import com.bridgelabz.model.Stock;
import com.bridgelabz.model.StockPortfolio;
import com.bridgelabz.utiltiy.Utility;
/**
 * Stock Management
 * @author Shweta Mahajan
 *
 */
public class StockManagement 
{
	public static void main(String[] args) 
	{
		//to map JSON into java objects
		ObjectMapper mapper=new ObjectMapper();
		String path ="/home/bridgeit/bootcamp/Oopsprogram/src/com/bridgelabz/repository/stock.json";
		try
		{
			System.out.println("Enter the no of stocks : ");
			int stocks = Utility.readInt();
			
			//to hold the list of stocks
			StockPortfolio[] stock = new StockPortfolio[stocks];
			
			//to store the data from file
			Map<String, Stock>map=mapper.readValue(new File(path), new TypeReference<Map<String, Stock>>(){}) ;		
		
			System.out.println("Stock name  stock share  share price  stock value");
			
			map.forEach((k,v)-> System.out.println(v.getStock_name()+"\t\t"+v.getNumber_of_share()+"\t\t"+v.getShare_price()+" \t"+v.getTotal_value()));
				
			long totalvalue = Utility.stockDetails(stock);
			System.out.println("Total value of Stock :" +totalvalue);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
