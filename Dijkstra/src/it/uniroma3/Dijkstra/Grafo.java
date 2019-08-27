package it.uniroma3.Dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	private Set<Vertice> vertici = new HashSet<>();
	
	public void addVertice(Vertice vertice){
		vertici.add(vertice);
	}

	public Set<Vertice> getVertici() {
		return vertici;
	}

	public void setVertici(Set<Vertice> vertici) {
		this.vertici = vertici;
	}
	
	public void stampaGrafo(Set<Vertice> vertici){
		Vertice verticeAdiacente;
		String listaAdiacenza;
		Map<Vertice,Integer> verticiAdiacentiMap = new HashMap<Vertice,Integer>();
		Set<Vertice> verticiAdiacenti= new HashSet<>();
		Iterator<Vertice> verticiIterator = vertici.iterator();
		while(verticiIterator.hasNext()){
			Vertice verticeU = verticiIterator.next();
			listaAdiacenza = verticeU.getNome();
			verticiAdiacentiMap = verticeU.getListaAdiacenza();
			verticiAdiacenti = verticiAdiacentiMap.keySet();
			Iterator<Vertice> verticiAdiacentiIterator = verticiAdiacenti.iterator();
			while(verticiAdiacentiIterator.hasNext()){
				verticeAdiacente = verticiAdiacentiIterator.next();
				String nomeVerticeAdiacente = verticeAdiacente.getNome();
				int pesoArco = verticiAdiacentiMap.get(verticeAdiacente);
				listaAdiacenza = listaAdiacenza + " -> " + nomeVerticeAdiacente +" ("+ pesoArco +")";
			}
			System.out.println(listaAdiacenza);
		} 
	}
	
	public void stampaCammini(Set<Vertice> vertici  ){
		Iterator<Vertice> verticiIterator = vertici.iterator();
		while(verticiIterator.hasNext()){
			Vertice verticeU = verticiIterator.next();
			String cammino = "";
			LinkedList<Vertice> camminoMinimo = verticeU.getCamminoMinimo();
			Iterator<Vertice> camminoMinimoIterator = camminoMinimo.iterator();
			while(camminoMinimoIterator.hasNext()){
				Vertice verticeSuccessivo = camminoMinimoIterator.next();
				int distanza = verticeSuccessivo.getDistanza();
				cammino = cammino + verticeSuccessivo.getNome() + " ("+distanza+")"+ " - ";
				
			}
			cammino = cammino + verticeU.getNome() + " ("+verticeU.getDistanza()+")";
			System.out.println(cammino);
		} 
	}
	
}
