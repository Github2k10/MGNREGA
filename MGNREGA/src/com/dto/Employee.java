package com.dto;

import java.time.LocalDate;

public interface Employee {
	public int getEid();
	
	public void setEid(int eid);
	
	public String getName();
	
	public void setName(String name);
	
	public String getEmail();
	
	public void setEmail(String email);
	
	public int getWorking_day();
	
	public void setWorking_day(int working_day);
	
	public int getPid();
	
	public void setPid(int pid);
	
	public LocalDate getDob() ;
	
	public void setDob(LocalDate dob) ;
	
	public int getGid();
	
	public void setGid(int gid);
}
