package ProyectoIntegrador;

public class Bebida extends Producto {
	
    private boolean esCaliente;

    public Bebida(String codigo, String nombreDelProducto, double precio, boolean esCaliente) {
        super(codigo, nombreDelProducto, precio);
        this.esCaliente = esCaliente;
    }

    public boolean esCaliente() {
        return esCaliente;
    }

    public void setEsCaliente(boolean esCaliente) {
        this.esCaliente = esCaliente;
    }

    @Override
    public String toString() {
        return super.toString() + " (Caliente: " + (esCaliente ? "Sí" : "No") + ")";
    }

}
