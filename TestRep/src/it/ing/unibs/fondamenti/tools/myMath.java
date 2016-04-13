package it.ing.unibs.fondamenti.tools;

import java.util.Random;

public class myMath 
{
	/**Logaritmo in base generica
	 * 
	 * @param base, del log 
	 * @param x ,valore da logaritmare
	 * @return logaritmo in una base passata
	 */
	public static double logBaseGenerica(double base, double x)
	{
		return Math.log(x)/Math.log(base); 
	}
	
	/**
	 * Calcola il log in base due di un numero
	 * 
	 * @param x valore da logaritmare
	 * @return logaritmo in base due di un numero
	 */
	public static double logBase2(double x)
	{
		return myMath.logBaseGenerica(2, x);
	}
	
	/**
	 * Calcola un intero casuale
	 * 
	 * @param inizio del range dei numeri casuali
	 * @param fine del range di numeri casuali
	 * @return un numero casuale compreso tra finizio e fine
	 */
	public static int randInt(int inizio,int fine)
	{
		Random random = new Random();
		int c = ((fine-inizio) + 1);
		int miavar = random.nextInt(c) + inizio;
		return miavar;
	}
}
