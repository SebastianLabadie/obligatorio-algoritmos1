
package interfaces;

import sistemaDistribucion.nodoCaja;

public interface IPCaja {
    public boolean esVacia();
    public boolean esllena();
    public boolean buscarelemento(int nroCaja);
    public void apilar(int nroCaja, int cantUnidades);
    public void desapilar();
    public nodoCaja cima();
    public int cantelementos();
    public nodoCaja back();
}
