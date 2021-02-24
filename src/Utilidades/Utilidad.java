package Utilidades;

public class Utilidad {

    public static String[] aumentarArray (String[] arrayLleno){

        String[] arrayDoble = new String [arrayLleno.length*2];
        for(int i=0; i<arrayLleno.length; i++)
            arrayDoble[i]=arrayLleno[i];

        return arrayDoble;
    }
}
