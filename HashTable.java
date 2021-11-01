import java.io.*;


public class HashTable
{
	private HashObject[] table;
	private int capacity;
	private int openAddressType;
	private double loadFactor;


	public HashTable()
	{
		this.table=new HashObject[95791];
		for(int i=0;i<95791;i++)
		{
			table[i]=new HashObject(-1);
		}
		this.capacity=95791;
		this.openAddressType=1;//this is linear probing
		this.loadFactor=0.75;
	}

	public HashTable(int sizeM, double a, int type)
	{
		this.table=new HashObject[sizeM];
		if(type==1 || type==2)
		{
		//	System.out.println("type of object is ints");
			for(int i=0;i<sizeM;i++)
			{
				table[i]=new HashObject(-1);
			}
		}
		else
		{
		//	System.out.println("type of object is stirngs");
			for(int i=0;i<sizeM;i++)
			{
				table[i]=new HashObject("");
			}
		}

		this.capacity=sizeM;
		this.openAddressType=type;
		this.loadFactor=a;
	}


	public void put(Object object, int type, int m)
	{
		int i=0;
		int index=0;
		LinearProbe linProbe=new LinearProbe();
		DoubleHashing doubleProbe=new DoubleHashing();
		HashObject hashObject=new HashObject(object);



		if(this.isFull())
		{
			//System.out.println("the table is full");
			if(!this.contains(object))
				return;
		}


		if(type==1)
		{
//	public int probeLinearHashPos(int mPrime, Object kValue, int i)
			while(table[linProbe.probeLinearHashPos(m,object,i)].checkFull()==true)
			{

				if(table[linProbe.probeLinearHashPos(m,object,i)].compareTo(object))
				{
					table[linProbe.probeLinearHashPos(m,object,i)].incFreqCount();
					return;
				}
				table[linProbe.probeLinearHashPos(m,object,i)].incProbeCount();


			//	System.out.println("attempted to put "+object.toString()+" in position "+linProbe.probeLinearHashPos(m,object,i)+", but it had "+table[linProbe.probeLinearHashPos(m,object,i)].getObject()+" in it");
				i++;
			}
				table[linProbe.probeLinearHashPos(m,object,i)].incProbeCount();
	//		System.out.println("time to set in position "+linProbe.probeLinearHashPos(m,object,i));
			table[linProbe.probeLinearHashPos(m,object,i)].set(object);
		}
		else if(type==2)
		{
//	public int probeLinearHashPos(int mPrime, Object kValue, int i)
			while(table[doubleProbe.probeDoubleHashPos(m,object,i)].checkFull()==true)
			{
				if(table[doubleProbe.probeDoubleHashPos(m,object,i)].compareTo(object))
				{
					table[doubleProbe.probeDoubleHashPos(m,object,i)].incFreqCount();
					return;
				}
				table[doubleProbe.probeDoubleHashPos(m,object,i)].incProbeCount();


			//	System.out.println("attempted to put "+object.toString()+" in position "+linProbe.probeLinearHashPos(m,object,i)+", but it had "+table[linProbe.probeLinearHashPos(m,object,i)].getObject()+" in it");
				i++;
			}
				table[doubleProbe.probeDoubleHashPos(m,object,i)].incProbeCount();
	//		System.out.println("time to set in position "+doubleProbe.probeDoubleHashPos(m,object,i));
			table[doubleProbe.probeDoubleHashPos(m,object,i)].set(object);
		}
		


		return;
	}


	public boolean isFull()
	{
		for(int i=0;i<this.capacity;i++)
		{
			if(!this.table[i].checkFull())
				return false;
		}
		return true;
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
			if(table[i].checkFull())
			{
				sum+=this.table[i].getProbeCount();
			}
		}
		return sum;		
	}

	public double averageProbes()
	{
		int probes=this.totalProbes();
		return ((double)probes/this.size());
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
			if(table[i].checkFull())
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
				table[i].incProbeCount();
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
				if(table[i].checkFull())
				System.out.println(table[i].toString());

			}
			catch(Exception e)
			{
				System.out.println("empty");
			}

		}
	}


	public void printFile(int type) throws IOException
	{
		File fout;
		if(type==1)
			fout=new File("linear-dump");
		else
			fout=new File("double-dump");

	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		for(int i=0;i<this.capacity;i++)
		{
			if(table[i].checkFull())
			{
				bw.write("table["+i+"]: ");
				bw.write(table[i].toString());
				bw.newLine();
			}
		}

		bw.close();
		return;
	}


//	public 



	
}