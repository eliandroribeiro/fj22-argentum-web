package br.com.caelum.argentum.indicadores;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderadaTest {

	private static final double delta = 0.00001;

	@Test
	public void sequenciaSimplesDeCandles() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6);
		MediaMovelPonderada mmp = new MediaMovelPonderada(3, new IndicadorFechamento());

		Assert.assertEquals(14.0 / mmp.getPonderacao(), mmp.calcula(2, serie),
				delta);
		Assert.assertEquals(20.0 / mmp.getPonderacao(), mmp.calcula(3, serie),
				delta);
		Assert.assertEquals(26.0 / mmp.getPonderacao(), mmp.calcula(4, serie),
				delta);
		Assert.assertEquals(32.0 / mmp.getPonderacao(), mmp.calcula(5, serie),
				delta);
	}
}
