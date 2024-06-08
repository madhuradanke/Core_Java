package com.app.tester;

import static com.app.utils.ItemUtils.addItem;
import static com.app.utils.ItemUtils.populateItem;
import static com.app.utils.IOUtils.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.ComparatorImpl;
import com.app.core.Item;


public class ItemApp {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
		Map<String,Item> itemMap=populateItem();
		boolean exit=false;
		while(!exit)
		{
			System.out.println("Enter choice:");
			System.out.println("1.Add item \n"+"2.Display all Items\n"
			+"3.Sort as per itemCode \n"
					+"4.Sort as per price \n"+"0.Exit");
			try {
				switch(sc.nextInt())
				{
				case 1:
					//add item
					System.out.println("enter itemCode,description,price,shipmentDate:");
					System.out.println(addItem(sc.next(),sc.next(),sc.nextDouble(),sc.next(),itemMap));
					break;
				case 2:
					//display
					itemMap.forEach((k,v)->System.out.println(v));
					break;
				case 3:
					//sort items as per itemCode
					//itemMap.values().stream().sorted().forEach(v->System.out.println(v));
					TreeMap<String,Item> treeMap=new TreeMap<>(itemMap);
					System.out.println("enter filename: ");
					writeDetails(treeMap,sc.next());
					//treeMap.forEach((k,v)->System.out.println(v));
					break;
				case 4:
					//sort as per price

					System.out.println("enter filename to store items sorted as per price:");
					//for sorting using value, convert map-->list and use collection.sort()
					LinkedList<Item> itemList=new LinkedList<>(itemMap.values());
					Collections.sort(itemList,new ComparatorImpl());
					System.out.println(writeDetailsPrice(itemList,sc.next()));
					
//					Comparator<Item> itemComp=((i1,i2)->{
//					if(i1.getPrice()<i2.getPrice())
//						return -1;
//					if(i1.getPrice()==i2.getPrice())
//						return 0;
//					else
//						return 1;
//				});
					
//					itemMap.values() //map-->collection
//					.stream() //stream[item]
//					.sorted(itemComp)
//							.forEach(v->System.out.println(v));
					
					break;
					
				case 0:
					exit=true;
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
