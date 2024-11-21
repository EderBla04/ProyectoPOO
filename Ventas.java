package ProyectoIntegrador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ventas{
	
	private String idTicket;
	private ArrayList<Producto> productos;
	private String  fecha;
	
	public Ventas(String idTicket) {
		super();
		this.idTicket = idTicket;
		this.productos = new ArrayList<Producto>();
	}
	
	
	public String getIdTicket() {
		return idTicket;
	}
	


	public String getFecha() {
		
		
		Date date = new Date();
		
		SimpleDateFormat formatodia = new SimpleDateFormat("dd-MM-yyyy");

		
		return fecha=formatodia.format(date);
	}
	
	


	public ArrayList<Producto> getProductos() {
		return productos;
	}


	public void agregar(Producto producto) {
		
		productos.add(producto);
		
	}
	
	public void eliminar(Producto producto) {
		
		productos.remove(producto);
		
	}
	
	public double subTotal() {
		
		double total=0;
		
		for(Producto var: productos) {
			
			total += var.getPrecio();
			
		}
		
		return total;
		
	}
	
	
	public double total() {
		
		double iva = this.subTotal()*0.16;
		
		
		return this.subTotal()+iva;
		
	}
	

	
	
	

}
