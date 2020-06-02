package com;

public class DogImp implements DogInf {
	private String name;
	private Integer age;

	public void jiao() {
		System.out.println("汪汪汪！" + name + "," + age);
	}

	public DogImp() {
		super();
	}

	public DogImp(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
