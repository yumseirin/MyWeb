package com.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Qu entity. @author MyEclipse Persistence Tools
 */

public class Qu implements java.io.Serializable {

	// Fields

	private String dno;
	private String name;
	private Set jiedaos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Qu() {
	}

	/** minimal constructor */
	public Qu(String dno) {
		this.dno = dno;
	}

	/** full constructor */
	public Qu(String dno, String name, Set jiedaos) {
		this.dno = dno;
		this.name = name;
		this.jiedaos = jiedaos;
	}

	// Property accessors

	public String getDno() {
		return this.dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getJiedaos() {
		return this.jiedaos;
	}

	public void setJiedaos(Set jiedaos) {
		this.jiedaos = jiedaos;
	}

}