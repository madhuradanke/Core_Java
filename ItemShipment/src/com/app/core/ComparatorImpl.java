package com.app.core;

import java.util.Comparator;

public class ComparatorImpl implements Comparator<Item> {

	@Override
	public int compare(Item i1, Item i2) {
		if(i1.getPrice()<i2.getPrice())
			return -1;
		if(i1.getPrice()==i2.getPrice())
			return 0;
		else
			return 1;
	}

}
