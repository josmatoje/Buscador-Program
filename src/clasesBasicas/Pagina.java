/**
 * Nombre: Pagina<br/>
 * Propiedades:<br/>
 *  Basicas:<br/>
 *   url: cadena, consultable<br/>
 *   descripcion: cadena, consultable, modificable<br/>
 *   pageRank: entero, consultable<br/>
 *   palabrasClaves: array de cadenas, consultable, modificable<br/>
 *   enlacesReferentes: cadena, consultable, modificable<br/>
 *<br/>
 * Derivadas: Ninguna<br/>
 *<br/>
 * Compartida: Ninguna<br/>
 *<br/>
 * Metodos principales:<br/>
 * 						-url:<br/>
 *  						public String getUrl()<br/>
 * 						-descripcion:<br/>
 *  						public String getDescripcion()<br/>
 *  						public void setDescripcion(String descripcion)<br/>
 * 						-pageRank:<br/>
 * 							 public int getPageRank()<br/>
 * 							 public void setPageRank(int pageRank)<br/>
 * 						-palabrasClaves:<br/>
 *  						public String[] getPalabrasClaves()<br/>
 *  						public void setPalabrasClaves(String[] palabrasClaves)<br/>
 * 						-enlacesClaves:<br/>
 *  						public String getEnlacesReferente()<br/>
 *  						public void setEnlacesReferente(String enlacesReferente)<br/>
 * Metodos anhadidos:<br/>
 *<br/>
 * Metodos heredados: Ninguno<br/>
 *
 */
package clasesBasicas;

public class Pagina {

	// Atributos
	private String url;
	private String descripcion;
	private int pageRank;
	private String[] palabrasClaves;
	private String enlacesReferente;

	// Constructor con parametros
	public Pagina(String url, String descripcion,int pageRank, String[] palabrasClaves, String enlacesReferente) {
		this.url = url;
		this.descripcion = descripcion;
		setPageRank(pageRank);
		this.palabrasClaves = palabrasClaves;
		this.enlacesReferente = enlacesReferente;
	}

	// Constructor por defecto
	public Pagina(String s, String s1, String[] palabrasClaves, String url) {
		this.url = "";
		descripcion = "";
		pageRank = 0;
		this.palabrasClaves = null;
		enlacesReferente = "";
	}

	// Getters and setters
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
		//A�adimos el ifelse en este set para que en caso de que nos metan un pageRank negativo, se convierta a 0.
		if(pageRank<0) {
			this.pageRank = 0;
		}else {
			this.pageRank = pageRank;
		}
		
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

	// Metodo toString para mostrar las paginas
	@Override
	public String toString() {
		// todo: en caso de pagina por defecto no imprimir;
		return ("\t"+url + "\n" + descripcion);
	}
}