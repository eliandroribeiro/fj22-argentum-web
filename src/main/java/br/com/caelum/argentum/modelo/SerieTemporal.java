package br.com.caelum.argentum.modelo;

import java.util.List;

public class SerieTemporal {

	private final List<Candlestick> candles;

	public SerieTemporal(List<Candlestick> candles) {
		if (candles == null) {
			throw new IllegalArgumentException(
					"O argumento 'candles' não pode ser nulo.");
		}
		this.candles = candles;
	}

	public Candlestick getCandle(int i) {
		return candles.get(i);
	}

	public int getTotal() {
		return candles.size();
	}
}
