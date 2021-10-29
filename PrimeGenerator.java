

//generates a pair of primes in between the two ranges
public class PrimeGenerator
{

	private int lowerRange;
	private int upperRange;


	public PrimeGenerator(int a, int b)
	{
		this.lowerRange=a;
		this.upperRange=b;
	}

	public int primePairGenerator()
	{
		int[] toReturn= new int[2];

		boolean twinPrimes;

			for(int i=lowerRange;i<upperRange-2;i++)
			{
				if(i%2==0)
					continue;

				twinPrimes=false;
				int firstTwin=i;
				int secondTwin=i+2;


				for(int j=0;j<3;j++)
				{
					int randomNumber1=(int)Math.floor(Math.random()*upperRange);
					int randomNumber2=(int)Math.floor(Math.random()*upperRange);
						
					twinPrimes=(isPrime(randomNumber1,firstTwin) && isPrime(randomNumber2,secondTwin));
					if(!twinPrimes)
					{
						break;
					}	
						
				}

				if(twinPrimes)
				{
					System.out.println("the two primes are: "+firstTwin+" and " +secondTwin);
					return secondTwin;
				}

			}
//hopefully this never happens
System.out.println("could not find a prime");
return 0;



	}
//checks to see if an int is prime, didnt use long int so this was messed up.
	public boolean isPrime(int aInit,int p)
	{
		long a=1;
		for(int i=1;i<p;i++)
		{
			a=((a*aInit)%p+p)%p;
		}


		if(a==1)
			return true;
		else
			return false;

	}

	
}