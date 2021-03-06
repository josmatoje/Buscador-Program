package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clasesBasicas.Pagina;
import validaciones.Validacion;

public class TestValidacion {
	static Pagina paginaDePrueba;
	static Pagina paginaMala;
	static Pagina[] paginas = new Pagina[2];
	static Validacion validacion = new Validacion();
	static char respuesta;
	
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
	
	//Test para el metodo leerValidarRespuestaSiNo
	
	/**
	 * Descripcion: Test para ver si es afirmativa la respuesta
	 */
	@Test
	void leerValidarRespuestaSiNoAfirmativo() {
		assertTrue(Validacion.leerValidarRespuestaSiNo());
	}
	
	/**
	 * Descripcion: Test para ver si es afirmativa la respuesta
	 */
	@Test
	void leerValidarRespuestaSiNoNegativo() {
		assertFalse(Validacion.leerValidarRespuestaSiNo());
	}
	
	/**
	 * Descripcion: Test para comprobar que la validacion de url funciona bien
	 * cuando hay una url valida Metodo a testear: validarUrl(String url) de la
	 * clase Comprobaciones.
	 */
	//@Test
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

}
