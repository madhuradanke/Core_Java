package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;

import com.app.Material;
import com.app.Pen;
import com.app.customException.PensException;

public class PenUtils {
	// String brand, String color, String inkColor, Material material, int stock,
	// double price,
	// double discounts
	public static ArrayList<Pen> populateStore() {
		ArrayList<Pen> list = new ArrayList<>();
		Pen p1 = new Pen("cello", "black", "blue", Material.PLASTIC, 20, 10.0, 5.0,LocalDate.parse("2023-09-01"));
		Pen p2 = new Pen("reynolds", "red", "blue", Material.PLASTIC, 30, 15.0, 2.0,LocalDate.parse("2022-08-07"));
		Pen p3 = new Pen("linc", "blue", "black", Material.ALLOYSTEEL, 30, 15.0, 3.0,LocalDate.parse("2023-07-09"));
		Pen p4 = new Pen("max", "green", "black", Material.ALLOYSTEEL, 50, 12.0, 5.0,LocalDate.parse("2022-03-11"));
		Pen p5 = new Pen("gripper", "red", "red", Material.METAL, 10, 5.0, 10.0,LocalDate.parse("2022-04-21"));
		Pen p6 = new Pen("racer", "black", "red", Material.METAL, 40, 10.0, 2.0,LocalDate.parse("2024-03-01"));
		Pen[] arr = { p1, p2, p3, p4, p5, p6 };
		for (Pen p : arr) {
			list.add(p);
		}
		return list;
	}

	public static ArrayList<Pen> addPen(Pen pen) {
		ArrayList<Pen> list = new ArrayList<>();
		list.add(pen);
		return list;
	}

	public static String updateStock(ArrayList<Pen> pens, int id, int stock)throws PensException {
		String msg = "not updated";
		for (Pen p : pens) {
			if (p.getPenId() == id) {
				p.setStock(stock);
				msg = "updated stock";
				return msg;
			}
				else {
					throw new PensException("id not found");
				}
		}
		return msg;
	}

	public static String updateDiscount(ArrayList<Pen> pens) {
		String msg = "not updated discount";
		for (Pen p : pens) {
			if ((Period.between(p.getListingDate(), LocalDate.now()).getMonths()) > 3) {
				p.setDiscounts(20);
				msg="updated";
			}
		}
		return msg;
	}
	
	public static String removePens(ArrayList<Pen> pens)
	{
		String msg="pens not removed";
		Iterator<Pen> itr=pens.iterator();
//		for(Pen p:pens)
//		{
//			if((Period.between(p.getListingDate(), LocalDate.now()).getMonths())>9)
//			{
//				pens.remove(p);
//				msg="pens removed";
//			}
//		}
		
		while(itr.hasNext())
		{
			Pen pen = itr.next();
			System.out.println((Period.between(pen.getListingDate(), LocalDate.now()).getMonths()));
			if((Period.between(pen.getListingDate(), LocalDate.now()).getMonths())>9)
			{
				itr.remove();
				msg="pens removed";
			}
		}
		return msg;
	}

}
