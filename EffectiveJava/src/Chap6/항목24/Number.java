package Chap6.항목24;

import java.util.Date;

public final class Number {

	private final Date start;
	private final Date end;
	public Number(Date start,Date end)
	{
		//this.start = start;
		//this.end = end;
		//이렇게하면 변수바뀌면 이 값도 바뀌는 현상 일어남 아래처럼 방어복사해야함
		this.start=new Date(start.getTime());
		this.end = new Date(end.getTime());
	}
}
