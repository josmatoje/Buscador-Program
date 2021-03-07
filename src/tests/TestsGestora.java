package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clasesBasicas.Pagina;
import gestion.Gestora;

public class TestsGestora {
	static Pagina paginaSubirPageRank;
	static Pagina paginaDisminuirPageRank;
	static Pagina paginaMala;
	static Pagina[] paginas = new Pagina[2];
	static String [] palabrasClaves = new String[3]; 
	static String[] arrayVacia = new String[0]; //array vacia
	static Pagina[] arrayVaciaDePaginas = new Pagina[0]; //array vacia de Paginas

	
	@BeforeEach

	/*
	 * Objetos necesarios para los test que se crearan antes de la ejecucion de
	 * estos
	 */
	void Pagina() {
		palabrasClaves[0] = "coche";
		palabrasClaves[1] = "rueda";
		palabrasClaves[2] = "ferrari";
		paginaSubirPageRank = new Pagina("https://ciclo.iesnervion.es", "pagina hecha para probar los enlaces buenos",0,
				palabrasClaves, "");
		paginaDisminuirPageRank = new Pagina("https://papitas.com", "pagina hecha para probar los enlaces buenos",1,
				palabrasClaves, "");
		paginaMala = new Pagina("enlaceMalo.com", "pagina hecha para probar los enlaces malos",0,
				palabrasClaves, paginaSubirPageRank.getUrl());
		paginas[0] = paginaSubirPageRank;
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
		assertEquals(1, paginaSubirPageRank.getPageRank());
	}
	
	/**
	 * Descripcion: Test para comprobar que el page rank no aumenta(por tanto que no entra en el if pero si al for). Metodo a
	 * testear: aumentarPageRankPaginaEnlace(Pagina[] paginas, Pagina p) de la clase
	 * Gestora
	 */

	@Test
	void testNoAumentarPageRank() {
		Gestora.aumentarPageRankPaginaEnlace(paginas, paginaDisminuirPageRank.getEnlacesReferente());
		assertEquals(0, paginaMala.getPageRank());
	}
	
	/**
	 * Descripcion: Test para coomprobar que no se aumenta el page rank al no entrar en el for.
	 * Metodo a testear: aumentarPageRankPaginaEnlace(Pagina[] paginas, Pagina p) de la clase Gestora
	 */
	
	@Test
	void testNoEntraEnElFor() {
		Gestora.aumentarPageRankPaginaEnlace(arrayVaciaDePaginas, paginaSubirPageRank.getEnlacesReferente());
		assertEquals(0, paginaMala.getPageRank());
	}
	
	/**
	 * Descripcion: Test para comprobar que el page rank disminuye.
	 * Metodo a testear: disminuirPageRankPaginaEnlace(Pagina[] paginas, String urlEnlace) de la clase Gestora
	 * 
	 */
	
	@Test
	void testDisminiurPageRank() {
		paginas[0]=paginaDisminuirPageRank;
		Gestora.disminuirPageRankPaginaEnlace(paginas, paginaDisminuirPageRank.getUrl());
		assertEquals(0, paginaDisminuirPageRank.getPageRank());	
	}
	
	
	
	/*
	 * Tests para probar el método insertarPagina(Pagina[] paginas, Pagina pagina) de la clase Gestora 
	 * 
	 */
	
	
	
	/**
	 * Test para probar que el metodo duplica la array de paginas al estar llena e inserta la pagina que hemos dicho
	 */
	@Test
	void testDoblaLengthArrayEInsertaPagina() {
		paginas=Gestora.insertarPagina(paginas, paginaMala);
		assertEquals(4, paginas.length);
		assertEquals(paginaMala, paginas[2]);
	}
	
	/**
	 * Test para probar que el metodo inserta una pagina en una posicion en la que haya un null
	 * 
	 */
	
	@Test
	void testInsertaPaginaEnLaArray() {
		paginas[0]=null;
		paginas=Gestora.insertarPagina(paginas, paginaMala);
		assertEquals(paginaMala, paginas[0]);
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


