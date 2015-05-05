package com.arseb.escolazo;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class GeneradorAzar {
	
	// El siguiente método permite obtener un número aleatorio.
	// TODO: crear un array de números, ordenarlos y luego pasarlos a la cadena.
	public CharSequence testRandomNumber(int minNumber, int maxNumber, int howMany) {
		StringBuffer strAux=new StringBuffer("");
		// Si el parámetro howMany es igual o mayor a uno...
		if (howMany > 0) {
			Set<Integer> mySet = new TreeSet<Integer>();
			// obtenemos una serie de números aleatorios.
			mySet = GenerateRandomNumbers(minNumber, maxNumber, howMany);
			Iterator<Integer> iter = mySet.iterator();
			while(iter.hasNext()){
				strAux.append(iter.next());
				// Añadimos una coma y un espacio para separar los números ya ordenados.
				strAux.append(", ");
			}
			// Eliminamos la última coma y espacio.
			strAux.delete(strAux.length()- 2, strAux.length());
		}
		// Armamos la cadena que finalmente se mostrará.

		return strAux.toString();
	}
	
	private Set<Integer> GenerateRandomNumbers(int minValue, int maxValue, int howMany){
		// Este método devuelve un array, ordenado, de valores pseudoaleatorios
		// únicos.
		// maxValue define el valor máximo, inclusivo, que puede tener cada número.
		// minValue define el valor mínimo, inclusivo, que puede tener cada número.
		// howMany define la cantidad de números a generar.
		Random myRandomGenerator = new Random();
		// Creamos un TreeSet para evitar luego que los mismos se repitan.
		Set<Integer> mySet = new TreeSet<Integer>();
		// Chequeamos si los valores mínimos y máximos son distintos entre sí,
		// si maxValue es mayor a minValue y si howMany es mayor a cero.
		if ( howMany > 0 && maxValue > minValue ){
			// Random.nextInt(int n) devuelve un valor acotado entre {0; n-1}.
			// Es necesario calcular, en base a esto, cuál es el "decalaje"
			// necesario para obtener los intervalos dados.
			// Esta variable almacenará la distancia entre minValue y maxValue.
			int intDistance = maxValue - minValue;
			// Verificamos que la cantidad de números solicitados sea menor o igual al rango:
			if (intDistance >= howMany) {
				int intAux = 0;
				// Ingresamos al bucle de generación de números.
				while (mySet.size() < howMany) {
					// Obtenemos un valor aleatorio entre 0 e intDistance
					// Recordemos que intDistance debe incrementarse en uno para que incluya su propio valor
					// como máximo posible.
					intAux = myRandomGenerator.nextInt(intDistance + 1);
					// Ajustamos el valor obtenido para ubicarlo dentro del rango definido
					// por minValue y maxValue.
					intAux = intAux + minValue;
					// Asignamos el valor al Set:
					mySet.add(intAux);
				}
				
				return mySet;   
			}
			else {
				mySet.add(0);
				return mySet;
			}
		}
		else {
			mySet.add(0);
			return mySet;
		}
	}
	
}