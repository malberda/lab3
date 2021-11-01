public class LinearProbe
{
	//not sure if necessary but added
	public LinearProbe()
	{

	}

//pass in larger prime for this one, then returns the hash value
	public int probeLinearHashPos(int mPrime, Object kValue, int i)
	{
		int h1=PositiveMod(kValue.hashCode(),mPrime);


		return ((h1+i)%mPrime);
	}

		//positively mods according to lab paper.
	public int PositiveMod(int dividend, int divisor)
	{
		int value=dividend%divisor;
		if(value<0)
			value+=divisor;
		return value;
	}

	
}