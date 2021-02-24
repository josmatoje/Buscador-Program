package Mensajes;

import ClasesBasicas.Pagina;

public class Mensaje {
	
	//Métodos para mostrar menús
	
	/**Cabecera del método:
	 * Precondiciones: ninguna
	 * Postcondiciones: Nos muestra el menú inicial del buscador
	 * Entrada: Ninguna
	 * Salida: Ninguna
	 */
	public void menuPrincipal() {
		System.out.println("********************\n\n"
				+ "Bienvenido a tu buscador favorito, ¿que desea realizar? \n"
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
	
	public void mostrarResultadoBusqueda(Pagina[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i].toString());
		}
	}
}
