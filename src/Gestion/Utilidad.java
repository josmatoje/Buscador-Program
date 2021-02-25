package Gestion;

import ClasesBasicas.Pagina;

public class Utilidad {

    public static String[] aumentarArray (String[] arrayLleno, int celdasExtra){

        String[] arrayDoble = new String [arrayLleno.length+celdasExtra+1]; //Creamos un array del tamaño*2 del array que queremos duplicar
        for(int i=0; i<arrayLleno.length; i++)
            arrayDoble[i]=arrayLleno[i];

        return arrayDoble;
    }

    public static Pagina[] ordenarPaginas (Pagina[] listaPaginas, String[] palabrasClave){

        int longitud;
        String[] palabrasAuxiliar;
        int[] posiciones= new int [listaPaginas.length] ;
        Pagina auxiliar;

        for (int i=0; i<listaPaginas.length; i++){
            palabrasAuxiliar=listaPaginas[i].getPalabrasClaves();
            longitud= Math.min(palabrasClave.length, palabrasAuxiliar.length);//Cogemos el valor mas bajo
            for(int j=0; j<longitud; j++){

            }
        }

        return listaPaginas;
    }

    public int palabrasCoincidentes(String[] palabrasPagina, String[] palabrasComprobar){


        int contador=0, longitud = Math.min(palabrasPagina.length, palabrasComprobar.length);//Cogemos el valor mas bajo

        for(int i=0; i<longitud; i++){
            if(palabrasComprobar[i]==palabrasPagina[])
        }


    }

}
