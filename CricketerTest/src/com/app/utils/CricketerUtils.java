package com.app.utils;

import static com.app.utils.ValidationRules.validateInputs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.core.Cricketer;
import com.app.customException.CricketerException;
public class CricketerUtils {
	public static List<Cricketer> populateCricketer()
	{
		List<Cricketer> list=new ArrayList<>();
		Cricketer c1=new Cricketer("c1", 18, "c1@gmail.com", "1234", 5);
		Cricketer c2=new Cricketer("c2", 20, "c2@gmail.com", "1236", 2);
		Cricketer c3=new Cricketer("c3", 21, "c3@gmail.com", "5662", 3);
		Cricketer c4=new Cricketer("c4", 18, "c4@gmail.com", "12345", 5);
		Cricketer c5=new Cricketer("c5", 22, "c5@gmail.com", "5632", 4);
		Cricketer[] crics= {c1,c2,c3,c4,c5};
		for(Cricketer c:crics)
		{
			list.add(c);
		}
		return list;

	}
	
	public static List<Cricketer> addCricketer(String name,int age,String email,String phone,int rating,List<Cricketer> list) throws CricketerException
	{
		Cricketer cricketer = validateInputs(name,age,email,phone,rating,list);
		list.add(cricketer);
		System.out.println("cricketer added!!!");
		return list;
	}
	
	public static String modifyRatings(String email,int newRating,List<Cricketer> list) throws CricketerException
	{
		Iterator<Cricketer> itr=list.listIterator();
		while(itr.hasNext())
		{
			Cricketer cricketer = itr.next();
			if(cricketer.getEmail().equals(email))
			{
				cricketer.setRating(newRating);
				
			}
		}
		return "ratings updated";
	}
	
	public static Cricketer searchByName(String name, List<Cricketer> list) throws CricketerException {
	    for (Cricketer c : list) {
	        if (c.getName().equals(name)) {
	            return c;
	        }
	    }
	    throw new CricketerException("invalid name");
	}

}
