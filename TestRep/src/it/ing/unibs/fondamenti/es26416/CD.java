package it.ing.unibs.fondamenti.es26416;

import java.util.ArrayList;

public class CD 
{
	private String titolo;
	private String autore;
	private ArrayList<Brano> brani;
	
	public CD(String titolo, String autore)
	{
		super();
		this.titolo = titolo;
		this.autore = autore;
		brani=new ArrayList<Brano>();
	}
	
	public void addSong(Brano b)
	{
		boolean test=true;
		for(int i=0;i<brani.size();i++)
		{
			if(brani.get(i).getNome().equalsIgnoreCase(b.getNome()))
			{
				test=false;
			}
		}
		if(test)
			brani.add(b);
	}
	
	public boolean remSong(String nome)
	{
		int p=-1;
		for(int i=0;i<brani.size();i++)
		{
			if(brani.get(i).getNome().equalsIgnoreCase(nome))
			{
				p=i;
			}
		}
		if(p==-1)
		{
			return false;
		}
		else
		{
			brani.remove(p);
			return true;
		}
	}
	
	
	
}
