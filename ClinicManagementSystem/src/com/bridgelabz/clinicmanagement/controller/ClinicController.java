package com.bridgelabz.clinicmanagement.controller;

import java.io.IOException;
import java.util.List;

import com.bridgelabz.clinicmanagement.model.Connections;
import com.bridgelabz.clinicmanagement.model.Doctor;
import com.bridgelabz.clinicmanagement.model.Patient;
import com.bridgelabz.clinicmanagement.services.Operations;
import com.bridgelabz.clinicmanagement.services.Search;
import com.bridgelabz.clinicmanagement.services.Utility;
/**
 * clinic controller
 * main class of clinic management system
 * @author Shweta Mahajan
 *
 */
public class ClinicController
{
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException 
	{
		Operations operations= new Operations();
		Search search = new Search();
		
		Utility utility = new Utility();
		
		Connections con = new Connections();
		int choice=0;
	
		do 
		{
			System.out.println("1 : add Doctor");
			System.out.println("2 : add Patient");
			System.out.println("3: delete Doctor");
			System.out.println("4 : delete Patient");
			System.out.println("5 : Take Appointment");
			System.out.println("6 : search Patient");
			System.out.println("7 : Search Doctor");
			System.out.println("8 : Exit");
			choice = utility.readint();
			
			switch(choice)
			{
			case 1:
				List<Doctor> listOfdoc = con.readFileDoc();
				operations.addDoctor(listOfdoc);
				con.writedocfile(listOfdoc);
				
				break;
			case 2:
				List<Patient> patlist = con.readFilePat();
				operations.addPatient(patlist);
				con.writepatfile(patlist);
				break;
			case 3:
				List<Doctor> doctorlist = con.readFileDoc(); 
				operations.deleteDoctor(doctorlist);
				con.writedocfile(doctorlist);
				break;
			case 4:
				List<Patient> patientlist =con.readFilePat();
				operations.deletePatient(patientlist);
				con.writepatfile(patientlist);
				break;
	
			case 5:
				utility.appointmentfix();
				break;
			
			case 6:
				List<Patient> list = con.readFilePat();
				System.out.println("1 Search Patient by name");
				System.out.println("2 Search Patient By age");
				System.out.println("3 :Search Patient by id");
				System.out.println("4 : search Patient By number");
				System.out.println("5 : Exit");
				int ch = utility.readint();
				switch(ch) {
				case 1:
					search.findByPname(list);
					break;
				case 2:
					search.findByage(list);
					break;
				case 3:
					Patient p = search.findByPId(list);
					System.out.println("Age "+p.getAge()+" Name "+p.getPatientname()+" mobile no. "+p.getPmbno());
					break;
				case 4:
					Patient p1 = search.findByNumber(list);
					System.out.println("id "+p1.getPatientid()+"Age "+p1.getAge()+" Name "+p1.getPatientname()+" mobile no "+p1.getPmbno());
					break;
				case 5: System.exit(0);
					break;
				}
				break;
			case 7:
				List<Doctor> dlist = con.readFileDoc();
				System.out.println("1. Search Doctor by name");
				System.out.println("2. Search Doctor by id");
				System.out.println("3. Search Doctor by specialization");
				System.out.println("4. Seach Doctor by availability");
				System.out.println("5 : Exit");
				int ch1 = utility.readint();
				switch(ch1) {
				case 1:
					search.findBydname(dlist);
					break;
				case 2:
					search.findDocById(dlist,4565);
					break;
				case 3:
					search.findByspeci(dlist);
					break;
				case 4:
					search.findByAvailability(dlist);
					break;
				case 5: System.exit(0);
					break;
				}
				break;	
			case 8: System.exit(0);
					break;
			}
						
		}while(choice!=7);
		
		System.out.println("File has Updated");
	}

}