package it.ing.unibs.fondamenti.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IO 
{
		/**
		 * Funzione che permette la lettura da tastiera
		 * 
		 * @param b se falso chiude l'input altrimenti legge i dati
		 * @return str String di output letta da tstiera
		 */
		public String inKeyBoard(boolean b)
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
		 * Funzione che tampa a video i dati
		 */
		public void outScreen(Object s)
		{
			System.out.println(s);
		}

		public static void main(String[] args)
		{
			IO i=new IO();
			i.outScreen(i.inKeyBoard(true));
		}

}