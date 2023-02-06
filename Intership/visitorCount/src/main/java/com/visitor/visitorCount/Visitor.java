package com.visitor.visitorCount;

public class Visitor {

	private String name;
	private static int count;
	
	public Visitor() {
		
	}
	
	
	public Visitor(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


	
	
}
