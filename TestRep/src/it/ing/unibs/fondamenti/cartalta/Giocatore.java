package it.ing.unibs.fondamenti.cartalta;

public class Giocatore
{
	private int soldi;
	private int puntata;

	
	public Giocatore() 
	{
		soldi=0;
		puntata=0;
	}

	public Giocatore(int soldi)
	{
		this.soldi = soldi;
		puntata=0;
	}
	
	public void addVittoria()
	{
		this.soldi+=puntata;
	}
	
	public void remVittoria()
	{
		this.soldi-=puntata;
	}
	
	public void addSoldi(int soldi)
	{
		this.soldi+=soldi;
	}
	
	public boolean punta(int puntata)
	{
		if(puntata>soldi)
			return false;
		soldi-=puntata;
		return true;
	}

	public int getPuntata() {
		return puntata;
	}

	public int getSoldi() {
		return soldi;
	}	
}
