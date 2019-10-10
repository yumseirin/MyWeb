package com.vo;

import java.util.Date;

public class House {

	private String qname; // 区名
	private String tname; // 房屋类型名
	private String hdesc; // 房屋描述
	private String uname; // 用户名
	private float price; // 房屋价格
	private String rdesc; // 用户对房屋描述
	private Date rdate; // 租房日期
	private String pwd; // 密码
	private String jname; // 街道名

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getHdesc() {
		return hdesc;
	}

	public void setHdesc(String hdesc) {
		this.hdesc = hdesc;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getRdesc() {
		return rdesc;
	}

	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

}
