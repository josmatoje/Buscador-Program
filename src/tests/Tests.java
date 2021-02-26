package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clasesBasicas.Pagina;
import validaciones.Comprobaciones;

class Tests {
	static Pagina paginaDePrueba;
	static Pagina paginaMala;
	static Pagina[] paginas = new Pagina[10];
	@BeforeAll
	static void Pagina() {
		 paginaDePrueba=new Pagina();
		 paginaMala=new Pagina("enlaceMalo.com", "pagina hecha para probar los enlaces malos", 0, new String[]{"buscador"}, paginaDePrueba.getUrl() );
		  
	}
	
	
	@Test
	void testUrlValida() {
		assertTrue(Comprobaciones.validarUrl(paginaDePrueba.getUrl()));
	}
	@Test
	void testUrlNoValida() {
		assertFalse(Comprobaciones.validarUrl(paginaMala.getUrl()));
	}

}
