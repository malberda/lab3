import java.util.Random;


public class HashTest
{


	public static void main(String[] args) {
		
		int largerPrime;
		PrimeGenerator pGen=new PrimeGenerator(95500,96000);
		largerPrime=pGen.primePairGenerator();
		int m=largerPrime;

		try{
			int debugLevel=0;
			int inputType=Integer.parseInt(args[0]);
			double  loadFactor=Double.parseDouble(args[1]);


			try{
				debugLevel=Integer.parseInt(args[2]);
			}
			catch(Exception e)
			{
				System.out.println("there was no debug choice given, so debug defaults to 0");
				//do nothing i think
			}

			
			if(inputType>3 || inputType<0)
			{
				System.out.println("InputType must be between 1 and 3");
				return;
			}
			if(debugLevel!=0 && debugLevel!=1)
			{
				System.out.println("The debug level must be either 0 or 1");
			}
			//for clarification, a, n, and m are variables added to match the lab description
			double a=loadFactor; 
			int n=(int)(a*(double)m);


			//generating the different objects and hashing them happens next. first im creating the hashtable.java code.



			//driving code
			Random ran=new Random();
			HashTable linearTable=new HashTable(largerPrime,a,1);			
			HashTable doubleTable=new HashTable(largerPrime,a,2);

			for(int i=0;i<n;i++)
			{
				if(inputType==1)
				{
					int input=ran.nextInt();
				//	System.out.println("input is "+input);
					linearTable.put(input);
					doubleTable.put(input);
				}
				else if(inputType==2)
				{
					long input=System.currentTimeMillis();
				//	System.out.println("input is "+input);
					linearTable.put(input);
					doubleTable.put(input);
				}
				else//input is 3 hopefully
				{
					return;

				}




			}
System.out.println("about to print");

			hashTable.print();




		}
		catch(Exception e){
			System.out.println("correct input is java HashTest a b c, where a is 1-3, b is the load factor, and c is either 0 or 1");
			return;
		}





		//System.out.println("inputType is "+inputType+" loadfactor is "+loadFactor+" debug level is "+debugLevel);









		return;



	}

}