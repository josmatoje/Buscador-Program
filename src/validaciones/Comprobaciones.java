package validaciones;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import clasesBasicas.Pagina;

public class Comprobaciones {
    
    /*
        Signatura: public boolean leerValidarRespuestaSiNo (Scanner teclado) 
        
        Comentario: Metodo que lee y valida si una respuesta es S o N. En funcion de esta se devolvera un valor boleano u otro.
        
        Precondiciones: Ninguna
        
        Entrada: Scanner teclado
        
        Salida: Boolean afirmativo 
         
        Postcondiciones: Este metodo se trata de una funciona ya que devuelve en este caso un boleano(afirmativo) cuyo valor sera:
        				 -true: si respuesta es 's'.	
        				 -false: si respuesta es 'n.
        				
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
        Signatura:public int leerValidarNumeroEntreRango(int valorInicial, int valorFinal, Scanner teclado)
        
        Comentario: Este metodo se encarga de leer y validar que un numero este entre un rango.
        
        Precondiciones: El numero valorInicial tiene que ser menor que valorFinal
        
        Entradas:
         		 Scanner teclado
        		 int valorInicial, valorFinal
        
		Salidas: int numero 
        
        Postcondiciones: Este metodo se trata de un funcion ya que devuelve un tipo de dato, entero(numero) en este caso,
        				 el cual estara entre un rango(valorInicial y valorFinal)
    */

    public int leerValidarNumeroEntreRango(int valorInicial, int valorFinal, Scanner teclado){
        int numero = 0; 
        
        System.out.println("Ingrese un numero entre ("+valorInicial+"-"+valorFinal+")");
        do {
        	
        	numero = teclado.nextInt();
        	if (numero < valorInicial || numero > valorInicial) {
				System.out.println("Numero ingresado no valido, vuelva intentarlo: ");
			}
        	
        }while(numero < valorInicial || numero > valorInicial);
        
        return numero;
    }
    
    /**Precondiociones=Ninguna
     * Postcondiciones= Este metodo nos sirve para validar lo introducido por teclado en el menu principal. Para ello nos devolvera
     * un boolean que sera verdadero en caso de que sea un numero valido y false si no lo es.
     * Entrada: String eleccion
     * Salida=boolean eleccionCorrecta
     * 
     * @param eleccion
     * @return eleccionCorrecta
     */
    
    public boolean menuPrincipal(String eleccion) {
    	boolean eleccionCorrecta=true;
    	switch(eleccion) {
    	case "1" -> System.out.println();
    	case "2" -> System.out.println();
    	case "3" -> System.out.println();
    	case "4" -> System.out.println();
    	default -> eleccionCorrecta=false;
    	}
    	return eleccionCorrecta;
    }
    
    public boolean validarUrl(String url) {
    	boolean valida;

    	try {    		
			URL urlValida = new URL(url);			
			valida = true;
		} catch (MalformedURLException e) {
			valida = false;
		}  	
    	return valida;
    }
 
    public boolean validarExistenciaUrl(Pagina[] paginas,String url) {
    	boolean urlValida = false;
    	for(int i = 0; i < paginas.length && !urlValida;i++) {
    		if (!url.equals(paginas[i].getUrl())) {
					urlValida = true;
			}
    	}
    	return urlValida;
    }
}