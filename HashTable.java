public class HashTable
{
	private HashObject[] table;
	private int capacity;
	private int openAddressType;
	private double loadFactor;


	public HashTable()
	{
		this.table=new HashObject[95791];
		this.capacity=95791;
		this.openAddressType=1;//this is linear probing
		this.loadFactor=0.75;
	}

	public HashTable(int sizeM, double a, int type)
	{
		this.table=new HashObject[sizeM];
		this.capacity=sizeM;
		this.openAddressType=type;
		this.loadFactor=a;
	}


	public void put(Object object, int type)
	{

		


		return;
	}

	public double getLoadFactor()
	{
		return this.loadFactor;
	}

	public int totalDuplicates()
	{
		int sum=0;
		for(int i=0;i<this.capacity;i++)
		{
			sum+=this.table[i].getFreqCount();
		}
		return sum;
	}

	public int totalProbes()
	{
		int sum=0;
		for(int i=0;i<this.capacity;i++)
		{
			sum+=this.table[i].getProbeCount();
		}
		return sum;		
	}

	public double averageProbes()
	{
		int probes=this.totalProbes();
		return (probes/this.capacity);
	}

	public void remove(Object key)
	{
		for(int i=0;i<this.capacity;i++)
		{
			if(table[i].compareTo(key))
			{
				table[i].clear();
			}
		}
	}

	public int size()
	{
		int count=0;
		for(int i=0;i<this.capacity;i++)
		{
			if(table[i].getObject()!=null)
				count+=1;
		}
		return count;
	}

	public void clear()
	{
		for(int i=0;i<this.capacity;i++)
		{
			table[i].clear();
		}
	}

	public boolean contains(Object key)
	{
		for(int i=0;i<this.capacity;i++)
		{
			if(table[i].compareTo(key))
				return true;
		}
		return false;
	}

	public void print()
	{
		for(int i=0;i<this.capacity;i++)
		{
			System.out.print("entry number "+i+": ");
			try{
				System.out.println(table[i].toString());
				return;
			}
			catch(Exception e)
			{
				System.out.println("empty");
			}

		}
	}



//	public 



	
}