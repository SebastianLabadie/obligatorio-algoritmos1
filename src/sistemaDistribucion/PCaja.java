package sistemaDistribucion;

import interfaces.IPCaja;

public class PCaja implements IPCaja {

    nodoCaja primero;
    nodoCaja ultimo;
    int maximo;  // maxima cantidad de elementos aceptados en pila
    int cantelementos;

    public PCaja(int maximo) {
        this.primero = null;
        this.ultimo = null;
        this.maximo = maximo;
        this.cantelementos = 0;
    }

    public nodoCaja getPrimero() {
        return primero;
    }

    public void setPrimero(nodoCaja primero) {
        this.primero = primero;
    }

    public nodoCaja getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoCaja ultimo) {
        this.ultimo = ultimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getCantelementos() {
        return cantelementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantelementos = cantelementos;
    }


    @Override
    public boolean esVacia() {
        return (this.cantelementos == 0);
    }

    @Override
    public boolean esllena() {
        return (this.cantelementos == this.maximo);
    }

    @Override
    public void apilar(int nroCaja, int cantUnidades) {
        nodoCaja nuevo = new nodoCaja(nroCaja, cantUnidades);
        if (!this.esllena()) {
            if (this.esVacia()) {
                this.setPrimero(nuevo);
                this.setUltimo(nuevo);
            } else {
                nuevo.setSiguiente(primero);
                primero = nuevo;
            }
            this.cantelementos = this.cantelementos + 1;
        } else {
            System.out.println("No se puede agregar, la cola esta llena");
        }
    }

    @Override
    public void desapilar() {
        if (!this.esVacia()) {
            if (this.cantelementos == 1) {
                this.setPrimero(null);
                this.setUltimo(null);
            } else {
                this.setPrimero(this.primero.getSiguiente());                
            }
            this.cantelementos = this.cantelementos - 1;
        } else {
            System.out.println("No hay elementos para quitar");
        }

    }

    @Override
    public nodoCaja cima() {
        if (!this.esVacia()) {
            return this.getPrimero();
        } else {
            return null; //"No hay elementos";
        }
    }

    @Override
    public int cantelementos() {
        return this.cantelementos;
    }

    @Override
    public nodoCaja back() {
        if (!this.esVacia()) {
            return this.getUltimo();
        } else {
            return null; // "No hay elementos";
        }
    }
    
     
    @Override
    public boolean buscarelemento(int nroCaja) {
        boolean encontrado = false;
        nodoCaja aux = this.getPrimero();
        while (aux != null && !encontrado) {
            if (aux.getNroCaja() == nroCaja) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }
        return encontrado;
    }

}
