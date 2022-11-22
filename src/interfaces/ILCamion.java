
package interfaces;

import sistemaDistribucion.nodoCamion;

public interface ILCamion {
    public boolean esVacia();
    public void agregarInicio(String matricula, int toneladasMaxSoportadas);
    public void borrarInicio(); 
    public boolean buscarelemento(String matricula);
    public nodoCamion obtenerElemento(String matricula);
    public void mostrar();
    public void mostrarREC(); // implementar el mostrar recursivo    
    public void vaciar();    
     // metodos complementarios    
    public void agregarFinal(String matricula, int toneladasMaxSoportadas);            
    public void borrarFin();      
    //public void agregarOrd(String matricula, int toneladasMaxSoportadas);
    public void borrarElemento(String matricula);
    public void MostrarCamionesConMaxToneladas();    
    public int cantElementos();   
}
