package br.com.caelum.argentum.indicadores;

import java.lang.reflect.Constructor;

public class IndicadorFactory {
	private static final String pacoteIndicadores = "br.com.caelum.argentum.indicadores.";
	private String nomeIndicador;
	private String nomeMedia;
	private int intervalo;

	public IndicadorFactory(String nomeIndicador) {
		this.nomeIndicador = nomeIndicador;
	}

	public IndicadorFactory(String nomeIndicador, String nomeMedia,
			int intervalo) {
		this.nomeIndicador = nomeIndicador;
		this.nomeMedia = nomeMedia;
		this.intervalo = intervalo;
	}

	public Indicador getIndicador() {
		try {
			Indicador indicador = (Indicador) Class.forName(
					pacoteIndicadores + nomeIndicador).newInstance();

			if (nomeMedia != null && !nomeMedia.isEmpty()) {
				Constructor<?> constructor = Class.forName(
						pacoteIndicadores + nomeMedia).getConstructor(
						int.class, Indicador.class);

				indicador = (Indicador) constructor.newInstance(intervalo,
						indicador);
			}
			return indicador;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
