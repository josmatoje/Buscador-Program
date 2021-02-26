package gestion;

import clasesBasicas.Pagina;

public class Utilidad {
	/**
	 * Precondiciones=que la array introducida este creada e inicializada
	 * Postcondiciones: Este metodo nos coge una array de paginas y nos devuelve un array con los mismos valores pero de longitud doble
	 * Entrada: Pagina[] arrayLleno
	 * Salida: Pagina[] arrayDoble
	 * @param arrayLleno
	 * @return arrayDoble
	 */

    public static Pagina[] aumentarArray (Pagina[] arrayLleno){

        Pagina[] arrayDoble = new Pagina [arrayLleno.length*2]; //Creamos un array del tamaño*2 del array que queremos copiar
        for(int i=0; i<arrayLleno.length; i++)
            arrayDoble[i]=arrayLleno[i];

        return arrayDoble;
    }

    public static void ordenarPaginas (Pagina[] listaPaginas, String[] palabrasClave){

        int puntoMedio;
        Pagina[] semiLista;
        Pagina auxiliar;

        if(listaPaginas.length>1) {//Caso base, una lista de una unica pagina (un unico elemento ya está ordenado)

            puntoMedio = partirLista(listaPaginas, palabrasClave);//Partimos (y ordenamos) la lista

            semiLista= new Pagina[puntoMedio];//Creamos y copiamos una semilista de paginas para ordenarla
            for(int i =0; i<semiLista.length; i++)//Lo llenamos hasta el puntoMedio-1
                semiLista[i]=listaPaginas[i];
            ordenarPaginas(semiLista,palabrasClave);

            if(listaPaginas.length-puntoMedio-1>0) {//Caso de una lista de paginas de logitud dos se desprecia este caso
                semiLista = new Pagina[listaPaginas.length - puntoMedio - 1];//Creamos y copiamos la otra semilista
                for (int i = 0; i < semiLista.length; i++)
                    semiLista[i] = listaPaginas[i + puntoMedio + 1];//Lo rellenamos a partir de la posicion puntomedio+1 de la lista original
                ordenarPaginas(semiLista, palabrasClave);
            }

        }

    }

    public static int partirLista(Pagina[] listaPaginas, String[] palabrasClave){

        int[] palabrasCoincidentes= new int [listaPaginas.length] ;
        int particion=0; //Celda en la que se encuentra el valor por el que vamos a partir el array
        //En nuestro caso al pasarle siempre un array siempre trabajamos con la posicion cero como referencia y esta no varia
        // hasta el final del metodo.
        // Hemos mantenido el uso del parametro particion en la totalidad del codigo para ayudar a la legibilidad.
        boolean pageRankMayor = true;
        Pagina paginaAux;

        //Genera un array de enteros con el numero de palabras coincidentes para cada pagina de la lista dada
        for (int i=0; i<listaPaginas.length; i++)
            palabrasCoincidentes[i]=palabrasCoincidentes(listaPaginas[i].getPalabrasClaves(),palabrasClave);

        for(int i=1, j=listaPaginas.length; i<j;){//Empezando por el principio (saltandonos la posicion cero que será nuestra pagina a comparar)
            // y el final del array y aseguramos que i siempre menor que j
            
            //pageRankMayor=true; no es necesario actualizar ya que del bloque anterior siempre sale a falso o sale del bucle principal
            // y en la primera iteracion se ha inicializado a true.

            //avanzamos con el indice i mientras la pagina en esa posicion tenga mas o igual numero de palabras coincidentes que la pagina de particion
            for(;palabrasCoincidentes[i]>=palabrasCoincidentes[0]&&pageRankMayor;i++){
                if(palabrasCoincidentes[i]==palabrasCoincidentes[0]){ //En caso de tener el mismo numero valoramos el pageRank
                    if(listaPaginas[i].getPageRank()<listaPaginas[0].getPageRank())
                        pageRankMayor=false;//Si tiene menos pasamos al siguiente bloque (la pagina es menos relevante
                }
            }
            
            //pageRankMayor=false; no es necesario actualizar ya que del bloque anterior siempre sale a falso o sale del bucle principal
            
            //avanzamos con el indice j mientras la pagina en esa posicion tenga menos numero de palabras coincidentes que la pagina de particion
            for(;palabrasCoincidentes[j]<palabrasCoincidentes[0]&&!pageRankMayor;j++){//Ahora pageRank debe ser menor
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

    /**  Descripcion: Compara dos arrays de cadenas y devuelve el numero de veces que coinciden cadenas en ambos string
     *Precondiciones: No se encuentran palabras repetidas en niguna de las cadenas que se pasan por parametros
     *Postcondiciones: Le damos dos array de String y el metodo nos devuelve el numero de veces que coinciden las palabras de un array en la otra.
     *Entrada:String[] palabrasPagina, String[] palabrasComprobar
     *Salida:int contador
     * 
     * @param palabrasPagina
     * @param palabrasComprobar
     * @return
     */
    public static int palabrasCoincidentes(String[] palabrasPagina, String[] palabrasComprobar){

        int contador=0;
        boolean comprobado;

        for(int i=0; i<palabrasComprobar.length; i++){
            comprobado=false;
            for(int j=0; i<palabrasPagina.length && !comprobado; i++){
                if(palabrasComprobar[i].equals(palabrasPagina[j]) ) {
                    contador++;
                    comprobado=true;
                }
            }
        }

        return contador;
    }

}
