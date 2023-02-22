package com.dto;

public class ProjectImp {
	private int pid;
	private String pname;
	private double pcost;
	private int pduration;
	private int eid;
	private int gid;
	
	public ProjectImp(int pid, String pname, double pcost, int pduration, int eid, int gid) {
		this.pid = pid;
		this.pname = pname;
		this.pcost = pcost;
		this.pduration = pduration;
		this.eid = eid;
		this.gid = gid;
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

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	@Override
	public String toString() {
		return "ProjectImp Id = " + pid + ", Name = " + pname + ", Cost = " + pcost + ", Duration = " + pduration;
	}
	
	
}
