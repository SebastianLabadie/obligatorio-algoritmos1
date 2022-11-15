package sistemaDistribucion;

import interfaces.ILCliente;

public class LCliente implements ILCliente {

    nodoCliente primero;
    nodoCliente ultimo;
    int cantnodos;

    public LCliente() {
        this.primero = null;
        this.ultimo = null;
        this.cantnodos = 0;
    }

    public nodoCliente getPrimero() {
        return primero;
    }

    public void setPrimero(nodoCliente primero) {
        this.primero = primero;
    }

    public nodoCliente getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoCliente ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantnodos() {
        return cantnodos;
    }

    public void setCantnodos(int cantnodos) {
        this.cantnodos = cantnodos;
    }

    @Override
    public boolean esVacia() {
        return (this.getPrimero() == null);
    }

    @Override
    public void agregarInicio(String nombre,String rut,int tel, String direccion){
        nodoCliente nuevo = new nodoCliente(nombre, rut, tel, direccion);
        if (this.esVacia()) {
            this.setUltimo(nuevo);
        } else {
            nuevo.setSiguiente(this.getPrimero());
        }
        this.setPrimero(nuevo);
        this.cantnodos = this.cantnodos + 1;
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            this.setPrimero(this.primero.getSiguiente());
            if (this.cantnodos == 1) {
                this.setUltimo(null);
            }
            this.cantnodos = this.cantnodos - 1;
        }
    }

    @Override
    public boolean buscarelemento(String rut) {
        boolean encontrado = false;
        nodoCliente aux = this.getPrimero();
        while (aux != null && !encontrado) {
            if (aux.getRut().equals(rut)) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }
        return encontrado;
    }

    @Override
    public nodoCliente obtenerElemento(String rut) {
        nodoCliente elemento = null;
        nodoCliente aux = this.getPrimero();
        while (aux != null && elemento == null) {
            if (aux.getRut().equals(rut)) {
                elemento = aux;
            }
            aux = aux.getSiguiente();
        }
        return elemento;
    }

    @Override
    public void mostrar() {
        nodoCliente aux = this.getPrimero();
        if (!this.esVacia()) {
            while (aux != null) {
               // if(aux.nombre){
                //}
                System.out.println(aux.getNombre()+ " - " + aux.getRut()+ " - "+ aux.getDireccion());
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("La lista de clientes esta vacia.");
        }
        System.out.println();
    }

    @Override
    public void mostrarREC(nodoCliente l) {
        System.out.println("Muestro del primero al ultimo");
        System.out.println(mostrarRECPrimeroalUltimo(this.primero, this.ultimo));
        System.out.println("Muestro del ultimo al primero");
        System.out.println(mostrarRECUltimoalPrimero(this.primero, this.ultimo));

    }

    public String mostrarRECPrimeroalUltimo(nodoCliente primero, nodoCliente ultimo) {
        if (primero == ultimo) {
            return " " + ultimo.getRut();
        } else {
            return primero.getRut() + " - " + mostrarRECPrimeroalUltimo(primero.siguiente, ultimo);

        }
    }

    public String mostrarRECUltimoalPrimero(nodoCliente primero, nodoCliente ultimo) {
        if (primero == ultimo) {
            return " " + ultimo.getRut();
        } else {
            return mostrarRECUltimoalPrimero(primero.siguiente, ultimo) + " - " + primero.getRut();

        }
    }

    @Override
    public void vaciar() {
        this.setPrimero(null);
        this.setUltimo(null);
        this.cantnodos = 0;
    }

    @Override
    public void agregarFinal(String nombre,String rut,int tel, String direccion) {
        nodoCliente nuevo = new nodoCliente(nombre, rut, tel, direccion);
        if (this.esVacia()) {
            this.setPrimero(nuevo);
            this.setUltimo(nuevo);
        } else {
            this.ultimo.setSiguiente(nuevo);
            this.setUltimo(nuevo);
        }
        this.cantnodos = this.cantnodos + 1;
    }

    @Override
    public void borrarFin() {
        if (this.primero == this.ultimo) {
            this.setPrimero(null);
            this.setUltimo(null);
            this.cantnodos = 0;
        } else {
            nodoCliente aux = this.primero;
            while (aux.getSiguiente() != this.getUltimo()) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
            this.setUltimo(aux);
            this.cantnodos = this.cantnodos - 1;
        }

    }

    @Override
    public void agregarOrd(String nombre,String rut,int tel, String direccion) {
        if (this.esVacia() || nombre.compareTo(this.getPrimero().getNombre()) < 0){
            this.agregarInicio(nombre, rut, tel, direccion);
        }else{
            if (nombre.compareTo(this.getUltimo().getNombre()) > 0){
                this.agregarFinal(nombre, rut, tel, direccion);
            }else{
                nodoCliente nuevo = new nodoCliente(nombre, rut, tel, direccion);
                nodoCliente aux=this.getPrimero();
                while (aux.getSiguiente()!=null && nombre.compareTo(aux.getSiguiente().getNombre()) >= 0){
                    aux=aux.getSiguiente();
                }
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
                this.cantnodos=this.cantnodos+1;
            }
        
        }

    }

    @Override
    public void borrarElemento(String rut) {
        if (this.buscarelemento(rut)) {
            boolean borrado = false;
            nodoCliente aux = this.getPrimero();
            if (this.primero.getRut().equals(rut)) {
                this.borrarInicio();
            } else {
                if (ultimo.getRut().equals(rut)) {
                    this.borrarFin();
                } else {
                    while (aux.getSiguiente() != this.getUltimo() && aux.getSiguiente() != null && !borrado) {
                        if (aux.siguiente.getRut().equals(rut)) {
                            aux.siguiente = aux.siguiente.siguiente;
                            borrado = true;
                            this.cantnodos = this.cantnodos - 1;
                        }
                        aux = aux.getSiguiente();
                    }
                }
            }
        } else {
            System.out.println("el elemento no existe");
        }

    }

    @Override
    public int cantElementos() {
        return this.getCantnodos();
    }

}
