package validaciones;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import clasesBasicas.Pagina;
import gestion.Gestora;
import mensajes.Mensaje;

public class Validacion {
    
	 private static Scanner teclado = new Scanner(System.in);
	 
    /**
     * Cabecera: public static boolean leerValidarRespuestaSiNo()
     *   
     * Comentario: Metodo que lee y valida si una respuesta es S o N. En funcion de esta se devolvera un valor boleano u otro.
     * 
     * Precondiciones: Ninguna
     * 
     * Entrada: Ninguna
     * 
     * Salida: Boolean afirmativo
     * 
     * Postcondiciones: Este metodo se trata de una funciona ya que devuelve en este caso un boleano(afirmativo) cuyo valor sera:
     * 					 -true: si respuesta es 's'.	
     *   				 -false: si respuesta es 'n.
     *   	
     *  @return afirmativo		
     */
    public static boolean leerValidarRespuestaSiNo() {   
        char respuesta;
        boolean afirmativo = true;
        
        System.out.println("Introduzca S (si) / N (no)");
        do {
        	 respuesta = teclado.nextLine().toLowerCase().charAt(0);

        	 if (respuesta != 's' && respuesta != 'n') {
				System.out.println("Error valor introducido invalido, ingrese uno de nuevo:");
        	 }
        	 
        }while(respuesta != 's' && respuesta != 'n');
        
        if(respuesta == 'n') { //Si la respuesta es No
        	afirmativo = false;
        }
        return afirmativo;
    }
    
    /**     
     * Cabecera: public static int leerValidarNumeroEntreRango(int valorInicial, int valorFinal)
     *   
     * Comentario: Este metodo se encarga de leer y validar que un numero este entre un rango.
     *   
     * Precondiciones: El numero valorInicial tiene que ser menor que valorFinal
     *   
     * Entradas: int valorInicial, int valorFinal
     *   
	 * Salidas: int numero 
     *   
     * Postcondiciones: Este metodo se trata de un funcion ya que devuelve un tipo de dato, entero(numero) en este caso,
     *   				 el cual estara entre un rango(valorInicial y valorFinal)
     *   
     * @param valorInicial
     * @param valorFinal
     * 
     * @return numero
     */
    public static int leerValidarNumeroEntreRango(int valorInicial, int valorFinal){
        int numero = 0; 
        
        System.out.println("Ingrese un numero entre("+valorInicial+"-"+valorFinal+")");
        do {
        	
        	numero = teclado.nextInt();
        	teclado.nextLine();
        	if (numero < valorInicial || numero > valorFinal) {
				System.out.println("Numero ingresado no valido, vuelva intentarlo: ");
			}
        	
        }while(numero < valorInicial || numero > valorFinal);
        
        return numero;
    }
    
    /**     
     * Cabecera: public static String obtenerUrl(Pagina[] paginas)
     *   
     * Comentario: Este metodo se encarga de leer una url. Ademas:
     * 			   -Mediante el metodo validarUrl() se validara que la url sea una url que esta bien formada
	 * 			   -Mediante el metodo comprobarExistenciaUrl() se comprobara que la url no sea igual a la url principal 
	 * 			    de alguna de la paginas que contiene un array de tipo Pagina
	 * 
     * Precondiciones: Ninguna
     *   
     * Entradas: Pagina[] paginas
     *   
	 * Salidas: String url
     *   
     * Postcondiciones: Este metodo se trata de un funcion ya que devuelve un tipo de dato, una cadena(url) en este caso,
     * 					la cual sera una url, esta sera una url bien formada y ademas no sera igual a la url principal de alguna 
     * 					de las paginas que hay en un array de tipo Pagina
     *   
     * @param paginas
     * 
     * @return url
     */
    public static String obtenerUrl(Pagina[] paginas) {
    	String url = "";
    	boolean urlValida = false, urlRepetida = false;
    	
    	do {    		
    		do{
        		System.out.println("Ingrese la url de la pagina");
        		url = teclado.nextLine();
    			urlValida = validarUrl(url); //Se comprobara que la url sea una que este bien formada(Que siga la sintaxis de una url)
    			if(!urlValida)
    				System.out.println("La Url introducida no esta bien formada.\n");
    		}while(!urlValida);
    		
    		urlRepetida = Gestora.comprobarExistenciaUrl(paginas, url); //Se comprueba que esa url no sea la url principal de alguna 
    															//de las paginas que hay en un array de tipo Pagina

    		if(urlRepetida)
				System.out.println("La url introducida ya existe");
    	
    	}while(urlRepetida);
    
    	return url;
    }
    
    /**
	 * Cabecera: public static boolean validarUrl(String url) 
	 *   
	 * Comentario: Este metodo se encarga de comprobar si una URL esta bien formada o no.
	 *   
	 * Precondiciones: Ninguna
	 *   
	 * Entrada: String url
	 *   
	 * Salida: boolean valida 
	 *    
	 * Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato(valida), en este caso un boleano el cual tomara los 
	 *   				siguientes valores:
	 *   				-true: si la url es correcta.	
	 *   				-false: si la url no es correcta. 
	 *   
	 * @param url
	 * 
	 * @return valida				
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
    
    /**
	 * Cabecera: public static String leerEnlaceReferente(Pagina[] paginas)
	 *   
	 * Comentario: Este metodo se encarga de leer una url de enlace referente.
	 * 			   Mediante el metodo validarUrl() se validara que la url de enlace referente sea una url que esta bien formada
	 * 			   Mediante el metodo comprobarExistenciaUrl() se comprobara que la url de enlace referente es igual a la url principal 
	 * 			   de alguna de la paginas que contiene un array de tipo Pagina
	 *   
	 * Precondiciones: Ninguna
	 *   
	 * Entrada: Pagina[] paginas
	 *   
	 * Salida: String enlaceReferente
	 *    
	 * Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato, en este caso una cadena(enlaceReferente).
	 * 
	 * @param paginas
	 *  
	 * @return enlaceReferente 				
     */
    public static String leerEnlaceReferente(Pagina[] paginas) {
    	
    	String enlaceReferente = "";
    	boolean urlValida = false, urlExiste = false, continuar = false;
		System.out.println("¿Quieres ingresar un enlace referente a la pagina?");
		
		if( leerValidarRespuestaSiNo() ) { //Si la respuesta que se lee es Si(true)
			
			do {			
				do{
					System.out.println("Ingrese el enlace referente");
					enlaceReferente = teclado.nextLine();
					urlValida = validarUrl(enlaceReferente); //Se comprueba que la url introducida sigue la sintaxis de una URL
					if(!urlValida)
		    			System.out.println("La Url no esta bien formada\n");
				}while(!urlValida); //Mientras el enlaceReferente no sea una url 
				
				urlExiste = Gestora.comprobarExistenciaUrl(paginas, enlaceReferente);//Se comprueba que ese enlace Referente corresponde a 
																			 //la url principal de alguna de las paginas que hay en un array 
																			 //de tipo Pagina
				if(!urlExiste)
					System.out.println("La Url de enlace introducida no corresponde con la Url principal de ninguna de las paginas\n");
					System.out.println("Desea continuar y volver a intentarlo");
					continuar = leerValidarRespuestaSiNo();
					if(!continuar)
						enlaceReferente = "";
			}while(!urlExiste && continuar); //Mientras el enlaceReferente no exista como url principal de otra pagina
			
		} 
		return enlaceReferente;
	}

    /**
	 * Cabecera: public static String[] leerPalabrasClaves()
	 *   
	 * Comentario: Este metodo se encarga de leer las palabras claves que se desee que tenga una pagina
	 * 			   Mediante el metodo eliminarPalabrasRepetida() se eliminaran aquellas palabras que esten repetidas
	 *   
	 * Precondiciones: Ninguna
	 *   
	 * Entrada: Ninguna
	 *   
	 * Salida: String[] palabrasClaves
	 *    
	 * Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato, en este caso un array de cadena(palabrasClaves).
	 *  
	 * @return palabrasClaves 				
     */
	public static String[] leerPalabrasClaves() {
    	
    	String[] palabrasClaves = null;
    	String palabras = "";
		System.out.println("¿Quieres ingresar una palabra clave?");
		
		if( leerValidarRespuestaSiNo() ) { //Si la respuesta que se lee es Si(true) 

			Mensaje.introducirPalabrasClave();
			palabras = teclado.next();

			palabrasClaves = palabras.split(" "); //Se guardan las palabras separadas por un espacio
			teclado.nextLine();
		} 
		
		if(palabrasClaves != null)
			Gestora.eliminarPalabrasRepetida(palabrasClaves); //Elimina las palabras que haya repetidas
		return palabrasClaves;
	}

    /**
	 * Cabecera: public static String leerDescripcion()
	 *   
	 * Comentario: Este metodo se encarga de leer una cadena, que sera la descripcion de una pagina
	 *   
	 * Precondiciones: Ninguna
	 *   
	 * Entrada: Ninguna
	 *   
	 * Salida: String(cadena)
	 *    
	 * Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato, en este caso una cadena.
	 *  
	 * @return teclado.nextLine();				
     */
	public static String leerDescripcion() {
    	return teclado.nextLine();
	}
    
    /**
	 * Cabecera: public static void cerrarTeclado()
	 *   
	 * Comentario: Este metodo se encarga de cerrar el flujo de entrada de datos de un objeto de tipo Scanner
	 *   
	 * Precondiciones: Ninguna
	 *   
	 * Entrada: Ninguna
	 *   
	 * Salida: Ninguna
	 *    
	 * Postcondiciones: Se cerrara el obtejo compartido de tipo Scanner.
	 *  				
     */
    public static void cerrarTeclado() {
    	teclado.close();
    }
    
}