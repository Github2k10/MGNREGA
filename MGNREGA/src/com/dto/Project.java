package com.dto;

public interface Project {
	public int getPid();
	
	public void setPid(int pid);
	

	public String getPname();
	

	public void setPname(String pname);

	public double getPcost();
	

	public void setPcost(double pcost);
	

	public int getPduration();
	

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
}
