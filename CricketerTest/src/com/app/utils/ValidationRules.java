package com.app.utils;

import java.util.List;

import com.app.core.Cricketer;
import com.app.customException.CricketerException;

public class ValidationRules {
	public static Cricketer validateInputs(String name,int age,String email,String phone,int rating,List<Cricketer> list) throws CricketerException
	{
		int rating1 = checkRating(rating);
		String emailId = checkEmail(email,list);
		Cricketer c=new Cricketer(name,age,emailId,phone,rating1);
		return c;
	}
	
	public static int checkRating(int rating) throws CricketerException
	{
		if(rating <=10)
		{
			return rating;
		}
		else
		{
			throw new CricketerException("invalid rating");
		}
	}
	
	public static String checkEmail(String email,List<Cricketer> list) throws CricketerException
	{
		for(Cricketer c:list)
		{
			if(c.getEmail().equals(email))
			{
				throw new CricketerException("duplicate email");
			}
		}
		return email;
	}

}
