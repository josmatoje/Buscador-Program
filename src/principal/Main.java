package principal;

import clasesBasicas.Pagina;
import gestion.Gestora;


public class Main {

	public static void main(String[] args) {	

		Pagina[] paginas = new Pagina[10];


		//System.out.println(3/2);

		Pagina p = new Pagina();
		Gestora.insertarPagina(paginas, p);
		Gestora.insertarPagina(paginas, p);
		paginas = Gestora.insertarPagina(paginas, p);
		Gestora.insertarPagina(paginas, p);
		Gestora.insertarPagina(paginas, p);
		Gestora.insertarPagina(paginas, p);
		Gestora.insertarPagina(paginas, p);

	}

}
