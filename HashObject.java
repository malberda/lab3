public class HashObject
{

	private Object object=null;
	private int freqCount;
	private int probeCount;


	public HashObject(Object obj)
	{
		this.object=obj;
		this.freqCount=0;
		this.probeCount=0;
	}





	public void clear()
	{
		this.object=null;
		this.freqCount=0;
		this.probeCount=0;
	}


@Override
	public String toString()
	{
		String toRet="this HashObject is "+this.object+"has frequency count: "+this.freqCount+" and probe count "+this.probeCount;
		return toRet;
	}	

	public void print()
	{
		return;
	}


//@Override
	public boolean compareTo(Object key)
	{
		return true;										//finish compareTo wherever that needs to go
	}

	public Object getObject()
	{
		return this.object;
	}

	public void setFreqCount()
	{

	}

	public void setProbeCount()
	{

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