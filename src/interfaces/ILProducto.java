
package interfaces;

import sistemaDistribucion.nodoProducto;

public interface ILProducto {
    public boolean esVacia();
    public void agregarInicio(String nombre, String descripcion);
    public void borrarInicio(); 
    public boolean buscarelemento(int codigo);
    public boolean buscarelemento(String nombre);
    public nodoProducto obtenerElemento(int codigo);
    public void mostrar();
    public void mostrarREC(nodoProducto l); // implementar el mostrar recursivo    
    public void vaciar();    
     // metodos complementarios    
    public void agregarFinal(String nombre, String descripcion);            
    public void borrarFin();      
//    public void agregarOrd(int dato,String nombre);
    public void borrarElemento(int codigo);    
    public int cantElementos();   
}
