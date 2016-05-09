package it.ing.unibs.fondamenti.cartalta;

import it.ing.unibs.fondamenti.tools.IO;

public class Main 
{
	private final static String BENVENUTO="Inserire l'ammontare del giocatore";
	private static final String SCELTA_FR = "FR";
	private static final String SCELTA_IT = "IT";
	private final static String SCELTA="Scegliere il tipo di mazzo:"+SCELTA_IT+"Mazzo italiano,"+SCELTA_FR+"Mazzo Francese";
	private final static String PUNTA="Scegliere una quantità da puntare,se non si vole puntare digitare 0 ";
	private final static String ESTRATTA="La carta estratta è : ";
	private final static String VINTO="Hai vinto ";
	private final static String PERSO="Hai Perso ";
	private final static String STATUS_SOLDI="Hai ancora disponibilei: ";
	private final static String CASE_EXIT="2";
	private final static String CASE="Per Uscire premere "+CASE_EXIT+",altrimenti un tasto qualsiasi per restare";
	private static final Object EXIT = "Sei Uscito dal gioco";
	
	public static Giocatore addGiocatore()
	{
		Giocatore ply=new Giocatore();
		int test=-1;
		//Cicla finchè il numero dei soldi è positivo
		do
		{	
			IO.out(BENVENUTO);
			test=Integer.parseInt(IO.inKeyBoard(true));
		}while(test<0);
		//aggiunge i soldi al giocatore
		ply.addSoldi(test);
		
		return ply;
	}
	
	public static void loop(Giocatore ply)
	{
		do
		{
			String test=null;
			do
			{	
				IO.out(SCELTA);
				test=IO.inKeyBoard(true);
			}while(!(test.equalsIgnoreCase(SCELTA_FR)||test.equalsIgnoreCase(SCELTA_IT)));
			//si crea il mazzo
			Mazzo mazzo=new Mazzo(test);
			//scarta una carta e la carica 
			Carta prima=new Carta(mazzo.scarta());
			IO.out(ESTRATTA+prima.toString());
			do
			{
				IO.out(PUNTA);
			}while(!(ply.punta(Integer.parseInt(IO.inKeyBoard(true)))));
			//CONTROLLA CHI VINCE
			Carta seconda=new Carta(mazzo.scarta());
			if(prima.getPunteggio()>=seconda.getPunteggio())//perde se ha la carta con pari punti del banco
			{
				IO.out(PERSO+ply.getPuntata());
				ply.remVittoria();
			}
			else
			{
				IO.out(VINTO+ply.getPuntata());
				ply.addVittoria();
			}
			IO.out(STATUS_SOLDI+ply.getSoldi());
			IO.out(CASE);
		}while(!(IO.inKeyBoard(true).equalsIgnoreCase(CASE_EXIT)||ply.getSoldi()<=0));
		IO.out(EXIT);
	}
	
	public static void main(String[] args)
	{
		Main.loop(addGiocatore());
	}
}
