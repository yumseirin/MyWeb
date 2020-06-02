package com;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Boy {
	private String name;
	private int age;
	private DogImp dog;
	private List likes;
	private Set<String> likesset;
	private Map<String, String> scoremap;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DogImp getDog() {
		return dog;
	}

	public void setDog(DogImp dog) {
		this.dog = dog;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List getLikes() {
		return likes;
	}

	public void setLikes(List likes) {
		this.likes = likes;
	}

	public Set<String> getLikesset() {
		return likesset;
	}

	public void setLikesset(Set<String> likesset) {
		this.likesset = likesset;
	}

	public Map<String, String> getScoremap() {
		return scoremap;
	}

	public void setScoremap(Map<String, String> scoremap) {
		this.scoremap = scoremap;
	}

	public Boy(String name, DogImp dog) {
		super();
		this.name = name;
		this.dog = dog;
	}
	
	

}
