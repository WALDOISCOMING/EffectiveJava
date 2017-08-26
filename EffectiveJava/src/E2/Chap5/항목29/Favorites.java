package E2.Chap5.Ç×¸ñ29;

import java.util.HashMap;
import java.util.Map;

public class Favorites {
	private Map<Class<?>,Object> favorties = new HashMap<Class<?>,Object>();
	public<T> void putFavorites(Class<T> type,T instance){
		if(type==null)
			throw new NullPointerException("type is null");
		favorties.put(type,instance);
	}
	
	public <T> T getFavorites(Class<T> type){
		return type.cast(favorties.get(type));
	}
	
	public static void main(String[] args){
		Favorites favorites=new Favorites();
		favorites.putFavorites(String.class,"hello");
		favorites.putFavorites(Integer.class,100);
		favorites.putFavorites(Class.class,Favorites.class);
		System.out.println(favorites.getFavorites(String.class));
		System.out.println(favorites.getFavorites(Integer.class));
		System.out.println(favorites.getFavorites(Class.class));
	}
}
