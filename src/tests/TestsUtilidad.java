package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import clasesBasicas.Pagina;
import gestion.Utilidad;


public class TestsUtilidad {
	static Pagina[] paginas = new Pagina[2];
	
	/**
	 * Descripcion: Test para comprobar que el metodo aumentar array funciona
	 * correctamente Metodo a testear: aumentarArray(Object [] arrayLleno)
	 */

	@Test
	void aumentarArray() {
		paginas = Utilidad.aumentarArray(paginas);
		paginas = Utilidad.aumentarArray(paginas);
		paginas = Utilidad.aumentarArray(paginas);
		paginas = Utilidad.aumentarArray(paginas);
		assertEquals(32, paginas.length);
	}

	//Tests para metodo palabras coincidentes
	
	/**
	 * Descripcion: Test para probar que hay palabras coincidentes
	 */
	
	@Test
	void palabrasCoincidentesCoinciden() {
		assertEquals(3, Utilidad.palabrasCoincidentes(paginas[0].getPalabrasClaves(), paginas[1].getPalabrasClaves()));
	}
	
	/**
	 * Descripcion: Test para probar que no hay palabras coincidentes
	 */
	
	@Test
	void palabrasCoincidentesNoCoinciden() {
		 String [] palabrasNoCoincidentes = new String[3];//array de palabras diferentes al creado anteriormente
		
		 palabrasNoCoincidentes[0] = "hola";
		 palabrasNoCoincidentes[1] = "adios";
		 palabrasNoCoincidentes[2] = "aguacate";
		 
		
		assertEquals(0, Utilidad.palabrasCoincidentes(paginas[0].getPalabrasClaves(), palabrasNoCoincidentes));
	}
	
	/**
	 * Descripcion: Test para probar que no el array para comprobar no tiene palabras clave
	 */
	
	@Test
	void palabrasCoincidentesNoHayPalabrasClavePalabrasComprobar() {
		
		assertEquals(0, Utilidad.palabrasCoincidentes(paginas[0].getPalabrasClaves(), arrayVacia));
	}
	
	/**
	 * Descripcion: Test para probar que no el array de la pagina no tiene palabras clave
	 */
	
	@Test
	void palabrasCoincidentesNoHayPalabrasClavePalabrasPagina() {
		
		
		assertEquals(0, Utilidad.palabrasCoincidentes(arrayVacia, arrayVacia));
	}
}
