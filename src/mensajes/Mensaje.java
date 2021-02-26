package mensajes;

import clasesBasicas.Pagina;

public  class Mensaje {
	
	//Metodos para mostrar menos
	
	/**Cabecera del metodo:
	 * Precondiciones: ninguna

	 * Postcondiciones: Nos muestra el menu inicial del buscador

	 * Postcondiciones: Nos muestra el mensaje inicial del buscador

	 * Entrada: Ninguna
	 * Salida: Ninguna
	 */
	public static void menuPrincipal() {
		System.out.println("********************\n\n"

				+ "Bienvenido a tu buscador favorito, que desea realizar? \n"
				+ "1.- Dar de alta una nueva pagina web \n"
				+ "2.- Buscar paginas claves \n"
				+ "3.- Modificar una pagina web existente \n"
				+ "4.- Salir\n\n"
				+ "********************");
	}
	
	/**
	 * Precondiciones: Ninguna
	 * Postcondiciones: El metodo nos muestra las diferentes paginas segun su orden de relevancia con respecto a la busqueda realizada por el usuario.
	 * para ello utilizamos una array de paginas ya ordenadas y el toString de la clase Pagina.
	 * Entrada: Pagina[] array
	 * Salida: Ninguna
	 * @param array
	 */
	
	public static void mostrarResultadoBusqueda(Pagina[] array) {
		System.out.println("Resultados:");
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i].toString());
		}
	}
	/**
	 * Precondiciones=ninguna
	 * Postcondiciones=Nos muestra un pequenho mensaje indicandonos que introduzcamos una url valida
	 * Entrada=ninguna
	 * Salida=ninguna 
	 * 
	 */
	
	public static void anhadirPaginaWeb() {
		System.out.print("Introduzca la url que desea anhadir:");
	}
	
	/**
	 * Precondiciones=ninguna
	 * Postcondiciones=Nos muestra un pequenho mensaje indicandonos que introduzcamos una url valida para modificar la pagina
	 * Entrada=ninguna
	 * Salida=ninguna 
	 * 
	 */
	
	public static void modificarPaginaWeb() {
		System.out.print("Introduzca el url de la pagina que desea modificar:");
	}
	
	/**
	 * Precondiciones=ninguna
	 * Postcondiciones=Nos muestra el menu para la opcion de modificar una pagina una vez introducida una url valida.
	 * Entrada=ninguna
	 * Salida=ninguna 
	 * 
	 */
	public static void menuModificarPaginaWeb() {
		System.out.println("********************\n\n"
				+ "1.- Cambiar la descripcion \n"
				+ "2.- A�adir palabras claves \n"
				+ "3.- Volver al menu principal\n\n"
				+ "********************");
	}
	
	/**
	 * Precondiciones=ninguna
	 * Postcondiciones=Le muestra al usuario un mensaje para indicar que ha introducido un dato no valido
	 * Entrada=ninguna
	 * Salida=ninguna
	 */
	public static void caracterIntroducidoNoValido() {
		System.out.println("Caracter introducido no valido, por favor vuelva a intentarlo");
	}
}
