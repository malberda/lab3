public class LinearProbe
{
	public LinearProbe()
	{

	}

//pass in larger prime for this one
	public int probeLinearHashPos(int mPrime, Object kValue, int i)
	{
		int h1=PositiveMod(kValue.hashCode(),mPrime);


		return ((h1+i)%mPrime);
	}

	public int PositiveMod(int dividend, int divisor)
	{
		int value=dividend%divisor;
		if(value<0)
			value+=divisor;
		return value;
	}

	
}