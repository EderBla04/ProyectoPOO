package ProyectoIntegrador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Cafeteria {
	
	private ArrayList<Producto> productos;
	
	private ArrayList<Ventas> ventas;
	
	private int  ultimoTicket;
	
	public Cafeteria() {
		// TODO Auto-generated constructor stub
		this .productos = new ArrayList<Producto>();
		
		this.ventas = new ArrayList<Ventas>();
		
		this.ultimoTicket=0;
	}
	
    public void cargarProductos() {
        productos.add(new Bebida("001", "Café late grande", 70, true));
        productos.add(new Bebida("002", "Café late chico", 50, true));
        productos.add(new Bebida("003", "Café Capuchino grande", 70, true));
        productos.add(new Bebida("004", "Café Capuchino chico", 50, true));
        productos.add(new Comida("005", "Baguete Clásico", 90, false));
        productos.add(new Comida("006", "Bagel con Avellana", 95, false));
        productos.add(new Bebida("007", "Café moka frapuchino", 56, false));
        productos.add(new Bebida("008", "Café expreso", 40, true));
        productos.add(new Comida("009", "Baguette italiano", 110, false));
        productos.add(new Bebida("010", "Aranciata Natural", 45, false));
    }
    
    public void mostrarProductos() {
    	
    	for(Producto var: productos) {
    		
    		System.out.println(var.toString());
    		
    	}
    	
    }

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public ArrayList<Ventas> getVentas() {
		return ventas;
	}


	
	public void iniciarVenta() {
		
		
		Ventas newVenta = new Ventas(this.generarTicket());
		
		ventas.add(newVenta);
		
		System.out.println("Se ha iniciado una nueva venta el: "+newVenta.getFecha()+" No de Ticket: "+String.format("%03d", this.ultimoTicket));
		
		
	}

	public String generarTicket() {
		
		ultimoTicket++;
		
		
		
		return String.format("%03d", ultimoTicket);
	}
	
    public void agregarProductoAVenta(String idTicket, Producto producto) {
        Ventas venta = buscarVenta(idTicket);
        if (venta != null) {
            venta.agregar(producto);
            System.out.println("Producto agregado al ticket.");
        } else {
            System.out.println("No se encontró la venta.");
        }
    }

    public void eliminarProductoDeVenta(String idTicket, Producto producto) {
        Ventas venta = buscarVenta(idTicket);
        if (venta != null) {
            venta.eliminar(producto);
            System.out.println("Producto eliminado del ticket.");
        } else {
            System.out.println("No se encontró la venta.");
        }
    }

    public void mostrarDetalleVenta(String idTicket) {
        Ventas venta = buscarVenta(idTicket);
        if (venta != null) {
            System.out.println("Detalle del ticket:");
            for (Producto producto : venta.getProductos()) {
                System.out.println(producto);
            }
            System.out.println("Subtotal: $" + venta.subTotal());
            System.out.println("IVA: $" + venta.subTotal()*0.16);
            System.out.println("Total a pagar: $" + venta.total());
        } else {
            System.out.println("No se encontró la venta.");
        }
        
    }
    
    public void crearArchivoTicket(String idTicket) {
        Ventas venta = buscarVenta(idTicket);
        if (venta != null) {
            StringBuilder detalle = new StringBuilder();
            detalle.append("Detalle del ticket:\n");
            for (Producto producto : venta.getProductos()) {
                detalle.append(producto).append("\n");
            }
            detalle.append("Subtotal: $").append(venta.subTotal()).append("\n");
            detalle.append("IVA: $").append(venta.subTotal() * 0.16).append("\n");
            detalle.append("Total a pagar: $").append(venta.total());

            // Crear archivo de ticket
            String nombreArchivo = "Ticket_" + idTicket + ".txt";
            try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
                writer.println(detalle.toString());
                System.out.println("Ticket generado y guardado en el archivo: " + nombreArchivo);
                ventas.remove(venta);
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("No se encontró la venta.");
        }
    }
        


    public void pagarVenta(String idTicket) {
        Ventas venta = buscarVenta(idTicket);
        if (venta != null) {
            System.out.println("Detalles de la venta:");
            mostrarDetalleVenta(idTicket);
            System.out.println("Se ha realizado el pago de la venta.");
            
        } else {
            System.out.println("No se encontró la venta.");
        }
    }

    private Ventas buscarVenta(String idTicket) {
        for (Ventas venta : ventas) {
            if (venta.getIdTicket().equals(idTicket)) {
                return venta;
            }
        }
        return null;
    }

    public static Producto buscarProductoPorCodigo(Cafeteria cafeteria, String codigo) {
        for (Producto producto : cafeteria.getProductos()) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }
    
 
    
    
    

    

    

}
    


