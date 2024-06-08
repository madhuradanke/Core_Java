package com.app.utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.app.utils.ValidationUtils.validateItem;
import com.app.core.Item;
import com.app.customException.ItemException;

public class ItemUtils {

	public static Map<String,Item> populateItem()
	{
		Map<String,Item> map=new HashMap<>();
		Item i1=new Item("i1","item1",100,LocalDate.of(2021, 07, 01));
		Item i2=new Item("i2","item2",150,LocalDate.of(2022, 8, 11));
		Item i3=new Item("i3","item3",200,LocalDate.of(2021, 11, 21));
		Item i4=new Item("i4","item4",250,LocalDate.of(2023, 9, 15));
		Item i5=new Item("i5","item5",50,LocalDate.of(2021, 12, 12));
		Item[] items= {i1,i2,i3,i4,i5};
		for(Item i:items)
		{
			map.put(i.getItemCode(), i);
		}
		return map;
	}
	
	public static String addItem(String itemCode,String desc,double price,String date,Map<String,Item> map) throws ItemException
	{
		Item item = validateItem(itemCode,desc,price,date,map);
		map.put(item.getItemCode(), item);
		return "item added";
	}
}
