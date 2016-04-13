package it.ing.unibs.fondamenti.es15316;

public class Retta 
{
	private Punto p1;
	private Punto p2;
	private double a;
	private double b;
	private String eq;
	
	public Retta(Punto p1, Punto p2) 
	{
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void creaRetta()
	{
		if(p2.getX()==p1.getX()&&p1.getY()==p2.getY())
		{
			//coincidenti
			eq="Errore";
			
		}else if(p2.getX()==p1.getX())
		{
			//parallelo y
			eq="x="+p2.getX();
		}
		else
		{
			//caso generico
			a=(p2.getY()-p1.getY())/(p2.getX()-p1.getX());
			b=p2.getY()-(a*p2.getX());
			eq="y="+a+"x+"+b+"|";
		}
	}
	
	public boolean appartiene(Punto p)
	{
		if(b==a*p.getX()-p.getY())
		{
			return true;
		}
		return false;
	}

	public String getEq() 
	{
		return eq;
	}
}
