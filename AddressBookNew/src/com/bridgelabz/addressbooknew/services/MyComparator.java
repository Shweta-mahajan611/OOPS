package com.bridgelabz.addressbooknew.services;

import java.util.Comparator;

import com.bridgelabz.addressbooknew.model.Person;

public  class MyComparator implements Comparator<Person>
{

	@Override
	public int compare(Person p1, Person p2)
	{
	        Person p11 = (Person) p1;
	        Person p12 = (Person) p2;
	        int res = p1.getLastName().compareToIgnoreCase(p2.getLastName());
	        if (res != 0)
	          {
	              return res;
	          }
			return 0;
			//return p1.getLastName().compareToIgnoreCase(p2.getLastName());
	}
	
}