package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

	private final int ponderacao;
	private Indicador outroIndicador;

	public MediaMovelPonderada(int intervalo, Indicador outroIndicador) {
		if (intervalo < 1) {
			throw new IllegalArgumentException(
					"O 'intervalo' deve ser maior que 0.");
		}
		ponderacao = calcularPonderacao(intervalo);
		this.outroIndicador = outroIndicador;
	}

	public int getPonderacao() {
		return ponderacao;
	}

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		int peso = 1;

		for (int i = posicao - 2; i <= posicao; i++) {
			soma += outroIndicador.calcula(i, serie) * peso;
			peso++;
		}
		return soma / ponderacao;
	}

	@Override
	public String toString() {
		return "MMP de " + outroIndicador;
	}

	private int calcularPonderacao(int intervalo) {
		int ponderacao = intervalo--;
		while (intervalo > 0) {
			ponderacao += intervalo--;
		}
		return ponderacao;
	}
}
