package com.app.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.Stock;

public class IOUtils {
	public static String writeDetails(Map<String,Stock> map,String filename) throws FileNotFoundException, IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
		{
			out.writeObject(map);
			return "Contents copied to file";
		}
	}

}
