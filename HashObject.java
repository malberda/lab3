public class HashObject
{

	private Object object;
	private int freqCount;
	private int probeCount;
	private boolean full;


	public HashObject(Object obj)
	{
		this.object=null;
		this.freqCount=0;
		this.probeCount=0;
		this.full=false;
	}





	public void clear()
	{
		this.object=null;
		this.freqCount=0;
		this.probeCount=0;
		this.full=false;
	}


@Override
	public String toString()
	{
		String toRet="this HashObject is "+this.object+"has frequency count: "+this.freqCount+" and probe count "+this.probeCount;
		return toRet;
	}	

	public boolean checkFull()
	{
		return this.full;
	}

	public void set(Object obj)
	{
		this.object=obj;
		this.full=true;
	}



//@Override
	public boolean compareTo(Object key)
	{

		return this.object.equals(key);
												//finish compareTo wherever that needs to go
	}

	public Object getObject()
	{
		return this.object;
	}

	public void incFreqCount()
	{
		this.freqCount+=1;
	}

	public void incProbeCount()
	{
		this.probeCount+=1;
	}


	public int getFreqCount()
	{
		return this.freqCount;
	}

	public int getProbeCount()
	{
		return this.probeCount;
	}


	
}