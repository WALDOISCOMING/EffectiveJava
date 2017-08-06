package Chap3.Ç×¸ñ10;


public class HashTable implements Cloneable{
	private Entry[] buckets;
	private int size;
	
	private static class Entry
	{
		Object key;
		Object value;
		Entry next;
		public Entry(Object key,Object value,Entry next) {
			this.key=key;
			this.value=value;
			this.next=next;
			// TODO Auto-generated constructor stub
		}
		Entry deepCopy()
		{
			Entry result = new Entry(key,value,next);
			for(Entry p=result;p.next!=null;p=p.next)
			{
				p.next=new Entry(p.next.key,p.next.value, p.next.next);
			}
			return result;
		}
				
	}
	
	HashTable(int sz)
	{
		size=sz;
		buckets=new Entry[size];
		for(int i=0;i<size;i++)
			buckets[i]=null;
	}
	public Object put(Object key,Object value)
	{
		int slot = key.hashCode()%size;
		if(buckets[slot]==null){
			buckets[slot]= new Entry(key, value, null);	
			return null;
		}else{
			Entry ent = buckets[slot];
			Entry prevEnt=ent;
			while(ent!=null)
			{
				if(ent.key.equals(key))
				{
					Object oldVal = ent.value;
					ent.value=value;
					return oldVal;
				}
				prevEnt=ent;
				ent=ent.next;
			}
			prevEnt.next=new Entry(key, value, null);
			return null;
		}		
	}
	
	public void listEntries()
	{
		int i=0;
		while(i<size)
		{
			if(buckets[i]!=null)
			{
				Entry ent = buckets[i];
				while(ent!=null)
				{
					System.out.println((String)ent.key+", "+(String)ent.value);
					ent=ent.next;			
				}								
			}
			i++;
		}
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		HashTable result = (HashTable)super.clone();
		result.buckets = new Entry[buckets.length];
		for(int i=0;i<buckets.length;i++)
		{
			if(buckets[i]!=null)
				result.buckets[i]=(Entry)buckets[i].deepCopy();			
		}
		return result;
	}
	
	
	public static void main(String[] args)
	{
		try{
			
			HashTable ht = new HashTable(10);
			ht.put("1","one1");
			ht.put("1","one1");
			ht.put("2","one2");
			ht.put("2","one2");
			System.out.println("bf cloning:");
			ht.listEntries();
			System.out.println("af cloning");
			HashTable ht2 = (HashTable)ht.clone();
			ht2.listEntries();
		}catch(CloneNotSupportedException e){}
	}
}
