
package sistemaDistribucion;

public class nodoProducto {
    int codigoProd;
    String nombre;
    String descripcion;
    int stockTotal;
    PCaja pc;
    Cola ce;
    nodoProducto siguiente;

    public nodoProducto (int codigoProd,String nombre, String descripcion) {
        this.codigoProd = codigoProd;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stockTotal =0;
        this.pc = new PCaja(999); //de momento hardcode
        this.ce = new Cola(999);
        this.siguiente = null;
    }

    public int getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(int codigoProd) {
        this.codigoProd = codigoProd;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public nodoProducto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoProducto siguiente) {
        this.siguiente = siguiente;
    }

    
    
    
}
