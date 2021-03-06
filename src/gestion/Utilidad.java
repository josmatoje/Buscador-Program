package gestion;

import java.util.Arrays;

public class Utilidad {

	/**
	 * Descripicion: Este metodo coge una array generico y nos devuelve un array con
	 * los mismos valores pero de longitud doble Precondiciones: que la array
	 * introducida este creada e inicializada Postcondiciones: la array tiene el
	 * doble de longitud, las nuevas celdas tienen valor null o por defecto Entrada:
	 * T[] arrayLleno Salida: T[] arrayDoble
	 * 
	 * @param arrayLleno
	 * @return arrayDoble
	 */

	// public static <T> T[] copyOf(T[] original,int newLength)
	public static <T> T[] aumentarArray(T[] arrayLleno) {
		// public static Pagina[] aumentarArray (Pagina[] paginas){

		/*
		 * String[] arrayDoble = new String [arrayLleno.length*2]; //Creamos un array
		 * del tamaño*2 del array que queremos copiar for(int i=0; i<arrayLleno.length;
		 * i++) arrayDoble[i]=arrayLleno[i];
		 */

		// Metodo de la clase Arrays (copia un array en un array de la longitud dada y
		// lo rellena con null si es necesario)
		return Arrays.copyOf(arrayLleno, arrayLleno.length * 2);
	}

	/**
	 * Descripcion: Compara dos arrays de cadenas y devuelve el numero de veces que
	 * coinciden cadenas en ambos string Precondiciones: No se encuentran palabras
	 * repetidas en niguna de las cadenas que se pasan por parametros
	 * Postcondiciones: Le damos dos array de String y el metodo nos devuelve el
	 * numero de veces que coinciden las palabras de un array en la otra.
	 * Entrada:String[] palabrasPagina, String[] palabrasComprobar Salida:int
	 * contador
	 * 
	 * @param palabrasPagina
	 * @param palabrasComprobar
	 * @return palabrasCoincidentes /* Entrada: dos listas (Arrays) de cadenas los
	 *         cuales van a ser comparados Salida: un entero que indica el numero de
	 *         veces que se encuentra una cadena en ambas listas (arrays)
	 *         Precondiciones: No se encuentran palabras repetidas en niguna de las
	 *         cadenas que se pasan por parametros Postcondiciones: el entero será
	 *         un numero mayor o igual a cero, las listas no se ven modificadas
	 */
	public static int palabrasCoincidentes(String[] palabrasPagina, String[] palabrasComprobar) {

		int contador = 0;
		boolean comprobado;

		for (int i = 0; i < palabrasComprobar.length; i++) {
			comprobado = false;
			for (int j = 0; j < palabrasPagina.length && !comprobado; j++) {
				if (!palabrasComprobar[i].equals("") && palabrasPagina[j] != null && !palabrasComprobar[j].equals("")
						&& palabrasComprobar[i].equals(palabrasPagina[j])) {
					contador++;
					comprobado = true;
				}
			}
		}

		return contador;
	}

}
