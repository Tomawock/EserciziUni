package it.ing.unibs.fondamenti.es12416;

import it.ing.unibs.fondamenti.tools.*;

public class TamaGod 
{
	//Costanti
	private final static String CASE_BISCOTTO="1";
	private final static String CASE_CAREZZA="2";
	private final static String CASE_EXIT="3";
	private final static String ERROR="DATI DI ERRATI";
	private final static String INS="BENVENUTO\nInserire nome,soddisfazione e sazietà staccati dal carattere '-'\n";
	private final static String EXIT="SEI USCITO";
	private final static String MORTO=" è MORTO_";
	private final static String INFELICE=" è TRISTE :[";
	private final static String FELICE=" è FELICE :]";
	private final static int RANGE_MIN=1;
	private final static int RANGE_MAX=10;
	
	/**
	 * Ciclo di vita del tamagochi, insermento dati con la scelta da tstiera e output dello status della felicita e controlla se è morto
	 * 
	 * @param tam Oggetto di tipo Tamagochi usare funzione CreaTamag
	 */
	public static void cicloVitaTamagochi(Tamagotchi tam)
	{
		String par="";
		do
		{
			//dice all'utente se Tamagochi è felice
			if(tam.isInfelice())
			{
				IO.out(tam.getNome()+INFELICE);
			}
			else
			{
				IO.out(tam.getNome()+FELICE);
			}
			
			IO.out("Dare biscotto ("+CASE_BISCOTTO+")\nDare Carezza ("+CASE_CAREZZA+")\nUscire ("+CASE_EXIT+")\n");
			
			par=IO.inKeyBoard(true);
			
			if(par.equalsIgnoreCase(CASE_BISCOTTO))
			{
				tam.daiBiscotti(myMath.randInt(RANGE_MIN,RANGE_MAX));
			}
			if(par.equalsIgnoreCase(CASE_CAREZZA))
			{
				tam.daiCarezza(myMath.randInt(RANGE_MIN,RANGE_MAX));
			}
			else if(!par.equalsIgnoreCase(CASE_EXIT))
			{
				IO.out(ERROR);
			}
			//status del tamagochi
			IO.out(tam.status());
			
		}while(!tam.isMorto()&&!par.equalsIgnoreCase(CASE_EXIT));
		
		//se è morto dice all'utente che è morto altrimenti è uscito
		if(tam.isMorto())
		{
			IO.out(MORTO+tam.getNome());
		}
		else
		{
			IO.out(EXIT);
		}
		//chiudo il buffer della tastiera
		IO.inKeyBoard(false);
	}
	
	/**
	 * Crea un Tamagochi, questa funzione viene usata come parametro della funzione vitaTamagochi()
	 * crea un tamagochi leggendo i dati da tstiera
	 * 
	 * @return Tamagochi un nuovo oggetto di tipo tamagochi 
	 */
	public static Tamagotchi creaTam()
	{
		IO.out(INS);
		String s=IO.inKeyBoard(true);
		String[] str={"ERR","-1","-1"};
		str=s.split("-");
		
		return new Tamagotchi(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
	}

}
