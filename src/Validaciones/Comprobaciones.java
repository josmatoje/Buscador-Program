package Validaciones;

import java.util.Scanner;

public class Comprobaciones {
    
    /*
    Metodo que pregunta Si o No y devuelve true en caso de seleccionar si o false en caso contrario
        Signatura: public boolean validacionSiNo () 
        Precondiciones: --
        Entrada: objeto de la clase Scanner
        Salida: boleano 
        Postcondiciones:--
    */
    public boolean validacionSiNo (Scanner teclado) {
    
        char respuesta;
        boolean afirmativo;
        
        
        System.out.println("Introduzca S (si)/ N (no)");
        respuesta=teclado.next().toLowerCase().charAt(0);

        while(respuesta!='s' && respuesta!='n'){
            System.out.println("Introduzca S o N");
            respuesta=teclado.next().toLowerCase().charAt(0);
        }
        
        afirmativo = respuesta=='s'; //Si respuesta=='s' afirmativo es true, en caso contrario es false
        
        return afirmativo;
    }


    /*
    Metodos que comprueban si el valor dado está entre un valor n y otro m
        Signatura:public int valorEntrenym(int eleccion, int valorInicial, int valorFinal, Scanner teclado)
        Precondiciones: --
        Entrada: enteros maximo y minimo entre los que se quiere acotar la eleccion, objeto de la clase Scanner
        Entrada/Salida: Entero que representa la eleccion (validada al salir) 
        Postcondiciones: el numero debe ser >= el valor inicial y menor o igual que el valor maximo
    */

    public int valorEntrenym(int eleccion, int valorInicial, int valorFinal, Scanner teclado){
        
        while(eleccion<valorInicial || eleccion>valorFinal){
            System.out.println("Introduzca un valor válido (de " + valorInicial + " a " + valorFinal + "): ");
            eleccion=teclado.nextInt();
        }
        
        return eleccion;
    }

}