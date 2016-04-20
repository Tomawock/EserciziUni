package it.ing.unibs.fondamenti.es12416.hack;

import it.ing.unibs.fondamenti.es12416.Tamagotchi;

public class TamaHack 
{
	public static TypeOfHack hackType(Tamagotchi tam)
	{
		TypeOfHack type=TypeOfHack.NORMAL;
		/*
		 * Se il nome del tamagochi è Z....E allora diventa zombie 
		 */
		if(tam.getNome().charAt(0)=='Z'&&tam.getNome().charAt(tam.getNome().length()-1)=='E'&&tam.getSazieta()==1)
		{
			type=TypeOfHack.ZOMBIE;
			tam.setSazieta(-1);
			
		}
		return type;
	}
}
