package maman11;

import java.util.Scanner;
/**
 * 
 * This program will receive the date as 3 integeres as parameters and validate it.
 * in case the date is invalid, the progrem will write an error about it.
 * after that the program will receove another number and add it to the date above.
 * the number of date must be an integer between 1-10 and if the number is negative or highter then 10 
 * the program will show an error regardin it.
 *
 * @author (Mark Pergamenshik) 
 * @version (1.0)
 * 
 */
public class Dates {
	
	public static void main(String[] args){
	    //declaring and initializing varibles that will store original date
		int days = 0;
		int month = 0;
		int years = 0;
		//declaring and initializing varibles that will store resulting date
		int resDays = 0;
		int resMonth= 0;
		int resYears = 0;
		
		//Reading the date and assigning it to the varibles
		Scanner scan = new Scanner (System.in);
		System.out.println ("Please enter 3 integers to represent a valid date: ");
		days = scan.nextInt();
		month = scan.nextInt();
		years = scan.nextInt();
		
		//calculating the number of days in month
		int numberOfDaysInMonth = 0;
		switch(month){
		    //months with 31 days
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: numberOfDaysInMonth = 31;
					break;
			//months with 30 days
			case 4:
			case 6:
			case 9:
			case 11: numberOfDaysInMonth = 30;
					break;
			//the tricky part, calculating the number of days for february
			case 2: if(years % 4 == 0){
						if(years % 100 != 0){
							numberOfDaysInMonth = 29;
						} else {
							if(years % 400 == 0){
								numberOfDaysInMonth = 29;
							} else {
								numberOfDaysInMonth = 28;
							}
						}
					} else {
						numberOfDaysInMonth = 28;
					}
					break;
		}
		

		//Accourding to the description, before we promt for the number of days to add, we are printing the original date
		if((days > numberOfDaysInMonth) || (month > 12)){
		    //if the date is invalid, there is no point to continue therefore printing the error message
			System.out.println("The original date " + days + "/" + month + "/" + years + " is invalid.");
		} else {
		    //Promting for the days to add
			System.out.println ("Please enter an integer which represents the number of days: ");
			int daysToAdd = scan.nextInt();
			
			//Validating the date, making sure that the number is positive
			if(daysToAdd < 0){
				System.out.println("The number of days must be positive.");
			} else if (daysToAdd > 10){
			    //Validating the date, making sure that the number between 1 and 10
				System.out.println("The number of days must be between 1 to 10.");
			} else {
				System.out.println("The original date is " + days +"/" + month + "/" + years);
				//there are two posible options, eather we will have to jump to the next year / month
				if((days + daysToAdd) > numberOfDaysInMonth){
					//if this is the 12 month and we also need to jump to the next month, it means we also need to jump to the next year
					if(month == 12){
						resDays = (days + daysToAdd) % numberOfDaysInMonth;
						resMonth = 1;
						resYears = years + 1;
					} else {
					    ///we only need to jump to the next month
						resDays = (days + daysToAdd) % numberOfDaysInMonth;
						resMonth = month + 1;
						resYears = years;
					}
				//we don't have to jump to the next month, we can just add the number of days to the current date
				} else {
					resDays = days + daysToAdd;
					resMonth = month;
					resYears = years;
				}
				
				System.out.println("After " + daysToAdd + " days the date is " + resDays +"/" + resMonth + "/" + resYears);
			}	
			
		}
		
	}
		
}


