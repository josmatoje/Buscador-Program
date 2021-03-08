package mensajes;

import clasesBasicas.Pagina;

public class Mensaje {

	/**
	 * <b>Cabecera:</b> public static void menuPrincipal() <br>
	 * <b>Precondiciones:</b> Ninguna <br>
	 * <b>Entrada:</b> Ninguna <br>
	 * <b>Salida:</b> Ninguna <br>
	 * <b>Postcondiciones:</b> Nos muestra el menu inicial del buscador <br>
	 */
	public static void menuPrincipal() {
		System.out.println("******************************************************\n\n"

				+ "Bienvenido a tu buscador favorito, que desea realizar? \n"
				+ "1.- Dar de alta una nueva pagina web \n" + "2.- Buscar paginas claves \n"
				+ "3.- Modificar una pagina web existente \n" + "4.- Salir\n\n"
				+ "******************************************************");
	}

	/**
	 * <b>Cabecera:</b> public static void mostrarResultadoBusqueda(Pagina[] array) <br>
	 * <b>Precondiciones:</b> Ninguna <br>
	 * <b>Entrada:</b> Pagina[] array <br>
	 * <b>Salida:</b> Ninguna <br>
	 * <b>Postcondiciones:</b> El metodo nos muestra las diferentes <br>
	 *  paginas segun su orden de relevancia con respecto a la busqueda realizada por <br>
	 *  el usuario. para ello utilizamos una array de paginas ya ordenadas y el <br>
	 *  toString de la clase Pagina. <br>
	 *
	 * @param array
	 */

	public static void mostrarResultadoBusqueda(Pagina[] array) {
		System.out.println("Resultados:");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].toString());
		}
	}

	/**
	 * <b>Cabecera:</b> public static void anhadirPaginaWeb() <br>
	 * <b>Precondiciones:</b> Ninguna <br>
	 * <b>Entrada:</b> Ninguna <br>
	 * <b>Salida:</b> Ninguna <br>
	 * <b>Postcondiciones:</b>Nos muestra un mensaje para indicarnos que introduzcamos una url valida que queramos anhadir <br>
	 */

	public static void anhadirPaginaWeb() {
		System.out.print("Introduzca la url que desea anhadir:");
	}

	/**
	 * <b>Cabecera:</b> public static void modificarPaginaWeb() <br>
	 * <b>Precondiciones:</b> Ninguna <br>
	 * <b>Entrada:</b>ninguna <br>
	 * <b>Salida:</b>ninguna <br>
	 * <b>Postcondiciones:</b>Nos muestra un mensaje para indicarnos que introduzcamos una url valida para modificar la pagina <br>
	 */

	public static void modificarPaginaWeb() {
		System.out.print("Introduzca el url de la pagina que desea modificar:");
	}

	/**
	 * <b>Cabecera:</b> public static void menuModificarPaginaWeb() <br>
	 * <b>Precondiciones:</b>ninguna <br>
	 * <b>Entrada:</b>ninguna <br>
	 * <b>Salida:</b>ninguna <br>
	 * <b>Postcondiciones:</b>Nos muestra el menu para la opcion de modificar una pagina una vez introducida una url valida. <br>
	 */
	public static void menuModificarPaginaWeb() {
		System.out.println("******************************\n\n"
				+ "1.- Cambiar la descripcion \n"
				+ "2.- Anhadir palabras claves \n"
				+ "3.- Volver al menu principal\n\n"
				+ "******************************");
	}

	/**
	 * <b>Cabecera:</b> public static void caracterIntroducidoNoValido() <br>
	 * <b>Comentario:</b> Este metodo imprime el mensaje de que el caracter introducido no es valido <br>
	 * <b>Precondicion:</b> Ninguna <br>
	 * <b>Entrada:</b> Ninguna <br>
	 * <b>Salida:</b> Ninguna <br>
	 * <b>Postcondicion:</b> mensaje impreso por pantalla <br>
	 */
	public static void caracterIntroducidoNoValido() {
		System.out.println("Caracter introducido no valido, por favor vuelva a intentarlo");
	}

	/**
	 * <b>Cabecera:</b> public static void introducirPalabrasClave()<br>
	 * <b>Comentario:</b> Este metodo imprime el mensaje para introducir las palabras claves<br>
	 * <b>Precondicion:</b> Ninguna<br>
	 * <b>Entrada:</b> Ninguna <br>
	 * <b>Salida:</b> Ninguna <br>
	 * <b>Postcondicion:</b> mensaje impreso por pantalla <br>
	 */
	public static void introducirPalabrasClave() {
		System.out.println("Ingrese todas las palabras separadas por espacios:");
	}

	/**
	 * <b>Cabecera:</b> public static void noExistenPaginas()<br>
	 * <b>Comentario:</b> Este metodo imprime el mensaje de que no existen paginas creadas<br>
	 * <b>Precondicion:</b> Ninguna<br>
	 * <b>Entrada:</b> Ninguna <br>
	 * <b>Salida:</b> Ninguna <br>
	 * <b>Postcondicion:</b> mensaje impreso por pantalla <br>
	 */
	public static void noExistenPaginas() {
		System.out.println("No existen paginas creadas, cree una antes de inciar su busqueda");
	}

	/**
	 * <b>Cabecera:</b> public static int imprimirPaginas(Pagina[] listaPaginas) <br>
	 * <b>Comentario:</b> Este metodo imprime las paginas enumeradas hasta que encuentre una posicion nula en el array<br>
	 * <b>Precondicion:</b> El array debe tener los objetos agrupados en las primeras celdas
	 * <b>Entrada:</b> Un array con objetos pagina
	 * <b>Salida:</b> Un entero que indica la cantidad de paginas que existen en el array
	 * <b>Postcondicion:</b> las celdas que contengan valores no nulos despues de un valor nulo no seran mostradas <br>
	 *
	 * @param listaPaginas
	 * @return numeroPaginas
	 */
	public static int imprimirPaginas(Pagina[] listaPaginas){
		int numeroPaginas;

		for(numeroPaginas=0; listaPaginas[numeroPaginas]!=null && numeroPaginas< listaPaginas.length; numeroPaginas++){
			System.out.println((numeroPaginas+1)+". "+listaPaginas[numeroPaginas].toString());
		}

		return numeroPaginas;
	}

	/**
	 * <b>Cabecera:</b> public static void mostrarPalabrasClave (String[] palabrasClave) <br>
	 * <b>Comentario:</b> Este metodo imprime las palabras claves del array dada<br>
	 * <b>Precondicion:</b> El array no puede estar vacia <br>
	 * <b>Entrada:</b> Un array de string <br>
	 * <b>Salida:</b> Ninguna <br>
	 * <b>Postcondicion:</b> se muestra el mensaje <br>
	 *
	 * @param palabrasClave
	 */
	public static void mostrarPalabrasClave (String[] palabrasClave){
		for(String palabra:palabrasClave){
			System.out.println("- "+palabra);
		}
	}
}
