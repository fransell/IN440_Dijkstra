package it.uniroma3.Test;

import java.awt.print.Printable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.CamminiMinimi.*;
import it.uniroma3.Grafo.Arco;
import it.uniroma3.Grafo.Grafo;
import it.uniroma3.Grafo.LetturaDatiFile;
import it.uniroma3.Grafo.Vertice;

public class Test {

	public static void main(String[] args) throws IOException {
		//Acquisizione degli archi del grafo da file
		String percorso = args[0];
		LetturaDatiFile ldf = new LetturaDatiFile();
		LinkedList<Arco> archi = new LinkedList<Arco>();
		try {
			archi = ldf.leggiFile(percorso);

			Grafo grafo = new Grafo();
			Map<String,Vertice> verticiMap = new HashMap<>();
			verticiMap = grafo.riempiGrafo(grafo,archi);
						
			grafo.stampaGrafo(grafo.getVertici());
			
			if(args[1].equals("Dijkstra")) {
				
				System.out.println("\nDijkstra\n");
				
				Dijkstra dijkstra = new Dijkstra();
				grafo = dijkstra.DijkstraAlgoritmo(grafo, verticiMap.get("S"));
				Set<Vertice> verticiSet = new HashSet<>(grafo.getVertici());
				verticiSet.remove(verticiMap.get("S"));
				grafo.stampaCammini(verticiSet,verticiMap.get("S"));
			}else if(args[1].equals("BellmanFord")) {
				
				System.out.println("\nBellmanFord\n");
				
				BellmanFord bellmanFord = new BellmanFord();
				grafo = bellmanFord.BellmanFordAlgoritmo(grafo, verticiMap.get("S"));
				Set<Vertice> verticiSet = new HashSet<>(grafo.getVertici());
				verticiSet.remove(verticiMap.get("S"));
				grafo.stampaCammini(verticiSet ,verticiMap.get("S"));
				
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}


