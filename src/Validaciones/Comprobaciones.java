package Validaciones;

import java.util.Scanner;

public class Comprobaciones {
    
    /*
    	Metodo que pregunta Si o No y devuelve true en caso de seleccionar si o false en caso contrario
        Signatura: public boolean leerValidarRespuestaSiNo (Scanner teclado) 
        Precondiciones: Ninguna
        Entrada: Scanner teclado
        Salida: Boolean afirmativo  
        Postcondiciones: Este metodo se trata de una funciona ya que devuelve en este caso un boleano(afirmativo) cuyo valor sera:
        				 -true: si respuesta es 's'	
        				 -false: si respuesta es 'n'
        				
    */
    public boolean leerValidarRespuestaSiNo (Scanner teclado) {   
        char respuesta;
        boolean afirmativo = true;
        
        System.out.println("Introduzca S (si)/ N (no)");
        do {
        	 respuesta=teclado.next().toLowerCase().charAt(0);

        	 if (respuesta!='s' && respuesta!='n') {
				System.out.println("Error valor introducido invalido, ingrese uno de nuevo:");
			}
        	 
        }while(respuesta != 's' && respuesta != 'n');
        
        if(respuesta == 'n') { //Si la respuesta es No
        	afirmativo = false;
        }
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