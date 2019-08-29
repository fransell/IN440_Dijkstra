package it.uniroma3.Grafo;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

import it.uniroma3.Grafo.*;

public class LetturaDatiFile {
	
	LinkedList<Arco> archi = new LinkedList<Arco>();
	Arco arco;
	String[] arcoString = new String[3];
	
	public LinkedList<Arco> leggiFile(String percorso) throws Exception{
		BufferedReader filebuf = new BufferedReader(new FileReader(percorso)); 
		String riga;
		riga = filebuf.readLine();
		int i;
		while(riga != null) {
			StringTokenizer st = new StringTokenizer(riga, ",");
			i = 0;
			while (st.hasMoreTokens()) {
				arcoString[i] = st.nextToken();
				i++;
			}
			if(arcoString.length != 3 || !isNumeric(arcoString[2]))
				throw new Exception(riga+" non corretta");
			arco = new Arco(arcoString[0],arcoString[1],Integer.valueOf(arcoString[2]));
 			archi.add(arco);
			riga = filebuf.readLine();
		}
		filebuf.close();
		return archi;
	}
	
	public boolean isNumeric(String str) {
		boolean isNum = true;
		for(int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) 
				isNum = false;
		}
		return isNum;
	}
	
}
