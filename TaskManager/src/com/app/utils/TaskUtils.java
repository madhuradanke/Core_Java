package com.app.utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.app.core.Status;
import com.app.core.Task;

public class TaskUtils {
	
	//String taskName, String description, LocalDate taskDate, Status status, boolean active
	
	public static Map<Integer,Task> populateTask()
	{
		Map<Integer,Task> tasks=new HashMap();
		Task t1=new Task("task1","write",LocalDate.of(2002, 9, 02),Status.PENDING,true);
		Task t2=new Task("task2","read",LocalDate.of(2022, 9, 04),Status.PENDING,true);
		Task t3=new Task("task3","execute",LocalDate.of(2012, 9, 22),Status.PENDING,true);
		Task t4=new Task("task4","readOnly",LocalDate.of(2023, 10, 02),Status.PENDING,true);
		Task t5=new Task("task5","writeOnly",LocalDate.of(2022, 11, 12),Status.PENDING,true);
		Task t6=new Task("task6","writeRead",LocalDate.of(2023, 5, 15),Status.PENDING,true);
		Task[] arr= {t1,t2,t3,t4,t5,t6};
		for(Task t:arr)
		{
			tasks.put(t.getTaskId(), t);
		}
		return tasks;
	}
	
	public static Map<Integer,Task> addTask(Task task)
	{
		Map<Integer,Task> tasks=new HashMap();
		tasks.put(task.getTaskId(), task);
		return tasks;
	}

	public static String deleteTask(int taskId,Map<Integer,Task> tasks)
	{
		String msg="not deleted";
		if(tasks.containsKey(taskId))
		{
			tasks.remove(taskId);
			msg="deleted";
		}
		return msg;
	}
	
	public static String updateTask(int taskId,Status status,Map<Integer,Task> tasks)
	{
		String msg="status not updated";
		if(tasks.containsKey(taskId))
		{
			Task task = tasks.get(taskId);
			task.setStatus(status);
			msg="status updated";
		}
		return msg;
	}
	
	public static Map<Integer,Task> displayPendingTasks(Map<Integer,Task> tasks)
	{
		Map<Integer,Task> taskMap=new HashMap<>();
		for(Task t:tasks.values())
		{
			if(t.getStatus()==Status.PENDING)
			{
				System.out.println(t);
				//taskMap.put(t.getTaskId(),t);
			}
		}
		System.out.println("return");
		return taskMap;
	}

}
