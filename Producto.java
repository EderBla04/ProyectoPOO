package ProyectoIntegrador;

public class Producto{
	
	private String codigo;
	private String Nombre_del_producto;
	private double precio;
	public Producto(String codigo, String nombre_del_producto, double precio) {
		super();
		this.codigo = codigo;
		Nombre_del_producto = nombre_del_producto;
		this.precio = precio;
	}
	
	
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre_del_producto() {
		return Nombre_del_producto;
	}
	
	public void setNombre_del_producto(String nombre_del_producto) {
		Nombre_del_producto = nombre_del_producto;
	}
	
	public double getPrecio() {
		return precio;	
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		
		   final int CODIGO_LENGTH = 5; 
		    final int NOMBRE_LENGTH = 25; 
		    final int PRECIO_LENGTH = 5; 

		    String codigoPadded = String.format("%-" + CODIGO_LENGTH + "s", codigo);
		    String nombrePadded = String.format("%-" + NOMBRE_LENGTH + "s", Nombre_del_producto);
		    String precioPadded = String.format("%" + PRECIO_LENGTH + "s", precio);

		    return codigoPadded + " " + nombrePadded + " $" + precioPadded;
	}
	

	

}
