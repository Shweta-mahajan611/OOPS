package com.bridgelabz.controller;

import java.io.File;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.model.Inventory;

public class InventoryDataReader 
{
	public static void main(String[] args) 
	{
		//to map JSON into java objects
		ObjectMapper mapper=new ObjectMapper();
		try
		{
			//to store the data from file
			Map<String, Inventory>map=mapper.readValue(new File("/home/bridgeit/bootcamp/Oopsprogram/src/com/bridgelabz/repository/inventorydata.json"), new TypeReference<Map<String, Inventory>>(){
			}) ;
			Inventory rice=map.get("Rice");
			Inventory wheat=map.get("Wheat");
			Inventory pulses=map.get("Pulses");
			
			System.out.println("Name : "+rice.getName()+" Weight : "+rice.getWeight()+" Price : "+rice.getPrice());
			System.out.println("Name : "+wheat.getName()+" Weight : "+wheat.getWeight()+" Price : "+wheat.getPrice());
			System.out.println("Name : "+pulses.getName()+" Weight : "+pulses.getWeight()+" Price : "+pulses.getPrice());
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
