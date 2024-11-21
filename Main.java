package ProyectoIntegrador;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Administrar.cafeteria.cargarProductos();
		
		String opcion;
	    int control = 0;
		
		do {		
			
		
		Administrar.menu();
		opcion = sc.next();
		
		
		
		switch(opcion) {
		
		
		case "1": Administrar.menuProductos();
		break; 
		
		case "2": 
			Administrar.cafeteria.iniciarVenta();
			Administrar.menuPuntoDeVenta();
		break;
		
		case "3": System.out.println("Saliendo....");
		control = Integer.parseInt(opcion);
		break;
		
		default:  System.out.println("Opcion invalida, Ingrese una opcion valida");
		
		}
			
		
		}while(control != 3);


}
}

