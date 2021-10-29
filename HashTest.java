public class HashTest
{


	public static void main(String[] args) {
		
		int largerPrime;
		PrimeGenerator pGen=new PrimeGenerator(95500,96000);
		largerPrime=pGen.primePairGenerator();
		int m=largerPrime;

		try{
			int inputType=Integer.parseInt(args[0]);
			int loadFactor=Integer.parseInt(args[1]);
			int debugLevel=Integer.parseInt(args[2]);
			
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
			int a=loadFactor; 
			int n=a*m;


			//generating the different objects and hashing them happens next. first im creating the hashtable.java code.












		}
		catch(Exception e){
			System.out.println("correct input is java HashTest a b c, where a is 1-3, b is the load factor, and c is either 0 or 1");
			return;
		}





		//System.out.println("inputType is "+inputType+" loadfactor is "+loadFactor+" debug level is "+debugLevel);









		return;



	}

}