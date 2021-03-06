package gestion;

import clasesBasicas.Pagina;

import gestion.Utilidad;

import java.util.Arrays;

public class Gestora {

    /**
     * Entradas: array paginas y objeto p de la clase Pagina
     * Salida: Ninguna
     * Precondiciones: Crear la array paginas, asi como el objeto p
     * Postcondiciones: La variable aumentado es false si el enlace referente de la pagina p no coincide con ninguna url de la array paginas.
     * Si el url de alguna pagina coincide con la referente de la dada, el page rank de la primera aumentara en uno y aumentado es true.
     *
     * @param paginas
     * @param paginaNueva
     */
    public static void aumentarPageRankPaginaEnlace(Pagina[] paginas, Pagina paginaNueva) {
        boolean modificado = false;
        for(int i = 0; i < paginas.length && !modificado; i++) {
            if(paginas[i] != null && paginaNueva.getEnlacesReferente().equals(paginas[i].getUrl())) {
                paginas[i].setPageRank(paginas[i].getPageRank()+1);
                modificado = true;
            }
        }
    }
    
    /**
     * Entradas: array paginas y objeto p de la clase Pagina
     * Salida: Ninguna
     * Precondiciones: Crear la array paginas, asi como el objeto p
     * Postcondiciones: La variable aumentado es false si el enlace referente de la pagina p no coincide con ninguna url de la array paginas.
     * Si el url de alguna pagina coincide con la referente de la dada, el page rank de la primera aumentara en uno y aumentado es true.
     *
     * @param paginas
     * @param urlEnlace
     */
    public static void disminuirPageRankPaginaEnlace(Pagina[] paginas, String urlEnlace) {
        boolean modificado = false;
        for(int i = 0; i < paginas.length && !modificado; i++) {
            if(paginas[i] != null && paginas[i].getUrl().equals(urlEnlace)) {
                paginas[i].setPageRank(paginas[i].getPageRank()-1);
                modificado = true;
            }
        }
    }
    /**
     * Precondiciones: array paginas y objeto p de la clase Pagina
     * Postcondiciones: 
     * @param paginas
     * @param p
     * @return insertarPagina
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

    /*
    Entradas: un array de paginas y un array de cadenas.
    Precondiciones: el array (lista) no debe estar vacío.
    Salida: el mismo array (cambiado).
    Postcondiciones: lista está ordenado descendentemente según el criterio de palabras clave dado.
     */
    public static void ordenarPaginas (Pagina[] listaPaginas, String[] palabrasClave){

        int puntoMedio;
        Pagina[] semiLista1, semiLista2;

        if(listaPaginas.length>=1) {//Caso base, una lista de una unica pagina (un unico elemento ya está ordenado)

            puntoMedio = partirLista(listaPaginas, palabrasClave);//Partimos (y ordenamos) la lista

            semiLista1= new Pagina[puntoMedio];//Creamos y copiamos una semilista de paginas para ordenarla
            for(int i =0; i<semiLista1.length; i++)//Lo llenamos hasta el puntoMedio-1
                semiLista1[i]=listaPaginas[i];
            ordenarPaginas(semiLista1,palabrasClave);

            semiLista2 = new Pagina[listaPaginas.length - puntoMedio - 1];//Creamos y copiamos la otra semilista
            for (int i = 0; i < semiLista2.length; i++)
                semiLista2[i] = listaPaginas[i + puntoMedio + 1];//Lo rellenamos a partir de la posicion puntomedio+1 de la lista original
            if(semiLista2.length>0)
                ordenarPaginas(semiLista2, palabrasClave);

            //Rellenamos listaPaginas con la nueva ordenacion
            listaPaginas= Arrays.copyOf(semiLista1,listaPaginas.length);
            for(int i = 0;i<semiLista2.length;i++)
                listaPaginas[i+semiLista1.length]=semiLista2[i];

        }

    }

    /*
        Entradas: un array de paginas y un array de cadenas.
        Salida: el mismo array (cambiado).
          */

    /**
     * Precondiciones: el array (lista) no debe estar vacío.
     * Postcondiciones: lista [0],...,lista[N-1] está ordenado descendentemente según el criterio de palabras clave dado.
     * @param listaPaginas
     * @param palabrasClave
     * @param inicio
     * @param fin
     */
    public static void ordenarPaginas (Pagina[] listaPaginas, String[] palabrasClave, int inicio, int fin){

        int puntoMedio;

        if(inicio<fin) {//Caso base, indicesno definen un segmento del array
            puntoMedio = partirLista(listaPaginas, palabrasClave,inicio,fin);//Partimos (y ordenamos) la lista
            ordenarPaginas(listaPaginas,palabrasClave,inicio,puntoMedio-1);
            ordenarPaginas(listaPaginas, palabrasClave, puntoMedio+1,fin);
        }
    }

    /*
    Entradas: un array, el índice de la primera y de la última casilla.
    Precondiciones: el array no debe estar vacío.
    Salida: el mismo array (cambiado) y el punto por donde se ha partido el array.
    Postcondiciones: Las siguientes,
        - Según las especificaciones, array[ppio], ...., array[fin] quedará dividido
        respecto a valorParticion.
        - Asociado al nombre del subprograma se devuelve el lugar por el que se
        divide el array. Por tanto, el subprograma se diseñará como función.
     */
    public static int partirLista(Pagina[] listaPaginas, String[] palabrasClave){

        int[] palabrasCoincidentes= new int [listaPaginas.length];
        int particion=0; //Celda en la que se encuentra el valor por el que vamos a partir el array
        //En nuestro caso al pasarle siempre un array siempre trabajamos con la posicion cero como referencia y esta no varia
        // hasta el final del metodo.
        // Hemos mantenido el uso del parametro particion en la totalidad del codigo para ayudar a la legibilidad.
        boolean pageRankMayor = true;
        Pagina paginaAux;

        //Genera un array de enteros con el numero de palabras coincidentes para cada pagina de la lista dada
        for (int i=0; i<listaPaginas.length; i++)
            palabrasCoincidentes[i]=Utilidad.palabrasCoincidentes(listaPaginas[i].getPalabrasClaves(),palabrasClave);

        for(int i=1, j=listaPaginas.length; i<j;){//Empezando por el principio (saltandonos la posicion cero que será nuestra pagina a comparar)
            // y el final del array y aseguramos que i siempre menor que j

            //pageRankMayor=true; no es necesario actualizar ya que del bloque anterior siempre sale a falso o sale del bucle principal
            // y en la primera iteracion se ha inicializado a true.

            //avanzamos con el indice i mientras la pagina en esa posicion tenga mas o igual numero de palabras coincidentes que la pagina de particion
            for(;(palabrasCoincidentes[i]>=palabrasCoincidentes[0])&&pageRankMayor;i++){
                if(palabrasCoincidentes[i]==palabrasCoincidentes[0]){ //En caso de tener el mismo numero valoramos el pageRank
                    if(listaPaginas[i].getPageRank()<listaPaginas[0].getPageRank())
                        pageRankMayor=false;//Si tiene menos pasamos al siguiente bloque (la pagina es menos relevante
                }
            }

            //pageRankMayor=false; no es necesario actualizar ya que del bloque anterior siempre sale a falso o sale del bucle principal

            //avanzamos con el indice j mientras la pagina en esa posicion tenga menos numero de palabras coincidentes que la pagina de particion
            for(;palabrasCoincidentes[j]<palabrasCoincidentes[0]&&!pageRankMayor;j--){//Ahora pageRank debe ser menor
                if(palabrasCoincidentes[j]==palabrasCoincidentes[0]){ //En caso de tener el mismo numero valoramos el pageRank
                    if(listaPaginas[j].getPageRank()>listaPaginas[0].getPageRank())
                        pageRankMayor=true;//Si tiene mas pasamos al siguiente bloque (la pagina es mas relevante)
                    //En este caso si es (y el anterior) si son iguales hablamos de paginas con la misma relevancia
                }
            }
            //Tenemos la posicion i de una pagina de menor relevancia a la particion y en j una de mayor relevancia
            paginaAux=listaPaginas[i];
            listaPaginas[i]=listaPaginas[j];
            listaPaginas[j]=paginaAux; //Intercambiamos la pagina en i por la pagina en j
            particion=i;//Actualizamos la posicion por la que vamos intercambiando las celdas ya que en la ultima iteracion i=j y este será nuestro
            // punto de particion

        }//Final de busqueda de particion y de ordenacion del array

        //Comprobamos si el ultima caso es
        if(palabrasCoincidentes[0]>=palabrasCoincidentes[particion]){
            if(palabrasCoincidentes[0]==palabrasCoincidentes[particion] && listaPaginas[0].getPageRank()>listaPaginas[particion].getPageRank()){
                particion--;
            }
        }
        //Debemos intercambiar el valor de particion para dejarlo en la posicion deseada
        paginaAux=listaPaginas[0];
        listaPaginas[0]=listaPaginas[particion];
        listaPaginas[particion]=paginaAux; //Intercambiamos la pagina en i por la pagina en j

        return particion;
    }


    /*
    Entradas: un array, el índice de la primera y de la última casilla.
    Precondiciones: el array no debe estar vacío.
    Salida: el mismo array (cambiado) y el punto por donde se ha partido el array.
    Postcondiciones: Las siguientes,
        - Según las especificaciones, array[ppio], ...., array[fin] quedará dividido
        respecto a valorParticion.
        - Asociado al nombre del subprograma se devuelve el lugar por el que se
        divide el array. Por tanto, el subprograma se diseñará como función.
     */
    public static int partirLista(Pagina[] listaPaginas, String[] palabrasClave, int inicio, int fin){

        int[] palabrasCoincidentes= new int [fin-inicio+1] ;
        int particion = inicio;//El programa asume la pagina de inicio como la de particion
        boolean pageRankMayor = true;
        Pagina paginaAux;

        //Genera un array de enteros con el numero de palabras coincidentes para cada pagina del fragmento de lista dado
        for (int i=0; i<palabrasCoincidentes.length; i++)
            palabrasCoincidentes[i]=Utilidad.palabrasCoincidentes(listaPaginas[inicio+i].getPalabrasClaves(),palabrasClave);

        for(int i=inicio+1, j=fin; i<j;){//recorremos el array desde el pinicio y el final y aseguramos que i siempre menor que j

            //pageRankMayor=true; no es necesario actualizar ya que del bloque anterior siempre sale a falso o sale del bucle principal
            // y en la primera iteracion se ha inicializado a true.

            //avanzamos con el indice i mientras la pagina en esa posicion tenga mas o igual numero de palabras coincidentes que la pagina de particion (0)
            for(;(palabrasCoincidentes[i-inicio]>=palabrasCoincidentes[0])&&pageRankMayor;i++){
                if(palabrasCoincidentes[i-inicio]==palabrasCoincidentes[0]){ //En caso de tener el mismo numero valoramos el pageRank
                    if(listaPaginas[i].getPageRank()<listaPaginas[inicio].getPageRank())
                        pageRankMayor=false;//Si tiene menos pasamos al siguiente bloque (la pagina es menos relevante)
                }
            }

            //pageRankMayor=false; no es necesario actualizar ya que del bloque anterior siempre sale a falso o sale del bucle principal

            //avanzamos con el indice j mientras la pagina en esa posicion tenga menos numero de palabras coincidentes que la pagina de particion
            for(;palabrasCoincidentes[j-inicio]<=palabrasCoincidentes[0]&&!pageRankMayor;j--){//Ahora pageRank debe ser menor
                if(palabrasCoincidentes[j-inicio]==palabrasCoincidentes[0]){ //En caso de tener el mismo numero valoramos el pageRank
                    if(listaPaginas[j].getPageRank()>listaPaginas[inicio].getPageRank())
                        pageRankMayor=true;//Si tiene mas pasamos al siguiente bloque (la pagina es mas relevante)
                    //En este caso si es (y el anterior) si son iguales hablamos de paginas con la misma relevancia
                }
            }

            //Tenemos la posicion i de una pagina de menor relevancia a la particion y en j una de mayor relevancia
            paginaAux=listaPaginas[j];
            listaPaginas[j]=listaPaginas[i];
            listaPaginas[i]=paginaAux; //Intercambiamos la pagina en i por la pagina en j
            particion=i;//Actualizamos la posicion por la que vamos intercambiando las celdas ya que en la ultima iteracion i=j
            //este será nuestro punto de particion

        }//Final de busqueda de particion y de ordenacion del array

        //Comprobamos si el ultima caso la pagina es menos relevante que la pagina de particion
        if(palabrasCoincidentes[0]>=palabrasCoincidentes[particion-inicio]){
            if(palabrasCoincidentes[0]==palabrasCoincidentes[particion] && listaPaginas[inicio].getPageRank()>listaPaginas[particion].getPageRank()){
                particion--;//En caso afirmativo lo dejamos a la derecha
            }
        }
        //Debemos intercambiar el valor de particion para dejarlo en la posicion deseada
        paginaAux=listaPaginas[inicio];
        listaPaginas[inicio]=listaPaginas[particion];
        listaPaginas[particion]=paginaAux; //Intercambiamos la pagina en i por la pagina en j

        return particion;
    }
    
	/*
	  
	  
	 */
	public static void eliminarPalabrasRepetida(String[] palabras) {
		boolean repetida = false; 
		for(int i = 0; i < palabras.length; i++) {
			repetida = false;
			for(int j = i; j < palabras.length && !repetida; j++) {
				if(i != j && !palabras[i].equals("") && palabras[i].equals(palabras[j]) ) {
					palabras[i] = "";
					repetida = true;					
				}
			}
		}
	}
}
