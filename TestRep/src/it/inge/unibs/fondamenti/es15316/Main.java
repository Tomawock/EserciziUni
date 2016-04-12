package it.inge.unibs.fondamenti.es15316;


public class Main 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("SONO UN REPOSTORY WOW");
		Punto p1=new Punto(1,1);
		Punto p2=new Punto(2,2);
		Punto p3=new Punto(3,3);
		Retta r=new Retta(p1,p2);
		r.creaRetta();
		System.out.println(r.getEq()+"--------"+p1.dist(p2)+"CCC"+r.appartiene(p3));
		
	}
}
