package sistemaDistribucion;

import interfaces.ILProducto;

public class LProducto implements ILProducto {

    
    int ultimoCodigoProd;
    nodoProducto primero;
    nodoProducto ultimo;
    int cantnodos;

    public LProducto() {
        this.primero = null;
        this.ultimo = null;
        this.cantnodos = 0;
        this.ultimoCodigoProd = 1;
    }

    public nodoProducto getPrimero() {
        return primero;
    }

    public void setPrimero(nodoProducto primero) {
        this.primero = primero;
    }

    public nodoProducto getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoProducto ultimo) {
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
    public void agregarInicio(String nombre, String descripcion){
        nodoProducto nuevo = new nodoProducto(ultimoCodigoProd, nombre, descripcion);
        if (this.esVacia()) {
            this.setUltimo(nuevo);
        } else {
            nuevo.setSiguiente(this.getPrimero());
        }
        this.setPrimero(nuevo);
        this.cantnodos = this.cantnodos + 1;
        this.ultimoCodigoProd += 1;
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
    public boolean buscarelemento(int codigoProd) {
        boolean encontrado = false;
        nodoProducto aux = this.getPrimero();
        while (aux != null && !encontrado) {
            if (aux.getCodigoProd() == codigoProd) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }
        return encontrado;
    }
    
    @Override
    public boolean buscarelemento(String nombre) {
        boolean encontrado = false;
        nodoProducto aux = this.getPrimero();
        while (aux != null && !encontrado) {
            if (aux.getNombre().equals(nombre)) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }
        return encontrado;
    }

    @Override
    public nodoProducto obtenerElemento(int codigoProd) {
        nodoProducto elemento = null;
        nodoProducto aux = this.getPrimero();
        while (aux != null && elemento == null) {
            if (aux.getCodigoProd() == codigoProd) {
                elemento = aux;
            }
            aux = aux.getSiguiente();
        }
        return elemento;
    }

    @Override
    public void mostrar() {
        nodoProducto aux = this.getPrimero();
        if (!this.esVacia()) {
            while (aux != null) {
                System.out.println(aux.getCodigoProd()+ " - " + aux.getNombre()+ " - "+ aux.getDescripcion());
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("La lista de productos esta vacia.");
        }
        System.out.println();
    }

    @Override
    public void mostrarREC(nodoProducto l) {
        System.out.println("Muestro del primero al ultimo");
        System.out.println(mostrarRECPrimeroalUltimo(this.primero, this.ultimo));
        System.out.println("Muestro del ultimo al primero");
        System.out.println(mostrarRECUltimoalPrimero(this.primero, this.ultimo));

    }

    public String mostrarRECPrimeroalUltimo(nodoProducto primero, nodoProducto ultimo) {
        if (primero == ultimo) {
            return " " + ultimo.getCodigoProd();
        } else {
            return primero.getCodigoProd() + " - " + mostrarRECPrimeroalUltimo(primero.siguiente, ultimo);

        }
    }

    public String mostrarRECUltimoalPrimero(nodoProducto primero, nodoProducto ultimo) {
        if (primero == ultimo) {
            return " " + ultimo.getCodigoProd();
        } else {
            return mostrarRECUltimoalPrimero(primero.siguiente, ultimo) + " - " + primero.getCodigoProd();

        }
    }

    @Override
    public void vaciar() {
        this.setPrimero(null);
        this.setUltimo(null);
        this.cantnodos = 0;
    }

    @Override
    public void agregarFinal(String nombre, String descripcion) {
         nodoProducto nuevo = new nodoProducto(ultimoCodigoProd, nombre, descripcion);
        if (this.esVacia()) {
            this.setPrimero(nuevo);
            this.setUltimo(nuevo);
        } else {
            this.ultimo.setSiguiente(nuevo);
            this.setUltimo(nuevo);
        }
        this.cantnodos = this.cantnodos + 1;
        this.ultimoCodigoProd += 1;
    }

    @Override
    public void borrarFin() {
        if (this.primero == this.ultimo) {
            this.setPrimero(null);
            this.setUltimo(null);
            this.cantnodos = 0;
        } else {
            nodoProducto aux = this.primero;
            while (aux.getSiguiente() != this.getUltimo()) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
            this.setUltimo(aux);
            this.cantnodos = this.cantnodos - 1;
        }

    }

//    @Override
//    public void agregarOrd(int dato, String nombre) {
//        if (this.esVacia() || dato< this.getPrimero().getCodigoProd()){
//            this.agregarInicio(dato,nombre);
//        }else{
//            if (dato> this.getUltimo().getCodigoProd()){
//                this.agregarFinal(dato,nombre);
//            }else{
//                nodoProducto nuevo = new nodoProducto(dato,nombre);
//                nodoProducto aux=this.getPrimero();
//                while (aux.getSiguiente()!=null && dato>=aux.getSiguiente().getCodigoProd()){
//                    aux=aux.getSiguiente();
//                }
//                nuevo.setSiguiente(aux.getSiguiente());
//                aux.setSiguiente(nuevo);
//                this.cantnodos=this.cantnodos+1;
//            }
//        
//        }
//
//    }

    @Override
    public void borrarElemento(int codigoProd) {
        if (this.buscarelemento(codigoProd)) {
            boolean borrado = false;
            nodoProducto aux = this.getPrimero();
            if (this.primero.getCodigoProd() == codigoProd) {
                this.borrarInicio();
            } else {
                if (ultimo.getCodigoProd() == codigoProd) {
                    this.borrarFin();
                } else {
                    while (aux.getSiguiente() != this.getUltimo() && aux.getSiguiente() != null && !borrado) {
                        if (aux.siguiente.getCodigoProd() == codigoProd) {
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

   public boolean validarExistenciaCaja(int nroCaja){
        boolean encontrado = false;
        nodoProducto aux = this.getPrimero();
        while (aux != null && !encontrado) {
            if (aux.pc.buscarelemento(nroCaja)) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }
        
        return encontrado;
    }

}
