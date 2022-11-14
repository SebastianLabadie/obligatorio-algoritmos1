
package sistemaDistribucion;

public class nodoCaja {
    int nroCaja;
    int cantUnidades;
    nodoCaja siguiente;

    public nodoCaja(int nroCaja, int cantUnidades) {
        this.nroCaja = nroCaja;
        this.cantUnidades = cantUnidades;
        this.siguiente = null;
    }

    public int getNroCaja() {
        return nroCaja;
    }

    public void setNroCaja(int nroCaja) {
        this.nroCaja = nroCaja;
    }

    public int getCantUnidades() {
        return cantUnidades;
    }

    public void setCantUnidades(int cantUnidades) {
        this.cantUnidades = cantUnidades;
    }


    public nodoCaja getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoCaja siguiente) {
        this.siguiente = siguiente;
    }
    
}
