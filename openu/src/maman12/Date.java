package maman12;

/**
 * This class is used as a container and stores the date.
 * In addition this class contains utility methods
 * @author (Mark Pergamenshik) 
 * @version (1.0)
 *
 */
public class Date {
	
	//varibles section
	private int day;
	private int month;
	private int year;
	
	/**
	 * Main constractor.
	 * Contains logic for validating the fields
	 */
	public Date(int day, int month, int year){
		//Checking that the date is valid
		if((month < 1) || (month > 12) ||
			(year < 1000) || (year > 9999)	||
			(day < 1) || day > this.getDaysInMonth(month, year)){
			//If validation failed setting the default date
				this.day = 1;
				this.month = 1;
				this.year = 2000;
		} else {
			//Validation OK, setting the date from constractor
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
	
	/**
	 * Copy constractor, opens the other obkect and calls the constractor above to validate data
	 */
	public Date(Date other){
		this(other.getDay(), other.getMonth(), other.getYear());
	}
	
	/**
	 * day getter
	 */
	public int getDay() {
		return day;
	}
	/**
	 * day setter
	 * Also validating that the day is valid, if not doing nothing
	 */
	public void setDay(int day) {
		if(day < 1 || day > getDaysInMonth(this.month, this.year)){
			return;
		}
		this.day = day;
	}
	/**
	 * month getter
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * month setter
	 * Also validating that the month is valid, if not doing nothing
	 */
	public void setMonth(int month) {
		if(month < 1 || month > 12){
			return;
		}
		this.month = month;
	}
	/**
	 * year getter
	 */
	public int getYear() {
		return year;
	}
	/**
	 * year setter
	 * Also validating that the year is valid, if not doing nothing
	 */
	public void setYear(int year) {
		if(year < 1000 || year > 9999){
			return;
		}
		this.year = year;
	}
	
	/**
	 * return true if other date is before and false otherwise
	 */
	public boolean before(Date other){
		//checking the year, if the year is before then no need to check month or day
		if(this.getYear() < other.getYear()){
			return true;
		//if the year is the same, checking only month
		} else if((this.getYear() == other.getYear()) && (this.getMonth() < other.getMonth())){
			return true;
		//if the year and month are the same, only then checking day
		} else if((this.getYear() == other.getYear()) &&
					(this.getMonth() == other.getMonth()) &&
					(this.getDay() == other.getDay())){
			return true;
		} else {
			//If we are here meaning the date is not before
			return false;
		}
	}
	
	/**
	 * using other.before to check if this date is after
	 */
	
	public boolean after(Date other){
		if(other.before(this)){
			return true;
		}
		return false;
	}
	/**
	 * comparing all fields of the class, if they are the same meaning the date is equals
	 */
	public boolean equals(Date other){
		if((other.getDay() != this.getDay()) ||
			(other.getMonth() != this.getMonth()) ||
			(other.getYear() != this.getYear())){
			return false;
		}
		return true;
	}
	
	/**
	 * Calculating the difference in days.
	 */
	public int difference(Date other){
		int diff = other.calculateDate(other.getDay(), other.getMonth(), other.getYear()) - 
				this.calculateDate(this.getDay(), this.getMonth(), this.getYear());
		if(diff < 0)
			return diff * (-1);
		
		return diff;
	}
	
	/**
	 * printing the date as String
	 */
	
	public String toString(){
		return this.getDay() + "/" + this.getMonth() + "/" + this.getYear();
	}
	
	/**
	 * Calculating the day of week according to specified function in the maman
	 */
	public int dayInWeek(){
		int localYear = 0;
		int localMonth = 0;
		
		if(this.getMonth() < 3 ){
			localMonth = (12 + this.getMonth());
			localYear = this.getYear() - 1;
		} else {
			localMonth =  this.getMonth();
			localYear = this.getYear();
		}
		
		int D = this.getDay();
		int M = localMonth;
		int C = localYear / 100;
		int Y = localYear % 100;
		
		int dayInWeek = (D + (26*(M+1))/10 + Y + Y/4 + C/4 - 2*C) % 7;
		return dayInWeek;
	}
	
	/**
	 * This function is used in constructor to validate that the Date is OK
	 */
	private int getDaysInMonth(int month, int year){
		
		int numberOfDaysInMonth = 0;
		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: numberOfDaysInMonth = 31;
					break;
			case 4:
			case 6:
			case 9:
			case 11: numberOfDaysInMonth = 30;
					break;
			case 2: if(year % 4 == 0){
						if(year % 100 != 0){
							numberOfDaysInMonth = 29;
						} else {
							if(year % 400 == 0){
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
		
		return numberOfDaysInMonth;
		
	}
	/**
	 * private method, not a part of API, copied from maman
	 */
	private int calculateDate ( int day, int month, int year) {
		if (month < 3) {
			year--;
			month = month + 12;
		}
		return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
	}

}
