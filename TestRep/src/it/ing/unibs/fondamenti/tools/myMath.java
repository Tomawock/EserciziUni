package it.ing.unibs.fondamenti.tools;

import java.util.Random;

public class myMath 
{
	public static double logBaseGenerica(double base, double x)
	{
		return Math.log(x)/Math.log(base); 
	}
	
	public static double logBase2(double x)
	{
		return myMath.logBaseGenerica(2, x);
	}
	public static int randInt(int inizio,int fine)
	{
		Random random = new Random();
		int c = ((fine-inizio) + 1);
		int miavar = random.nextInt(c) + inizio;
		return miavar;
	}
}
