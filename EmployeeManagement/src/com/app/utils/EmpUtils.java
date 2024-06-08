package com.app.utils;

import static com.app.utils.ValidationRules.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.core.Employee;
import com.app.core.Type;
import com.app.customExceptions.EmployeeException;
public class EmpUtils {

	// Type type, String name, LocalDate dateOfJoining,
	// String phoneNo, String aadhaarNo, double salary
	public static ArrayList<Employee> populateApp() {
		ArrayList<Employee> empList = new ArrayList<>();
		Employee e1 = new Employee(Type.FULLTIME, "emp1", LocalDate.parse("2023-09-08"), "1234567890", "111", 5000.0);
		Employee e2 = new Employee(Type.PARTTIME, "emp2", LocalDate.parse("2022-09-08"), "1234567891", "222", 1000.0);
		Employee e3 = new Employee(Type.FULLTIME, "emp3", LocalDate.parse("2023-11-18"), "1234567892", "333", 7000.0);
		Employee e4 = new Employee(Type.PARTTIME, "emp4", LocalDate.parse("2021-07-15"), "1234567893", "444", 500.0);
		Employee e5 = new Employee(Type.FULLTIME, "emp5", LocalDate.parse("2022-12-16"), "1234567894", "555", 15000.0);
		Employee[] emp = { e1, e2, e3, e4, e5 };
		for (Employee e : emp) {
			empList.add(e);
		}
		return empList;
	}
	
	public static String addFulltimeEmployee(String type,String name,String date,String phoneNo,String aadhaarNO,double price,List<Employee> list) throws EmployeeException
	{
		Employee employee = validateFulltimeInputs( type, name, date, phoneNo, aadhaarNO, price,list);
		list.add(employee);
		return "emp added";
	}
	
	public static String addParttimeEmployee(String type,String name,String date,String phoneNo,String aadhaarNO,double price,List<Employee> list) throws EmployeeException
	{
		Employee employee = validateParttimeInputs( type, name, date, phoneNo, aadhaarNO, price,list);
		list.add(employee);
		return "emp added";
	}
	
	public static String deleteEmployee(int empid,List<Employee> list)
	{
		Iterator<Employee> itr=list.listIterator();
		while(itr.hasNext())
		{
			Employee employee = itr.next();
			if(employee.getId()==empid)
			{
				itr.remove();
				return "Employee deleted";
			}
		}
		return "Employee not deleted";
	}
	
	public static Employee searchByAadhaar(String aadhaarNo,List<Employee> list) throws EmployeeException
	{
		Iterator<Employee> itr=list.listIterator();
		while(itr.hasNext())
		{
			Employee employee = itr.next();
			if(employee.getAadhaarNo().equals(aadhaarNo))
			{
				return employee; 
			}
		}
		throw new EmployeeException("addharNo doesnot exists");
	}

}
