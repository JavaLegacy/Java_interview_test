package servico;

import dominio.Cidade;

public class CidadeVO {
	
	private Cidade cidade1;
	private Cidade cidade2;
	
	private Double distancia;

	public Cidade getCidade1() {
		return cidade1;
	}

	public void setCidade1(Cidade cidade1) {
		this.cidade1 = cidade1;
	}

	public Cidade getCidade2() {
		return cidade2;
	}

	public void setCidade2(Cidade cidade2) {
		this.cidade2 = cidade2;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
}
