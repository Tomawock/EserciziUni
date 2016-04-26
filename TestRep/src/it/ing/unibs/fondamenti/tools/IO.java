package it.ing.unibs.fondamenti.tools;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;

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
	 * Crea il file 
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
	 * Permette la scrittura di una sringa su un file
	 * 
	 * @param file file destinazione su cui scrivere 
	 * @param testo strina che si vuole scrivere
	 */
	public static void scriviFile(File file,String testo)
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
	
	public static void main(String[] args)
	{	
		File f;
		//IO.outOnFrame("Ciaos");
		f=IO.apreCreaFile("src/File/test.txt");
		File f1=IO.apreCreaFile("src/File/test2.xls");
		IO.scriviFile(f, "Parte 1 \n");
		IO.scriviFile(f, "Parte 2 \n");
		//IO.scriviFile(f, null, true);
	}

}
