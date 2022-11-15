package interfaces;

import sistemaDistribucion.Retorno;


public interface IObligatorio {
    
    //pre:Sistema debe estar creado         post:Inicializa las listas necesarias para la representacion del sistema y su capacidad. 
    public Retorno crearSistemaDeDistribucion(int capacidadMax);
     //pre:Sistema debe estar creado        post:Agrega un nuevo cliente al sistema siempre y cuando sus datos sean validos.
    public Retorno agregarCliente(String nombre,String rut,int tel, String direccion);
     //pre:Sistema debe estar creado        post:
    public Retorno eliminarCliente(String rut);
     //pre:Sistema debe estar creado        post:
    public Retorno agregarCamion(String matricula, int toneladasMaxSoportadas); 
     //pre:Sistema debe estar creado        post:
    public Retorno eliminarCamion(String matricula);
     //pre:Sistema debe estar creado        post:
    public Retorno registrarProducto(String nombre, String descripcion);
     //pre:Sistema debe estar creado        post:
    public Retorno altaDeStockDeProducto(String matriculaCamion, int codigoProd, int nroCaja, int cantUnidades);
     //pre:Sistema debe estar creado        post:
    public Retorno retiroDeProducto(String matriculaCam, String rutCliente, int codProducto, int cant); 
     //pre:Sistema debe estar creado        post:
    public Retorno listarCamiones();
     //pre:Sistema debe estar creado        post:
    public Retorno listarClientesOrdenado(); 
     //pre:Sistema debe estar creado        post:
    public Retorno listarProductos(); 
     //pre:Sistema debe estar creado        post:
    public Retorno ultimoProductoRegistrado();
     //pre:Sistema debe estar creado        post:
    public Retorno listarEnvíosDeProducto(int codProd);
     //pre:Sistema debe estar creado        post:
    public Retorno listarOrdenesPendientes(int codProd);
     //pre:Sistema debe estar creado        post:
    public Retorno reporteDeEnviosDeProductos();
    
    
}
