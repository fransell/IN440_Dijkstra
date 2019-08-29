package it.uniroma3.Grafo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
	
	public Map<String,Vertice> riempiGrafo(Grafo grafo, LinkedList<Arco> archi){
		Map<String,Vertice> verticiMap = new HashMap<>();
		Iterator<Arco> archiIterator = archi.iterator();
		while (archiIterator.hasNext()) {
			Arco arco = archiIterator.next();
			Vertice estremoA = arco.getVertEstremoA();
			String nomeEstremoA = estremoA.getNome();
			Vertice estremoB = arco.getVertEstremoB();
			String nomeEstremoB = estremoB.getNome();
			if(!verticiMap.containsKey(nomeEstremoA))
				verticiMap.put(nomeEstremoA, estremoA);
			else 
				estremoA = verticiMap.get(arco.getEstremoA());
				
			if(!verticiMap.containsKey(nomeEstremoB))
				verticiMap.put(nomeEstremoB, estremoB);
			else
				estremoB = verticiMap.get(arco.getEstremoB());
			int peso = arco.getPeso();
			estremoA.addArco(estremoB, peso);
		}
		
		for (Map.Entry<String,Vertice> entry : verticiMap.entrySet()){
			grafo.addVertice(entry.getValue());
		}
		return verticiMap;
	}
	
	public void stampaGrafo(Set<Vertice> vertici){
		Vertice verticeAdiacente;
		String listaAdiacenza = "";
		Map<Vertice,Integer> verticiAdiacentiMap = new HashMap<Vertice,Integer>();
		Set<Vertice> verticiAdiacenti= new HashSet<>();
		Iterator<Vertice> verticiIterator = vertici.iterator();
		while(verticiIterator.hasNext()){
			Vertice verticeU = verticiIterator.next();
			listaAdiacenza = "Lista di adiacenza di "+verticeU.getNome()+":\n "+verticeU.getNome();
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
	
	public void stampaCammini(Set<Vertice> vertici,Vertice sorgente){
		Iterator<Vertice> verticiIterator = vertici.iterator();
		while(verticiIterator.hasNext()){
			Vertice verticeU = verticiIterator.next();
			String cammino = "";
			LinkedList<Vertice> camminoMinimo = verticeU.getCamminoMinimo();
			Iterator<Vertice> camminoMinimoIterator = camminoMinimo.iterator();
			while(camminoMinimoIterator.hasNext()){
				Vertice verticeSuccessivo = camminoMinimoIterator.next();
				int distanza = verticeSuccessivo.getDistanza();
				cammino = cammino + verticeSuccessivo.getNome() + " ("+distanza+")"+ " -> ";
				
			}
			cammino = cammino + verticeU.getNome() + " ("+verticeU.getDistanza()+")";
			System.out.println("Cammino minimo dal vertice "+sorgente.getNome()+" al vertice "+verticeU.getNome()+"\n"+ cammino);
		} 
	}
	
}
