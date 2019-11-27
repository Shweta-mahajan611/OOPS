package com.bridgelabz.clinicmanagement.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.clinicmanagement.model.Connections;
import com.bridgelabz.clinicmanagement.model.Doctor;
/**
 * utility class for clinic management
 * @author Shweta Mahajan
 *
 */
public class Utility 
{
	Scanner sc = new Scanner(System.in);
	/**
	 * take string input
	 * @return
	 */
	public String readString() throws IOException
	{
		String str = sc.next();
		return str;
	}
	/**
	 * take boolean input
	 * @return
	 */
	public boolean readBoolean() throws IOException
	{
		boolean flag = sc.nextBoolean();
		return flag;
	}
	/**
	 * take int input
	 * @return
	 */
	public int readint() throws IOException
	{
		int num = sc.nextInt();
		return num;
	}
	/**
	 * print date
	 * @param date
	 * @return
	 */
	public Date printDate(String date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try{
			return sdf.parse(date);
		}
		catch(ParseException pe){
			return null;
		}
	}
	/**
	 * fix appointment between doctor and patient
	 * @throws IOException
	 */
	public void appointmentfix() throws IOException
	{
		System.out.println("Enter Doctor Id ");
		int did=readint();
	
		List<Doctor> alist = Connections.readFileDoc();
		Doctor doctor=Search.findDocById(alist,did);
		
	
		if(doctor!=null) {
			System.out.println("Enter the availablity");
			String available = readString();
			if(doctor.getAvailability().equals(available)) {
				
				if(doctor.getAppointments()<5) {
					
					doctor.setAppointments(doctor.getAppointments()+1);
					System.out.println("Appointed ");
					Connections.writeappfile(alist);
					
				}else {
					System.out.println("Get appointment of another doctor");
				}
				
			}
			else {
				System.out.println("Doctor is not available");
			}
		}
	}
}
