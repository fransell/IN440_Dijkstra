package it.uniroma3.Grafo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Vertice {

		private String nome;
		
		private LinkedList<Vertice> camminoMinimo = new LinkedList<>();
		
		private Integer distanza = Integer.MAX_VALUE;
		
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
		
		//override metodi di uguaglianza: due vertici sono uguali se denominati dallo stesso nome
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertice other = (Vertice) obj;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			return true;
		}

}
