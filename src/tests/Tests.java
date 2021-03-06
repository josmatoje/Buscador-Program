package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clasesBasicas.Pagina;
import gestion.Gestora;
import gestion.Utilidad;
import validaciones.Validacion;

class Tests {

	static Pagina paginaDePrueba;
	static Pagina paginaMala;
	static Pagina[] paginas = new Pagina[2];
	static Validacion validacion = new Validacion();

	@BeforeAll

	/*
	 * Objetos necesarios para los test que se crearan antes de la ejecucion de
	 * estos
	 */
	static void Pagina() {
		paginaDePrueba = new Pagina("https://ciclo.iesnervion.es", "pagina hecha para probar los enlaces buenos",
				new String[] { "informatica" }, "");
		paginaMala = new Pagina("enlaceMalo.com", "pagina hecha para probar los enlaces malos",
				new String[] { "buscador" }, paginaDePrueba.getUrl());
		paginas[0] = paginaDePrueba;
		paginas[1] = paginaMala;
	}

	/**
	 * Descripcion: Test para comprobar que la validacion de url funciona bien
	 * cuando hay una url valida Metodo a testear: validarUrl(String url) de la
	 * clase Comprobaciones.
	 */
	@Test
	void testUrlValida() {
		assertTrue(Validacion.validarUrl(paginaDePrueba.getUrl()));
	}

	/**
	 * Descripcion: Test para comprobar que la validacion de url funciona bien
	 * cuando se mete una url no valida. Metodo a testear: validarUrl(String url) de
	 * la clase Comprobaciones.
	 */
	@Test
	void testUrlNoValida() {
		assertFalse(Validacion.validarUrl(paginaMala.getUrl()));
	}

	/**
	 * Descripcion: Test para comprobar que el page rank de una pagina aumenta.
	 * Metodo a testear: aumentarPageRankPaginaEnlace(Pagina[] paginas, Pagina p) de
	 * la clase Gestora
	 */
	@Test
	void testAumentarPageRank() {
		Gestora.aumentarPageRankPaginaEnlace(paginas, paginaMala.getEnlacesReferente());
		assertEquals(1, paginaDePrueba.getPageRank());
	}

	/**
	 * Descripcion: Test para comprobar que el page rank no aumenta. Metodo a
	 * testear: aumentarPageRankPaginaEnlace(Pagina[] paginas, Pagina p) de la clase
	 * Gestora
	 */

	@Test
	void testNoAumentarPageRank() {
		Gestora.aumentarPageRankPaginaEnlace(paginas, paginaDePrueba.getEnlacesReferente());
		assertEquals(0, paginaMala.getPageRank());
	}

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
}
