package it.ing.unibs.fondamenti.medagliere;

import java.util.ArrayList;

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
	
	@Override
	public String toString()
	{
		String s="";
		for(int i=0; i<nazioni.size(); i++)
		{
			s+=nazioni.get(i).toString();
		}
		return s;
	}
}