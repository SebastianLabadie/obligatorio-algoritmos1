
package sistemaDistribucion;

import interfaces.ICola;

public class Cola implements ICola {
    int maximo; // maximo permitido o maxima cantidad de elementos permitido
    int cantelementos;
    nodoEnvio primero;      // es el que esta en la cima de la pila
    nodoEnvio ultimo; 

    public Cola(int maximo) {
        this.maximo = maximo;
        this.cantelementos = 0;
        this.primero = null;
        this.ultimo = null;
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

    public nodoEnvio getPrimero() {
        return primero;
    }

    public void setPrimero(nodoEnvio primero) {
        this.primero = primero;
    }

    public nodoEnvio getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoEnvio ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public void encolar(nodoCamion camion, nodoCliente cliente, nodoProducto producto, int cant) {
        if (!this.esllena()){
            nodoEnvio nuevo= new nodoEnvio(camion, cliente, producto, cant);
            if (this.esVacia()){
                this.setPrimero(nuevo);
                this.setUltimo(nuevo);
            }else{
                nuevo.setSiguiente(this.getPrimero());
                this.setPrimero(nuevo);
            }
            this.cantelementos=this.cantelementos+1;
        }else{
            System.out.println("La cola esta llena, no se puede agregar el elemento");
        }
    }

    @Override
    public void desencolar() {
        if (!this.esVacia()){
           if (this.cantelementos==1){
               this.setPrimero(null);
               this.setUltimo(null);
           }else{
               nodoEnvio aux=this.getPrimero();
               while (aux.siguiente!=ultimo){
                   aux=aux.getSiguiente();
               }
               aux.setSiguiente(null);
               this.setUltimo(aux);               
           }
           this.cantelementos=this.cantelementos-1;
        }else{
        System.out.println("No hay elementos para borrar, la pila esta vacia");
        }

    }

    @Override
    public boolean esVacia() {
        return this.cantelementos==0;
    }

    @Override
    public boolean esllena() {
        return this.cantelementos==this.maximo;
    }

    @Override
    public int cantelementos() {
        return this.cantelementos;
    }

    @Override
    public nodoEnvio frente() {
        if (!this.esVacia()){
            return this.getUltimo();
        }else{
            return null;
        }
    }

    @Override
    public nodoEnvio fondo() {
        if (!this.esVacia()){
            return this.primero;
        }else{
        return null;
        }
    }

    @Override
    public void mostrar() {
        
        nodoEnvio aux = this.getPrimero();
        if (!this.esVacia()) {
            while (aux != null) {
                System.out.println(aux.getProducto().nombre+ " - " + aux.getCliente().nombre+ " - ");
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("La lista espera esta vacioa");
        }
        System.out.println();
    }

    
    
    
}
