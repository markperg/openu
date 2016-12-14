package maman11;

import java.util.Scanner;
/**
 * 
 * This class will get a number of milliseconds
 * and turn them into date according to specified format.
 *
 * @author (Mark Pergamenshik) 
 * @version (1.0)
 * 
 */
public class Milliseconds{
	
	//Constants for calculations
	private static final int MILISECONDS_IN_DAY = 86400000;
	private static final int MILISECONDS_IN_HOUR = 3600000;
	private static final int MILISECONDS_IN_MINUTE = 60000;
	
	public static void main (String [] args){
		Scanner scan = new Scanner (System.in);
		System.out.println ("This program reads an integer which " +
				"represents Milliseconds and converts it to days, " +
				"hours, minutes and seconds. ");
		
		System.out.println ("Please enter the number of Milliseconds");
		long ms = scan.nextLong();

		//result values that will be printed later
		int number_of_days = 0;
		int number_of_hours = 0;
		int number_of_minutes = 0;
		int number_of_seconds = 0;
		
		//Calculating values of days, what's is left will be calculated in hours
		number_of_days = (int) (ms / MILISECONDS_IN_DAY);
		ms = ms % MILISECONDS_IN_DAY;
		//Calculating values of hours, what's is left will be calculated in minutes
		number_of_hours = (int) (ms / MILISECONDS_IN_HOUR);
		ms = ms % MILISECONDS_IN_HOUR;
		//Calculating values of minutes, what's is left will be only the seconds
		number_of_minutes = (int) (ms / MILISECONDS_IN_MINUTE);
		
		// The seconds
		ms = ms % MILISECONDS_IN_MINUTE;
		number_of_seconds = (int) (ms / 1000);
		
		System.out.println(number_of_days + " days " + number_of_hours +":" + number_of_minutes + ":" + number_of_seconds + " hours");
	} // end of method main
} //end of class Milliseconds
