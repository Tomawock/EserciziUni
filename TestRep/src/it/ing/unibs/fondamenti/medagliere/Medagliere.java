package it.ing.unibs.fondamenti.medagliere;

import java.util.ArrayList;
import java.util.Comparator;

import it.ing.unibs.fondamenti.tools.IO;

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
<<<<<<< HEAD
		Nazione n=new Nazione("");
		nazioni.sort((Comparator<? super Nazione>) n);
		return nazioni;
	}
	
	
	@Override
	public String toString()
	{
		String s="";
		for(int i=0; i<nazioni.size(); i++)
		{
			s+=nazioni.get(i).toString()+"\n";
		}
		return s;
	}

	public static void main (String[] args)
	{
		Medagliere m=new Medagliere();
		Nazione n1=new Nazione("Francia");
		Nazione n2=new Nazione("Italia");
		Nazione n3=new Nazione("Macedonia");
		n1.addOro();
		n2.addArgento();
		n3.addBronzo();
		m.addNazione(n3);
		m.addNazione(n2);
		m.addNazione(n1);
		m.medagliereOrdinato();
		IO.out(m.toString());
	}
=======
		nazioni.sort(null);
		return nazioni;
	}
>>>>>>> origin/master
}