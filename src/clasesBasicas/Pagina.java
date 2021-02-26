/**
 * Nombre: Pagina
 * Propiedades:
 *  Basicas:
 *   url: cadena, consultable
 *   descripcion: cadena, consultable, modificable
 *   pageRank: entero, consultable
 *   palabrasClaves: array de cadenas, consultable, modificable
 *   enlacesReferentes: cadena, consultable, modificable
 *
 * Derivadas: Ninguna
 *
 * Compartida: Ninguna
 *
 * Metodos principales:
 * 						-url:
 *  						public String getUrl()
 * 						-descripcion:
 *  						public String getDescripcion()
 *  						public void setDescripcion(String descripcion)
 * 						-pageRank:
 * 							 public int getPageRank()
 * 						-palabrasClaves:
 *  						public String[] getPalabrasClaves()
 *  						public void setPalabrasClaves(String[] palabrasClaves)
 * 						-enlacesClaves:
 *  						public String getEnlacesReferente()
 *  						public void setEnlacesReferente(String enlacesReferente)
 * Metodos anhadidos:
 *
 *
 * Metodos heredados: Ninguno
 *
 */
package clasesBasicas;

import gestion.Gestora;

public class Pagina {

    //Atributos
    private String url;
    private String descripcion;
    private int pageRank;
    private String [] palabrasClaves;
    private String enlacesReferente;

    //Constructor con parametros
    public Pagina(String url, String descripcion, int pageRank, String[] palabrasClaves, String enlacesReferente, Pagina[] paginas) {
        this.url = url;
        this.descripcion = descripcion;
        this.pageRank = pageRank;
        this.palabrasClaves = palabrasClaves;
        this.enlacesReferente = enlacesReferente;
    }

    //Constructor por defecto
    public Pagina() {
        url = "google";
        descripcion = "maravillosa";
        pageRank = 0;
        palabrasClaves = new String[]{"vacio"};
        enlacesReferente = "otrapagina";
    }

    //Getters and setters
    public String getUrl() {
        return url;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPageRank() {
        return pageRank;
    }

    public void setPageRank(int pageRank) {
        this.pageRank = pageRank;
    }

    public String[] getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String[] palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public String getEnlacesReferente() {
        return enlacesReferente;
    }

    public void setEnlacesReferente(String enlacesReferente) {
        this.enlacesReferente = enlacesReferente;
    }
    
    //Metodo toString para mostrar las paginas
    @Override
     public String toString() {
    	 return("       http://"+url+".com       \n"
    	 		+descripcion);
     }

    //Metodos anhadidos

}