package principal;


import clasesBasicas.Pagina;
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
		int opcion = 0, pageRank;
		boolean salir;

		do {

			Mensaje.menuPrincipal(); // Mostrar opciones menu principal
			opcion = Validacion.leerValidarNumeroEntreRango(1, 4); // Valida la opcion entre 1 y 4

			switch (opcion) {

			case 1: // Opcion dar de alta una pagina web

				url = Validacion.obtenerUrl(paginasWeb); // Se obtiene al url de la nueva pagina que se creara
				System.out.println("Ingrese una breve descripcion sobre la pagina");
				descripcion = Validacion.leerDescripcion();
				pageRank = Validacion.leerPageRank();
				enlaceReferente = Validacion.leerEnlaceReferente(paginasWeb);
				palabrasClaves = Validacion.leerPalabrasClaves();

				// Se crea la nueva pagina
				pagina = new Pagina(url, descripcion, pageRank, palabrasClaves, enlaceReferente);

				Gestora.insertarPagina(paginasWeb, pagina); // Se guarda la nueva pagina en el array donde estan todas
															// las paginas
				if (!pagina.getEnlacesReferente().equals(""))
					Gestora.aumentarPageRankPaginaEnlace(paginasWeb, pagina.getEnlacesReferente());

				break;

			case 2: // Buscar paginas
				
				if(Gestora.comprobarExistenciaPaginas(paginasWeb)) {
					
					palabrasClaves = Validacion.leerPalabrasClaves();

					// Genera un array de enteros con el numero de palabras coincidentes para cada
					// pagina de la lista dada
					palabrasCoincidentes = new int[paginasWeb.length];
					for (int i = 0; i < palabrasCoincidentes.length; i++)
						palabrasCoincidentes[i] = paginasWeb[i]==null ?  //ifelse --> operador ternario (en caso de paginaWeb nula, palabras coincidentes 0)
								0: Gestora.palabrasCoincidentes (paginasWeb[i].getPalabrasClaves(),palabrasClaves);

					//Gestora.ordenarPaginas(paginasWeb, palabrasCoincidentes, 0, paginasWeb.length-1);
					Gestora.ordenacionInsercionDirecta(paginasWeb,palabrasCoincidentes);

					System.out.println("Estas son las paginas por orden de rlevancia:");
					// Imprime todas las paginas ordenadas por la condicion
					Mensaje.imprimirPaginas(paginasWeb);
			
				}else
					Mensaje.noExistenPaginas();


				break;

			case 3: // Modificar una pagina web


				if(Gestora.comprobarExistenciaPaginas(paginasWeb)) {

					System.out.println("Escoja la pagina que desea modificar: ");
					opcion = Mensaje.imprimirPaginas(paginasWeb);
					opcion = Validacion.leerValidarNumeroEntreRango(1, opcion) - 1;//Restamos uno para que se corresponda con la posición del array

					System.out.println("¿Desea modificar la descripción de esta página?");
					if (Validacion.leerValidarRespuestaSiNo())
						paginasWeb[opcion].setDescripcion(Validacion.leerDescripcion());

					System.out.println("¿Desea modificar las palabras clave?");
					if (Validacion.leerValidarRespuestaSiNo()) {
						Mensaje.mostrarPalabrasClave(paginasWeb[opcion].getPalabrasClaves());
						System.out.println("¿Desea modificar todas las palabras?");
						if (Validacion.leerValidarRespuestaSiNo()) {
							paginasWeb[opcion].setPalabrasClaves(Validacion.leerPalabrasClaves());
						} else {
							salir = false;
							while (!salir) {
								Validacion.leerModificarPalabra(paginasWeb[opcion].getPalabrasClaves());
								System.out.println("Desea modificar otra palabra?");
								salir = Validacion.leerValidarRespuestaSiNo();
							}
						}
					}

					System.out.println("¿Desea modificar el enlace de referencia?");
					if (Validacion.leerValidarRespuestaSiNo()) {
						enlaceReferente = Validacion.leerEnlaceReferente(paginasWeb);
						if (!enlaceReferente.equals(""))//El metodo leerEnlaceReferente devuelve una cadena vacia si finalmente el
							// usuario no introduce ningun enlace de refernecia
							paginasWeb[opcion].setEnlacesReferente(enlaceReferente);
					}
				}else
					Mensaje.noExistenPaginas();

			break;

			case 4: //Opcion salir del programa
				System.out.println("###Saliendo del programa...###"); 
			break;

			default:
				System.out.println("###Ha ocurrido un error###"); 
			}

		} while (opcion != 4); // Mientras la opcion no sea salir(4)

		Validacion.cerrarTeclado();
	}
}
