package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clasesBasicas.Pagina;
import gestion.Utilidad;
import validaciones.Validacion;

public class TestsUtilidad {
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
