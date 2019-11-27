package com.bridgelabz.controller;

import java.io.File;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.model.Inventory;

public class InventoryManager 
{

	public static void main(String[] args)  
	{
		//to map JSON into java objects
		ObjectMapper mapper=new ObjectMapper();
		try 
		{
		
		//to store the data from file
		Map<String, Inventory>map=mapper.readValue(new File("/home/bridgeit/bootcamp/Oopsprogram/src/com/bridgelabz/repository/inventory.json"), new TypeReference<Map<String, Inventory>>(){
		}) ;		
		
		Inventory rice=map.get("list1");
		Inventory pulses=map.get("list2");
		Inventory wheats=map.get("list3");
		
		System.out.println("------------ Rice -----------------");
		 
		System.out.println("Quantity of Rice :"+rice.getWeight());
		System.out.println("Price of rice :"+rice.getPrice()+" per kg");		
		System.out.println("Total cost of Rice Rs."+(rice.getWeight()*(rice.getPrice())));
		
		System.out.println();
		System.out.println("------------ Pulses -----------------");
	
		System.out.println("Quantity of Pulses :"+pulses.getWeight());
		System.out.println("Price of Pulses :"+pulses.getPrice()+" per kg");		
		System.out.println("Total cost of Rice Rs."+(pulses.getWeight()*(pulses.getPrice())));
		
		System.out.println();
		System.out.println("------------ Wheats -----------------");	
		
		System.out.println("Quantity of Wheats :"+wheats.getWeight());
		System.out.println("Price of Wheats :"+wheats.getPrice()+" per kg");		
		System.out.println("Total cost of Wheats Rs."+(wheats.getWeight()*(wheats.getPrice())));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
