package com.vo;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private String uname;
	private String pwd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bir;
	private Set like;

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

	public Date getBir() {
		return bir;
	}

	public void setBir(Date bir) {
		this.bir = bir;
	}

	public Set getLike() {
		return like;
	}

	public void setLike(Set like) {
		this.like = like;
	}

}
