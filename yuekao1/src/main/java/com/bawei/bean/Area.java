package com.bawei.bean;

public class Area {
  private Integer aid;
  private String aname;
  private Integer sid;
public Integer getAid() {
	return aid;
}
public void setAid(Integer aid) {
	this.aid = aid;
}
public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
public Integer getSid() {
	return sid;
}
public void setSid(Integer sid) {
	this.sid = sid;
}
public Area() {
	super();
	// TODO Auto-generated constructor stub
}
public Area(Integer aid, String aname, Integer sid) {
	super();
	this.aid = aid;
	this.aname = aname;
	this.sid = sid;
}
@Override
public String toString() {
	return "Area [aid=" + aid + ", aname=" + aname + ", sid=" + sid + "]";
}
  
}
