package Chap2.항목1;
import java.util.*;

public class Foo {
	private static Map implementations=null;
	private static ResourceBundle classNames;//properties
	//동시접속을 불가하도록 하자. 처음 호출
	private static synchronized void initMapIfNecesary()
	{
		if(implementations==null)
			implementations = new HashMap();
		
		String firstFoo = getValue("firstFoo");
		String secondFoo = getValue("secondFoo");
		String thirdFoo = getValue("thirdFoo");
		try{
			Class obj1 = Class.forName(firstFoo);
			Class obj2 = Class.forName(secondFoo);
			Class obj3 = Class.forName(thirdFoo);
			implementations.put("firstfoo",obj1);
			implementations.put("secondfoo",obj2);
			implementations.put("thirdfoo",obj3);
			
			
		}catch(ClassNotFoundException e){
			System.out.println("Class not found");
		}
	
	}
	private static String getValue(String s)
	{
		String value=classNames.getString(s);
		return value;
	}
	
	
	static{
		try{
			classNames=ResourceBundle.getBundle("Tabletext");
		}catch(java.util.MissingResourceException e){
			System.out.println("Resource File not Found");
			System.exit(1);
		}
				
		}

	public static Foo getInstace(String key)
	{
		initMapIfNecesary();
		Class c = (Class)implementations.get(key);
		System.out.println(c+" "+"returned");
		if(c==null)
			return new Foo();
		try{
			return (Foo)c.newInstance();	
		}catch(Exception e){
			return new Foo();
		}

	}

	
	
}
