package it.ing.unibs.fondamenti.cartalta;

import it.ing.unibs.fondamenti.tools.IO;

public class Carta 
{
	private String nomeCarta;
	private String segno;
	private int punteggio;
	
	public Carta(String nomeCarta, String segno) 
	{
		this.nomeCarta = nomeCarta;
		this.segno = segno;
		this.setPunteggio();
	}
	
	public Carta(Carta c)
	{
		this.nomeCarta = c.getNomeCarta();
		this.segno = c.getSegno();
		this.setPunteggio();
	}
	
	private void setPunteggio()
	{
		for(int i=0;i<Mazzo.FR_NOME.length;i++)
		{
			if(nomeCarta.equalsIgnoreCase(Mazzo.FR_NOME[i]))
			{
				switch(i)
				{
					case 0:{
						punteggio=14;
						break;
					}
					case 10:{
						punteggio=11;
						break;
					}
					case 11:{
						punteggio=12;
						break;
					}
					case 12:{
						punteggio=13;
						break;
					}
					default:{
						punteggio=i+1;
						break;
					}
				}
			}
		}
	}
	
	

	@Override
	public String toString()
	{
		return nomeCarta + " segno=" + segno + " punteggio=" + punteggio;
	}

	public String getNomeCarta() {
		return nomeCarta;
	}

	public String getSegno() {
		return segno;
	}

	public int getPunteggio() {
		return punteggio;
	}
}
