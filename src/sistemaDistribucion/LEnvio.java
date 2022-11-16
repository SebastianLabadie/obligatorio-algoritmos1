package sistemaDistribucion;

import interfaces.ILEnvio;

public class LEnvio implements ILEnvio {

    
    int ultimoCodigoProd;
    nodoEnvio primero;
    nodoEnvio ultimo;
    int cantnodos;
    
    

    public LEnvio() {
        this.primero = null;
        this.ultimo = null;
        this.cantnodos = 0;
        this.ultimoCodigoProd = 1;
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
    public void agregarInicio(nodoCamion camion, nodoCliente cliente, nodoProducto producto, int cant){
        nodoEnvio nuevo = new nodoEnvio(camion, cliente, producto, cant);
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
    public boolean buscarelemento(String matricula) {
        boolean encontrado = false;
        nodoEnvio aux = this.getPrimero();
        while (aux != null && !encontrado) {
            if (aux.getCamion().matricula == matricula) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }
        return encontrado;
    }
    
//    @Override
//    public boolean buscarelemento(String nombre) {
//         boolean encontrado = false;
//        nodoEnvio aux = this.getPrimero();
//        while (aux != null && !encontrado) {
//            if (aux.getNombre().equals(nombre)) {
//                encontrado = true;
//            }
//            aux = aux.getSiguiente();
//        }
//        return encontrado;
//    }
//
//    @Override
//    public nodoEnvio obtenerElemento(int codigoProd) {
//        nodoEnvio elemento = null;
//        nodoEnvio aux = this.getPrimero();
//        while (aux != null && elemento == null) {
//            if (aux.getCodigoProd() == codigoProd) {
//                elemento = aux;
//            }
//            aux = aux.getSiguiente();
//        }
//        return elemento;
//    }

    @Override
    public void mostrar() {
        nodoEnvio aux = this.getPrimero();
        if (!this.esVacia()) {
            while (aux != null) {
                System.out.println(aux.getCamion().matricula+ " - " + aux.getCliente().rut+ " - "+ aux.getProducto().nombre + " - "+aux.getCantidadUnidades());
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("La lista de productos esta vacia.");
        }
        System.out.println();
    }

    @Override
    public void mostrarREC(nodoEnvio l) {
//        System.out.println("Muestro del primero al ultimo");
//        System.out.println(mostrarRECPrimeroalUltimo(this.primero, this.ultimo));
//        System.out.println("Muestro del ultimo al primero");
//        System.out.println(mostrarRECUltimoalPrimero(this.primero, this.ultimo));

    }

//    public String mostrarRECPrimeroalUltimo(nodoEnvio primero, nodoEnvio ultimo) {
//        if (primero == ultimo) {
//            return " " + ultimo.getCodigoProd();
//        } else {
//            return primero.getCodigoProd() + " - " + mostrarRECPrimeroalUltimo(primero.siguiente, ultimo);
//
//        }
//    }
//
//    public String mostrarRECUltimoalPrimero(nodoEnvio primero, nodoEnvio ultimo) {
//        if (primero == ultimo) {
//            return " " + ultimo.getCodigoProd();
//        } else {
//            return mostrarRECUltimoalPrimero(primero.siguiente, ultimo) + " - " + primero.getCodigoProd();
//
//        }
//    }

    @Override
    public void vaciar() {
        this.setPrimero(null);
        this.setUltimo(null);
        this.cantnodos = 0;
    }

    @Override
    public void agregarFinal(nodoCamion camion, nodoCliente cliente, nodoProducto producto, int cant) {
         nodoEnvio nuevo = new nodoEnvio(camion, cliente, producto, cant);
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
            nodoEnvio aux = this.primero;
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
//                nodoEnvio nuevo = new nodoEnvio(dato,nombre);
//                nodoEnvio aux=this.getPrimero();
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

//    @Override
//    public void borrarElemento(int codigoProd) {
//        if (this.buscarelemento(codigoProd)) {
//            boolean borrado = false;
//            nodoEnvio aux = this.getPrimero();
//            if (this.primero.getCodigoProd() == codigoProd) {
//                this.borrarInicio();
//            } else {
//                if (ultimo.getCodigoProd() == codigoProd) {
//                    this.borrarFin();
//                } else {
//                    while (aux.getSiguiente() != this.getUltimo() && aux.getSiguiente() != null && !borrado) {
//                        if (aux.siguiente.getCodigoProd() == codigoProd) {
//                            aux.siguiente = aux.siguiente.siguiente;
//                            borrado = true;
//                            this.cantnodos = this.cantnodos - 1;
//                        }
//                        aux = aux.getSiguiente();
//                    }
//                }
//            }
//        } else {
//            System.out.println("el elemento no existe");
//        }
//
//    }

    @Override
    public int cantElementos() {
        return this.getCantnodos();
    }

    @Override
    public void obtenerElementoByCodigoProd(int CodigoProd,nodoEnvio aux) {
       
        
            if (aux.getProducto().codigoProd == CodigoProd) {
                System.out.println(aux.getCamion().matricula + " - " + aux.getCliente().nombre + " - " + aux.getCantidadUnidades());
            }
            
            aux = aux.getSiguiente();
            
            if( aux != null){
                obtenerElementoByCodigoProd(CodigoProd, aux);
            }
            
   
        
    }
    
     public boolean obtenerCantidadByCliente(String Rut){
        nodoEnvio aux = this.getPrimero();
        boolean encontre=false;
        if (!this.esVacia()) {
            while (aux != null && !encontre) {
                if (aux.cliente.getRut().equals(Rut)){
                    encontre = true;
                }
                aux = aux.getSiguiente();
            }
            
        } 
        return encontre;
       
    }
    
    public int obtenerCantidadByClienteYProducto(int CodProd,int Rut){
        nodoEnvio aux = this.getPrimero();
        
        int Cantidad = 0;
        if (!this.esVacia()) {
            while (aux != null) {
                
                if (Integer.parseInt(aux.cliente.getRut())==Rut && aux.producto.getCodigoProd()==CodProd){
                    Cantidad += aux.cantidadUnidades;
                }
                
                aux = aux.getSiguiente();
            }
            
        } else {
            System.out.println("La lista de productos esta vacia.");
        }
        return Cantidad;
       
    }

   

   

}
