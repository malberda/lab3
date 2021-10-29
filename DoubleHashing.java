public class DoubleHashing
{

//pass in smaller prime then larger prime
	public int ProbeDoubleHashPos(int mPrime1,int mPrime2, int kValue,int  i)
	{
		return (((kValue%mPrime2)+i*(1+kValue%mPrime2))%mPrime2);
	}

	
}