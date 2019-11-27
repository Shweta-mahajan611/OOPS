package com.bridgelabz.addressbooknew.controller;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.addressbooknew.model.Person;
import com.bridgelabz.addressbooknew.services.AddressImplentsClass;
import com.bridgelabz.addressbooknew.utility.Utility;
/**
 * main class of addressbook
 * @author Shweta Mahajan
 *
 */
public class AddressBook 
{

	public static void main(String[] args) throws Exception
	{
		String path = "/home/bridgeit/bootcamp/AddressBookNew/src/com/bridgelabz/addressbooknew/repository/person.json";
		List<Person> personlist = new ArrayList<Person>();
		int ch=0;
		AddressImplentsClass object = new AddressImplentsClass();
		do 
		{
		System.out.println("1. Add Person");
		System.out.println("2. Delete Person");
		System.out.println("3. Edit Person");
		System.out.println("4. Sort by last name");
		System.out.println("5. Sort by zip");
		System.out.println("6. save");
		System.out.println("7. show AddressBook");

		System.out.println("Enter your choice : ");
		ch = Utility.readInt();
		switch(ch)
		{
		case 1: object.addPerson();
			break;
		case 2: object.deletePerson();
			break;
		case 3: object.editPerson();
			break;
		case 4: object.sortByLastName();
			break;
		case 5: object.sortByZip();
			break;
		case 6: object.save();
			break;
		case 7: personlist = Utility.readPersonList(path);
			break;
		}
	}while(ch!=7);

}
}
