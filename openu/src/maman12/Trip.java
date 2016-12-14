package maman12;

/**
 * This class is a container that used to store Trip information
 * And utility methods
 * @author (Mark Pergamenshik) 
 * @version (1.0)
 */
public class Trip {

	//Variable declaration section
	private String guideName;
	private int noOfCountries;
	private Date departureDate;
	private Date returningDate;
	private int noOfTravellers;
	//Final Variable declaration section
	private final int PRICE_PER_DAY = 250;
	private final int PRICE_PER_COUNTRY = 100;
	/**
	 * Main constractor. used to get and validate data
	 */
	public Trip(String name,
			Date depDate, 
			Date retDate, 
			int noOfCountries, 
			int noOfTravellers){
		
		this.guideName = name;
		//Validating the returning and departure dates
		//Since the Date itself validated in the constractor if Date method
		//The only thing that we need to validate is that departure Date is not before returning date
		// And if so putting the default value
		if(!retDate.after(depDate)){
			this.departureDate = new Date(1,1,2000);
			this.returningDate = new Date(1,1,2000); 
		} else {
			this.departureDate = depDate;
			this.returningDate = retDate; 
		}
		//Validating number of countries
		if(noOfCountries > 10 || noOfCountries < 0){
			this.noOfCountries = 1;
		} else {
			this.noOfCountries  = noOfCountries;
		}
		//validating number of travelers
		if(noOfTravellers > 50 || noOfTravellers < 0){
			this.noOfTravellers = 10;
		} else {
			this.noOfTravellers  = noOfTravellers;
		}
	}
	/**
	 * Copy Contractor
	 * No validation here, getting other Trip object assigning it to this fields
	 */
	public Trip(Trip other){
		this.guideName = other.guideName;
		this.noOfCountries = other.noOfCountries;
		this.departureDate = other.departureDate;
		this.returningDate = other.returningDate;
		this.noOfTravellers = other.noOfTravellers;
		
	}
	/**
	 * Another Contractor
	 * Similar to the other contractor but we also creating the departure and Return dates as Objects
	 */
	public Trip(String name, 
			int depDay, 
			int depMonth, 
			int depYear, 
			int retDay, 
			int retMonth, 
			int retYear, 
			int noOfCountries, 
			int noOfTravellers){
		
		this.guideName = name;
		
		Date retDate = new Date(retDay, retMonth, retYear);
		Date depDate = new Date(depDay, depMonth, depYear);
		
		if(!retDate.after(depDate)){
			this.departureDate = new Date(1,1,2000);
			this.returningDate = new Date(1,1,2000); 
		} else {
			this.departureDate = depDate;
			this.returningDate = retDate; 
		}
		
		if(noOfCountries > 10 || noOfCountries < 0){
			this.noOfCountries = 1;
		} else {
			this.noOfCountries  = noOfCountries;
		}
		
		if(noOfTravellers > 50 || noOfTravellers < 0){
			this.noOfTravellers = 10;
		} else {
			this.noOfTravellers  = noOfTravellers;
		}
	}
	/**
	 * Getter method
	 */
	public String getGuideName() {
		return guideName;
	}
	/**
	 * Setter method, no validation needed
	 */
	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}
	/**
	 * Getter method
	 */
	public int getNoOfCountries() {
		return noOfCountries;
	}
	/**
	 * Setter method, Validating the noOfCountries parameter, if failed doing nothing
	 */
	public void setNoOfCountries(int noOfCountries) {
		if(noOfCountries > 10 || noOfCountries < 0)
			return;
		this.noOfCountries = noOfCountries;
	}
	/**
	 * Getter method
	 */
	public Date getDepartureDate() {
		return departureDate;
	}
	/**
	 * Setter method, no validation needed
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	/**
	 * Getter method
	 */
	public Date getReturningDate() {
		return returningDate;
	}
	/**
	 * Setter method, no validation needed
	 */
	public void setReturningDate(Date returningDate) {
		this.returningDate = returningDate;
	}
	/**
	 * Getter method
	 */
	public int getNoOfTravellers() {
		return noOfTravellers;
	}
	/**
	 * Setter method, Validating the noOfTravellers parameter, if failed doing nothing
	 */
	public void setNoOfTravellers(int noOfTravellers) {
		if(noOfTravellers > 50 || noOfTravellers < 0)
			return;
		this.noOfTravellers = noOfTravellers;
	}
	
	/**
	 * comparing all fields of the class, if they are the same meaning the date is equals
	 */
	public boolean equals(Trip other) {
		if(this.getDepartureDate().equals(other.getDepartureDate()) &&
				this.getReturningDate().equals(other.getReturningDate()) &&
				this.getGuideName().equals(other.getGuideName()) &&
				(this.getNoOfCountries() == other.getNoOfCountries()) &&
				(this.getNoOfTravellers() == other.getNoOfTravellers())){
			return true;
		}
		
		return false;
	}
	/**
	 * comparing DepartureDate object of this and the object that was passed as a parameter, if they are the same returning true and false otherwise
	 */
	public boolean sameDepartureDate(Trip otherTrip) {
		if(this.getDepartureDate().equals(otherTrip.getDepartureDate())){
			return true;
		}
		
		return false;
	}
	/**
	 * comparing ReturningDate object of this and the object that was passed as a parameter, if they are the same returning true and false otherwise
	 */
	public boolean sameReturningDate(Trip otherTrip) {
		if(this.getReturningDate().equals(otherTrip.getReturningDate())){
			return true;
		}
		return false;
	}
	/**
	 * Checking if 2 Trips have overlapping dates.
	 * 
	 */
	public boolean overlap(Trip other){
		if(this.getReturningDate().equals(other.getDepartureDate()) ||
				this.getDepartureDate().equals(other.getReturningDate()))
			return true;
		else if(this.getReturningDate().after(other.getDepartureDate())
				&& this.getDepartureDate().before(other.getReturningDate())){
			return true;
		}
		return false;
	}
	/**
	 * Returning trip duration
	 */
	public int tripDuration(){
		return this.getDepartureDate().difference(this.getReturningDate()) + 1;
	}
	
	/**
	 * Returning true or false according to method specification
	 */
	public boolean isLoaded(){
		if(getNoOfCountries() > this.tripDuration())
			return true;
		return false;
	}
	/**
	 * Returning true or false according to method specification
	 */
	public int howManyCars(){
		if(this.getNoOfTravellers() == 0)
			return 0;
		return (this.getNoOfTravellers() / 10) + 1;
	}
	/**
	 * Calculating the number of weekend
	 * Formula: taking the number of current day and adding the duration.
	 * dividing it by / and we are getting how many weeks is the trip.
	 * if trip is less then a week and there is a weekend in the middle, the number will be bigger then 6
	 * if there first day is the weekend then we should add 1 to the number of weekends
	 */
	public int howManyWeekends(){
		int dayInWeek = this.getDepartureDate().dayInWeek();
		int duration = this.tripDuration();
		
		int daysCounter = dayInWeek + duration;
		
		if(dayInWeek == 0){
			return (daysCounter / 7) + 1;
		}
		
		return (daysCounter / 7);
	}
	/**
	 * Calculating price according to specified formula
	 */
	public int calculatePrice(){
		int price =  (this.tripDuration() * this.PRICE_PER_DAY) + (this.getNoOfCountries() * this.PRICE_PER_COUNTRY);
		
		if(this.getDepartureDate().getMonth() == 7 || this.getDepartureDate().getMonth() == 8){
			price = (int) (price * 1.2);
		}
		
		price = price + (this.howManyWeekends() * 100);
		
		return price;
	}
	/**
	 * calculating the next weekend
	 * when taking the dayOfWeek of the departure Date, the nearest 7 is the weekend.
	 * we should add the number to nearest 7 to the departure Date and we will get next weekend
	 * adding also logic to handle end of month and year
	 */
	public Date firstWeekend(){
		// if there are no weekend in the middle then returning null
		if(this.howManyWeekends() == 0)
			return null;
		// if departure day is the weekend then returning it
		if(this.getDepartureDate().dayInWeek() == 0)
			return this.getDepartureDate();
		//calculating how many days from departure day to the nearest weekend
		int daysToWeekend = 7 - this.getDepartureDate().dayInWeek();
		//covering scenario when the next weekend is in the next month		
		if((this.getDepartureDate().getDay() + daysToWeekend) > getDaysInMonth(getDepartureDate().getMonth(), getDepartureDate().getYear())){
			//Handling scenario when the next weekend also in the next year
			if(getDepartureDate().getMonth() == 12){
				int resDays = (getDepartureDate().getDay() + daysToWeekend) % getDaysInMonth(getDepartureDate().getMonth(), getDepartureDate().getYear());
				int resMonth = 1;
				int resYears = getDepartureDate().getYear() + 1;
				return new Date(resDays, resMonth, resYears);
			} else {
				//If the weekend only in the next month
				int resDays = (getDepartureDate().getDay() + daysToWeekend) % getDaysInMonth(getDepartureDate().getMonth(), getDepartureDate().getYear());
				int resMonth = getDepartureDate().getMonth() + 1;
				int resYears = getDepartureDate().getYear();
				return new Date(resDays, resMonth, resYears);
			}
		} else {
			// If the next weekend not in the next month just add the days and that it
			return new Date(getDepartureDate().getDay() + daysToWeekend, getDepartureDate().getMonth(), getDepartureDate().getYear());
		}
		
	}
	/**
	 * Returning string representation of the object
	 */
	public String toString(){
		return "TRIP:" + this.getGuideName() + "|" + this.getDepartureDate().toString() + "|" + this.getReturningDate().toString() + "|" + this.getNoOfCountries() + "|" + this.getNoOfTravellers(); 
	}
	
	/**
	 * private method, used in firstWeekend method,
	 * In case the departure date is end of month and we need to calculate when is the next weekend, we need to konw how many days in the month
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

}
