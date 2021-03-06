package principal;

import java.util.Scanner;

import clasesBasicas.Pagina;
import validaciones.Validacion;
import gestion.Gestora;
import mensajes.Mensaje;


public class Main {

	public static void main(String[] args) {	
			
		Scanner teclado = new Scanner(System.in);
		Pagina pagina;
		Pagina[] paginasWeb = new Pagina[10];
		String[] palabrasClaves;
		String url = "", descripcion = "", enlaceReferente = "";
		int opcion = 0;
		
		do {
			
			Mensaje.menuPrincipal(); //Mostrar opciones menu principal
			opcion = Validacion.leerValidarNumeroEntreRango(1, 4); //Valida la opcion entre 1 y 4
			
			switch(opcion) {
			
			case 1:	//Opcion dar de alta una pagina web

				url = Validacion.obtenerValidarUrl(paginasWeb); //Se obtiene al url de la nueva pagina que se creara
				System.out.println("Ingrese una breve descripcion sobre la pagina");
				descripcion = teclado.nextLine();
				enlaceReferente = Validacion.leerValidarEnlaceReferente(paginasWeb);
				palabrasClaves = Validacion.leerValidarPalabrasClaves();
				//Se creara la nueva pagina
				pagina = new Pagina(url,descripcion,palabrasClaves,enlaceReferente); //Faltan el [] de las palabras claves

				Gestora.insertarPagina(paginasWeb, pagina);
				if(!pagina.getEnlacesReferente().equals(""))
					Gestora.aumentarPageRankPaginaEnlace(paginasWeb, pagina);

		
			break;
			
			case 2: //Buscar paginas 
				
			break;
			
			case 3: //Modificar una pagina web 
				
			break;
			
			}
			
		}while(opcion != 4); //Mientras la opcion no sea salir(4)
		
		Validacion.cerrarTeclado(); 
	}
}
