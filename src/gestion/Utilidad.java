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

	

}
