package Chap2.항목4;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {
	private final Date birthDate;
	public Person(Date birthDate)
	{
		this.birthDate=birthDate;
	}
	
	
	//이처럼 객체를 만들면 안된다.
	public boolean poor_isBabyBoomer()
	{
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GmT"));
		cal.set(1946, Calendar.JANUARY,1,0,0,0);
		Date boomstart = cal.getTime();
		cal.set(1965, Calendar.JANUARY,1,0,0,0);
		 Date boomEnd= cal.getTime(); 
		
		return birthDate.compareTo(boomstart)>=0&&
				birthDate.compareTo(boomEnd)<0;
	}

	private static final Date BOOM_START;
	private static final Date BOOM_END;
	static
	{
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.set(1946, Calendar.JANUARY,1,0,0,0);
		BOOM_START= cal.getTime();
		cal.set(1965, Calendar.JANUARY,1,0,0,0);
		BOOM_END= cal.getTime(); 
	}
	
	public boolean real_isBabyBoomer()
	{
		
		
		return birthDate.compareTo(BOOM_START)>=0&&
				birthDate.compareTo(BOOM_END)<0;
	}
	
}
