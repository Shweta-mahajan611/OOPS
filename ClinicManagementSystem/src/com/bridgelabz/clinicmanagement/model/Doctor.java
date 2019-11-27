package com.bridgelabz.clinicmanagement.model;

public class Doctor {
	private String dname;
	private int did;
	private String specialization;
	private String availability;
	private int appointments;
	
	public int getAppointments() {
		return appointments;
	}

	public void setAppointments(int appointments) {
		this.appointments = appointments;
	}
	
	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
}