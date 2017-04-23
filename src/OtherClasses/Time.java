package OtherClasses;

import java.util.Date;

/*
 * Time that creates and stores the current time.
 * @author alvarezaaronai
 */
public class Time {
	/*
	 * Member Variables that store the current date and time
	 */
	private double hours;
	private double minutes;
	private double seconds;
	private int year;
	private int month;
	private int day;

	/*
	 * Constructor that creates the current date when created
	 */
	public Time() {
		Date tempDate = new Date();
		this.hours = tempDate.getHours();
		this.minutes = tempDate.getMinutes();
		this.seconds = tempDate.getSeconds();
		this.year = tempDate.getYear();
		this.month = tempDate.getMonth();
		this.day = tempDate.getDay();
	}
	/*
	 * Public Method that updates the time
	 */
	public void updateTime() {
		Date tempDate = new Date();
		this.hours = tempDate.getHours();
		this.minutes = tempDate.getMinutes();
		this.seconds = tempDate.getSeconds();
		this.year = tempDate.getYear();
		this.month = tempDate.getMonth();
		this.day = tempDate.getDay();
		
	}
	/*
	 * Methods that retrieve the time and set time for any later update.
	 */
	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double getMinutes() {
		return minutes;
	}

	public void setMinutes(double minutes) {
		this.minutes = minutes;
	}

	public double getSeconds() {
		return seconds;
	}

	public void setSeconds(double seconds) {
		this.seconds = seconds;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Current Day = "+ this.month +"/"+ this.day +"/"+ this.year +"/n"+
				"Current Time" + + this.hours +":"+ this.minutes +":"+ this.seconds ;
	}
	

}
