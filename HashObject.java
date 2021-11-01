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




		//cleans the HashObject for the added removal functions
	public void clear()
	{
		this.object=null;
		this.freqCount=0;
		this.probeCount=0;
		this.full=false;
	}

	//returns the values of the HashObject as a string to be printed
@Override
	public String toString()
	{
		String toRet=this.object+" frequency:"+this.freqCount+" probes:"+this.probeCount;
		return toRet;
	}	

		//checks to see if the HashObject is full of an object
	public boolean checkFull()
	{
		return this.full;
	}

		//sets the value of the HashObject to the passed in Object, and sets its value to be true
	public void set(Object obj)
	{
		this.object=obj;
		this.full=true;
	}


			//returns a comparison based on the objects internal .equals() function
//@Override
	public boolean compareTo(Object key)
	{

		return this.object.equals(key);
												//finish compareTo wherever that needs to go
	}


		//returns the object
	public Object getObject()
	{
		return this.object;
	}

		//increases the frequency count
	public void incFreqCount()
	{
		this.freqCount+=1;
	}

		//increases the probe count
	public void incProbeCount()
	{
		this.probeCount+=1;
	}

		//returns frequency count
	public int getFreqCount()
	{
		return this.freqCount;
	}

		//returns probe count
	public int getProbeCount()
	{
		return this.probeCount;
	}


	
}