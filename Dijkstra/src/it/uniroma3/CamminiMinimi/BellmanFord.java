package it.uniroma3.CamminiMinimi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import it.uniroma3.Grafo.Grafo;
import it.uniroma3.Grafo.Vertice;

public class BellmanFord extends CamminiMinimiDaSorgenteSingola{

	public Grafo BellmanFordAlgoritmo(Grafo g, Vertice sorgente) throws Exception{
		Set<Vertice> vertici = g.getVertici();
		if(vertici.isEmpty())
			throw new Exception("Il grafo è vuoto");
		sorgente.setDistanza(0);
		for(int i = 1; i < vertici.size(); i++ ){
			Iterator<Vertice> verticiIterator = vertici.iterator();
			while(verticiIterator.hasNext()){
				Vertice vertice = verticiIterator.next();
				Map<Vertice,Integer> verticiAdiacentiMap = new HashMap<Vertice,Integer>(vertice.getListaAdiacenza());
				for (Map.Entry<Vertice,Integer> entry : verticiAdiacentiMap.entrySet()){
					Vertice estremo = entry.getKey();
					int pesoArco = entry.getValue();
					if(vertice.getDistanza() != Integer.MAX_VALUE)
						rilassaArco(vertice, estremo, pesoArco);
					
				} 
			}
		}

		Iterator<Vertice> verticiIterator = vertici.iterator();
		while(verticiIterator.hasNext()){
			Vertice vertice = verticiIterator.next();
			Map<Vertice,Integer> verticiAdiacentiMap = new HashMap<Vertice,Integer>(vertice.getListaAdiacenza());
			for (Map.Entry<Vertice,Integer> entry : verticiAdiacentiMap.entrySet()){
				Vertice estremo = entry.getKey();
				int pesoArco = entry.getValue();
				if(estremo.getDistanza() > vertice.getDistanza() + pesoArco){
					throw new Exception("Presenza cicli negativi");
				}
				
			} 
		}
		return g;		
	}
}
