package Chap2.Ç×¸ñ2;

public class Evlis {
	public static final Evlis INSTANCE = new Evlis();
	private static final String str="A";
	private Evlis(){}
	
	public static String printEvis()
	{
		return str;
	}
	
	
	public static Evlis getInstance()
	{
		return INSTANCE;
	}
}
