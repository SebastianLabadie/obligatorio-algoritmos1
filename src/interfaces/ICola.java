
package interfaces;

import sistemaDistribucion.nodoCamion;
import sistemaDistribucion.nodoCliente;
import sistemaDistribucion.nodoEnvio;
import sistemaDistribucion.nodoProducto;

public interface ICola {
   public void encolar(nodoCamion camion, nodoCliente cliente, nodoProducto producto, int cant);  // encolar, agregar utilizando cola de Object
   public void desencolar() ;  // desencolar, sacar un elemento de la cola de Object
   public boolean esVacia(); 
   public boolean esllena();
   public int  cantelementos() ;  // cantidad de elementos
   public nodoEnvio  frente();   //Mostrar el que esta en frente  de la cola    
   public nodoEnvio fondo();
   public void mostrar();
}
