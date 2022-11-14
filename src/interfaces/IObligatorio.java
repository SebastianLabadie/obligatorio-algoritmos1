package interfaces;

import sistemaDistribucion.Retorno;


public interface IObligatorio {
    
    //pre:      post:
    public Retorno crearSistemaDeDistribucion(int capacidadMax);
     //pre:      post:
    public Retorno agregarCliente(String nombre,String rut,int tel, String direccion);
     //pre:      post:
    public Retorno eliminarCliente(String rut);
     //pre:      post:
    public Retorno agregarCamion(String matricula, int toneladasMaxSoportadas); 
     //pre:      post:
    public Retorno eliminarCamion(String matricula);
     //pre:      post:
    public Retorno registrarProducto(String nombre, String descripcion);
     //pre:      post:
    public Retorno altaDeStockDeProducto(String matriculaCamion, int codigoProd, int nroCaja, int cantUnidades);
     //pre:      post:
    public Retorno retiroDeProducto(String matriculaCam, String rutCliente, int codProducto, int cant); 
     //pre:      post:
    public Retorno listarCamiones();
     //pre:      post:
    public Retorno listarClientesOrdenado(); 
     //pre:      post:
    public Retorno listarProductos(); 
     //pre:      post:
    public Retorno ultimoProductoRegistrado();
     //pre:      post:
    public Retorno listarEnvíosDeProducto(int codProd);
     //pre:      post:
    public Retorno listarOrdenesPendientes(int codProd);
     //pre:      post:
    public Retorno reporteDeEnviosDeProductos();
    
    
}
