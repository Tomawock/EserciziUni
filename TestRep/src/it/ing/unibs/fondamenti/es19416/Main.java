package it.ing.unibs.fondamenti.es19416;

import it.ing.unibs.fondamenti.tools.IO;

public class Main 
{
	private static final String ADDWEEK="1";
	private static final String ESCI="3";
	private static final String ERRMAX="UN GIORNO è STATO SUERPATO IL LIMITE MASSIMO DI "+Settimana.VMAX;
	private static final String ERRMED="SUERPATO IL LIMITE MEDIO SETTIMANALE DI "+Settimana.VMAX;
	private static final String AGGGIORNO ="AGGIUNGI I DATI DEL GIORNO ";
	private static final Object SETANNO = "INSERISCI L'ANNO ";
	private static final Object SETSETTIMANA = "";
	
	public static Settimana setSettimana()
	{
		double giorni[]=new double[Settimana.NGIORNI];
		int anno,settimana;
		Giorno giorniSet[]=Giorno.values();
		IO.out(SETANNO);
		anno=Integer.parseInt(IO.inKeyBoard(true));
		do
		{
			IO.out(SETSETTIMANA);
			settimana=Integer.parseInt(IO.inKeyBoard(true));
		}while(settimana>=1&&settimana<=53);
		for(int i=0;i<Settimana.NGIORNI;i++)
		{
			IO.out(AGGGIORNO+giorniSet[i]);
			giorni[i]=Double.parseDouble(IO.inKeyBoard(true));
		}
		
		return new Settimana(anno,settimana,giorni);
		
	}
	private static void loop(Settimana setWeek)
	{
		
	}

	public static void main(String[] args)
	{
		Main.loop(Main.setWeek());
	}

}
