package com.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Thousetype entity. @author MyEclipse Persistence Tools
 */

public class Thousetype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set thouses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Thousetype() {
	}

	/** minimal constructor */
	public Thousetype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Thousetype(Integer id, String name, Set thouses) {
		this.id = id;
		this.name = name;
		this.thouses = thouses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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