package com.app.utils;

import java.util.Comparator;

import com.app.core.Task;

public class CustomerOrdering implements Comparator<Task> {

	@Override
	public int compare(Task t1, Task t2) {
		return t1.getTaskDate().compareTo(t2.getTaskDate());
	}

}
