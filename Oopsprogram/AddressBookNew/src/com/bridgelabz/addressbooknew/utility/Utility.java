package com.bridgelabz.addressbooknew.utility;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.addressbooknew.model.AddressModel;
import com.bridgelabz.addressbooknew.model.Person;
/**
 * utility class for addressbook
 * @author Shweta Mahajan
 */
public class Utility 
{
	static Scanner sc = new Scanner(System.in);
	static ObjectMapper mapper =new ObjectMapper();
	static AddressModel model = new AddressModel();
	static List<Person> personlist = new ArrayList<>();

	static String path = "/home/bridgeit/bootcamp/AddressBookNew/src/com/bridgelabz/addressbooknew/repository/person.json";
	/**
	 * read data from json file
	 * @return
	 * @throws IOException
	 */
	public static AddressModel read(String path) throws IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(path);
		AddressModel model = mapper.readValue(file, AddressModel.class);
		System.out.println(model.toString());
		return model;
	}
	/**
	 * function to save records in file
	 * @return
	 * @throws IOException
	 */
	public static AddressModel write(List<Person> personlist) throws IOException
	{
		String path = "/home/bridgeit/bootcamp/AddressBookNew/src/com/bridgelabz/addressbooknew/repository/person.json";
		try {
			
		//	mapper.writeValue(new File("/home/bridgeit/bootcamp/AddressBookNew/src/com/bridgelabz/addressbooknew/repository/personinfo.json"), personlist);
			mapper.writeValue(new File(path), personlist);
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
	 * method to set file path in addressbook repository
	 * @param fileName
	 * @param fileExtension
	 * @return
	 */
	public static File getPathOfFile(String fileName, String fileExtension)
	{
		fileName = "/home/bridgeit/bootcamp/AddressBookNew/src/com/bridgelabz/addressbooknew/repository/"+ fileName + fileExtension;
		
		File file = new File(fileName);
		
		return file;
	}
	/**
	 * function to create new file in addressbook
	 * @param fileName
	 * @param fileExtension
	 * @return
	 */
	public static File createNewFile(String fileName, String fileExtension)
	{
		File file = Utility.getPathOfFile(fileName, fileExtension);
		try
		{
			FileWriter Writer = new FileWriter(file);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return file;
	}
	/**
	 * take string input from user
	 * @return
	 */
	public static String readString()
	{
			return sc.next();
	}
	
	
	/**
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static  List<Person> readPersonList(String path) throws IOException 
	{
		System.out.println("----------AddressBook Info-------------");
		ObjectMapper mapper = new ObjectMapper();
		List<Person> personlist = mapper.readValue(new File(path), new TypeReference<List<Person>>() {});
		System.out.println(personlist);
		return personlist;

	}
	
	/**
	 * take integer value from user
	 * @return
	 */
	public static int readInt() 
	{
		return sc.nextInt();
	}
}
