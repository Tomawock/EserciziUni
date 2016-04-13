package it.ing.unibs.fondamenti.es12416;

import it.ing.unibs.fondamenti.tools.IO;

public class Tamagochi 
{
	//Costanti
	private final static int SAZ_CAREZZE=2;
	private final static int SOD_BISC=4;
	private final static int PERCENTUALE_BISC=10;
	private final static int SOGLIA_SODD=30;
	private final static int SOGLIA_SAZ=30;
	private final static int MAX_SAZ=90;
	private final static int MIN_VITA=0;
	private final static int MAX_VITA=100;
	//ttributi
	private String nome;					//nome tamagochi
	private int soddisfazione=MAX_VITA/2; 	//grado di soddisfazione
	private int sazieta=MAX_VITA; 		//grado di sazietas
	//Costruttori
	/**
	 * Default cosnsctructor
	 */
	public Tamagochi()
	{
		//
	}
	
	/**Costruttore che crea un tamagochi con nome soddisfazione e saziet�
	 * 
	 * @param nome,del tamagochi
	 * @param soddisfazione,del tamagochi
	 * @param sazieta,del tamagochi
	 */
	public Tamagochi(String nome, int soddisfazione, int sazieta) 
	{
		this.nome = nome;
		this.soddisfazione = soddisfazione;
		this.sazieta = sazieta;
	}
	
	//Funzioni
	/**Da delle carezze al tamagochi,riduce la saziet� aumenta soddisfazione
	 * 
	 * @param quantit� di carezze date al tamagochi
	 */
	public void daiCarezza(int carezze)
	{
		//aumenta grado di soddisfazione e diminusce della meta la sazieta
		soddisfazione+=carezze;
		sazieta-=(carezze/SAZ_CAREZZE);
		if(soddisfazione>100)
		{
			soddisfazione=100;
		}
	}
	
	/**Da dei biscotti al tamagochi,riduce la soddisfazone aumenta la saziet�
	 * 
	 * @param quantita di biscotti ingeriti
	 */
	public void daiBiscotto(int biscotto)
	{
		//aumenta del 10% il valore di saziet� e diminuisce la soddisfazione di 1/4
		sazieta+=(sazieta*(PERCENTUALE_BISC*biscotto))/100;
		soddisfazione-=(biscotto/SOD_BISC);
	}
	
	/**Controlla lo stato del tamagchi e dice se � vivo o meno
	 * 
	 * @return true se � morto, false se � vivo
	 */
	public boolean isMorto()
	{
		if (sazieta<=MIN_VITA || sazieta >=MAX_VITA || soddisfazione<=MIN_VITA)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**Controlla se � felice o meno il Tamagochi
	 * 
	 * @return true se � infelice, false se � felice
	 */
	public boolean isInfelice()
	{
		if (sazieta<SOGLIA_SAZ || sazieta>MAX_SAZ || soddisfazione<SOGLIA_SODD)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**Restituisce la stringa con lo status del tuo tamagochi
	 * 
	 * @return stato del Tamagochi, sottospece di toString()
	 */
	public String status() 
	{
		return "Nome=" + nome + ", soddisfazione=" + soddisfazione + ", sazieta=" + sazieta + ", Morto="
				+ isMorto() + ", Infelice=" + isInfelice() + "]";
	}
	
	/**Getter del nome
	 * 
	 * @return nome del Tamagochi
	 */
	public String getNome() 
	{
		return nome;
	}
	
	/**
	 * Getter della soddisfazione
	 * @return valore della soddisfazione
	 */
	public int getSoddisfazione() 
	{
		return soddisfazione;
	}
	
	/**
	 * Getter della saziet�
	 * @return valore della saziet�
	 */
	public int getSazieta() 
	{
		return sazieta;
	}
	
	public static void main(String[] args)
	{
		Tamagochi t= new Tamagochi();
		t.daiBiscotto(1);
		IO.out(t.getSazieta());
	}
}
