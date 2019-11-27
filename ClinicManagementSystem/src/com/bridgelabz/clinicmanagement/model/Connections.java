package com.bridgelabz.clinicmanagement.model;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
/**
 * Class connection for json file  
 * @author bridgeit
 *
 */
public class Connections 
{
	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}
	static File doctorfile = new File("/home/bridgeit/bootcamp/ClinicManagementSystem/src/com/bridgelabz/clinicmanagement/repository/doctor.json");
	static File patientfile = new File("/home/bridgeit/bootcamp/ClinicManagementSystem/src/com/bridgelabz/clinicmanagement/repository/patient.json");
	static File appointmentfile = new File("/home/bridgeit/bootcamp/ClinicManagementSystem/src/com/bridgelabz/clinicmanagement/repository/appointment.json");
	/**
	 * read file doctor.json
	 * @return
	 * @throws IOException
	 */
	public static List<Doctor> readFileDoc() throws  IOException {
		
			List<Doctor> list = mapper.readValue(doctorfile,new TypeReference<List<Doctor>>(){});
		
		return list;
		
	}
	/**
	 * write file doctor.json
	 * @param list
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public void writedocfile(List<Doctor> list) throws IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(doctorfile,list);
	}
	/**
	 * read file patient.json
	 * @return
	 * @throws IOException
	 */
	public List<Patient> readFilePat() throws  IOException {
		
		List<Patient> listpat = mapper.readValue(patientfile,new TypeReference<List<Patient>>(){});
	
		return listpat;	
	}
	/**
	 * write file patient.json
	 * @param list
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public void writepatfile(List<Patient> list) throws IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(patientfile,list);
		
	}
	/**
	 * write file appointment.json
	 * @param listOfapp
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public void writeApp(Object listOfapp) throws  IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(appointmentfile,listOfapp);
		System.out.println("File has updated");
	}
	/**
	 * write file appointment.json
	 * @param listOfapp
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static void writeappfile(List<Doctor> alist) throws IOException 
	{
		mapper.defaultPrettyPrintingWriter().writeValue(appointmentfile,alist);
	}
	
}