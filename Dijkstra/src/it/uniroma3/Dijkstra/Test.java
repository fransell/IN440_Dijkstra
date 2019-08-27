package it.uniroma3.Dijkstra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		
		Vertice verticeS = new Vertice("S");
		Vertice verticeT = new Vertice("T");
		Vertice verticeX = new Vertice("X");
		Vertice verticeY = new Vertice("Y");
		Vertice verticeZ = new Vertice("Z");
		
		verticeS.addArco(verticeT, 10);
		verticeS.addArco(verticeY, 5);
		
		verticeT.addArco(verticeX, 1);
		verticeT.addArco(verticeY, 2);
		
		verticeX.addArco(verticeZ, 4);
		
		verticeZ.addArco(verticeX, 6);
		verticeZ.addArco(verticeS, 7);
		
		verticeY.addArco(verticeT, 3);
		verticeY.addArco(verticeX, 9);
		verticeY.addArco(verticeZ, 2);
		
		grafo.addVertice(verticeS);
		grafo.addVertice(verticeT);
		grafo.addVertice(verticeX);
		grafo.addVertice(verticeZ);
		grafo.addVertice(verticeY);
		
		grafo.stampaGrafo(grafo.getVertici());
		Dijkstra dijkstra = new Dijkstra();
		grafo = dijkstra.DijkstraAlgoritmo(grafo, verticeS);
		Set<Vertice> camminiMinimiVertici = new HashSet<>(grafo.getVertici());
		camminiMinimiVertici.remove(verticeS);
		grafo.stampaCammini(camminiMinimiVertici);
	}

}


