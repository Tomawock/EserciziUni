package it.ing.unibs.fondamenti.medagliere;

public class Gara
{
	private String nome;
	private Nazione[] podio;
	
	public Gara(String nome) 
	{
		this.nome = nome;
		podio=new Nazione[2];
	}
	
	public void setPodio(Nazione oro,Nazione arg,Nazione brz )
	{
		podio[0]=oro;
		podio[1]=arg;
		podio[2]=brz;
		oro.addOro();
		arg.addArgento();
		brz.addBronzo();
	}

	public String getNome() {
		return nome;
	}
	
	
	

}
