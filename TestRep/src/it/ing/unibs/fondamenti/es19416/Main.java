package it.ing.unibs.fondamenti.es19416;

import it.ing.unibs.fondamenti.tools.IO;

public class Main 
{
	private static final String ERRMAX="UN GIORNO è STATO SUPERATO IL LIMITE MASSIMO DI "+Settimana.VMAX+"\n";
	private static final String ERRMED="SUPERATO IL LIMITE MEDIO SETTIMANALE DI "+Settimana.VMED+"\n";
	private static final String AGGGIORNO ="AGGIUNGI I DATI DEL GIORNO ";
	private static final String SETANNO = "INSERISCI L'ANNO ";
	private static final String SETSETTIMANA = "INSERISCI IL NUMERO DELLA SETTIMANA 1-53";
	private static final String CASESTAY="1";
	private static final String CASEEXIT="2";
	private static final String SCELTA = "PREMERE "+CASEEXIT+" PER USCIRE O "+CASESTAY+" PER CONTINUARE";
	private static final String ERRDATI = "SCEGLIERE UN DATO CORRETTO TRA:\n"+SCELTA;
	private static final String OUT = "SEI USCITO";
	private static final String DEFAULT = "NON CI SONO STATI ERRORI\n";
	
	private static Settimana setSettimana()
	{
		double giorni[]=new double[Settimana.NGIORNI];
		int anno,settimana;
		//trasformo l'enum in array
		Giorno giorniSet[]=Giorno.values();
		IO.out(SETANNO);
		anno=Integer.parseInt(IO.inKeyBoard(true));
		do
		{
			IO.out(SETSETTIMANA);
			settimana=Integer.parseInt(IO.inKeyBoard(true));
			
		}while(settimana<1||settimana>53);
		
		for(int i=0;i<Settimana.NGIORNI;i++)
		{
			IO.out(AGGGIORNO+giorniSet[i]);
			giorni[i]=Double.parseDouble(IO.inKeyBoard(true));
		}
		
		return new Settimana(anno,settimana,giorni);
	}
	
	private static void loop()
	{
		String res="";
		Settimana week;
		do
		{
			IO.out(SCELTA);
			res=IO.inKeyBoard(true);
			while(!res.equalsIgnoreCase(CASEEXIT)&&!res.equalsIgnoreCase(CASESTAY))
			{
				IO.out(ERRDATI);
				res=IO.inKeyBoard(true);
				
			}
			
			if(res.equals(CASESTAY))
			{
				week=Main.setSettimana();
				if(week.isOverMax())
				{
					IO.out(ERRMAX);
				}
				if(week.isOverMed())
				{
					IO.out(ERRMED);
				}
				if(!week.isOverMax()&&!week.isOverMed())
				{
					IO.out(DEFAULT);
				}
			}
		}while(!res.equalsIgnoreCase(CASEEXIT));
		IO.inKeyBoard(false);
		IO.out(OUT);
	}

	public static void main(String[] args)
	{
		Main.loop();
	}
}