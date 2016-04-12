package it.ing.unibs.fondamenti.es12416;

import it.ing.unibs.fondamenti.tools.*;

public class Main 
{
	private final static String INS="Inserire nome soddisfazione e sazietà staccati dal '-'\n";
	private final static String EXIT="SEI USCITO";
	private final static String MORTO="è MORTO_";
	private final static String INFELICE="è TRISTE :[";
	private final static String FELICE="è FELICE :]";
	private final static int RANGE_MIN=0;
	private final static int RANGE_MAX=10;
	
	public static void vitaTamagochi(Tamagochi tam)
	{
		String par="";
		do
		{
			if(tam.isInfelice())
			{
				IO.out(tam.getNome()+INFELICE);
			}
			else
			{
				IO.out(tam.getNome()+FELICE);
			}
			
			IO.out("Dare biscotto (1)\nDare Carezza (2)\nUscire (3)\n");
			
			par=IO.inKeyBoard(true);
			
			if(par.equalsIgnoreCase("1"))
			{
				tam.daiBiscotto(myMath.randInt(RANGE_MIN,RANGE_MAX));
			}
			else if(par.equalsIgnoreCase("2"))
			{
				tam.daiCarezza(myMath.randInt(RANGE_MIN,RANGE_MAX));
			}
			IO.out(tam.toString());
		}while(!tam.isMorto()||par.equalsIgnoreCase("3"));
		
		if(tam.isMorto())
		{
			IO.out(MORTO+tam.getNome());
		}
		else
		{
			IO.out(EXIT);
		}
	}
	
	public static Tamagochi creaTam()
	{
		IO.out(INS);
		String s=IO.inKeyBoard(true);
		String[] str=s.split("-");
		return new Tamagochi(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
	}
	
	public static void main (String[] args)
	{
		Main.vitaTamagochi(Main.creaTam());
	}
}
