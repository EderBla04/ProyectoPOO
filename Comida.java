package ProyectoIntegrador;

public class Comida extends Producto {
	
	   private boolean esVegetariano;

	    public Comida(String codigo, String nombreDelProducto, double precio, boolean esVegetariano) {
	        super(codigo, nombreDelProducto, precio);
	        this.esVegetariano = esVegetariano;
	    }

	    public boolean esVegetariano() {
	        return esVegetariano;
	    }

	    public void setEsVegetariano(boolean esVegetariano) {
	        this.esVegetariano = esVegetariano;
	    }
	    
	    public String toString() {
	        return super.toString() + " (Vegetariano: " + (esVegetariano ? "Sí" : "No") + ")";
	    }

}
