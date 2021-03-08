package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clasesBasicas.Pagina;
import gestion.Gestora;
import validaciones.Validacion;

public class TestsGestora {
	static Pagina paginaSubirPageRank;
	static Pagina paginaDisminuirPageRank;
	static Pagina paginaMala;
	static Pagina[] paginas = new Pagina[2];
	static Validacion validacion = new Validacion();
	
	@BeforeEach

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

}
