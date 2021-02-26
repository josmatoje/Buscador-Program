package Gestion;

import ClasesBasicas.Pagina;

public class Utilidad {

    public static String[] aumentarArray (String[] arrayLleno){

        String[] arrayDoble = new String [arrayLleno.length*2]; //Creamos un array del tamaño*2 del array que queremos copiar
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

        int[] posiciones= new int [listaPaginas.length] ;
        int particion=listaPaginas.length/2;

        //Genera un array de enteros con el numero de palabras coincidentes para cada pagina de la lista dada
        for (int i=0; i<listaPaginas.length; i++)
            posiciones[i]=palabrasCoincidentes(listaPaginas[i].getPalabrasClaves(),palabrasClave);



        return particion;
    }

    /*
    Descripcion: Compara dos arrays de cadenas y devuelve el numero de veces que coinciden cadenas en ambos string
    Precondiciones: No se encuentran palabras repetidas en niguna de las cadenas que se pasan por parametros
    Postcondiciones:
     */
    public static int palabrasCoincidentes(String[] palabrasPagina, String[] palabrasComprobar){

        int contador=0;
        boolean comprobado;

        for(int i=0; i<palabrasComprobar.length; i++){
            comprobado=false;
            for(int j=0; i<palabrasPagina.length; i++){
                if(palabrasComprobar[i].equals(palabrasPagina[j]) && !comprobado) {
                    contador++;
                    comprobado=true;
                }
            }
        }

        return contador;
    }

}
