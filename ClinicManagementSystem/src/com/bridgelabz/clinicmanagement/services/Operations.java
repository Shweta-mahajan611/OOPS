package com.bridgelabz.clinicmanagement.services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

import com.bridgelabz.clinicmanagement.model.Doctor;
import com.bridgelabz.clinicmanagement.model.Patient;
/**
 * class to perform diff operations
 * 1.Add Doctor
 * 2.Delete Doctor
 * 3.Add Patient
 * 4.Delete Patient
 * @author Shweta Mahajan
 *
 */
public class Operations {
	
	Utility utility = new Utility();
	/**
	 * function to add doctor record in file
	 * @param listOfDoctor
	 * @throws IOException
	 */
	public void addDoctor(List<Doctor> listOfDoctor) throws IOException 
	{
			Doctor doctor = new Doctor();
			System.out.println("Enter the doctor name.");
			doctor.setDname(utility.readString());
			
			try {
			System.out.println("Enter the doctor id");
			int did = utility.readint();
			doctor.setDid(did);
			
			}catch(Exception e)
			{
				System.out.println(e);
			}
			System.out.println("Enter the Doctor speciality");
			utility.readString();
			doctor.setSpecialization(utility.readString());
			
			System.out.println("Enter the doctor availability ");
			
			doctor.setAvailability(utility.readString());
			listOfDoctor.add(doctor);		
	}
	/**
	 * function to add patient record in file
	 * @param listOfPatient
	 * @throws IOException
	 */
	public void addPatient( List<Patient> listOfPatient) throws IOException
	{
			Patient p = new Patient();
			
			System.out.println("Enter the patient name");
			p.setPatientname(utility.readString());
			
			try {
			System.out.println("Enter the patient id");
			int pid = utility.readint();
			p.setPatientid(pid);
			
			System.out.println("Enter the patient age");
			p.setAge(utility.readint());
			
			}catch(Exception e) {
				System.out.println(e);
			}
			System.out.println("Enter the patient mobileno ");
			p.setPmbno(utility.readString());
			
			listOfPatient.add(p);
			
	}
	/**
	 * delete record of doctor in file
	 * @param listOfDoctor
	 * @return
	 * @throws IOException
	 */
	public boolean deleteDoctor(List<Doctor> listOfDoctor) throws IOException, InputMismatchException
	{
		System.out.println("Enter the doctor name");
		String dname = utility.readString();
		for(int i=0;i<listOfDoctor.size();i++) {
			if(listOfDoctor.get(i).getDname().equals(dname)) 
			{
				listOfDoctor.remove(i);
				return true;
			}
		}
		return false;
	}
	/**
	 * to delete patient record from file
	 * @param listOfPatient
	 * @return
	 * @throws IOException
	 */
	public boolean deletePatient(List<Patient> listOfPatient) throws IOException, InputMismatchException
	{
		System.out.println("Enter the Patient name");
		String pname = utility.readString();
		for(int i=0;i<listOfPatient.size();i++) {
			if(listOfPatient.get(i).getPatientname().equals(pname))
			{
				listOfPatient.remove(i);
				return true;
			}
		}
		return false;
	}
		
}