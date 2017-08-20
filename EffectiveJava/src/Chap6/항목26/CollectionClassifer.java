package Chap6.항목26;

import java.util.*;

public class CollectionClassifer {

	public static String classify(Set s){
		return "set";
	}
	public static String classify(List l){
		return "list";
	}
	
	public static String classify(Collection c){
		//return "unknown";
		return (c instanceof Set?"set":
				c instanceof List?"list":"unknown");
	}
	//중복정의 메소드이므로 모두 unknown이 된다. 이러한건 이미 컴파일시점에 결정이 되는데, 컴파일 시점에는 모두 collection이기 때문이다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection[] test = new Collection[]{
				new HashSet(),
				new ArrayList(),
				new HashMap().values()
		};
		for(int i=0;i<3;i++)
			System.out.println(classify(test[i]));
	}

}
