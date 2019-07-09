package com.bawei.bean;

public class Course {
   private Integer cid;
   private String cname;
   private String cdesc;
   private Integer sheng;
   private Integer shi;
   private Integer xian;
   private String startDate;
   private String endDate;
   private String label;
   private String images;
   private Area asheng;
   private Area ashi;
   private Area axian;
   private String uname;
   private Integer utype;
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCdesc() {
	return cdesc;
}
public void setCdesc(String cdesc) {
	this.cdesc = cdesc;
}
public Integer getSheng() {
	return sheng;
}
public void setSheng(Integer sheng) {
	this.sheng = sheng;
}
public Integer getShi() {
	return shi;
}
public void setShi(Integer shi) {
	this.shi = shi;
}
public Integer getXian() {
	return xian;
}
public void setXian(Integer xian) {
	this.xian = xian;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}
public String getImages() {
	return images;
}
public void setImages(String images) {
	this.images = images;
}
public Area getAsheng() {
	return asheng;
}
public void setAsheng(Area asheng) {
	this.asheng = asheng;
}
public Area getAshi() {
	return ashi;
}
public void setAshi(Area ashi) {
	this.ashi = ashi;
}
public Area getAxian() {
	return axian;
}
public void setAxian(Area axian) {
	this.axian = axian;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public Integer getUtype() {
	return utype;
}
public void setUtype(Integer utype) {
	this.utype = utype;
}
public Course(Integer cid, String cname, String cdesc, Integer sheng,
		Integer shi, Integer xian, String startDate, String endDate,
		String label, String images, Area asheng, Area ashi, Area axian,
		String uname, Integer utype) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.cdesc = cdesc;
	this.sheng = sheng;
	this.shi = shi;
	this.xian = xian;
	this.startDate = startDate;
	this.endDate = endDate;
	this.label = label;
	this.images = images;
	this.asheng = asheng;
	this.ashi = ashi;
	this.axian = axian;
	this.uname = uname;
	this.utype = utype;
}
public Course() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Course [cid=" + cid + ", cname=" + cname + ", cdesc=" + cdesc
			+ ", sheng=" + sheng + ", shi=" + shi + ", xian=" + xian
			+ ", startDate=" + startDate + ", endDate=" + endDate + ", label="
			+ label + ", images=" + images + ", asheng=" + asheng + ", ashi="
			+ ashi + ", axian=" + axian + ", uname=" + uname + ", utype="
			+ utype + "]";
}

   
}
