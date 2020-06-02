package com.vo;

/**
 * Test entity. @author MyEclipse Persistence Tools
 */

public class Test implements java.io.Serializable {

	// Fields

	private Integer tno;
	private String tname;

	// Constructors

	/** default constructor */
	public Test() {
	}

	/** full constructor */
	public Test(String tname) {
		this.tname = tname;
	}

	// Property accessors

	public Integer getTno() {
		return this.tno;
	}

	public void setTno(Integer tno) {
		this.tno = tno;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

}