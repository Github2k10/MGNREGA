package com.dto;

public class GPMImp {
	private int eid;
	private String name;
	private String email;
	private String password;
	private String district;
	private String state;
	
	public GPMImp(int eid, String name, String email, String password, String district, String state) {
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.district = district;
		this.state = state;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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

	@Override
	public String toString() {
		return "Gram Panchayat Member Id = " + eid + ", Name = " + name + ", Email = " + email + ", District = " + district + ", State = "
				+ state;;
	}
	
	
}
