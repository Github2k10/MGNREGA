package com.dto;

public class ProjectImp {
	private int pid;
	private String pname;
	private double pcost;
	private int pduration;
	private int gpmid;
	
	public ProjectImp() {}
	
	public ProjectImp(int pid, String pname, double pcost, int pduration, int gpmid) {
		this.pid = pid;
		this.pname = pname;
		this.pcost = pcost;
		this.pduration = pduration;
		this.gpmid = gpmid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPcost() {
		return pcost;
	}

	public void setPcost(double pcost) {
		this.pcost = pcost;
	}

	public int getPduration() {
		return pduration;
	}

	public void setPduration(int pduration) {
		this.pduration = pduration;
	}

	public int getGPMid() {
		return gpmid;
	}

	public void setGPMid(int gpmid) {
		this.gpmid = gpmid;
	}

	@Override
	public String toString() {
		return "ProjectImp Id = " + pid + ", Name = " + pname + ", Cost = " + pcost + ", Duration = " + pduration;
	}
}
