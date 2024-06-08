package com.app.utils;

import java.time.LocalDate;
import java.util.List;

import com.app.core.Employee;
import com.app.core.Type;
import com.app.customExceptions.EmployeeException;

public class ValidationRules {
	public static Employee validateFulltimeInputs(String type,String name,String date,String phoneNo,String aadhaarNo,double sal,List<Employee> list) throws EmployeeException
	{
		LocalDate joiningDate=LocalDate.parse(date);
		Type fulltimeType = validateFulltimeType(type);
		
			Employee e= new Employee(fulltimeType,name,joiningDate,phoneNo,aadhaarNo,sal);
		
		//String validatedPhoneNo = validatePhoneNo(phoneNo);
		//String validatedAadhaarNo = validateAadhaarNo(aadhaarNo,list);
		return e;
	}
	
	public static Employee validateParttimeInputs(String type,String name,String date,String phoneNo,String aadhaarNo,double sal,List<Employee> list) throws EmployeeException
	{
		LocalDate joiningDate=LocalDate.parse(date);
		Type parttimeType = validateParttimeType(type);
		Employee e= new Employee(parttimeType,name,joiningDate,phoneNo,aadhaarNo,sal);
		return e;
	}
	
	public static Type validateFulltimeType(String type) throws EmployeeException
	{
		Type emptype=Type.valueOf(type.toUpperCase());
		if(emptype.equals(Type.FULLTIME))
		{
			return emptype;
		}
		else
		{
			throw new EmployeeException("Not a fulltime employee");
		}
	}
	
	public static Type validateParttimeType(String type) throws EmployeeException
	{
		Type emptype=Type.valueOf(type.toUpperCase());
		if(emptype.equals(Type.PARTTIME))
		{
			return emptype;
		}
		else
		{
			throw new EmployeeException("Not a parttime employee");
		}
	}
	
	
	public static String validatePhoneNo(String phoneNo) throws EmployeeException
	{
		String regexp="^\\d{10}$\r\n"; 
		if(regexp.matches(phoneNo))
		{
			//throw new EmployeeException("not a valid phone number");
			return phoneNo;
		}
	else {
		
		throw new EmployeeException("not a valid phone number");
	}

	}
//	
// public static String validateAadhaarNo(String aadhaarNo,List<Employee> list) throws EmployeeException
// {
//	 String regexp="^\\S+$";
//	 if(regexp.matches(aadhaarNo) && !list.contains(aadhaarNo))
//	 {
//		 return aadhaarNo;
//	 }
//	 throw new EmployeeException("invalid aadhar number");
// }
	

}
