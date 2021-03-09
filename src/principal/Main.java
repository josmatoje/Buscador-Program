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
		boolean seguir;

		do {

			Mensaje.menuPrincipal(); // Mostrar opciones menu principal
			opcion = Validacion.leerValidarNumeroEntreRango(1, 4); // Valida la opcion entre 1 y 4

			switch (opcion) {

			case 1: // Opcion dar de alta una pagina web

				url = Validacion.obtenerUrl(paginasWeb); // Se obtiene al url de la nueva pagina que se creara
				descripcion = Validacion.leerDescripcion(); //Se obtiene una descripcion
				pageRank = Validacion.leerPageRank(); //Se obtiene un pageRank
				enlaceReferente = Validacion.leerEnlaceReferente(paginasWeb); //Se obtiene en enlace de referente
				palabrasClaves = Validacion.leerPalabrasClaves(); //Se leen las palabras claves de la pagina 

				// Se crea la nueva pagina
				pagina = new Pagina(url, descripcion, pageRank, palabrasClaves, enlaceReferente);

				Gestora.insertarPagina(paginasWeb, pagina); // Se guarda la nueva pagina en el array donde estan todas
															// las paginas
				if (!pagina.getEnlaceReferente().equals(""))//Si la pagina tiene un enlace referente 
					Gestora.aumentarPageRankPaginaEnlace(paginasWeb, pagina.getEnlaceReferente());

				break;

			case 2: // Buscar paginas
				
				if(Gestora.comprobarExistenciaPaginas(paginasWeb)) { //Si existen paginas
					
					palabrasClaves = Validacion.leerPalabrasClaves();

					// Genera un array de enteros con el numero de palabras coincidentes para cada
					// pagina de la lista dada
					palabrasCoincidentes = new int[paginasWeb.length];
					for (int i = 0; i < palabrasCoincidentes.length; i++)
						palabrasCoincidentes[i] = paginasWeb[i]==null ?  //ifelse --> operador ternario (en caso de paginaWeb nula, palabras coincidentes 0)
								0: Gestora.palabrasCoincidentes (paginasWeb[i].getPalabrasClaves(),palabrasClaves);

					//Gestora.ordenarPaginas(paginasWeb, palabrasCoincidentes, 0, paginasWeb.length-1);
					Gestora.ordenacionInsercionDirecta(paginasWeb,palabrasCoincidentes);

					System.out.println("Estas son las paginas por orden de relevancia:");
					// Imprime todas las paginas ordenadas por la condicion
					Mensaje.imprimirPaginas(paginasWeb);
			
				}else {
					Mensaje.noExistenPaginas();
				}
				break;

			case 3: // Modificar una pagina web

				if(Gestora.comprobarExistenciaPaginas(paginasWeb)) { //Si existen paginas

					System.out.println("Escoja la pagina que desea modificar: ");
					opcion = Mensaje.imprimirPaginas(paginasWeb);
					opcion = Validacion.leerValidarNumeroEntreRango(1, opcion) - 1;//Restamos uno para que se corresponda con la posición del array

					System.out.println("Desea modificar la descripcion de esta pagina?");
					if (Validacion.leerValidarRespuestaSiNo()) {  
						paginasWeb[opcion].setDescripcion(Validacion.leerDescripcion());
					}

					System.out.println("Desea modificar las palabras clave?");
					if (Validacion.leerValidarRespuestaSiNo()) {
						Mensaje.mostrarPalabrasClave(paginasWeb[opcion].getPalabrasClaves());
						System.out.println("Desea modificar todas las palabras?");
						if (Validacion.leerValidarRespuestaSiNo()) { 
							paginasWeb[opcion].setPalabrasClaves(Validacion.leerPalabrasClaves());
						} else {
							seguir=true;
							while (seguir) {
								Validacion.leerModificarPalabra(paginasWeb[opcion].getPalabrasClaves());
								System.out.println("Desea modificar otra palabra?");
								seguir = Validacion.leerValidarRespuestaSiNo();
							}
						}
					}

					System.out.println("Desea modificar o eliminar el enlace de referencia?");
					if (Validacion.leerValidarRespuestaSiNo()) { //Si la respuesta es si 
					
						if(!paginasWeb[opcion].getEnlaceReferente().equals("")){ //Si la pagina que se desea modificar tiene una url de enlace
							Gestora.disminuirPageRankPaginaEnlace(paginasWeb, paginasWeb[opcion].getEnlaceReferente());
						}
						enlaceReferente = Validacion.leerEnlaceReferente(paginasWeb);
										
						if (enlaceReferente.equals(paginasWeb[opcion].getUrl())){//Si el enlace referente se lee es igual a la url de la 
																				 //pagina en la que se esta haciendo la modificacion 
							System.out.println("Una pagina no puede referenciarse a ella misma");
						}else { 
							if(!enlaceReferente.equals("")){ //Si el enlace referente que se lee no es una cadena vacia 
								Gestora.aumentarPageRankPaginaEnlace(paginasWeb, enlaceReferente);
							}
							paginasWeb[opcion].setEnlaceReferente(enlaceReferente);
						}
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
