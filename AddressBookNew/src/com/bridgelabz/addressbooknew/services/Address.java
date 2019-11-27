package com.bridgelabz.addressbooknew.services;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.addressbooknew.model.Person;

/**
 * interface for addressbook related operations
 * @author Shweta Mahajan
 *
 */
public interface Address {
		/**
		 * Purpose:- Method for Creating New Address_Book
		 */
		void createNewAddressBook();

		/**
		 * Purpose:- Method for Opening New Address_Book
		 */
		void openAddressBook();

		/**
		 * Purpose:- Method for adding person record
		 */
		void addPerson();

		/**
		 * Purpose:- Method for deleting person record
		 */
		void deletePerson();

		/**
		 * Purpose:- Method for editing person record
		 */
		void editPerson();

		/**
		 * Purpose:- Method for Sorting from lastname
		 */
		void sortByLastName();

		/**
		 * Purpose:- Method for Sorting from Zipcode
		 * @return 
		 */
		ArrayList<Person> sortByZip();

		/**
		 * Purpose:- Method for reading Json File
		 */
		void readJson();

		/**
		 * Purpose:- Method for writing into Json File
		 */
		void save();
		/**
		 * Purpose:- Method for printing the person record
		 */
		void PrintPersonDetails();

	}


