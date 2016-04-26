package it.ing.unibs.fondamenti.es26416;

public class Brano 
{
	private String nome;
	private String durata;
	
	public Brano(String nome, String durata) 
	{
		super();
		this.nome = nome;
		this.durata = durata;
	}

	@Override
	public String toString() 
	{
		return "Nome=" + nome + " Durata=" + durata ;
	}

	public String getNome() 
	{
		return nome;
	}
	
}
