package com.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Thouse entity. @author MyEclipse Persistence Tools
 */

public class Thouse implements java.io.Serializable {

	// Fields

	private Integer hid;
	private Thousetype thousetype;
	private Jiedao jiedao;
	private String hdesc;
	private Double hprice;
	private Set thouserents = new HashSet(0);

	// Constructors

	/** default constructor */
	public Thouse() {
	}

	/** minimal constructor */
	public Thouse(Integer hid) {
		this.hid = hid;
	}

	/** full constructor */
	public Thouse(Integer hid, Thousetype thousetype, Jiedao jiedao,
			String hdesc, Double hprice, Set thouserents) {
		this.hid = hid;
		this.thousetype = thousetype;
		this.jiedao = jiedao;
		this.hdesc = hdesc;
		this.hprice = hprice;
		this.thouserents = thouserents;
	}

	// Property accessors

	public Integer getHid() {
		return this.hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public Thousetype getThousetype() {
		return this.thousetype;
	}

	public void setThousetype(Thousetype thousetype) {
		this.thousetype = thousetype;
	}

	public Jiedao getJiedao() {
		return this.jiedao;
	}

	public void setJiedao(Jiedao jiedao) {
		this.jiedao = jiedao;
	}

	public String getHdesc() {
		return this.hdesc;
	}

	public void setHdesc(String hdesc) {
		this.hdesc = hdesc;
	}

	public Double getHprice() {
		return this.hprice;
	}

	public void setHprice(Double hprice) {
		this.hprice = hprice;
	}

	public Set getThouserents() {
		return this.thouserents;
	}

	public void setThouserents(Set thouserents) {
		this.thouserents = thouserents;
	}

}