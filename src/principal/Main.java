package principal;

import java.util.Scanner;

import clasesBasicas.Pagina;
import gestion.Utilidad;
import validaciones.Validacion;
import gestion.Gestora;
import mensajes.Mensaje;


public class Main {

	public static void main(String[] args) {	

		Pagina pagina;
		Pagina[] paginasWeb = new Pagina[10];
		String[] palabrasClaves;
		int[] palabrasCoincidentes;
		String url = "", descripcion = "", enlaceReferente = "";
		int opcion = 0;
		
		do {
			
			Mensaje.menuPrincipal(); //Mostrar opciones menu principal
			opcion = Validacion.leerValidarNumeroEntreRango(1, 4); //Valida la opcion entre 1 y 4
			
			switch(opcion) {
			
				case 1:	//Opcion dar de alta una pagina web

					url = Validacion.obtenerValidarUrl(paginasWeb); //Se obtiene al url de la nueva pagina que se creara
					System.out.println("Ingrese una breve descripcion sobre la pagina");
					descripcion = Validacion.leerDescripcion();
					enlaceReferente = Validacion.leerValidarEnlaceReferente(paginasWeb);
					palabrasClaves = Validacion.leerValidarPalabrasClaves();
					//Se creara la nueva pagina
					pagina = new Pagina(url,descripcion,palabrasClaves,enlaceReferente); //Faltan el [] de las palabras claves

					Gestora.insertarPagina(paginasWeb, pagina);
					if(!pagina.getEnlacesReferente().equals(""))
						Gestora.aumentarPageRankPaginaEnlace(paginasWeb, pagina);

				break;

				case 2: //Buscar paginas

					Mensaje.introducirPalabrasClave();
					palabrasClaves = Validacion.leerValidarPalabrasClaves();
					
					//Genera un array de enteros con el numero de palabras coincidentes para cada pagina de la lista dada
					palabrasCoincidentes = new int[paginasWeb.length];
					for (int i=0; i<palabrasCoincidentes.length; i++)
						palabrasCoincidentes[i]= Utilidad.palabrasCoincidentes(paginasWeb[i].getPalabrasClaves(),palabrasClaves);

					Gestora.ordenarPaginas(paginasWeb,palabrasCoincidentes,0,paginasWeb.length);
					for (Pagina value : paginasWeb) value.toString(); //Imprime todas las paginas ordenadas por la condición


					break;

				case 3: //Modificar una pagina web

				break;

				default:
					System.out.println("###Ha ocurrido un error###");

			}
			
		}while(opcion != 4); //Mientras la opcion no sea salir(4)
		
		Validacion.cerrarTeclado(); 
	}
}
