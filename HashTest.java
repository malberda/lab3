import java.util.Random;
import java.util.Scanner;
import java.io.*;


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
			HashTable linearTable=new HashTable(largerPrime,a,inputType);			
			HashTable doubleTable=new HashTable(largerPrime,a,inputType);



			for(int i=0;i<n;i++)
			{
				if(inputType==1)
				{
					int input=ran.nextInt();
				//	System.out.println("input is "+input+" number is "+i);
					linearTable.put(input,1,m);
					doubleTable.put(input,2,m);
				}
				else if(inputType==2)
				{
					long input=System.currentTimeMillis();
				//	System.out.println("input is "+input);
					linearTable.put(input,1,m);
					doubleTable.put(input,2,m);
				}
				else//input should jsut be 3 hopefully
				{
					FileInputStream fis=new FileInputStream("word-list");
					Scanner sc=new Scanner(fis);

					while(sc.hasNextLine()&&i<n)
					{
							String input=sc.nextLine();
					//		System.out.println("input is "+input);
							linearTable.put(input,1,m);
							doubleTable.put(input,2,m);
							i++;
							System.out.println(i);
					}sc.close();

/*
				Scanner sc2=new Scanner(new File("word-list"));
					
					while(sc2.hasNextLine()&& i<n){
						Scanner s2=new Scanner(sc2.nextLine());
						while(s2.hasNext()&&i<n){
							String input=s2.next();
					//		System.out.println("input is "+input);
							linearTable.put(input,1,m);
							doubleTable.put(input,2,m);
							i++;
							System.out.println(i);
						}
					}*/

				}




			}

			System.out.println("A good table size is found: "+m);
			System.out.print("Data source type: ");
			if(inputType==1)
			{System.out.println("Integers");}
			if(inputType==2)
			{System.out.println("Long Integers");}
			if(inputType==3)
			{System.out.println("word-list");}

System.out.println();

int numDuplicates;
double averageProbes;

			numDuplicates=linearTable.totalDuplicates();
			averageProbes=linearTable.averageProbes();

System.out.println("Using Linear Hashing....");
System.out.println("Input "+n+" elements, of which "+numDuplicates+" duplicates");
System.out.println("load factor = "+loadFactor+", Avg. no. of probes "+averageProbes);

			//linearTable.print();

			numDuplicates=doubleTable.totalDuplicates();
			averageProbes=doubleTable.averageProbes();

System.out.println();

System.out.println("Using Double Hashing....");
System.out.println("Input "+n+" elements, of which "+numDuplicates+" duplicates");
System.out.println("load factor = "+loadFactor+", Avg. no. of probes "+averageProbes);

			//doubleTable.print();






			if(debugLevel==1)
			{
				linearTable.printFile(1);
				doubleTable.printFile(2);
			}


		//System.out.println("inputType is "+inputType+" loadfactor is "+loadFactor+" debug level is "+debugLevel);




		}
		catch(Exception e){
			System.out.println("Error: correct input is java HashTest a b c, where a is 1-3, b is the load factor, and c is either 0 or 1");
			return;
		}














		return;



	}

}