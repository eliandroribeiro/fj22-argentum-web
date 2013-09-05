package br.com.caelum.argentum.indicadores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class GeradorDeSerie {

	public static SerieTemporal criaSerie(int... valores) {
		List<Candlestick> candles = new ArrayList<Candlestick>();
		for (double valor : valores) {
			candles.add(new Candlestick(valor, valor, valor, valor, 10000,
					Calendar.getInstance()));
		}
		return new SerieTemporal(candles);
	}
}
