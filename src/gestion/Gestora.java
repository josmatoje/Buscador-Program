package gestion;

import clasesBasicas.Pagina;

public class Gestora {

    /**
     * Entradas: array paginas y objeto p de la clase Pagina
     * Salida: Ninguna
     * Precondiciones: Crear la array paginas, asi como el objeto p
     * Postcondiciones: La variable aumentado es false si el enlace referente de la pagina p no coincide con ninguna url de la array paginas.
     * Si el url de alguna pagina coincide con la referente de la dada, el page rank de la primera aumentara en uno y aumentado es true.
     *
     * @param paginas
     * @param p
     */

    public static void aumentarPageRankPaginaEnlace(Pagina[] paginas, Pagina p) {
        boolean aumentado = false;
        for(int i = 0; i < paginas.length && !aumentado; i++) {
            if(paginas[i] != null && p.getEnlacesReferente().equals(paginas[i].getUrl())) {
                paginas[i].setPageRank(paginas[i].getPageRank()+1);
                aumentado = true;
            }
        }
    }

    /**
     * Precondiciones: array paginas y objeto p de la clase Pagina
     * Postcondiciones: 
     * @param paginas
     * @param p
     */

    public static Pagina[] insertarPagina(Pagina[] paginas,Pagina p){
        boolean auxiliar=false;
        int i;
        for(i=0; i< paginas.length && auxiliar==false; i++){
            if(paginas[i] == null){
                paginas[i] = p;
                auxiliar=true;
            }
        }
        if(!auxiliar){//si la pagina no se ha metido en la lista
            paginas = Utilidad.aumentarArray(paginas);
            paginas[i] = p;
        }
        return paginas;
    }
}
