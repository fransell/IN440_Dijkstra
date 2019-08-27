package it.uniroma3.Dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
	
	
	public void Inizializza(Grafo g){
		Set<Vertice> vertici = g.getVertici();
		Iterator<Vertice> verticiIterator = vertici.iterator();
		while(verticiIterator.hasNext()){
			Vertice verticeU = verticiIterator.next();
			verticeU.setDistanza(Integer.MAX_VALUE);
		}
	}
	
	public void rilassaArco(Vertice verticeU, Vertice verticeAdiacenteU,int pesoArco){
		if(verticeAdiacenteU.getDistanza() > verticeU.getDistanza() + pesoArco) {
			verticeAdiacenteU.setDistanza(verticeU.getDistanza() + pesoArco);
			LinkedList<Vertice> camminoMinimo = new LinkedList<>(verticeU.getCamminoMinimo());
			camminoMinimo.add(verticeU);
			verticeAdiacenteU.setCamminoMinimo(camminoMinimo);
		}					
	}
	
	private Vertice getMinDistanzaVertici(Set<Vertice> vertici){
		Vertice verticeMinDistanza = null;
		int minDistanza = Integer.MAX_VALUE;
		for (Vertice vertice : vertici) {
			int distVertice = vertice.getDistanza();
			if(distVertice <= minDistanza){
				minDistanza = distVertice;
				verticeMinDistanza = vertice;
			}
		}
		return verticeMinDistanza;
	}
	
	public Grafo DijkstraAlgoritmo(Grafo g, Vertice sorgente){
		Inizializza(g);
		sorgente.setDistanza(0);
		Set<Vertice> vertici = new HashSet<>();
		vertici.addAll(new HashSet<>(g.getVertici()));
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
					rilassaArco(verticeU, verticeAdiacenteU, pesoArco);
					
				}
			
		}
		return g;		
	}
}
