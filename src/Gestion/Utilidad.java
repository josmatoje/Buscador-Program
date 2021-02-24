package Gestion;

public class Utilidad {

    public static String[] aumentarArray (String[] arrayLleno, int celdasExtra){

        String[] arrayDoble = new String [arrayLleno.length+celdasExtra+1]; //Creamos un array del tamaño*2 del array que queremos duplicar
        for(int i=0; i<arrayLleno.length; i++)
            arrayDoble[i]=arrayLleno[i];

        return arrayDoble;
    }

}
