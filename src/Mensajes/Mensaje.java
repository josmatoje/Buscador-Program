package Mensajes;

public class Mensaje {
	
	//Métodos para mostrar menús
	
	/**Cabecera del método:
	 * Precondiciones: ninguna
	 * Postcondiciones: Nos muerta el menú inicial del buscador
	 * Entrada: Ninguna
	 * Salida: Ninguna
	 */
	public void menuPrincipal() {
		System.out.println("********************\n\n"
				+ "Bienvenido a tu buscador favorito, ¿qué desea realizar? \n"
				+ "1.- Dar de alta una nueva pagina web \n"
				+ "2.- Buscar paginas claves \n"
				+ "3.- Modificar una pagina web existente \n"
				+ "4.- Salir\n\n"
				+ "********************");
	}
}
