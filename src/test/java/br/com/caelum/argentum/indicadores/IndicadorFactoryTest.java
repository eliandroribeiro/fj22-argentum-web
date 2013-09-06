package br.com.caelum.argentum.indicadores;

import junit.framework.Assert;

import org.junit.Test;

public class IndicadorFactoryTest {

	private static final String indicadorAbertura = "IndicadorAbertura";
	private static final String indicadorFechamento = "IndicadorFechamento";
	private static final String mediaMovelSimples = "MediaMovelSimples";
	private static final String mediaMovelPonderada = "MediaMovelPonderada";
	private static final int intervalo = 1;

	@Test
	public void deveFabricarIndicadorAbertura() {

		IndicadorFactory indicadorFactory = new IndicadorFactory(
				indicadorAbertura);
		Indicador indicador = indicadorFactory.getIndicador();

		Assert.assertTrue(indicador instanceof IndicadorAbertura);
	}

	@Test
	public void deveFabricarIndicadorAberturaComMediaMovelSimples() {

		IndicadorFactory indicadorFactory = new IndicadorFactory(
				indicadorAbertura, mediaMovelSimples, intervalo);
		Indicador indicador = indicadorFactory.getIndicador();

		Assert.assertTrue(indicador instanceof MediaMovelSimples);
	}

	@Test
	public void deveFabricarIndicadorAberturaComMediaMovelPonderada() {

		IndicadorFactory indicadorFactory = new IndicadorFactory(
				indicadorAbertura, mediaMovelPonderada, intervalo);
		Indicador indicador = indicadorFactory.getIndicador();

		Assert.assertTrue(indicador instanceof MediaMovelPonderada);
	}

	@Test
	public void deveFabricarIndicadorFechamento() {

		IndicadorFactory indicadorFactory = new IndicadorFactory(
				indicadorFechamento);
		Indicador indicador = indicadorFactory.getIndicador();

		Assert.assertTrue(indicador instanceof IndicadorFechamento);
	}

	@Test
	public void deveFabricarIndicadorFechamentoComMediaMovelSimples() {

		IndicadorFactory indicadorFactory = new IndicadorFactory(
				indicadorFechamento, mediaMovelSimples, intervalo);
		Indicador indicador = indicadorFactory.getIndicador();

		Assert.assertTrue(indicador instanceof MediaMovelSimples);
	}

	@Test
	public void deveFabricarIndicadorFechamentoComMediaMovelPonderada() {

		IndicadorFactory indicadorFactory = new IndicadorFactory(
				indicadorFechamento, mediaMovelPonderada, intervalo);
		Indicador indicador = indicadorFactory.getIndicador();

		Assert.assertTrue(indicador instanceof MediaMovelPonderada);
	}
}
