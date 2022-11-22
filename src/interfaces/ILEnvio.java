
package interfaces;

import sistemaDistribucion.nodoCamion;
import sistemaDistribucion.nodoCliente;
import sistemaDistribucion.nodoEnvio;
import sistemaDistribucion.nodoProducto;

public interface ILEnvio {
    public boolean esVacia();
    public void agregarInicio(nodoCamion camion, nodoCliente cliente, nodoProducto producto, int cant);
    public void borrarInicio(); 
    public boolean buscarelemento(String matricula);
    public void obtenerElementoByCodigoProd(int CodigoProd,nodoEnvio aux);
    public int obtenerCantidadByProducto(int CodProd);
    public void mostrar();
    public void mostrarREC(nodoEnvio l);    
    public void vaciar();    
     // metodos complementarios    
    public void agregarFinal(nodoCamion camion, nodoCliente cliente, nodoProducto producto, int cant);         
    public void borrarFin();      
    //public void agregarOrd(String matricula, int toneladasMaxSoportadas);
//    public void borrarElemento(String matricula);    
    public int cantElementos();   
}
