package it.ing.unibs.fondamenti.medagliere;

import java.util.ArrayList;
import java.util.Comparator;

public class Medagliere 
{
	private ArrayList<Nazione> nazioni;

	public Medagliere() 
	{
		nazioni=new ArrayList<>();
	}
	
	public void addNazione(Nazione n)
	{
		nazioni.add(n);
	}
	
	public ArrayList<Nazione> medagliereOrdinato()
	{
		nazioni.sort(null);
		return nazioni;
	}
}