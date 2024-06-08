package com.app.tester;

import static com.app.utils.CricketerUtils.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.core.Cricketer;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Cricketer> cricList = populateCricketer();
			boolean exit = false;
			while (!exit) {
				System.out.println("Choose an option:");
				System.out.println("Menu: \n" + "1.Add cricketer \n" + "2.Display \n" + "3.Modify ratings \n"
						+ "4.Search by Name \n"+"5.sort as per rating \n" + "0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						// add a cricketer
						System.out.println("enter name,age,email,phone,rating:");
						addCricketer(sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), cricList);
						break;
					case 2:
						cricList.stream().forEach(p -> System.out.println(p));
//						for(Cricketer c:cricList)
//						{
//							System.out.println("in for");
//							System.out.println(c);
//						}
						break;
					case 3:
						System.out.println("enter email and new rating: ");
						System.out.println(modifyRatings(sc.next(), sc.nextInt(), cricList));
						break;
					case 4:
						System.out.println("enter name: ");
						System.out.println(searchByName(sc.next(), cricList));
						break;
					case 5:
						// display cric in sorted form as per rating
						Collections.sort(cricList, new Comparator<Cricketer>() {

							@Override
							public int compare(Cricketer c1, Cricketer c2) {
								if (c1.getRating() < c2.getRating())
									return -1;
								if (c1.getRating() == c2.getRating())
									return 0;
								else
									return 1;
							}
						});
						for(Cricketer c:cricList)
						{
							System.out.println(c);
						}
						break;
					case 0:
						exit = true;
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}

}
