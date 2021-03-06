package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clasesBasicas.Pagina;
import gestion.Gestora;
import validaciones.Validacion;

public class TestsGestora {
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

}
