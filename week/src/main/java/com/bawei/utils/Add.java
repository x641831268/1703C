package com.bawei.utils;

public class Add {
   private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Add(String name) {
	super();
	this.name = name;
}

public Add() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Add [name=" + name + "]";
}
   
}
