package Chap6.�׸�24;

import java.util.Date;

public final class Number {

	private final Date start;
	private final Date end;
	public Number(Date start,Date end)
	{
		//this.start = start;
		//this.end = end;
		//�̷����ϸ� �����ٲ�� �� ���� �ٲ�� ���� �Ͼ �Ʒ�ó�� �����ؾ���
		this.start=new Date(start.getTime());
		this.end = new Date(end.getTime());
	}
}
