package it.uniroma3.Dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Vertice {

		private String nome;
		
		private LinkedList<Vertice> camminoMinimo = new LinkedList<>();
		
		private Integer distanza;
		
		private Map<Vertice,Integer> listaAdiacenza = new HashMap<>();
		

		public Vertice(String nome){
			this.nome = nome;
		}
	
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public LinkedList<Vertice> getCamminoMinimo() {
			return camminoMinimo;
		}

		public void setCamminoMinimo(LinkedList<Vertice> camminoMinimo) {
			this.camminoMinimo = camminoMinimo;
		}

		public Integer getDistanza() {
			return distanza;
		}

		public void setDistanza(Integer distanza) {
			this.distanza = distanza;
		}

		public Map<Vertice, Integer> getListaAdiacenza() {
			return listaAdiacenza;
		}

		public void setListaAdiacenza(Map<Vertice, Integer> listaAdiacenza) {
			this.listaAdiacenza = listaAdiacenza;
		}
		
		public void addArco(Vertice estremoArco, int peso){
			listaAdiacenza.put(estremoArco, peso);
		}
		
}
