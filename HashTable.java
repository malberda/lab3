import java.io.*;


public class HashTable
{
	private HashObject[] table;
	private int capacity;
	private int openAddressType;
	private double loadFactor;

//constructor
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

		//constructor with variables, default use
	public HashTable(int sizeM, double a, int type)
	{
		this.table=new HashObject[sizeM];	//initializes new table
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

			//main adding code
	public int put(Object object, int type, int m)  //returns 1 if non duplicate, 0 if duplicate
	{
		int i=0;
		LinearProbe linProbe=new LinearProbe();
		DoubleHashing doubleProbe=new DoubleHashing();


			//if type is one, then run this code, which is linear hashing
		if(type==1)
		{
			while(table[linProbe.probeLinearHashPos(m,object,i)].checkFull()==true)
			{
				table[linProbe.probeLinearHashPos(m,object,i)].incProbeCount();

				if(table[linProbe.probeLinearHashPos(m,object,i)].compareTo(object))
				{
					table[linProbe.probeLinearHashPos(m,object,i)].decProbeCount();
					table[linProbe.probeLinearHashPos(m,object,i)].incFreqCount();
					return 0;
				}


				i++;
			}
				table[linProbe.probeLinearHashPos(m,object,i)].incProbeCount();
			table[linProbe.probeLinearHashPos(m,object,i)].set(object);
		}
		else if(type==2)		//if type is 2, then double hashing
		{
			while(table[doubleProbe.probeDoubleHashPos(m,object,i)].checkFull()==true)
			{
				table[doubleProbe.probeDoubleHashPos(m,object,i)].incProbeCount();


				if(table[doubleProbe.probeDoubleHashPos(m,object,i)].compareTo(object))
				{
					table[doubleProbe.probeDoubleHashPos(m,object,i)].decProbeCount();
					table[doubleProbe.probeDoubleHashPos(m,object,i)].incFreqCount();
					return 0;
				}

				i++;
			}
				table[doubleProbe.probeDoubleHashPos(m,object,i)].incProbeCount();
			table[doubleProbe.probeDoubleHashPos(m,object,i)].set(object);
		}
		


		return 1;
	}

//checks if table is full
	public boolean isFull()
	{
		for(int i=0;i<this.capacity;i++)
		{
			if(!this.table[i].checkFull())
				return false;
		}
		return true;
	}

//returns load factor
	public double getLoadFactor()
	{
		return this.loadFactor;
	}

//checks how many duplicates theyre are
	public int totalDuplicates()
	{
		int sum=0;
		for(int i=0;i<this.capacity;i++)
		{
			sum+=this.table[i].getFreqCount();
		}
		return sum;
	}

//checks how many times each element in the table was probed, thouhg only those elements who are not empty
	public int totalProbes()
	{
		int sum=0;
		for(int i=0;i<this.capacity;i++)
		{
				sum+=this.table[i].getProbeCount();
		}
		return sum;		
	}

//returns total number of probes
	public double averageProbes()
	{
		int probes=this.totalProbes();
//		System.out.println("the total probes is "+probes);
		return ((double)probes/this.size());
	}

//removes all objects matching passed in Object key
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

//returns the total number of full spaces in the table
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

//clears the whole table
	public void clear()
	{
		for(int i=0;i<this.capacity;i++)
		{
			table[i].clear();
		}
	}

//increases the probe count for everything
	public void increaseProbeCountForEverything()
	{
		for(int i=0;i<this.capacity;i++)
		{
				table[i].incProbeCount();
		}
		return;
	}

//checks if table contains Object key
	public boolean contains(Object key)
	{
		for(int i=0;i<this.capacity;i++)
		{
			//	table[i].incProbeCount();
			if(table[i].compareTo(key))
				return true;
		}
		return false;
	}

//prints the table
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

//prints table to linear-dump and double-dump if debu-level is 1
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