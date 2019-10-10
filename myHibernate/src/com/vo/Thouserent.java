package com.vo;

import java.sql.Timestamp;

/**
 * Thouserent entity. @author MyEclipse Persistence Tools
 */

public class Thouserent implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tuser tuser;
	private Thouse thouse;
	private Double price;
	private String rdesc;
	private Timestamp rdate;

	// Constructors

	/** default constructor */
	public Thouserent() {
	}

	/** minimal constructor */
	public Thouserent(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Thouserent(Integer id, Tuser tuser, Thouse thouse, Double price,
			String rdesc, Timestamp rdate) {
		this.id = id;
		this.tuser = tuser;
		this.thouse = thouse;
		this.price = price;
		this.rdesc = rdesc;
		this.rdate = rdate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

	public Thouse getThouse() {
		return this.thouse;
	}

	public void setThouse(Thouse thouse) {
		this.thouse = thouse;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRdesc() {
		return this.rdesc;
	}

	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}

	public Timestamp getRdate() {
		return this.rdate;
	}

	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}

}