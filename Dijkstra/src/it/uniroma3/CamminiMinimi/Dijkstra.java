package it.uniroma3.CamminiMinimi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import it.uniroma3.Grafo.Grafo;
import it.uniroma3.Grafo.Vertice;

public class Dijkstra extends CamminiMinimiDaSorgenteSingola{

	public Grafo DijkstraAlgoritmo(Grafo g, Vertice sorgente) throws Exception{
		Set<Vertice> vertici = new HashSet<>(g.getVertici());
		if(vertici.isEmpty())
			throw new Exception("Il grafo è vuoto");
		sorgente.setDistanza(0);
		while(!vertici.isEmpty()){
			Vertice verticeU = getMinDistanzaVertici(vertici);
			vertici.remove(verticeU);
			Map<Vertice,Integer> verticiAdiacentiUMap = new HashMap<Vertice,Integer>();
			Set<Vertice> verticiAdiacentiU = new HashSet<Vertice>();
			verticiAdiacentiUMap = verticeU.getListaAdiacenza();
			verticiAdiacentiU = verticiAdiacentiUMap.keySet();
			Iterator<Vertice> verticiAdiacentiUIterator = verticiAdiacentiU.iterator();
				while(verticiAdiacentiUIterator.hasNext()) {
					Vertice verticeAdiacenteU = verticiAdiacentiUIterator.next();
					int pesoArco = verticiAdiacentiUMap.get(verticeAdiacenteU);
					if(pesoArco <= 0)
						throw new Exception("L'algoritmo di Dijkstra si applica su grafi con archi di peso positivo");
					rilassaArco(verticeU, verticeAdiacenteU, pesoArco);
					
				}			
		}
		return g;		
	}
}
