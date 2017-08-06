package Chap3.항목7;

public class ColorPoint {

	private Point point;
	private Color color;
	public ColorPoint(int x,int y,Color color)
	{
		point = new Point(x, y);
		this.color=color;
	}
	
	public Point asPoint()
	{
		return point;
	}
	public boolean equals(Object o)
	{
		if(!(o instanceof ColorPoint))
			return false;
		ColorPoint cp = (ColorPoint)o;
		return cp.point.equals(point)&&cp.color.equals(color);
	}
	
	public static void main(String[] args)
	{
		Point p = new Point(1,2);
		ColorPoint cp = new ColorPoint(1, 2, Color.RED);
		//대칭성
		System.out.println(p.equals(cp));
		System.out.println(cp.equals(p));
		System.out.println();
		//추이성

		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1,2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.RED);
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println(p2.equals(p3));
	}
}
