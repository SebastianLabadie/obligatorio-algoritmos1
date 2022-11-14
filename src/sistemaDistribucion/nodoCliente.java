
package sistemaDistribucion;

public class nodoCliente {
    String rut;
    String nombre;
//    LMedio lm;
    String direccion;
    int tel;
    nodoCliente siguiente;

    public nodoCliente(String nombre,String rut,int tel, String direccion){
        this.rut = rut;
        this.nombre = nombre;
        this.tel = tel;
        this.direccion = direccion;
//        this.lm = new LMedio();
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    
    public nodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoCliente siguiente) {
        this.siguiente = siguiente;
    }


    
    
}
