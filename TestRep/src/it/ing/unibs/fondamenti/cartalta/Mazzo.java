package it.ing.unibs.fondamenti.cartalta;

import java.util.ArrayList;

import it.ing.unibs.fondamenti.tools.IO;
import it.ing.unibs.fondamenti.tools.myMath;

public class Mazzo 
{
	public static final String[] FR_SEGNO={"Quadri","Cuori","Fiori","Picche"};
	public static final String[] FR_NOME={"Asso","Due","Tre","Quattro","Cinque","Sei","Sette","Otto","Nove","Dieci","Jack","Donna","Re"};
	public static final String[] IT_SEGNO={"Bastoni","Coppe","Ori","Spade"};
	public static final String[] IT_NOME={"Asso","Due","Tre","Quattro","Cinque","Sei","Sette","Otto","Nove","Dieci","Fante","Cavallo","Re"};
	
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
		for(int i=0;i<Mazzo.IT_SEGNO.length;i++)
		{
			for(int j=0;j<Mazzo.IT_NOME.length;j++)
			{
				carte.add(new Carta(Mazzo.IT_NOME[j],Mazzo.IT_SEGNO[i]));
			}
		}
		
	}

	public Carta scarta()
	{
		int rand=myMath.randInt(0, carte.size()-1);
		Carta ret=new Carta(carte.get(rand));
		carte.remove(rand);
		return ret;
	}
	
	public void mostraCarteScreen()
	{
		for(int i=0;i<carte.size();i++)
		{
			IO.out(carte.get(i).toString()+"\n");
		}
	}
	
	public int carteRimanenti()
	{
		return carte.size();
	}
	
	
	
}
