package principal;

import java.util.Scanner;

import clasesBasicas.Pagina;
import gestion.Utilidad;
import validaciones.Validacion;
import gestion.Gestora;
import mensajes.Mensaje;

public class Main {

	public static void main(String[] args) {

		Pagina[] paginasWeb = new Pagina[10];
		String[] palabrasClaves;
		int[] palabrasCoincidentes;

		Pagina pagina;
		String url = "", descripcion = "", enlaceReferente = "";
		int opcion = 0;

		do {

			Mensaje.menuPrincipal(); // Mostrar opciones menu principal
			opcion = Validacion.leerValidarNumeroEntreRango(1, 4); // Valida la opcion entre 1 y 4

			switch (opcion) {

			case 1: // Opcion dar de alta una pagina web

				url = Validacion.obtenerUrl(paginasWeb); // Se obtiene al url de la nueva pagina que se creara
				System.out.println("Ingrese una breve descripcion sobre la pagina");
				descripcion = Validacion.leerDescripcion();
				enlaceReferente = Validacion.leerEnlaceReferente(paginasWeb);
				palabrasClaves = Validacion.leerPalabrasClaves();

				// Se crea la nueva pagina
				pagina = new Pagina(url, descripcion, palabrasClaves, enlaceReferente);

				Gestora.insertarPagina(paginasWeb, pagina); // Se guarda la nueva pagina en el array donde estan todas
															// las paginas
				if (!pagina.getEnlacesReferente().equals(""))
					Gestora.aumentarPageRankPaginaEnlace(paginasWeb, pagina.getEnlacesReferente());

				break;

			case 2: // Buscar paginas

				Mensaje.introducirPalabrasClave();
				palabrasClaves = Validacion.leerPalabrasClaves();

				// Genera un array de enteros con el numero de palabras coincidentes para cada
				// pagina de la lista dada
				palabrasCoincidentes = new int[paginasWeb.length];
				for (int i = 0; i < palabrasCoincidentes.length; i++)
					palabrasCoincidentes[i] = Gestora.palabrasCoincidentes(paginasWeb[i].getPalabrasClaves(),
							palabrasClaves);

				Gestora.ordenarPaginas(paginasWeb, palabrasCoincidentes, 0, paginasWeb.length);
				for (Pagina value : paginasWeb)
					value.toString(); // Imprime todas las paginas ordenadas por la condicion

				break;

			case 3: // Modificar una pagina web

				break;

			default:
				System.out.println("###Saliendo del programa...###"); // Sera la opcion 4 de salir del programa

			}

		} while (opcion != 4); // Mientras la opcion no sea salir(4)

		Validacion.cerrarTeclado();
	}
}
