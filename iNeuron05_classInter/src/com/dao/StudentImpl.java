package com.dao;

public class StudentImpl implements IStudent {

	@Override
	public String name() {
		System.out.println("The name of the person is "+ "Sachin");
		return null;
	}

	@Override
	public void walk() {
		System.out.println("Sachin is walking");

	}

	@Override
	public void run() {
		System.out.println("Suchin is running");

	}

	@Override
	public void eat() {
		System.out.println("Sachin is eating");

	}

	@Override
	public void study() {
		System.out.println("Sachin doing study");

	}

}
