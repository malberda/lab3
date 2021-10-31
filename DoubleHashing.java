public class DoubleHashing
{

//pass in smaller prime then larger prime
	public int probeDoubleHashPos(int mPrime, Object kValue,int  i)
	{
			int h1=PositiveMod(kValue.hashCode(),mPrime);
			int h2=PositiveMod(kValue.hashCode(),mPrime-2);
			h2+=1;


		return PositiveMod(h1+i*h2,mPrime);
	}

	
	public int PositiveMod(int dividend, int divisor)
	{
		int value=dividend%divisor;
		if(value<0)
			value+=divisor;
		return value;
	}

}