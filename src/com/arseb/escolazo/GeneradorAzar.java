package com.arseb.escolazo;

import java.util.Iterator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class GeneradorAzar {

	private GeneradorAzar() {
		// Evita instanciación.
	}

	/**
	 * El siguiente método permite obtener un número aleatorio.
	 * 
	 * @param maxNumber
	 *            define el valor máximo, inclusivo, que puede tener cada
	 *            número.
	 * @param minNumber
	 *            define el valor mínimo, inclusivo, que puede tener cada
	 *            número.
	 * @param howMany
	 *            define la cantidad de números a generar.
	 */
	public static String generarJuego(int minNumber, int maxNumber, int howMany) {

		if (howMany <= 0)
			return "";

		Random random = new Random();
		SortedSet<Integer> set = new TreeSet<Integer>();
		while (set.size() < howMany)
			set.add(minNumber + random.nextInt(Math.abs(maxNumber - minNumber)));

		Iterator<Integer> it = set.iterator();
		StringBuilder sb = new StringBuilder(it.next().toString());
		while (it.hasNext())
			sb.append(", ").append(it.next());
		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(GeneradorAzar.generarJuego(13, 40, 10));

	}
}
