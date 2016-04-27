package it.ing.unibs.fondamenti.tools;


import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO 
{	
	/**
	 * Funzione che permette la lettura da tastiera
	 * 
	 * @param b se falso chiude l'input altrimenti legge i dati
	 * @return str String di output letta da tstiera
	 */
	public static String inKeyBoard(boolean b)
	{
		 InputStreamReader reader = new InputStreamReader (System.in);
         BufferedReader myInput = new BufferedReader (reader);
         String str= new String();
         try
         {
        	 if(b==true)
        	 {
        		 str = myInput.readLine(); 
        	 }
        	 else
        	 {
        		 myInput.close();
        	 }
         }catch(Exception e)
         {
        	 System.out.println("ERRORE "+e);
         }
         return str;
	}

	/**
	 * Funzione che stampa a video i dati
	 */
	public static void out(Object s)
	{
		System.out.println(s);
	}
	
	/**
	 * Crea il file , se è gia presente non fa nulla
	 * 
	 * @param percorso di destinazione del file
	 * @return il file creato
	 */
	public static File apreCreaFile(String percorso)
	{
		File file = new File(percorso);	
	    try 
	    {
	    	if (!file.exists())
			{
	    		file.createNewFile();
	    		IO.out("File creato in "+percorso);
			}
			else 
				IO.out("non è possibile crare il file in "+percorso);
		} catch (IOException e)
	    {
			IO.out(e);
		}
	    
	    return file;
	}
	
	/**
	 * Permette la scrittura di una sringa su un file txt
	 * 
	 * @param file file destinazione su cui scrivere 
	 * @param testo strina che si vuole scrivere
	 */
	public static void scriviFileTxt(File file,String testo)
	{
		try 
		{
			FileWriter fw = new FileWriter(file.getCanonicalFile(),true);
			fw.write(testo);
			fw.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}

	/**
	 * Legge i dati presenti in un file txt e li restituisce in output come una stringa
	 * @param file da cui legge i dati
	 * @return stringa di dati presenti nel file
	 */
	public static String leggiFileTxt(File file)
	{
		String str="";
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) 
			{
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			str=stringBuffer.toString();

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return str;
	}
	
	/**
	 * Elimina tutti i dati presenti su unu file txt
	 * 
	 * @param file da svuotare
	 */
	public static void svuotaFileTxt(File file)
	{
		try 
		{
			FileWriter fw = new FileWriter(file.getCanonicalFile(),false);
			fw.write("");
			fw.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args)
	{	
		File f;
		//IO.outOnFrame("Ciaos");
		//f=IO.apreCreaFile("src/File/test.txt");
		f=IO.apreCreaFile("src/File/test2.xls");
		IO.svuotaFileTxt(f);
		IO.scriviFileTxt(f, "P XXX LOL \n");
		IO.scriviFileTxt(f, "PP \n");
		IO.out(IO.leggiFileTxt(f));
	}

}
