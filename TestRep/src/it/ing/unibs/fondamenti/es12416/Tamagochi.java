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
	public Tamagochi()
	{
		//
	}
	
	public Tamagochi(String nome, int soddisfazione, int sazieta) 
	{
		this.nome = nome;
		this.soddisfazione = soddisfazione;
		this.sazieta = sazieta;
	}

	//funzioni
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
	
	public void daiBiscotto(int biscotto)
	{
		//aumenta del 10% il valore di sazietà e diminuisce la soddisfazione di 1/4
		sazieta+=(sazieta*(PERCENTUALE_BISC*biscotto))/100;
		soddisfazione-=(biscotto/SOD_BISC);
	}
	
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
	
	
	@Override
	public String toString() 
	{
		return "Nome=" + nome + ", soddisfazione=" + soddisfazione + ", sazieta=" + sazieta + ", Morto="
				+ isMorto() + ", Infelice=" + isInfelice() + "]";
	}

	public String getNome() 
	{
		return nome;
	}

	public double getSoddisfazione() 
	{
		return soddisfazione;
	}

	public double getSazieta() 
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
