public class LinearProbe
{

//pass in larger prime for this one
	public int ProbeLinearHashPos(int mPrime, int kValue, int i)
	{
		return ((kValue%mPrime+i)%mPrime);
	}

	
}