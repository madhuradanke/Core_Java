package com.app.tester;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.core.Employee;
import static com.app.utils.EmpUtils.*;
public class EMS {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			List<Employee> empList=populateApp();
			boolean exit=false;
			while(true)
			{
				System.out.println("Enter choice: ");
				System.out.println("1.Add fulltime Employee \n"+"2.Add parttime Employee \n"
				+"3.Delete emp by id \n"+"4.Search by aadhaar no \n"
				+"5.Display all emp details \n"
				+"6.Display according to date of joining \n"+"0.Exit");
				try {
					switch(sc.nextInt())
					{
					case 1:
						//add fulltime emp
						System.out.println("enter type of emp,name,dateOfJoining,phoneNo,aadhaarNo,salary: ");
						System.out.println(addFulltimeEmployee(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),empList));
						break;
					case 2:
						//add parttime emp
						System.out.println("enter type of emp,name,dateOfJoining,phoneNo,aadhaarNo,salary: ");
						System.out.println(addParttimeEmployee(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),empList));

						break;
					case 3:
						//delete emp by id
						System.out.println("enter empid: ");
						System.out.println(deleteEmployee(sc.nextInt(),empList));
						break;
					case 4:
						//search emp details by aadhar card
						System.out.println("enter aadharNo: ");
						System.out.println(searchByAadhaar(sc.next(),empList));
						break;
					case 5:
						empList.forEach(e->System.out.println(e));
						break;
					case 6:
						//Display all employee details sorted by date of joining
						Collections.sort(empList, new Comparator<Employee>() {

							@Override
							public int compare(Employee e1, Employee e2) {
								return (e1.getDateOfJoining().compareTo(e2.getDateOfJoining()));
							}
							
						});
						empList.forEach(v->System.out.println(v));
						break;
					case 0:
						exit=true;
						break;
					}
					
				}catch(Exception e)
				{
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}

}
