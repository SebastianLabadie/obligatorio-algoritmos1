package sistemaDistribucion;

import interfaces.ILCamion;

public class LCamion implements ILCamion {

    nodoCamion primero;
    nodoCamion ultimo;
    int cantnodos;

    public LCamion() {
        this.primero = null;
        this.ultimo = null;
        this.cantnodos = 0;
    }

    public nodoCamion getPrimero() {
        return primero;
    }

    public void setPrimero(nodoCamion primero) {
        this.primero = primero;
    }

    public nodoCamion getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoCamion ultimo) {
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
    public void agregarInicio(String matricula, int toneladasMaxSoportadas ){
        nodoCamion nuevo = new nodoCamion(matricula,toneladasMaxSoportadas);
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
    public boolean buscarelemento(String matricula) {
        boolean encontrado = false;
        nodoCamion aux = this.getPrimero();
        while (aux != null && !encontrado) {
            if (aux.getMatricula().equals(matricula)) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }
        return encontrado;
    }

    @Override
    public nodoCamion obtenerElemento(String matricula) {
        nodoCamion elemento = null;
        nodoCamion aux = this.getPrimero();
        while (aux != null && elemento == null) {
            if (aux.getMatricula().equals(matricula)) {
                elemento = aux;
            }
            aux = aux.getSiguiente();
        }
        return elemento;
    }

    @Override
    public void mostrar() {
        nodoCamion aux = this.getPrimero();
        if (!this.esVacia()) {
            while (aux != null) {
                System.out.print(aux.getMatricula()+ " - " + aux.getToneladasMaxSoportadas());
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("La lista de camiones esta vacia.");
        }
        System.out.println();
    }

    @Override
    public void mostrarREC() {
        System.out.println("Muestro del primero al ultimo");
        System.out.println(mostrarRECPrimeroalUltimo(this.primero, this.ultimo));
        //System.out.println("Muestro del ultimo al primero");
        //System.out.println(mostrarRECUltimoalPrimero(this.primero, this.ultimo));

    }

    
    public String mostrarRECPrimeroalUltimo(nodoCamion primero, nodoCamion ultimo) {
        if (primero == ultimo) {
            return " " + ultimo.getMatricula();
        } else {
            return primero.getMatricula()+ " - " + mostrarRECPrimeroalUltimo(primero.siguiente, ultimo);

        }
    }

    public String mostrarRECUltimoalPrimero(nodoCamion primero, nodoCamion ultimo) {
        if (primero == ultimo) {
            return " " + ultimo.getMatricula();
        } else {
            return mostrarRECUltimoalPrimero(primero.siguiente, ultimo) + " - " + primero.getMatricula();

        }
    }

    @Override
    public void vaciar() {
        this.setPrimero(null);
        this.setUltimo(null);
        this.cantnodos = 0;
    }

    @Override
    public void agregarFinal(String matricula, int toneladasMaxSoportadas) {
        nodoCamion nuevo = new nodoCamion(matricula, toneladasMaxSoportadas);
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
            nodoCamion aux = this.primero;
            while (aux.getSiguiente() != this.getUltimo()) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
            this.setUltimo(aux);
            this.cantnodos = this.cantnodos - 1;
        }

    }
/*
    @Override
    public void agregarOrd(String nombre,String rut,int tel, String direccion) {
        if (this.esVacia() || nombre.compareTo(this.getPrimero().getNombre()) < 0){
            this.agregarInicio(nombre, rut, tel, direccion);
        }else{
            if (nombre.compareTo(this.getUltimo().getNombre()) > 0){
                this.agregarFinal(nombre, rut, tel, direccion);
            }else{
                nodoCamion nuevo = new nodoCamion(nombre, rut, tel, direccion);
                nodoCamion aux=this.getPrimero();
                while (aux.getSiguiente()!=null && nombre.compareTo(aux.getSiguiente().getNombre()) >= 0){
                    aux=aux.getSiguiente();
                }
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
                this.cantnodos=this.cantnodos+1;
            }
        
        }

    }
*/
    @Override
    public void borrarElemento(String matricula) {
        if (this.buscarelemento(matricula)) {
            boolean borrado = false;
            nodoCamion aux = this.getPrimero();
            if (this.primero.getMatricula().equals(matricula)) {
                this.borrarInicio();
            } else {
                if (ultimo.getMatricula().equals(matricula)) {
                    this.borrarFin();
                } else {
                    while (aux.getSiguiente() != this.getUltimo() && aux.getSiguiente() != null && !borrado) {
                        if (aux.siguiente.getMatricula().equals(matricula)) {
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
