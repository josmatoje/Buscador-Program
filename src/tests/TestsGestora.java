package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clasesBasicas.Pagina;
import gestion.Gestora;
import gestion.Gestora;
import validaciones.Validacion;

public class TestsGestora {
	static Pagina paginaDePrueba;
	static Pagina paginaMala;
	static Pagina[] paginas = new Pagina[2];
	static String [] palabrasClaves = new String[3]; 
	static String[] arrayVacia = new String[0]; //array vacia 
	
	@BeforeAll

	/*
	 * Objetos necesarios para los test que se crearan antes de la ejecucion de
	 * estos
	 */
	static void Pagina() {
		palabrasClaves[0] = "coche";
		palabrasClaves[1] = "rueda";
		palabrasClaves[2] = "ferrari";
		paginaDePrueba = new Pagina("https://ciclo.iesnervion.es", "pagina hecha para probar los enlaces buenos",
				palabrasClaves, "");
		paginaMala = new Pagina("enlaceMalo.com", "pagina hecha para probar los enlaces malos",
				palabrasClaves, paginaDePrueba.getUrl());
		paginas[0] = paginaDePrueba;
		paginas[1] = paginaMala;
	}

	
	/**
	 * Descripcion: Test para comprobar que el page rank de una pagina aumenta(que entra en el for y en el if).
	 * Metodo a testear: aumentarPageRankPaginaEnlace(Pagina[] paginas, Pagina p) de
	 * la clase Gestora
	 */
	@Test
	void testAumentarPageRank() {
		Gestora.aumentarPageRankPaginaEnlace(paginas, paginaMala.getEnlacesReferente());
		assertEquals(1, paginaDePrueba.getPageRank());
	}
	
	/**
	 * Descripcion: Test para comprobar que el page rank no aumenta(por tanto que no entra en el if pero si al for). Metodo a
	 * testear: aumentarPageRankPaginaEnlace(Pagina[] paginas, Pagina p) de la clase
	 * Gestora
	 */

	@Test
	void testNoAumentarPageRank() {
		Gestora.aumentarPageRankPaginaEnlace(paginas, paginaDePrueba.getEnlacesReferente());
		assertEquals(0, paginaMala.getPageRank());
	}
	
	/**
	 * Descripcion: Test para coomprobar que no se aumenta el page rank al no entrar en el for.
	 * Metodo a testear: aumentarPageRankPaginaEnlace(Pagina[] paginas, Pagina p) de la clase Gestora
	 */
	
	@Test
	void testNoEntraEnElFor() {
		
	}
	
	/**
	 * Descripcion: Test para comprobar que el pagvee rank disminuye.
	 * Metodo a testear: disminuirPageRankPaginaEnlace(Pagina[] paginas, String urlEnlace) de la clase Gestora
	 * 
	 */
	
	@Test
	void testDisminiurPageRank() {
		
	}
	
	//Tests para metodo palabras coincidentes
	
		/**
		 * Descripcion: Test para probar que hay palabras coincidentes
		 */
		
		@Test
		void palabrasCoincidentesCoinciden() {
			assertEquals(3, Gestora.palabrasCoincidentes(paginas[0].getPalabrasClaves(), paginas[1].getPalabrasClaves()));
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
			 
			
			assertEquals(0, Gestora.palabrasCoincidentes(paginas[0].getPalabrasClaves(), palabrasNoCoincidentes));
		}
		
		/**
		 * Descripcion: Test para probar que no el array para comprobar no tiene palabras clave
		 */
		
		@Test
		void palabrasCoincidentesNoHayPalabrasClavePalabrasComprobar() {
			
			assertEquals(0, Gestora.palabrasCoincidentes(paginas[0].getPalabrasClaves(), arrayVacia));
		}
		
		/**
		 * 
		 * Descripcion: Test para probar que no el array de la pagina no tiene palabras clave
		 */
		
		@Test
		void palabrasCoincidentesNoHayPalabrasClavePalabrasPagina() {
			
			assertEquals(0, Gestora.palabrasCoincidentes(arrayVacia, arrayVacia));
		}
	}


