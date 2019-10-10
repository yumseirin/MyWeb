package com.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Jiedao entity. @author MyEclipse Persistence Tools
 */

public class Jiedao implements java.io.Serializable {

	// Fields

	private String sno;
	private Qu qu;
	private String name;
	private Set thouses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Jiedao() {
	}

	/** minimal constructor */
	public Jiedao(String sno) {
		this.sno = sno;
	}

	/** full constructor */
	public Jiedao(String sno, Qu qu, String name, Set thouses) {
		this.sno = sno;
		this.qu = qu;
		this.name = name;
		this.thouses = thouses;
	}

	// Property accessors

	public String getSno() {
		return this.sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public Qu getQu() {
		return this.qu;
	}

	public void setQu(Qu qu) {
		this.qu = qu;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getThouses() {
		return this.thouses;
	}

	public void setThouses(Set thouses) {
		this.thouses = thouses;
	}

}