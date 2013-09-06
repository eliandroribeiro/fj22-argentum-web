package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {

	private final int intervalo;
	private Indicador outroIndicador;

	public MediaMovelSimples(int intervalo, Indicador outroIndicador) {
		if (intervalo < 1) {
			throw new IllegalArgumentException(
					"O 'intervalo' deve ser maior que 0.");
		}
		this.intervalo = intervalo;
		this.outroIndicador = outroIndicador;
	}

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		for (int i = posicao - 2; i <= posicao; i++) {
			soma += outroIndicador.calcula(i, serie);
		}
		return soma / intervalo;
	}

	@Override
	public String toString() {
		return "MMS de " + outroIndicador;
	}
}
