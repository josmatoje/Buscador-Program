package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clasesBasicas.Pagina;
import gestion.Gestora;
import validaciones.Comprobaciones;

class Tests {
	 static Pagina paginaDePrueba;
	 static Pagina paginaMala;
	 static Pagina[] paginas = new Pagina[2];
	 
	@BeforeAll
	
	/*
	 * Objetos necesarios para los test que se crearan antes de la ejecucion de estos
	 */
	 static void Pagina() {
		 paginaDePrueba=new Pagina();
		 paginaMala=new Pagina("enlaceMalo.com", "pagina hecha para probar los enlaces malos", new String[]{"buscador"}, paginaDePrueba.getUrl() );
		 paginas[0]= paginaDePrueba;
		 paginas[1]=paginaMala;
	}
	
	/**
	 * Descripcion: Test para comprobar que la validacion de url funciona bien cuando hay una url valida
	 * Metodo a testear: validarUrl(String url) de la clase Comprobaciones.
	 */
	@Test
	void testUrlValida() {
		assertTrue(Comprobaciones.validarUrl(paginaDePrueba.getUrl()));
	}
	/**
	 * Descripcion: Test para comprobar que la validacion de url funciona bien cuando se mete una url no valida.
	 * Metodo a testear: validarUrl(String url) de la clase Comprobaciones.
	 */
	@Test
	void testUrlNoValida() {
		assertFalse(Comprobaciones.validarUrl(paginaMala.getUrl()));
	}
	/**
	 * Descripcion: Test para comprobar que el page rank de una pagina aumenta.
	 * Metodo a testear: aumentarPageRankPaginaEnlace(Pagina[] paginas, Pagina p) de la clase Gestora
	 */
	@Test
	void testAumentarPageRank() {
		Gestora.aumentarPageRankPaginaEnlace(paginas, paginaMala);
		assertEquals(1, paginaDePrueba.getPageRank());
	}
	/**
	 * Descripcion: Test para comprobar que el page rank no aumenta.
	 * Metodo a testear: aumentarPageRankPaginaEnlace(Pagina[] paginas, Pagina p) de la clase Gestora
	 */
	
	@Test
	void testNoAumentarPageRank() {
		Gestora.aumentarPageRankPaginaEnlace(paginas, paginaDePrueba);
		assertEquals(0, paginaMala.getPageRank());
	}
	/**
	 * Descripcion: Test para comprobar que el metodo aumentar array funciona correctamente 
	 * Metodo a testear: aumentarArray(Object [] arrayLleno)
	 */
	
	
	
	

}
