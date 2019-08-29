package it.uniroma3.Grafo;

public class Arco {
	
	Vertice estremoA;
	Vertice estremoB;
	Integer peso;
	
	public Arco(String u, String v, Integer peso){
		this.estremoA = new Vertice(u);
		this.estremoB = new Vertice(v);
		this.peso = peso;
	}

	public String getEstremoA() {
		return estremoA.getNome();
	}

	public String getEstremoB() {
		return estremoB.getNome();
	}
	
	public Vertice getVertEstremoA() {
		return estremoA;
	}

	public Vertice getVertEstremoB() {
		return estremoB;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
}
