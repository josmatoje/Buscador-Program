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
     * <b>Cabecera:</b> public static boolean leerValidarRespuestaSiNo()<br>
     *   <br>
     * <b>Comentario:</b> Metodo que lee y valida si una respuesta es S o N. En funcion de esta se devolvera un valor boleano u otro.<br>
     * <br>
     * <b>Precondiciones:</b> Ninguna<br>
     * <br>
     * <b>Entrada:</b> Ninguna<br>
     * <br>
     * <b>Salida:</b> Boolean afirmativo<br>
     * <br>
     * <b>Postcondiciones:</b> Este metodo se trata de una funciona ya que devuelve en este caso un boleano(afirmativo) cuyo valor sera:<br>
     * 	&nbsp;&nbsp;&nbsp;&nbsp;-true: si respuesta es 's'.<br>
     *  &nbsp;&nbsp;&nbsp;&nbsp;-false: si respuesta es 'n.<br>
     *   	<br>
     *  @return afirmativo	<br>
     */
    public static boolean leerValidarRespuestaSiNo() {   
        char respuesta=' ';
        boolean afirmativo = true;
        
        System.out.println("Introduzca S (si) / N (no)");
        do {
        	try {
        	 respuesta = teclado.nextLine().toLowerCase().charAt(0);
        	}catch(Exception e){
	        	//Hemos introducido un try catch para evitar que salte una excepci�n cuando el usuario no ingrese un caracter y le de directamente a intro
        	}
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
     * <b>Cabecera:</b> public static int leerValidarNumeroEntreRango(int valorInicial, int valorFinal)<br>
     *   <br>
     * <b>Comentario:</b> Este metodo se encarga de leer y validar que un numero este entre un rango.<br>
     *   <br>
     * <b>Precondiciones:</b> El numero valorInicial tiene que ser menor que valorFinal<br>
     *   <br>
     * <b>Entradas:</b> int valorInicial, int valorFinal<br>
     *   <br>
	 * <b>Salidas:</b> int numero <br>
     *   <br>
     * <b>Postcondiciones:</b> Este metodo se trata de un funcion ya que devuelve un tipo de dato, entero(numero) en este caso,
     *   				 el cual estara entre un rango(valorInicial y valorFinal)<br>
     *   <br>
     * @param valorInicial
     * @param valorFinal<br>
     * <br>
     * @return numero<br>
     */
    public static int leerValidarNumeroEntreRango(int valorInicial, int valorFinal){
        int numero=valorInicial-1;
        
        System.out.println("Ingrese un numero entre "+valorInicial+" y "+valorFinal+":");
		while(numero < valorInicial || numero > valorFinal) {
        	try {
				numero = Integer.parseInt(teclado.nextLine());
				if (numero < valorInicial || numero > valorFinal) {
					System.out.println("Numero ingresado no valido, vuelva intentarlo: ");
				}
			} catch (NumberFormatException e) {
				System.out.println("Introduzca un numero");
			}
        }
        
        return numero;
    }
    
    /**     
     * <b>Cabecera:</b> public static String obtenerUrl(Pagina[] paginas)<br>
     *   <br>
     * <b>Comentario:</b> Este metodo se encarga de leer una url. Ademas:<br>
     * 	&nbsp;&nbsp;&nbsp;&nbsp;-Mediante el metodo validarUrl() se validara que la url sea una url que esta bien formada.<br>
	 * 	&nbsp;&nbsp;&nbsp;&nbsp;-Mediante el metodo comprobarExistenciaUrl() se comprobara que la url no sea igual a la url principal
	 * 			    de alguna de la paginas que contiene un array de tipo Pagina<br>
	 * <br>
     * <b>Precondiciones:</b> Ninguna<br>
     *   <br>
     * <b>Entradas:</b> Pagina[] paginas<br>
     *   <br>
	 * <b>Salidas:</b> String url <br>
     *   <br>
     * <b>Postcondiciones:</b> Este metodo se trata de un funcion ya que devuelve un tipo de dato, una cadena(url) en este caso,
     * 					la cual sera una url, esta sera una url bien formada y ademas no sera igual a la url principal de alguna 
     * 					de las paginas que hay en un array de tipo Pagina<br>
     *   <br>
     * @param paginas<br>
     * <br>
     * @return url<br>
     */
    public static String obtenerUrl(Pagina[] paginas) {
    	String url = "";
    	boolean urlValida = false, urlRepetida = false;
    	
    	do {    		
    		do{
        		System.out.println("Ingrese la url de la pagina (recuerde que debe empezar con http:)");
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
	 * Cabecera: public static boolean validarUrl(String url) <br>
	 *   <br>
	 * Comentario: Este metodo se encarga de comprobar si una URL esta bien formada o no.<br>
	 *   <br>
	 * Precondiciones: Ninguna<br>
	 *   <br>
	 * Entrada: String url<br>
	 *   <br>
	 * Salida: boolean valida<br>
	 *    <br>
	 * Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato(valida), en este caso un boleano el cual tomara los 
	 *   				siguientes valores:<br>
	 *  &nbsp;&nbsp;&nbsp;&nbsp;-true: si la url es correcta.<br>
	 *  &nbsp;&nbsp;&nbsp;&nbsp;-false: si la url no es correcta.<br>
	 *   <br>
	 * @param url <br>
	 * <br>
	 * @return valida <br>
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
	 * Cabecera: public static String leerDescripcion()<br>
	 * <br>
	 * Comentario: Este metodo se encarga de leer una cadena, que sera la descripcion de una pagina<br>
	 * <br>
	 * Precondiciones: Ninguna<br>
	 * <br>
	 * Entrada: Ninguna<br>
	 * <br>
	 * Salida: String(cadena)<br>
	 * <br>
	 * Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato, en este caso una cadena.<br>
	 *  <br>
	 * @return descripcion<br>
     */
	public static String leerDescripcion() {
		System.out.println("Ingrese una breve descripcion sobre la pagina");
    	return teclado.nextLine();
	}

	/**
	 * <b>Cabecera:</b> public static int leerPageRank() <br>
	 *<br>
	 * <b>Comentario:</b> Este metodo se encrga de leer el pageRank para introducirlo por parametros al insertar un pageRank <br>
	 *<br>
	 * <b>Precondiciones:</b> ninguna <br>
	 *<br>
	 * <b>Postcondiciones:</b> ninguna <br>
	 *<br>
	 * <b>Entrada:</b> Ninguna <br>
	 * <br>
	 * <b>Salida:</b> String (pageRank) <br>
	 * <br>
	 * @return pageRank <br>
	 */
	public static int leerPageRank(){
		int numero=-1;

		System.out.println("Introduzca un valor de pageRank para la página: ");
		while(numero<0){
			try {
				numero = Integer.parseInt(teclado.nextLine());
			}
			 catch (NumberFormatException e) {
				 System.out.println("Introduzca un numero");
			 }
		}
		return numero;
	}

	/**
	 * Cabecera: public static String leerEnlaceReferente(Pagina[] paginas)<br>
	 *   <br>
	 * Comentario: Este metodo se encarga de leer una url de enlace referente.
	 * 			   Mediante el metodo validarUrl() se validara que la url de enlace referente sea una url que esta bien formada.
	 * 			   Mediante el metodo comprobarExistenciaUrl() se comprobara que la url de enlace referente es igual a la url principal
	 * 			   de alguna de la paginas que contiene un array de tipo Pagina<br>
	 *   <br>
	 * Precondiciones: Ninguna<br>
	 *   <br>
	 * Entrada: Pagina[] paginas<br>
	 *   <br>
	 * Salida: String enlaceReferente<br>
	 *    <br>
	 * Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato, en este caso una cadena(enlaceReferente).<br>
	 * <br>
	 * @param paginas <br>
	 *  <br>
	 * @return enlaceReferente <br>
	 */
	public static String leerEnlaceReferente(Pagina[] paginas) {

		String enlaceReferente = "";
		boolean urlValida = false, urlExiste = false, continuar = false;
		System.out.println("¿Quieres ingresar un enlace referente a la pagina? (Si la respuesta es no la pagina no referencia a nada)");

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
				if(!urlExiste) {
					System.out.println("La Url de enlace introducida no corresponde con la Url principal de ninguna de las paginas\n");
					System.out.println("Desea continuar y volver a intentarlo");
					continuar = leerValidarRespuestaSiNo();
					if (!continuar)
						enlaceReferente = "";
				}

			}while(!urlExiste && continuar); //Mientras el enlaceReferente no exista como url principal de otra pagina

		}
		return enlaceReferente;
	}

	/**
	 * <b>Cabecera:</b> public static String[] leerPalabrasClaves()<br>
	 *   <br>
	 * <b>Comentario:</b> Este metodo se encarga de leer las palabras claves que se desee que tenga una pagina.
	 * 			   Mediante el metodo eliminarPalabrasRepetida() se eliminaran aquellas palabras que esten repetidas<br>
	 *   <br>
	 * <b>Precondiciones:</b> Ninguna<br>
	 *   <br>
	 * <b>Entrada:</b> Ninguna<br>
	 *   <br>
	 * <b>Salida:</b> String[] palabrasClaves<br>
	 *    <br>
	 * <b>Postcondiciones:</b> Este metodo se trata de una funcion ya que devulve un tipo de dato, en este caso un array de
	 * 					cadena(palabrasClaves).<br>
	 *  <br>
	 * @return palabrasClaves <br>
	 */
	public static String[] leerPalabrasClaves() {

		String[] palabrasClaves = null;
		String palabras = "";
		System.out.println("¿Quieres ingresar una palabra clave?");

		if( leerValidarRespuestaSiNo() ) { //Si la respuesta que se lee es Si(true)

			Mensaje.introducirPalabrasClave();
			palabras = teclado.nextLine().toLowerCase();

			palabrasClaves = palabras.split(" "); //Se guardan las palabras separadas por un espacio
		}

		if(palabrasClaves != null)
			Gestora.eliminarPalabrasRepetida(palabrasClaves); //Elimina las palabras que haya repetidas
		else
			palabrasClaves= new String[]{""};

		return palabrasClaves;
	}

	/**
	 * <b>Cabecera:</b> public static void leerModificarPalabra (String[] palabrasClave) <br>
	 *   <br>
	 * <b>Comentario:</b> Modifica una palabra concreta de un array de palabras clave<br>
	 *   <br>
	 * <b>Precondiciones:</b> Ninguna <br>
	 *   <br>
	 * <b>Entrada:</b> String[] palabrasClave <br>
	 *   <br>
	 * <b>Salida:</b> Ninguna <br>
	 *    <br>
	 * <b>Postcondiciones:</b> Modifica la palabra indicada.<br>
	 *
	 * @param palabrasClave
	 */
	public static void leerModificarPalabra (String[] palabrasClave){
		String palabra;
		boolean modificado=false;

		System.out.println("Escriba la palabra que desea modificar:");
		palabra=teclado.nextLine();
		for (int i=0; !modificado && i<palabrasClave.length; i++){
			if(palabrasClave[i].equals(palabra)){
				System.out.println("Escriba la nueva palabra:");
				palabra=teclado.nextLine().toLowerCase();
				palabrasClave[i]=palabra;
				modificado=true;
			}
		}
		if(!modificado)
			System.out.println("La palabra no existe");
	}
    
    /**
	 * <b>Cabecera:</b> public static void cerrarTeclado()<br>
	 *   <br>
	 * <b>Comentario:</b> Este metodo se encarga de cerrar el flujo de entrada de datos de un objeto de tipo Scanner. <br>
	 *   <br>
	 * <b>Precondiciones:</b> Ninguna <br>
	 *   <br>
	 * <b>Entrada:</b> Ninguna <br>
	 *   <br>
	 * <b>Salida:</b> Ninguna <br>
	 *    <br>
	 * <b>Postcondiciones:</b> Se cerrara el obtejo compartido de tipo Scanner.<br>
	 *  				
     */
    public static void cerrarTeclado() {
    	teclado.close();
    }
    
}