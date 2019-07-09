package com.bawei.bean;

public class User {
   private Integer uid;
   private String uname;
   private String upwd;
   private Integer utype;
public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUpwd() {
	return upwd;
}
public void setUpwd(String upwd) {
	this.upwd = upwd;
}
public Integer getUtype() {
	return utype;
}
public void setUtype(Integer utype) {
	this.utype = utype;
}
public User(Integer uid, String uname, String upwd, Integer utype) {
	super();
	this.uid = uid;
	this.uname = uname;
	this.upwd = upwd;
	this.utype = utype;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd
			+ ", utype=" + utype + "]";
}
   
}
