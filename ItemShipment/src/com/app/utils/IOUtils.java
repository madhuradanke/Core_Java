package com.app.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Map;

import com.app.core.Item;

public class IOUtils {
	public static String writeDetails(Map<String,Item> map,String filename) throws FileNotFoundException, IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
		{
			out.writeObject(map);
			return "contents copied to "+filename;
		}
	}
	
	public static String writeDetailsPrice(LinkedList<Item> item,String filename) throws IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
		{
			out.writeObject(item);
			return "contents copied to "+filename;
		}
	}

}
