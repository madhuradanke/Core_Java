package com.app.core;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	private int id;
	private static int cnt;
	static {
		cnt=1;
	}
	private Type type;
	private String name;
	private LocalDate dateOfJoining;
	private String phoneNo;
	private String AadhaarNo;
	private double salary;
	public Employee() {
		super();
	}
	public Employee(Type type, String name, LocalDate dateOfJoining, String phoneNo, String aadhaarNo, double salary) {
		super();
		this.id=cnt;
		cnt++;
		this.type = type;
		this.name = name;
		this.dateOfJoining = dateOfJoining;
		this.phoneNo = phoneNo;
		AadhaarNo = aadhaarNo;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAadhaarNo() {
		return AadhaarNo;
	}
	public void setAadhaarNo(String aadhaarNo) {
		AadhaarNo = aadhaarNo;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + id + ", type=" + type + ", name=" + name + ", dateOfJoining=" + dateOfJoining
				+ ", phoneNo=" + phoneNo + ", AadhaarNo=" + AadhaarNo + ", salary=" + salary + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}
	

}
