package Chap6.�׸�26;

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
	//�ߺ����� �޼ҵ��̹Ƿ� ��� unknown�� �ȴ�. �̷��Ѱ� �̹� �����Ͻ����� ������ �Ǵµ�, ������ �������� ��� collection�̱� �����̴�.
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
