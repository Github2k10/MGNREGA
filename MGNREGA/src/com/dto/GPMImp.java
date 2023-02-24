package com.dto;

public class GPMImp implements GPM{
	private int gpmid;
	private String name;
	private String email;
	private String password;
	private String district;
	private String state;
	private String contact;

	public GPMImp() {}
	
	public GPMImp(String name, String email, String password, String district, String state, String contact) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.district = district;
		this.state = state;
	}

	public int getGPMid() {
		return gpmid;
	}

	public void setGPMid(int gpmid) {
		this.gpmid = gpmid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public int getGpmid() {
		return gpmid;
	}

	public void setGpmid(int gpmid) {
		this.gpmid = gpmid;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Gram Panchayat Member Id = " + gpmid + ", Name = " + name + ", Email = " + email + ", District = " + district + ", State = "
				+ state;
	}
	
}
