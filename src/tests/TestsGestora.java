package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	static Pagina paginaPageRankAlto;
	static Pagina paginaPageRankBajo;
	int[] palabrasCoincidentes= new int[paginas.length];

	
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
		paginaPageRankAlto = new Pagina("https://mequieromorir.com", "pagina hecha para probar el metodo de ordenacion",8,
				palabrasClaves, "");
		paginaPageRankBajo=new Pagina("https://mequieromorir.com", "pagina hecha para probar el metodo de ordenacion",4,
				palabrasClaves, "");
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
	
	/**
	 * Descripcion: Test para comprobar que el pageRank  no disminuye
	 * Metodo a testear: disminuirPageRankPaginaEnlace(Pagina[] paginas, String urlEnlace) de la clase Gestora
	 */
	@Test
	void testNoDisminuirPageRank() {
		Gestora.disminuirPageRankPaginaEnlace(paginas,  paginaDisminuirPageRank.getUrl());
		assertEquals(1, paginaDisminuirPageRank.getPageRank());
	}
	
	
	
	/*
	 * Tests para probar el m�todo insertarPagina(Pagina[] paginas, Pagina pagina) de la clase Gestora 
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
	
	
	/*@Test
	void testOrdenarArray() {
		paginas=Utilidad.aumentarArray(paginas);
		paginas=Utilidad.aumentarArray(paginas);
		paginas=Utilidad.aumentarArray(paginas);
		paginas[3]=paginaPageRankBajo;
		paginas[4]=paginaPageRankAlto;
		paginas[0]=null;
		Gestora.ordenarPaginas(paginas, palabrasCoincidentes,0, 16);
		}
	*/
	
	/**
	 * Test para comprobar que las palabras repetidas en un array se eliminan
	 * Metodo a testear: eliminarPalabrasRepetida(String[] palabras)
	 */
	@Test
	void comprobarEliminarPalabrasCoincidentes() {
		palabrasClaves[0]="rueda";
		Gestora.eliminarPalabrasRepetida(palabrasClaves);
		assertEquals("", palabrasClaves[0]);
	}
	/**
	 * Test para comprobar que las palabras no repetidas en un array no se eliminan
	 * Metodo a testear: eliminarPalabrasRepetida(String[] palabras)
	 */
	@Test
	void comprobarNoSeEliminanPalabrasCoincidentes() {
		Gestora.eliminarPalabrasRepetida(palabrasClaves);
		assertEquals("coche", palabrasClaves[0]);
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
		/**
		 * Descripcion: Test para comprobar que nos devuelve el true si hay una pagina igual que el url que le indicamos
		 * Metodo a testear: comprobarExistenciaUrl(Pagina[] paginas,String url) de la clase Gestora
		 */
		@Test
		void testExisteUnaUrlCreada() {
			assertTrue(Gestora.comprobarExistenciaUrl(paginas, "https://ciclo.iesnervion.es" ));
		}
		
		/**
		 * Descripcion: Test para comprobar que nos devuelve el false si no hay una pagina igual que el url que le indicamos
		 * Metodo a testear: comprobarExistenciaUrl(Pagina[] paginas,String url) de la clase Gestora
		 */
		@Test
		void testNoExisteUnaUrlCreada() {
			assertFalse(Gestora.comprobarExistenciaUrl(paginas, "https://papitas.com" ));
		}
		
		/**
		 * Descripcion: Test para comprobar que nos devuelve true en caso de que la array de paginas este inicializada y no sea todo null
		 * Metodo a testear: comprobarExistenciaPaginas(Pagina[] paginas) de la clase Gestora
		 */
		
		@Test
		void testArrayPaginasValida() {
			assertTrue(Gestora.comprobarExistenciaPaginas(paginas));
		}
		
		/**
		 * Descripcion: Test para comprobar que nos devuelve False en caso de que la array de paginas no este inicializada
		 * Metodo a testear: comprobarExistenciaPaginas(Pagina[] paginas) de la clase Gestora
		 */
		@Test
		void testArrayPaginasNoValida() {
			assertFalse(Gestora.comprobarExistenciaPaginas(arrayVaciaDePaginas));
		}
		
	}



