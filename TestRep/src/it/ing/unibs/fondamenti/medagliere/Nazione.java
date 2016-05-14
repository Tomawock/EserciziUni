package it.ing.unibs.fondamenti.medagliere;

import java.util.Comparator;

public class Nazione implements Comparable
{
	private String nome;
	private int ori;
	private int argenti;
	private int bronzi;

	public Nazione(String nome) 
	{
		this.nome = nome;
		ori=0;
		argenti=0;
		bronzi=0;
	}
	public String getNome()
	{
		return nome;
	}
	public void addOro()
	{
		ori++;
	}
	public void addArgento()
	{
		argenti++;
	}
	public void addBronzo()
	{
		bronzi++;
	}
	
	public int getOri()
	{
		return ori;
	}
	public int getArgenti()
	{
		return argenti;
	}
	public int getBronzi()
	{
		return bronzi;
	}
	
	@Override
	public int compareTo(Nazione o) 
	{
		Nazione n=(Nazione)o;
		if(this.ori>n.getOri())
		{
			return 1;
		}
		else if(this.ori<n.getOri())
		{
			return -1;
		}
		else
		{
			if(this.argenti>n.getArgenti())
			{
				return 1;
			}
			else if(this.argenti<n.getArgenti())
			{
				return -1;
			}
			else
			{
				if(this.bronzi>n.getBronzi())
				{
					return 1;
				}
				else if(this.bronzi<n.getBronzi())
				{
					return -1;
				}
			}
			
		}
		return 0;
	}
	@Override
	public String toString() {
		return "Nazione [nome=" + nome + ", ori=" + ori + ", argenti=" + argenti + ", bronzi=" + bronzi + "]";
	}
	
	
}
