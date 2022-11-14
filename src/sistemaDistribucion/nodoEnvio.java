
package sistemaDistribucion;

public class nodoEnvio {
    int cantidadUnidades;
    nodoProducto producto;
    nodoCliente cliente;
    nodoCamion camion;
    nodoEnvio siguiente;
    

    public nodoEnvio(nodoCamion camion, nodoCliente cliente, nodoProducto producto, int cant) {
        this.cantidadUnidades = cant;
        this.camion = camion;
        this.cliente = cliente;
        this.producto = producto;
        this.siguiente = null;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public nodoProducto getProducto() {
        return producto;
    }

    public void setProducto(nodoProducto producto) {
        this.producto = producto;
    }

    public nodoCliente getCliente() {
        return cliente;
    }

    public void setCliente(nodoCliente cliente) {
        this.cliente = cliente;
    }

    public nodoCamion getCamion() {
        return camion;
    }

    public void setCamion(nodoCamion camion) {
        this.camion = camion;
    }


    public nodoEnvio getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoEnvio siguiente) {
        this.siguiente = siguiente;
    }
    
}
