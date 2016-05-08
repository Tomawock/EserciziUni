package it.ing.unibs.fondamenti.cartalta;

public class Giocatore
{
	private int soldi;
	private int puntata;

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
	
	public boolean punta(int puntata)
	{
		if(puntata>soldi)
			return false;
		soldi-=puntata;
		return true;
	}
}
