package com.bridgelabz.addressbooknew.services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bridgelabz.addressbooknew.model.AddressModel;
import com.bridgelabz.addressbooknew.model.Person;
import com.bridgelabz.addressbooknew.utility.Utility;
/**
 * class to implements all methods of Address Interface
 * @author Shweta Mahajan
 *
 */
public class AddressImplentsClass implements Address
{
	ArrayList<Person> personlist = new ArrayList<Person>();
	ArrayList<Address> addresslist = new ArrayList<Address>();
	ArrayList<AddressModel> model = new ArrayList<AddressModel>();
	String path = "/home/bridgeit/bootcamp/AddressBookNew/src/com/bridgelabz/addressbooknew/repository/personinfo.json";
	int count = personlist.size();
	@Override
	public void createNewAddressBook() 
	{
		System.out.println("Enter file name : ");
		String fileName = Utility.readString();
		System.out.println("Enter file extension :");
		String fileExtension = Utility.readString();
		Utility.getPathOfFile(fileName, fileExtension);
		if(fileExtension.equals("json"))
		{
			Utility.createNewFile(fileName, fileExtension);
		}
	}
	
	String firstname="";
	String lastname="";
	String phone="";
	String address="";
	String city="";
	String state="";
	String zip="";
	@Override
	public void openAddressBook()
	{
		try 
		{
			Utility.read(path);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * add person in address book
	 */
	@Override
	public void addPerson() 
	{
		try {
			String path = "/home/bridgeit/bootcamp/AddressBookNew/src/com/bridgelabz/addressbooknew/repository/person.json";
			List<Person> listOfPerson = Utility.readPersonList(path);
		
		System.out.println(listOfPerson);
		
		System.out.println("Enter first name :");
		
		firstname = Utility.readString();
		System.out.println("Enter last name :");
		lastname = Utility.readString();
		System.out.println("Enter phone :");
		phone = Utility.readString();
		System.out.println("Enter address :");
		address = Utility.readString();
		System.out.println("Enter city :");
		city = Utility.readString();
		System.out.println("Enter state :");
		state = Utility.readString();
		System.out.println("Enter zip code :");
		zip = Utility.readString();
		Person newperson = new Person(firstname, lastname, address, city, state, zip, phone);
		listOfPerson.add(newperson);
		Utility.write(listOfPerson); 
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	/**
	 * delete record from address book
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void deletePerson() 
	{
			//System.out.println("Enter phone no :");
			//firstname= Utility.readString();
			personlist = sortByZip();
			personlist.remove(personlist);
			try
			{
				Utility.readPersonList(path);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
	}
	/**
	 * seach person record by last name
	 * @return
	 */
	public void searchByLastname() 
	{
		System.out.println("Enter last name : ");
		lastname = Utility.readString();
	    Person result = personlist.stream().filter(p->lastname.equals(p.getLastName())).findAny().orElse(null);
		System.out.println(result);
		
	}
	/**
	 * search person by phone no
	 * @return
	 */
	public ArrayList<Person> searchByPhoneNo() 
	{
		System.out.println("Enter phone no :");
		String phoneNo = Utility.readString();
		List<Person> list=personlist.stream().filter(i->i.getPhone().equals(phoneNo)).collect(Collectors.toList());
	    System.out.println(list);
		if(!list.isEmpty())
        {
			for(int i=0;i<list.size();i++)
	        {
	            System.out.println(list.get(i).toString());
	        }
        }
        else
        {
        	System.out.println("not found");
        }
	    return null;
	}
	/**
	 * edit person record in address book
	 */
	@Override
	public void editPerson() 
	{
		System.out.println("Enter first name :");
		firstname = Utility.readString();
		System.out.println("Enter last name :");
		lastname = Utility.readString();
		System.out.println("Enter phone :");
		phone = Utility.readString();
		System.out.println("Enter address :");
		address = Utility.readString();
		System.out.println("Enter city :");
		city = Utility.readString();
		System.out.println("Enter state :");
		state = Utility.readString();
		System.out.println("Enter zip code :");
		zip = Utility.readString();
		Person newperson = new Person(firstname, lastname, address, city, state, zip, phone);
		
	}
	/**
	 * sort records by last name of person
	 * @return 
	 */
//	@Override
//	public void sortByLastName()
//	{
//		Collections.sort(personlist, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
//		System.out.println(personlist);
//	}
//	/**
//	 * sort records by zip code
//	 */
	String path1 ="/home/bridgeit/bootcamp/AddressBookNew/src/com/bridgelabz/addressbooknew/repository/person.json";
	@Override
	public ArrayList<Person> sortByZip() 
	{
		
		try {
			List<Person> personlist = Utility.readPersonList(path1);
			//List<Person> listOfSort=personlist.stream().sorted(Comparator.comparing(Person::getZip)).collect(Collectors.toList());
			//System.out.println(listOfSort);
			Collections.sort(personlist, (p1, p2) -> p1.getZip().compareTo(p2.getZip()));
			return (ArrayList<Person>) personlist;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Collections.sort(personlist, (p1, p2) -> p1.getZip().compareTo(p2.getZip()));
		return null;

	}
	/**
	 * function to read json file
	 */
	@Override
	public void readJson() 
	{
		try 
		{
			Utility.read(path);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * function to save record in addressbook
	 */
	@Override
	public void save() 
	{
		try 
		{
			Utility.write(personlist);
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * function to print person details
	 */
	@Override
	public void PrintPersonDetails() 
	{
		System.out.println("Enter phone no : ");
		phone = Utility.readString();
		List<Person> list=personlist.stream().filter(i->i.getPhone().equals(phone)).collect(Collectors.toList());
		System.out.println(list);
	}	
	/**
	 * sort by last name
	 */
	public void sortByLastName() 
	{
		if (count > 1) 
		{
			System.out.println("Sorting by last name");
			Collections.sort(personlist, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

			// Print after Sorting
			System.out.println(personlist);
		} 
		else 
		{
			System.out.println("less record to sort");
		}
	}

	/*
	 * Purpose :Method for Sorting object bY Zipcode
	 */
//	@Override
//	public ArrayList<Person> sortByZip()
//	{
//		if (count > 1)
//		{
//			System.out.println("Sorting By Zipcode");
//			Collections.sort(personlist, (p1, p2) -> String.valueOf(p1.getZip())
//					.compareTo(String.valueOf(p2.getZip())));
//
//			// Print after Sorting
//			//System.out.println(personlist);
//
//		} else 
//		{
//			System.out.println("less record to sort");
//		}
//		return personlist;
//	}
	/**
	 * 
	 * @param personlist
	 */

	public List<Person> getSortedList(List<Person> personlist) 
	{
	    return personlist.stream().sorted(Comparator.comparing(Person::getLastName)).collect(Collectors.toList());
		 
	}
	
	
	}
