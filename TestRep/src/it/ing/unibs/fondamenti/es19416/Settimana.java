package it.ing.unibs.fondamenti.es19416;

public class Settimana 
{
	//Costanti
	public static final int NGIORNI=7;
	public static final double VMAX=75;
	public static final double VMED=50;
	//attributi
	private int anno;
	private int nSettimana;
	private double giorni[];
	//costruttore
	public Settimana(int anno, int nSettimana) 
	{
		this.anno = anno;
		this.nSettimana = nSettimana;
		giorni=new double[NGIORNI];
	}
	public Settimana(int anno, int nSettimana, double[] giorni)
	{
		this.anno = anno;
		this.nSettimana = nSettimana;
		this.giorni = giorni;
	}

	public Settimana()
	{
		//default
	}
	//funzioni
	public boolean isOverMax()
	{
		double max=giorni[0];
		for(int i=0;i<NGIORNI;i++)
		{
			if(max<=giorni[i])
			{
				max=giorni[i];
			}
		}
		if(max>VMAX)
			return true;
		return false;
	}
	public boolean isOverMed()
	{
		double med=0.0;
		for(int i=0;i<NGIORNI;i++)
		{
			med+=giorni[i];
		}
		med/=NGIORNI;
		if(med>VMED)
			return true;
		return false;
	}
	//getter e setter
	public void setGiorni(double[] giorni)
	{
		this.giorni = giorni;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public int getnSettimana() {
		return nSettimana;
	}
	public void setnSettimana(int nSettimana) {
		this.nSettimana = nSettimana;
	}
	public double[] getGiorni() {
		return giorni;
	}
	
}