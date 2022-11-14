
package interfaces;

import sistemaDistribucion.nodoCliente;

public interface ILCliente {
    public boolean esVacia();
    public void agregarInicio(String nombre,String rut,int tel, String direccion);
    public void borrarInicio(); 
    public boolean buscarelemento(String rut);
    public nodoCliente obtenerElemento(String rut);
    public void mostrar();
    public void mostrarREC(nodoCliente l); // implementar el mostrar recursivo    
    public void vaciar();    
     // metodos complementarios    
    public void agregarFinal(String nombre,String rut,int tel, String direccion);            
    public void borrarFin();      
    public void agregarOrd(String nombre,String rut,int tel, String direccion);
    public void borrarElemento(String rut);    
    public int cantElementos();   
}
