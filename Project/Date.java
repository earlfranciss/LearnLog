package Project;

public class Date {
	private int Month;
	private int Day;
	private int Year;
	
	public void setMonth(int Month) {
		this.Month = Month;
	}
	
	public void setDay(int Day) {
		this.Day = Day;
	}
	
	public void setYear(int Year) {
		this.Year = Year;
	}
	
	public int getMonth() {
		return Month;
	}
	
	public int getDay() {
		return Day;
	}
	
	public int getYear() {
		return Year;
	}
	
	@Override
	public String toString() {
		return Year + "-" + Month + "-" + Day;
	}
}
