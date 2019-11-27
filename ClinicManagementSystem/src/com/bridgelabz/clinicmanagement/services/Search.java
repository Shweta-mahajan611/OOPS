package com.bridgelabz.clinicmanagement.services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.bridgelabz.clinicmanagement.model.Doctor;
import com.bridgelabz.clinicmanagement.model.Patient;

/**
 * class for searching doctor and patient by diff attributes
 * @author Shweta Mahajan
 *
 */
public class Search 
{
	Utility utility = new Utility();
	//Doctor d = new Doctor();
	List<Doctor> doctorlist = new ArrayList<>();
	List<Patient> patientlist = new ArrayList<>();
	
	/**
	 * find doctor by name
	 * @param listOfDoctor
	 * @return
	 */
	public List<Doctor>  findByname(List<Doctor> listOfDoctor) throws IOException, InputMismatchException
	{
		System.out.println("Enter the doctor name");
		String name = utility.readString();
		for(int i=0;i<listOfDoctor.size();i++) {
			if(listOfDoctor.get(i).getDname().equals(name)) {
				doctorlist.add(listOfDoctor.get(i));
			}
		}
		return doctorlist;
	}
	/**
	 * find doctor by availability
	 * @param listOfDoctor
	 * @return
	 */
	public List<Doctor>  findByAvailability(List<Doctor> listOfDoctor) throws IOException, InputMismatchException
	{
		System.out.println("Enter the doctor Availability");
		String available = utility.readString();
		for(int i=0;i<listOfDoctor.size();i++) {
			if(listOfDoctor.get(i).getAvailability().equals(available)) {
				doctorlist.add(listOfDoctor.get(i));
			}
		}
		return doctorlist;
	}
	/**
	 * find doctor by specialization
	 * @param listOfDoctor
	 * @return
	 */
	public List<Doctor>  findByspeci(List<Doctor> listOfDoctor) throws IOException, InputMismatchException
	{
		System.out.println("Enter the doctor Speciality");
		String speci = utility.readString();
		for(int i=0;i<listOfDoctor.size();i++) {
			if(listOfDoctor.get(i).getSpecialization().equals(speci)) {
				doctorlist.add(listOfDoctor.get(i));
			}
		}
		return doctorlist;
	}
	/**
	 * find doctor by id
	 * @param listOfDoctor
	 * @param did
	 * @return
	 */
	public static Doctor findDocById(List<Doctor> listOfDoctor,int did) throws IOException, InputMismatchException
	{
		Doctor doc=null;
//		System.out.println("enter the doctor id");
//		int did = u.inputint();
		for(int i=0;i<listOfDoctor.size();i++) {
			if(listOfDoctor.get(i).getDid()==did) {
				doc = listOfDoctor.get(i);
			}
		}
		return doc;
	}
	/**
	 * find patient by name
	 * @param listOfPatient
	 */
	public void findByPname(List<Patient> listOfPatient) throws IOException, InputMismatchException
	{
		System.out.println("Enter the Patient name");
		String name = utility.readString();
		for(int i=0;i<listOfPatient.size();i++) {
			if(listOfPatient.get(i).getPatientname().equals(name)) {
				patientlist.add(listOfPatient.get(i));
			}
		}
		for(int i=0;i<patientlist.size();i++) {
			Patient temp = patientlist.get(i);
			System.out.println(temp.getAge()+"  id "+temp.getPatientid()+"  name  "+temp.getPatientname()+"  mobilenumber "+temp.getPmbno());
		}
	}
	/**
	 * find patient by mob no
	 * @param listOfPatient
	 * @return
	 */
	public Patient  findByNumber(List<Patient> listOfPatient) throws IOException, InputMismatchException
	{
		Patient p = null;
		System.out.println("Enter the Patient mob number");
		String num = utility.readString();
		for(int i=0;i<listOfPatient.size();i++) {
			if(listOfPatient.get(i).getPmbno().equals(num)) {
				p = listOfPatient.get(i);
			}
		}
		return p;
	}
	/**
	 * find patient by age
	 * @param listOfPatient
	 */
	public void  findByage(List<Patient> listOfPatient) throws IOException, InputMismatchException 
	{
		System.out.println("Enter the Patient age");
		int age = utility.readint();
		for(int i=0;i<listOfPatient.size();i++) {
			if(listOfPatient.get(i).getAge()==age) {
				patientlist.add(listOfPatient.get(i));
			}
		}
		for(int i=0;i<patientlist.size();i++) {
			Patient temp = patientlist.get(i);
			System.out.println(temp.getAge()+"  id "+temp.getPatientid()+"  name  "+temp.getPatientname()+"  mobilenumber "+temp.getPmbno());
		}
		
	}
	/**
	 * find patient by id
	 * @param listOfPatient
	 * @return
	 */
	public Patient findByPId(List<Patient> listOfPatient) throws IOException, InputMismatchException
	{
		Patient id=null;
		System.out.println("enter the Patient id");
		int pid = utility.readint();
		for(int i=0;i<listOfPatient.size();i++) {
			if(listOfPatient.get(i).getPatientid()==pid) {
				id = listOfPatient.get(i);
			}
		}
		return id;
	}
	/**
	 * find doctor by name
	 * @param listOfDoctor
	 */
	public void findBydname(List<Doctor> listOfDoctor) throws IOException, InputMismatchException
	{
		System.out.println("Enter the Doctor name");
		String name = utility.readString();
		for(int i=0;i<listOfDoctor.size();i++) {
			if(listOfDoctor.get(i).getDname().equals(name)) {
				doctorlist.add(listOfDoctor.get(i));
			}
		}
		for(int i=0;i<doctorlist.size();i++) {
			Doctor temp = doctorlist.get(i);
			System.out.println("  id "+temp.getDid()+"  name  "+temp.getDname()+"  specialization "+temp.getSpecialization()+" availability "+temp.getAvailability());
		}
	}

	
	
}