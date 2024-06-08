package com.app.Tester;

import static com.app.utils.PenUtils.*;
import static com.app.utils.PenUtils.populateStore;
import static com.app.utils.PenUtils.updateDiscount;
import static com.app.utils.PenUtils.updateStock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.app.Material;
import com.app.Pen;

public class Client {

	public static void main(String[] args) {
	try(Scanner sc=new Scanner(System.in))
	{
	ArrayList<Pen> pens=populateStore();
	boolean exit = false;
		while(!exit)
		{
			System.out.println("Choose an option:");
			System.out.println("Menu: \n"+"1.Add pen \n"+"2.Display \n"+"3.Update pen stock \n"
			+"4.update discount \n"+"5.Remove if listingDate>9 \n"+"0.Exit");
			try {
				switch(sc.nextInt())
				{
				case 1:
					//String brand, String color, String inkColor, Material material, int stock, double price,
					//double discounts
					System.out.println("enter brand,color,inkcolor,material,stock,price,discount:");
					Pen pen=new Pen(sc.next(),sc.next(),
							sc.next(),Material.valueOf(sc.next().toUpperCase()),
							sc.nextInt(),sc.nextDouble(),sc.nextDouble(),LocalDate.parse(sc.next()));
					pens=addPen(pen);
					break;
				case 2:
					pens.stream().forEach(p->System.out.println(p));
//					for(Pen p:pens)
//					{
//						System.out.println("in for");
//						System.out.println(p);
//					}
					break;
				case 3:
					System.out.println("enter brand and stocks: ");
					System.out.println(updateStock(pens,sc.nextInt(),sc.nextInt()));
					break;
				case 4:
					System.out.println(updateDiscount(pens));
					break;
				case 5:
					System.out.println(removePens(pens));
					break;
				case 0:
					exit=true;
					break;
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
