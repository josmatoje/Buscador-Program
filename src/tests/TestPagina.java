package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gestion.Utilidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clasesBasicas.Pagina;

public class TestPagina {
    //declaracion de paginas
    static Pagina paginaPrueba;

    @BeforeEach
    //Objetos necesarios para realizar los tests
    void Pagina(){
        paginaPrueba = new Pagina("https://ciclo.iesnervion.es", "pagina hecha para probar los enlaces buenos",0,
                new String[] { "informatica" }, "");
    }

    /**
     * Descripcion: Test para probar el metodo setPageRank metiendo un entero positivo
     */
    @Test
    void setPageRankPositivo(){
        paginaPrueba.setPageRank(5);
        assertEquals(5,paginaPrueba.getPageRank());
    }

    /**
     * Descripcion: Test para probar el metodo setPageRank metiendo un entero negativo
     */
    @Test
    void setPageRankNegativo(){
        paginaPrueba.setPageRank(-4);
        assertEquals(0,paginaPrueba.getPageRank());
    }
}
