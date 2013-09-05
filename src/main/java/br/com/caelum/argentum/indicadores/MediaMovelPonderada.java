package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		int peso = 1;

		for (int i = posicao - 2; i <= posicao; i++) {
			soma += serie.getCandle(i).getFechamento() * peso;
			peso++;
		}
		return soma / 6;
	}

	@Override
	public String toString() {
		return "MMP de Fechamento";
	}
}
