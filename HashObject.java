public class HashObject
{

	private Object object;
	private int freqCount;
	private int probeCount;
	private int key;


	public HashObject(Object obj, int k)
	{
		this.object=obj;
		this.freqCount=0;
		this.probeCount=0;
		this.key=k;
	}



@Override
	public String toString()
	{
		String toRet="this HashObject has frequency count: "+this.freqCount+" and probe count "+this.probeCount+" and key "+this.key;
		return toRet;
	}	


//@Override
	public boolean equals(HashObject ho2)
	{
		return ((this.key==ho2.getKey())   );// && (this.object.compareTo(ho2.getObject())));
												//finish compareTo wherever that needs to go
	}

	public Object getObject()
	{
		return this.object;
	}


	public int getKey()
	{
		return this.key;
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