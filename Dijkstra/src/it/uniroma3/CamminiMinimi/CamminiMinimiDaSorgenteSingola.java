package it.uniroma3.CamminiMinimi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import it.uniroma3.Grafo.Vertice;

public class CamminiMinimiDaSorgenteSingola {

	public void rilassaArco(Vertice verticeU, Vertice verticeAdiacenteU,int pesoArco){
		if(verticeAdiacenteU.getDistanza() > verticeU.getDistanza() + pesoArco) {
			verticeAdiacenteU.setDistanza(verticeU.getDistanza() + pesoArco);
			LinkedList<Vertice> camminoMinimo = new LinkedList<>(verticeU.getCamminoMinimo());
			camminoMinimo.add(verticeU);
			verticeAdiacenteU.setCamminoMinimo(camminoMinimo);
		}						
	}
	
	public Vertice getMinDistanzaVertici(Set<Vertice> vertici){
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
}
