package vo;

import java.util.Date;

public class Person {
	private int pid;
	private String uname;
	private String pwd;
	private String sex;
	private String likes;
	private Date bir;
	private String picname;
	private String call;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public Date getBir() {
		return bir;
	}

	public void setBir(Date bir) {
		this.bir = bir;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}

}
