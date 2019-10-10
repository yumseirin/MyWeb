package com.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Tuser entity. @author MyEclipse Persistence Tools
 */

public class Tuser implements java.io.Serializable {

	// Fields

	private String uname;
	private String pwd;
	private String email;
	private Set thouserents = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tuser() {
	}

	/** minimal constructor */
	public Tuser(String uname) {
		this.uname = uname;
	}

	/** full constructor */
	public Tuser(String uname, String pwd, String email, Set thouserents) {
		this.uname = uname;
		this.pwd = pwd;
		this.email = email;
		this.thouserents = thouserents;
	}

	// Property accessors

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getThouserents() {
		return this.thouserents;
	}

	public void setThouserents(Set thouserents) {
		this.thouserents = thouserents;
	}

}