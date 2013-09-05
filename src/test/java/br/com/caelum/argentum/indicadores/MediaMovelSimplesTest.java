package br.com.caelum.argentum.indicadores;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimplesTest {

	private static final double delta = 0.00001;

	@Test
	public void deveCalcularPeloFechamento() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 3, 4, 5, 4,
				3);
		Indicador mms = new MediaMovelSimples(3, new IndicadorFechamento());

		Assert.assertEquals(2.0, mms.calcula(2, serie), delta);
		Assert.assertEquals(3.0, mms.calcula(3, serie), delta);
		Assert.assertEquals(10.0 / 3, mms.calcula(4, serie), delta);
		Assert.assertEquals(11.0 / 3, mms.calcula(5, serie), delta);
		Assert.assertEquals(4.0, mms.calcula(6, serie), delta);
		Assert.assertEquals(13.0 / 3, mms.calcula(7, serie), delta);
		Assert.assertEquals(4.0, mms.calcula(8, serie), delta);
	}

	@Test
	public void deveCalcularPelaAbertura() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 3, 4, 5, 4,
				3);
		Indicador mms = new MediaMovelSimples(3, new IndicadorAbertura());

		Assert.assertEquals(2.0, mms.calcula(2, serie), delta);
		Assert.assertEquals(3.0, mms.calcula(3, serie), delta);
		Assert.assertEquals(10.0 / 3, mms.calcula(4, serie), delta);
		Assert.assertEquals(11.0 / 3, mms.calcula(5, serie), delta);
		Assert.assertEquals(4.0, mms.calcula(6, serie), delta);
		Assert.assertEquals(13.0 / 3, mms.calcula(7, serie), delta);
		Assert.assertEquals(4.0, mms.calcula(8, serie), delta);
	}
}
