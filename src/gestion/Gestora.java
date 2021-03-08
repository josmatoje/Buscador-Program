package gestion;

import clasesBasicas.Pagina;

import java.util.Arrays;

public class Gestora {

    /**
     * Cabecera: public static void aumentarPageRankPaginaEnlace(Pagina[] paginas, String urlEnlace)
     * 
     * Comentario: Este metodo se encarga de aumentar en uno el pageRank de un objeto de tipo Pagina que se encuentra en un array de tipo Pagina.
     * 			   Solo se aumentara si en dicho array se encuentra una pagina que su url es igual al parametro urlEnlace
     * 
     * Entradas: Pagina[] paginas,String urlEnlace
     * 
     * Salida: Ninguna
     * 
     * Precondiciones: Crear el array paginas
     * 
     * Postcondiciones: Se aumenta el pageRank de un objeto Pagina pero solo si se da el caso que en el array de paginas hay una que su url es 
     * 					igual al urlEnlace, entonces a esta se le aumentara en uno su pageRank, por lo tanto se hara por referencia.
     * 
     * @param paginas
     * @param urlEnlace
     */
    public static void aumentarPageRankPaginaEnlace(Pagina[] paginas, String urlEnlace) {
        boolean modificado = false;
        for(int i = 0; i < paginas.length && !modificado; i++) {
            if(paginas[i] != null && paginas[i].getUrl().equals(urlEnlace)) {
                paginas[i].setPageRank(paginas[i].getPageRank() + 1);
                modificado = true;
            }
        }
    }
    
    /**
     * Cabecera: public static void disminuirPageRankPaginaEnlace(Pagina[] paginas, String urlEnlace)
     * 
     * Comentario: Este metodo se encarga de disminuir en uno el pageRank de un objeto de tipo Pagina que se encuentra en un array de tipo Pagina.
     * 			   Solo se disminuira si en dicho array se encuentra una pagina que su url es igual al parametro urlEnlace
     * 
     * Entradas: Pagina[] paginas,String urlEnlace
     * 
     * Salida: Ninguna
     * 
     * Precondiciones: Crear el array paginas
     * 
     * Postcondiciones: Se disminuira el pageRank de un objeto Pagina pero solo si se da el caso que en el array de paginas hay una que su url es 
     * 					igual al urlEnlace, entonces a esta se le disminuira en uno su pageRank, por lo tanto se hara por referencia.
     * 
     * @param paginas Array de objetos pagina
     * @param urlEnlace
     */

    public static void disminuirPageRankPaginaEnlace(Pagina[] paginas, String urlEnlace) {
        boolean modificado = false;
        for(int i = 0; i < paginas.length && !modificado; i++) {
            if(paginas[i] != null && paginas[i].getUrl().equals(urlEnlace)) {
                paginas[i].setPageRank(paginas[i].getPageRank() - 1);
                modificado = true;
            }
        }
    }


	/**
	 * Precondiciones: array paginas y objeto p de la clase Pagina Postcondiciones:
	 * 
	 * @param paginas
	 * @param pagina
	 * 
	 * @return paginas
	 */

	/*
	 * Aclaracion: En el caso en el que paginas este lleno, se tendra que aumentar
	 * su tama�o, entonces este tomara otra referencia, por eso el metodo devuelve
	 * Pagina[]
	 */
	public static Pagina[] insertarPagina(Pagina[] paginas, Pagina pagina) {
		boolean auxiliar = false;
		int i;
		for (i = 0; i < paginas.length && !auxiliar; i++) {
			if (paginas[i] == null) {
				paginas[i] = pagina;
				auxiliar = true;
			}
		}
		if (!auxiliar) {// si la pagina no se ha metido en la lista
			paginas = Utilidad.aumentarArray(paginas); // Se creara otra referencia del array
			paginas[i] = pagina;
		}
		return paginas;
	}

	/**
	 * Cabecera: public static void ordenarPaginas (Pagina[] listaPaginas, int[]
	 * palabrasCoincidentes, int inicio, int fin)
	 * 
	 * Comentario: Este metodo se encarga de ordenar un array de tipo Pagina
	 * 
	 * Entradas: int[] palabrasCoincidentes, int inicio, int fin
	 * 
	 * Salidas: Ninguna.
	 * 
	 * Entrada/Salida: listaPaginas.
	 * 
	 * Precondiciones: listaPaginas no debe estar vacio.
	 * 
	 * Postcondiciones: lista [0],...,lista[N-1] esta ordenado descendentemente
	 * segun el criterio de palabras clave dado.
	 * 
	 * @param listaPaginas
	 * @param palabrasCoincidentes
	 * @param inicio
	 * @param fin
	 */
	public static void ordenarPaginas(Pagina[] listaPaginas, int[] palabrasCoincidentes, int inicio, int fin) {

		int puntoMedio;

		if (inicio < fin && listaPaginas[inicio]!=null) {// Caso base, indicesno definen un segmento del array
			puntoMedio = partirLista(listaPaginas, palabrasCoincidentes, inicio, fin);// Partimos (y ordenamos) la lista
			ordenarPaginas(listaPaginas, palabrasCoincidentes, inicio, puntoMedio - 1);
			ordenarPaginas(listaPaginas, palabrasCoincidentes, puntoMedio + 1, fin);
		}
	}

	/**
	 * Cabecera: public static int partirLista(Pagina[] listaPaginas, int[]
	 * palabrasCoincidentes, int inicio, int fin)
	 * 
	 * Entradas: int[] palabrasCoincidentes, int inicio, int fin
	 * 
	 * Salida: punto por donde se ha partido el array.
	 * 
	 * Entrada/Salida: Pagina[] listaPaginas
	 * 
	 * Precondiciones: el array no debe estar vacio.
	 * 
	 * Postcondiciones: Las siguientes, - Segun las especificaciones, array[ppio],
	 * ...., array[fin] quedara dividido respecto a valorParticion. - Asociado al
	 * nombre del subprograma se devuelve el lugar por el que se divide el array.
	 * Por tanto, el subprograma se dise�ara como funcion.
	 * 
	 * @param listaPaginas
	 * @param palabrasCoincidentes
	 * @param inicio
	 * @param fin
	 * 
	 * @return particion
	 */
	public static int partirLista(Pagina[] listaPaginas, int[] palabrasCoincidentes, int inicio, int fin) {

		int particion = inicio, palCoinAux;// El programa asume la pagina de inicio como la de particion
		boolean pageRankMayor = true;
		Pagina paginaAux;
		int i,j;

		for ( i = inicio + 1, j = fin; i < j;) {// recorremos el array desde el pinicio y el final y aseguramos que i
													// siempre menor que j

			// pageRankMayor=true; no es necesario actualizar ya que del bloque anterior
			// siempre sale a falso o sale del bucle principal
			// y en la primera iteracion se ha inicializado a true.

			// avanzamos con el indice i mientras sea distinto de nulo y la pagina en esa posicion tenga mas o
			// igual numero de palabras coincidentes que la pagina de particion (inicio) y que pageRankMayor sea true
			for (; i < j && listaPaginas[i]!=null && (palabrasCoincidentes[i] >= palabrasCoincidentes[inicio]) && pageRankMayor; i++) {
				if (palabrasCoincidentes[i] == palabrasCoincidentes[inicio]) { // En caso de tener el mismo numero
																				// valoramos el pageRank
					if (listaPaginas[i].getPageRank() > listaPaginas[inicio].getPageRank())
						pageRankMayor = false;// Si tiene menos pageRank pasamos al siguiente bloque
												// (la pagina es menos relevante)
				}
			}

			// pageRankMayor=false; no es necesario actualizar ya que del bloque anterior
			// siempre sale a falso o sale del bucle principal

			// avanzamos con el indice j si la pgina en j es nula o
			// mientras la pagina en esa posicion tenga menos número de palabras coincidentes que la pagina de particion
			for (; i < j && (palabrasCoincidentes[j] <= palabrasCoincidentes[inicio] && !pageRankMayor); j--) {
																								// Ahora pageRank debe ser menor
				if (palabrasCoincidentes[j] == palabrasCoincidentes[inicio]&&listaPaginas[j]!=null ) { // En caso de tener el mismo numero
																				// valoramos el pageRank
					if (listaPaginas[j].getPageRank() < listaPaginas[inicio].getPageRank())
						pageRankMayor = true;// Si tiene mas pasamos al siguiente bloque (la pagina es mas relevante)
					// En este caso si es (y el anterior) si son iguales hablamos de paginas con la
					// misma relevancia
				}
			}
			if(i < j) {


			// Tenemos la posicion i de una pagina de menor relevancia a la particion y en j
			// una de mayor relevancia
			paginaAux = listaPaginas[j];
			listaPaginas[j] = listaPaginas[i];
			listaPaginas[i] = paginaAux; // Intercambiamos la pagina en i por la pagina en j

			// Posteriormente cambiamos tambien las palabras coincidentes de nuestro array
			// de enteros para futuras posibles iteraciones que
			// cada posicion del array de enteros se corresponda con la posicion del array
			// de su pagina correspondiente
			palCoinAux = palabrasCoincidentes[j];
			palabrasCoincidentes[j] = palabrasCoincidentes[i];
			palabrasCoincidentes[i] = palCoinAux;

				// Tenemos la posicion i de una pagina de menor relevancia a la particion y en j
				// una de mayor relevancia
				paginaAux = listaPaginas[j];
				listaPaginas[j] = listaPaginas[i];
				listaPaginas[i] = paginaAux; // Intercambiamos la pagina en i por la pagina en j
	
				// Posteriormente cambiamos tambien las palabras coincidentes de nuestro array
				// de enteros para futuras posibles iteraciones que
				// cada posivion del array de enteros se corresponda con la posicion del array
				// de su pagina correspondiente
				palCoinAux = palabrasCoincidentes[j];
				palabrasCoincidentes[j] = palabrasCoincidentes[i];
				palabrasCoincidentes[i] = palCoinAux;
			}


			particion = i;// Actualizamos la posicion por la que vamos intercambiando las celdas ya que en
							// la ultima iteracion i=j
			// este sera nuestro punto de particion

		} // Final de busqueda de particion y de ordenacion del array

		// Comprobamos si el ultimo caso la pagina es menos relevante que la pagina de particion
		// o esta es null
		if (listaPaginas[particion]==null || palabrasCoincidentes[inicio] >= palabrasCoincidentes[particion]) {
			if (palabrasCoincidentes[inicio] == palabrasCoincidentes[particion]
					&& listaPaginas[inicio].getPageRank() > listaPaginas[particion].getPageRank()) {
				particion--;// En caso afirmativo lo dejamos a la derecha
			}
		}
		// Debemos intercambiar el valor de particion para dejarlo en la posicion
		// deseada
		if(listaPaginas[inicio].getPageRank()<listaPaginas[particion].getPageRank()) {
			paginaAux = listaPaginas[inicio];
			listaPaginas[inicio] = listaPaginas[particion];
			listaPaginas[particion] = paginaAux; // Intercambiamos la pagina en i por la pagina en j
		}
		

		// Tambien cambiamos las palabras coincidentes de nuestro array
		// de enteros para futuras posibles iteraciones que
		// cada posivion del array de enteros se corresponda con la posicion del array
		// de su pagina correspondiente
		palCoinAux = palabrasCoincidentes[inicio];
		palabrasCoincidentes[inicio] = palabrasCoincidentes[particion];
		palabrasCoincidentes[particion] = palCoinAux;

		// Tambien cambiamos las palabras coincidentes de nuestro array
		// de enteros para futuras posibles iteraciones que
		// cada posivion del array de enteros se corresponda con la posicion del array
		// de su pagina correspondiente
		palCoinAux = palabrasCoincidentes[inicio];
		palabrasCoincidentes[inicio] = palabrasCoincidentes[particion];
		palabrasCoincidentes[particion] = palCoinAux;

		return particion;
	}

	/**
	 * <b>Cabecera:</b> public static void ordenacionInsercionDirecta (Pagina[] listaPaginas, int[] palabrasCoincidentes)
	 * <b>Propósito:</b> ordenación ascendente de un array unidimensional de tamaño tam.<br>
	 *
	 * <b>Entradas/Salida:</b> un array.<br>
	 * <b>Precondiciones:</b>ambos arrays tienen que tener el mismo tamaño<br>
	 * <b>Postcondiciones:</b> array [0], ..., array[tam-1] está ordenado de mayor a meno relevancia<br>
	 *
	 * @param listaPaginas
	 * @param palabrasCoincidentes
	 */
	public static void ordenacionInsercionDirecta (Pagina[] listaPaginas, int[] palabrasCoincidentes){
		int palCoinAux;
		Pagina paginaAux;

		for (int i=1;i<listaPaginas.length; i++){
			for(int j=i; j>0;j--){
				if( listaPaginas[j-1] == null || palabrasCoincidentes[j]>palabrasCoincidentes[j-1] ||
					(	palabrasCoincidentes[j]==palabrasCoincidentes[j-1] && listaPaginas[j] != null &&
						listaPaginas[j].getPageRank() > listaPaginas[j-1].getPageRank()			)
					){

						//Intercambiamos ambas paginas
						paginaAux = listaPaginas[j];
						listaPaginas[j] = listaPaginas[j-1];
						listaPaginas[j-1] = paginaAux;

						// Posteriormente cambiamos tambien las palabras coincidentes de nuestro array
						// de enteros para futuras posibles iteraciones que
						// cada posicion del array de enteros se corresponda con la posicion del array
						// de su pagina correspondiente
						palCoinAux = palabrasCoincidentes[j];
						palabrasCoincidentes[j] = palabrasCoincidentes[j-1];
						palabrasCoincidentes[j-1] = palCoinAux;

				}
			}
		}
	}

	/**
	 * Cabecera: public static void eliminarPalabrasRepetida(String[] palabras)
	 * 
	 * Comentario: Este metodo sustituye las palabras repetidas de un array de
	 * cadenas por una cadena vacia (no nulas)
	 * 
	 * Entradas: Ninguna.
	 * 
	 * Salida: Ninguna.
	 * 
	 * Entrada/Salida: String[] palabras
	 * 
	 * Precondiciones: palabras no deberia contener ninguna posicion con un valor
	 * null.
	 * 
	 * Postcondiciones: El array contendra Strings distintos y tendrá la misma
	 * longitud que el array original. Solo podrá encontrarse repetidos strings
	 * vacios ("")
	 * 
	 * @param palabras
	 */
	public static void eliminarPalabrasRepetida(String[] palabras) {
		boolean repetida = false;
		for (int i = 0; i < palabras.length; i++) {
			repetida = false;
			for (int j = i; j < palabras.length && !repetida; j++) {
				if (i != j && !palabras[i].equals("") && palabras[i].equals(palabras[j])) {
					palabras[i] = "";
					repetida = true;
				}
			}
		}
	}
	
	/**
	 * <b>Descripcion:</b> Compara dos arrays de cadenas y devuelve el numero de veces que coinciden cadenas en ambos string <br>
	 * <b>Entrada:</b>  dos listas (Arrays) de cadenas los cuales van a ser comparados <br>
	 *
	 * <b>Precondiciones:</b> No se encuentran palabras repetidas en niguna de las cadenas que se pasan por parametros <br>
	 *
	 * <b>Postcondiciones:</b> El entero será un numero mayor o igual a cero, las listas no se ven modificadas.<br>
	 *
	 * <b>Salida:</b> un entero que indica el numero deveces que se encuentra una cadena en ambas listas (arrays) <br>
	 * 
	 * @param palabrasPagina
	 * @param palabrasComprobar
	 * @return palabrasCoincidentes
	 *
	 *
	 * Postcondiciones:
	 */
	public static int palabrasCoincidentes(String[] palabrasPagina, String[] palabrasComprobar) {

		int contador = 0;
		boolean comprobado;

		for (int i = 0; i < palabrasComprobar.length; i++) {
			comprobado = false;
			for (int j = 0; j < palabrasPagina.length && !comprobado; j++) {
				if (!palabrasComprobar[i].equals("") && palabrasPagina[j] != null && !palabrasComprobar[i].equals("")
						&& palabrasComprobar[i].equals(palabrasPagina[j])) {
					contador++;
					comprobado = true;
				}
			}
		}

		return contador;
	}
	
	/**
	 * Cabecera: public static boolean comprobarExistenciaUrl(Pagina[] paginas,String url)
	 *   
	 * Comentario: Este metodo se encarga de comprobar si la cadena(url) es igual a la url principal de alguna de las paginas 
	 *   		   que hay en un array de tipo Pagina
	 *   
	 * Precondiciones: Ninguna
	 *   
	 * Entrada: Pagina[] paginas,String url
	 *   
	 * Salida: boolean existe 
	 *    
	 * Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato(existe), en este caso un boleano el cual tomara los 
	 *   				siguientes valores:
	 *   			    -true: Si la url recibida como parametro es la url principal de otra pagina	
	 *   				-false: Si la url recibida como parametro no es la url principal de otra pagina	  
	 *   
	 * @param paginas
	 * @param url
	 * 
	 * @return existe				
     */
    public static boolean comprobarExistenciaUrl(Pagina[] paginas,String url) {
    	boolean existe = false;
    	for(int i = 0; i < paginas.length && !existe;i++) {
    		if (paginas[i] != null && url.equals(paginas[i].getUrl())) {
    			existe = true;
			}
    	}
    	return existe;
    }
    /**
	 * Cabecera: public static boolean comprobarExistenciaPaginas(Pagina[] paginas)
	 *   
	 * Comentario: Este metodo se encarga de comprobar si en la array de Paginas hay alguna creada o si estan todas a null.
	 *   		 
	 *   
	 * Precondiciones: Ninguna
	 *   
	 * Entrada: Pagina[] paginas
	 *   
	 * Salida: boolean existe 
	 *    
	 * Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato(existe), en este caso un boleano el cual tomara los 
	 *   				siguientes valores:
	 *   			    -true: Si la array paginas tiene un objeto Pagina que no sea null	
	 *   				-false: Si la array paginas solo tiene nulls	  
	 *   
	 * @param paginas
	 * 
	 * @return existe				
     */
    
    public static boolean comprobarExistenciaPaginas(Pagina[] paginas) {
    	boolean existe=false;
    	for(int i=0; i < paginas.length && !existe; i++) {
    		if(paginas[i] != null)
    			existe=true;

    	}
    	return existe;
    		
    }

	@Deprecated
	/**
	 * Cabecera: public static void ordenarPaginas (Pagina[] listaPaginas, String[]
	 * palabrasClave)
	 *
	 * Comentario: Este método está en deshuso ya que tiene peor rendimiento e internamente es bastante menos legible
	 *
	 * Entradas: String[] palabrasClave
	 *
	 * Salidas: Ninguna.
	 *
	 * Entrada/Salida: listaPaginas.
	 *
	 * Precondiciones: listaPaginas no debe estar vacio.
	 *
	 * Postcondiciones: lista esta ordenado descendentemente segun el criterio de
	 * palabras clave dado.
	 *
	 * @param listaPaginas
	 * @param palabrasClave
	 */
	public static void ordenarPaginas(Pagina[] listaPaginas, String[] palabrasClave) {

		int puntoMedio;
		Pagina[] semiLista1, semiLista2;

		if (listaPaginas.length >= 1) {// Caso base, una lista de una unica pagina (un unico elemento ya está
			// ordenado)

			puntoMedio = partirLista(listaPaginas, palabrasClave);// Partimos (y ordenamos) la lista

			semiLista1 = new Pagina[puntoMedio];// Creamos y copiamos una semilista de paginas para ordenarla
			for (int i = 0; i < semiLista1.length; i++)// Lo llenamos hasta el puntoMedio-1
				semiLista1[i] = listaPaginas[i];
			ordenarPaginas(semiLista1, palabrasClave);

			semiLista2 = new Pagina[listaPaginas.length - puntoMedio - 1];// Creamos y copiamos la otra semilista
			for (int i = 0; i < semiLista2.length; i++)
				semiLista2[i] = listaPaginas[i + puntoMedio + 1];// Lo rellenamos a partir de la posicion puntomedio+1
			// de la lista original
			if (semiLista2.length > 0)
				ordenarPaginas(semiLista2, palabrasClave);

			// Rellenamos listaPaginas con la nueva ordenacion
			listaPaginas = Arrays.copyOf(semiLista1, listaPaginas.length);
			for (int i = 0; i < semiLista2.length; i++)
				listaPaginas[i + semiLista1.length] = semiLista2[i];

		}

	}

	@Deprecated
	/**
	 * Cabecera: public static int partirLista(Pagina[] listaPaginas, String[]
	 * palabrasClave)
	 *
	 * Comentario: Este método está en deshuso ya que tiene peor rendimiento e internamente es bastante menos legible
	 *
	 * Entradas: String[] palabrasClave.
	 *
	 * Salida: punto por donde se ha partido el array.
	 *
	 * Entrada/Salida: Pagina[] listaPaginas
	 *
	 * Precondiciones: el array no debe estar vacio.
	 *
	 * Postcondiciones: Las siguientes, - Segun las especificaciones, array[ppio],
	 * ...., array[fin] quedara dividido respecto a valorParticion. - Asociado al
	 * nombre del subprograma se devuelve el lugar por el que se divide el array.
	 * Por tanto, el subprograma se dise�ara como funcion.
	 *
	 * @param listaPaginas
	 * @param palabrasClave
	 *
	 * @return particion
	 */
	public static int partirLista(Pagina[] listaPaginas, String[] palabrasClave) {

		int[] palabrasCoincidentes = new int[listaPaginas.length];
		int particion = 0; // Celda en la que se encuentra el valor por el que vamos a partir el array
		// En nuestro caso al pasarle siempre un array siempre trabajamos con la
		// posicion cero como referencia y esta no varia
		// hasta el final del metodo.
		// Hemos mantenido el uso del parametro particion en la totalidad del codigo
		// para ayudar a la legibilidad.
		boolean pageRankMayor = true;
		Pagina paginaAux;

		for (int i = 1, j = listaPaginas.length; i < j;) {// Empezando por el principio (saltandonos la posicion cero
			// que será nuestra pagina a comparar)
			// y el final del array y aseguramos que i siempre menor que j

			// pageRankMayor=true; no es necesario actualizar ya que del bloque anterior
			// siempre sale a falso o sale del bucle principal
			// y en la primera iteracion se ha inicializado a true.

			// avanzamos con el indice i mientras la pagina en esa posicion tenga mas o
			// igual numero de palabras coincidentes que la pagina de particion
			for (; (palabrasCoincidentes[i] >= palabrasCoincidentes[0]) && pageRankMayor; i++) {
				if (palabrasCoincidentes[i] == palabrasCoincidentes[0]) { // En caso de tener el mismo numero valoramos
					// el pageRank
					if (listaPaginas[i].getPageRank() < listaPaginas[0].getPageRank())
						pageRankMayor = false;// Si tiene menos pasamos al siguiente bloque (la pagina es menos
					// relevante
				}
			}

			// pageRankMayor=false; no es necesario actualizar ya que del bloque anterior
			// siempre sale a falso o sale del bucle principal

			// avanzamos con el indice j mientras la pagina en esa posicion tenga menos
			// numero de palabras coincidentes que la pagina de particion
			for (; palabrasCoincidentes[j] < palabrasCoincidentes[0] && !pageRankMayor; j--) {// Ahora pageRank debe ser
				// menor
				if (palabrasCoincidentes[j] == palabrasCoincidentes[0]) { // En caso de tener el mismo numero valoramos
					// el pageRank
					if (listaPaginas[j].getPageRank() > listaPaginas[0].getPageRank())
						pageRankMayor = true;// Si tiene mas pasamos al siguiente bloque (la pagina es mas relevante)
					// En este caso si es (y el anterior) si son iguales hablamos de paginas con la
					// misma relevancia
				}
			}
			// Tenemos la posicion i de una pagina de menor relevancia a la particion y en j
			// una de mayor relevancia
			paginaAux = listaPaginas[i];
			listaPaginas[i] = listaPaginas[j];
			listaPaginas[j] = paginaAux; // Intercambiamos la pagina en i por la pagina en j
			particion = i;// Actualizamos la posicion por la que vamos intercambiando las celdas ya que en
			// la ultima iteracion i=j y este será nuestro
			// punto de particion

		} // Final de busqueda de particion y de ordenacion del array

		// Comprobamos si el ultima caso es
		if (palabrasCoincidentes[0] >= palabrasCoincidentes[particion]) {
			if (palabrasCoincidentes[0] == palabrasCoincidentes[particion]
					&& listaPaginas[0].getPageRank() > listaPaginas[particion].getPageRank()) {
				particion--;
			}
		}
		// Debemos intercambiar el valor de particion para dejarlo en la posicion
		// deseada
		paginaAux = listaPaginas[0];
		listaPaginas[0] = listaPaginas[particion];
		listaPaginas[particion] = paginaAux; // Intercambiamos la pagina en i por la pagina en j

		return particion;
	}

}
