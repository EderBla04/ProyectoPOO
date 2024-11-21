package ProyectoIntegrador;

import java.util.Scanner;

public class Administrar {
	
	static Cafeteria cafeteria = new Cafeteria();
	
	static Scanner sc = new Scanner(System.in);
	
    public static void menu() {
    	
    	System.out.println("\nMenu de Punto de Cafeteria Don Juan");
        System.out.println("1. Productos");
        System.out.println("2. Punto de Venta");
        System.out.println("3. Salida");
        System.out.print("Seleccione una opción: ");
    	
    	
    }
	
	
	public static void menuProductos() {
		
		String opcion;
		int control=0;
		
        do {
            System.out.println("\nMenú de Productos:");
            System.out.println("1. Modificar productos");
            System.out.println("2. Listar productos");
            System.out.println("3. Regresar al menú principal");

            System.out.print("Seleccione una opción: ");
            opcion = sc.next();

            switch (opcion) {
                case "1":
                	
                	System.out.println("Ingrese el codigo del producto");
                	String codigoProducto = sc.next();
                    Producto ModificarPrecio = buscar(codigoProducto);
                    if (ModificarPrecio != null) {
                        System.out.print("Ingrese el nuevo precio: ");
                        double nuevoPrecio = sc.nextDouble();
                        ModificarPrecio.setPrecio(nuevoPrecio);
                        System.out.println("Precio del producto actualizado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;
                             	
                case "2":
                    System.out.println("\nLista de Productos:");
                    cafeteria.mostrarProductos();

                    break;
                case "3":
                    System.out.println("Regresando al menú principal.");
                    control=Integer.parseInt(opcion);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (control != 3);
        
        
		
	}
	
	public static void menuPuntoDeVenta() {
		
		String opcion;
		int control=0;
		
		do {
	        System.out.println("\nMenú de Punto de Venta:");
	        System.out.println("1. Agregar producto al ticket");
	        System.out.println("2. Eliminar producto del ticket");
	        System.out.println("3. Ver detalle del ticket");
	        System.out.println("4. Pagar la venta");
	        System.out.println("5. Regresar al menú principal");
	        System.out.print("Seleccione una opción: ");
	        opcion = sc.next();
	        
	        switch(opcion) {
	        
	        case "1": 
                System.out.println("Lista de Productos Disponibles:");
                cafeteria.mostrarProductos();
                System.out.print("Ingrese el código del producto a agregar: ");
                String codigoProducto = sc.next();
                Producto productoAAgregar = buscar(codigoProducto);
                if (productoAAgregar != null) {
                    cafeteria.agregarProductoAVenta(cafeteria.getVentas().get(cafeteria.getVentas().size() - 1).getIdTicket(), productoAAgregar);
                } else {
                    System.out.println("Producto no encontrado.");
                }
	        	break;
	        case "2": 

                verDetalleDelTicket(cafeteria.getVentas().get(cafeteria.getVentas().size() - 1));
                System.out.print("Ingrese el código del producto a eliminar: ");
                String codigoProductoEliminar = sc.next();
                Producto productoAEliminar = buscar(codigoProductoEliminar);
                if (productoAEliminar != null) {
                    cafeteria.eliminarProductoDeVenta(cafeteria.getVentas().get(cafeteria.getVentas().size() - 1).getIdTicket(), productoAEliminar);
                } else {
                    System.out.println("Producto no encontrado en el ticket.");
                }
	        	

	        	break;
	        case "3": 
  
                verDetalleDelTicket(cafeteria.getVentas().get(cafeteria.getVentas().size() - 1));

                break;

	        case "4":
	   
	                pagarVenta(cafeteria.getVentas().get(cafeteria.getVentas().size() - 1).getIdTicket());
	                cafeteria.crearArchivoTicket(cafeteria.getVentas().get(cafeteria.getVentas().size()-1).getIdTicket());
	                control = Integer.parseInt(opcion);
             
 
                break;
            case "5":
                System.out.println("Regresando al menú principal.");
                control = Integer.parseInt(opcion);
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo."); 
	        }
			
			
		}while(control != 5 && control !=4);
		
		
	}
	
    public static void pagarVenta(String idTicket) {
    
        cafeteria.pagarVenta(idTicket);
    }

    public static void verDetalleDelTicket(Ventas venta) {
        

  
        cafeteria.mostrarDetalleVenta(venta.getIdTicket());
    }

    public static Producto buscar(String codigo) {
        return Cafeteria.buscarProductoPorCodigo(cafeteria, codigo);
    }
    
  
    

    
    
    

    
    
	
	

}
