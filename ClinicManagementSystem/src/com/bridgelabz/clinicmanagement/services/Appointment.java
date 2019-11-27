package com.bridgelabz.clinicmanagement.services;

import java.util.Date;
import java.util.List;

import com.bridgelabz.clinicmanagement.model.Doctor;
/**
 * Appointment class
 * @author Shweta Mahajan
 *
 */
public class Appointment
{ 
	Integer doctorid;
	Date date;
	
	public Appointment() {
		// TODO Auto-generated constructor stub
	}
	//getter and setter methods
	public Date getDate() 
	{
		return date;
	}
	public Integer getDoctorid() {
		return doctorid;
	}


	public void setDoctorid(Integer doctorid) {
		this.doctorid = doctorid;
	}


	public void setDate(Date date) 
	{
		this.date = date;
	}

	public String toString() 
	{
		return "Appointment [doctorid=" + doctorid + ", date=" + date +  "]";
	}

	public int hashCode()
	{
    	return this.doctorid.hashCode()+this.date.hashCode();
	}
	//checking for equality
	public boolean equals(Object object)
	{
    	if (object == null) 
			return false;
    	if (object == this) 
			return true;
    	if (!(object instanceof Appointment))
			return false;
    	
    	Appointment dA = (Appointment) object;

		if((this.doctorid==dA.doctorid) && (this.date.equals(dA.date)))
			return true;
		else
			return false;
	}
	
	
}