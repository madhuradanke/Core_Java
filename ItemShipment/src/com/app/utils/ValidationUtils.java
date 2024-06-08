package com.app.utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.core.Item;
import com.app.customException.ItemException;

public class ValidationUtils {

	public static Item validateItem(String itemCode,String desc,double price,String date,Map<String,Item> map) throws ItemException
	{
		LocalDate shipmentDate=LocalDate.parse(date);
		String code = checkDup(itemCode,map);
		Item item=new Item(code,desc,price,shipmentDate);
		return item;
	}
	
	public static String checkDup(String itemCode,Map<String,Item> map) throws ItemException
	{
		for(Item i:map.values())
		{
			if(i.getItemCode().equals(itemCode))
			{
				throw new ItemException("Duplicate itemCode");
			}
		}
		return itemCode;
	}
}
