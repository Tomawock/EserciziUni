package it.ing.unibs.fondamenti.cartalta;

import java.util.ArrayList;

import it.ing.unibs.fondamenti.tools.IO;
import it.ing.unibs.fondamenti.tools.myMath;

public class Mazzo 
{
	public static final String[] FR_SEGNO={"Quadri","Cuori","Fiori","Picche"};
	public static final String[] FR_NOME={"Asso","Due","Tre","Quattro","Cinque","Sei","Sette","Otto","Nove","Dieci","Fante","Donna","Re"};
	
	private ArrayList<Carta> carte;
	
	public Mazzo(String tipo)
	{
		carte=new ArrayList<>();
		if(tipo.equalsIgnoreCase("IT"))
		{
			creaMazzoIT();
		}
		else
			creaMazzoFR();
	}
	
	private void creaMazzoFR()
	{
		for(int i=0;i<Mazzo.FR_SEGNO.length;i++)
		{
			for(int j=0;j<Mazzo.FR_NOME.length;j++)
			{
				carte.add(new Carta(Mazzo.FR_NOME[j],Mazzo.FR_SEGNO[i]));
			}
		}
	}
	
	private void creaMazzoIT()
	{
		// TODO Auto-generated method stub
		
	}

	public Carta scarta()
	{
		int rand=myMath.randInt(0, 51);
		Carta ret=new Carta(carte.get(rand));
		carte.remove(rand);
		return ret;
	}
	
	public void mostraCarte()
	{
		for(int i=0;i<carte.size();i++)
		{
			IO.out(carte.get(i).toString()+"\n");
		}
	}
	
	public static void main(String[] args)
	{
		Mazzo m=new Mazzo("");
		m.mostraCarte();
	}
	
}
