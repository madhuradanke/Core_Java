package com.app.tester;

import static com.app.utils.TaskUtils.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.*;

import com.app.core.Task;

public class Tester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			Map<Integer,Task> taskMap=populateTask();
			boolean exit=false;
			while(!exit)
			{
				System.out.println("enter choice");
				System.out.println("1.Add task\n"+"2.Display \n"
				+"3.Delete Task \n"+"4.Update task \n"
						+"5.Display all pending tasks \n"
				+"6.Sort by date \n"+"0.Exit");
				try {
					switch(sc.nextInt())
					{
					case 1:
						//add a task
						//taskName, String description, LocalDate taskDate
						System.out.println("enter taskname,desc,date");
						Task task=new Task(sc.next(),sc.next(),LocalDate.parse(sc.next()));
						addTask(task);
						System.out.println("task added");
						break;
					case 2:
						//display
						taskMap.forEach((k,v)->System.out.println(v));
						break;
					case 3:
						//delete a task
						System.out.println("enter task id to delete");
						System.out.println(deleteTask(sc.nextInt(),taskMap));
						break;
					case 4:
						//Update task
						System.out.println("enter task id to update and status");
						System.out.println(updateTask(sc.nextInt(),Status.valueOf(sc.next().toUpperCase()),taskMap));
						break;
					case 5:
						System.out.println("Displaying pending tasks: \n");
						displayPendingTasks(taskMap);
						break;
					case 6:
						TreeMap<Integer,Task> treeMap=new TreeMap<>(taskMap);
						Comparator<Task> dateComp=((t1,t2)->t1.getTaskDate().compareTo(t2.getTaskDate()));
						treeMap.values().stream().sorted(dateComp).forEach((k)->System.out.println(k));
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
