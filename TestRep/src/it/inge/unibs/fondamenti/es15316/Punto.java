package it.inge.unibs.fondamenti.es15316;

public class Punto 
{
	private double x;
	private double y;
	
	public Punto(double x, double y) 
	{
		this.x = x;
		this.y = y;
	}

	public Punto()
	{
		//Default
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	//fine auto code
	public double dist(Punto p2)
	{		
		return Math.sqrt(Math.pow(p2.getX()-x,2)+Math.pow(p2.getY()-y,2));
	}
}
