package validaciones;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import clasesBasicas.Pagina;
import gestion.Gestora;

public class Validacion {
    
	 private static Scanner teclado = new Scanner(System.in);
	 
    /*
        Signatura: public boolean leerValidarRespuestaSiNo () 
        
        Comentario: Metodo que lee y valida si una respuesta es S o N. En funcion de esta se devolvera un valor boleano u otro.
        
        Precondiciones: Ninguna
        
        Entrada: Scanner teclado
        
        Salida: Boolean afirmativo 
         
        Postcondiciones: Este metodo se trata de una funciona ya que devuelve en este caso un boleano(afirmativo) cuyo valor sera:
        				 -true: si respuesta es 's'.	
        				 -false: si respuesta es 'n.
        				
    */
    public static boolean leerValidarRespuestaSiNo () {   
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
        Signatura:public int leerValidarNumeroEntreRango(int valorInicial, int valorFinal)
        
        Comentario: Este metodo se encarga de leer y validar que un numero este entre un rango.
        
        Precondiciones: El numero valorInicial tiene que ser menor que valorFinal
        
        Entradas:
         		 Scanner teclado
        		 int valorInicial, valorFinal
        
		Salidas: int numero 
        
        Postcondiciones: Este metodo se trata de un funcion ya que devuelve un tipo de dato, entero(numero) en este caso,
        				 el cual estara entre un rango(valorInicial y valorFinal)
    */

    public static int leerValidarNumeroEntreRango(int valorInicial, int valorFinal){
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
    
    /*
     
      
     */
    public static String obtenerValidarUrl(Pagina[] paginas) {
    	String url = "";
    	boolean urlValida = false, urlRepetida = false;
    	
    	do {
    		System.out.println("Ingrese la url de la pagina");
    		url = teclado.nextLine();
    		urlValida = validarUrl(url);
    		urlRepetida = comprobarExistenciaUrl(paginas, url);
    		
    		if(!urlValida || urlRepetida) {
    			System.out.println("Url introducida invalida.");
    		}
    	
    	}while(!urlValida || urlRepetida);
    
    	return url;
    }
    /*
	    Signatura:  public boolean validarUrl(String url) 
	    
	    Comentario: Este metodo se encarga de comprobar si una URL esta bien formada o no.
	    
	    Precondiciones: Ninguna
	    
	    Entrada: String url
	    
	    Salida: Boolean valida 
	     
	    Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato(valida), en este caso un boleano el cual tomara los 
	    				 siguientes valores:
	    				 -true: si la url es correcta.	
	    				 -false: si la url no es correcta.   				
     */
    public static boolean validarUrl(String url) {
    	boolean valida;

    	try {    		
			URL urlValida = new URL(url);			
			valida = true;
		} catch (MalformedURLException e) { //Si la cadena url que se le pasa al objeto urlValida no es realmente una url se lanza 
											//un MalformedURLException la cual indica que se intento crear un objeto de tipo URL a 
											//partir de una cadena que no es una url
			valida = false;
		}  	
    	return valida;
    }
    
    /*
	    Signatura: public boolean comprobarExistenciaUrl(Pagina[] paginas,String url)
	    
	    Comentario: Este metodo se encarga de comprobar si la URL de enlace de una pagina, es la url principal de alguna de las paginas 
	    			que hay en un array de paginas
	    
	    Precondiciones: Pagina[] paginas,String url
	    
	    Entrada: String url
	    
	    Salida: Boolean existe 
	     
	    Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato(existe), en este caso un boleano el cual tomara los 
	    				 siguientes valores:
	    				 -true: si la url de enlace de una pagina es la url principal de otra pagina	
	    				 -false: si la url de enlace de una pagina no es la url principal de otra pagina	  				
     */
    public static boolean comprobarExistenciaUrl(Pagina[] paginas,String url) {
    	boolean existe = false;
    	for(int i = 0; i < paginas.length && !existe;i++) {
    		if (!url.equals(paginas[i].getUrl())) {
    			existe = true;
			}
    	}
    	return existe;
    } 
    
    /*
      
      
      
     */
    public static String leerValidarEnlaceReferente(Pagina[] paginas) {
    	
    	String enlaceReferente = "";
    	boolean urlValida = false, urlExiste = false;
		System.out.println("Quieres ingresar un enlace referente a la pagina");
		
		if( leerValidarRespuestaSiNo() ) { //Delvuelve true, es que Si 
			
			do {			
				do{
					System.out.println("Ingrese el enlace referente");
					enlaceReferente = teclado.nextLine();
					urlValida = validarUrl(enlaceReferente);
				}while( !urlValida ); //Mientras el enlaceReferente no sea una url 
				
				urlExiste = comprobarExistenciaUrl(paginas, enlaceReferente);	
			}while( urlExiste ); //Mientras el enlaceReferente sea una url que existe
			
		} 
		return enlaceReferente;
	}
    	
    /*
      
      
     */
    public static String[] leerValidarPalabrasClaves() {
    	
    	String[] palabrasClaves = null;
    	String palabras = "";
		System.out.println("Quieres ingresar una palabra clave");
		
		if( leerValidarRespuestaSiNo() ) { //Delvuelve true, es que Si 

			System.out.println("Ingrese todas las palabras separadas por un espacio");
			palabras = teclado.nextLine();

			palabrasClaves = palabras.split(" "); //Se guardan las palabras separadas por un espacio
		
		} 
		
		Gestora.eliminarPalabrasRepetida(palabrasClaves); //Elimina las palabras que haya repetidas
		return palabrasClaves;
	}
    
    /*
      
      
     */
    public static void cerrarTeclado() {
    	teclado.close();
    }
    
}