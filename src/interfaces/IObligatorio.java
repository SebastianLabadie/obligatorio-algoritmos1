package interfaces;

import sistemaDistribucion.Retorno;


public interface IObligatorio {
    
    //pre:                                  post:Inicializa las listas de cliente,producto,camion y envios
    public Retorno crearSistemaDeDistribucion(int capacidadMax);
     //pre:Sistema debe estar creado        post:Agrega un nuevo cliente a lc siempre y cuando sus datos sean validos.
    public Retorno agregarCliente(String nombre,String rut,int tel, String direccion);
     //pre:Sistema debe estar creado        post:Si existe el cliente y no tiene envios asociados borra cliente de lc
    public Retorno eliminarCliente(String rut);
     //pre:Sistema debe estar creado        post:Si no existe camion y toneladasMaxSoportadas > 0 agrega un camion a lcam
    public Retorno agregarCamion(String matricula, int toneladasMaxSoportadas); 
     //pre:Sistema debe estar creado        post:Si camion existe es eliminado de lcam
    public Retorno eliminarCamion(String matricula);
     //pre:Sistema debe estar creado        post:Agrega un nuevo producto a lp si los datos son validos
    public Retorno registrarProducto(String nombre, String descripcion);
     //pre:Sistema debe estar creado        post:En caso de que los datos sean validos se apila la caja en pc dentro del producto, si hay ordenes pendientes de dicho producto se realizan los envios necesarios. 
    public Retorno altaDeStockDeProducto(String matriculaCamion, int codigoProd, int nroCaja, int cantUnidades);
     //pre:Sistema debe estar creado        post:
    public Retorno retiroDeProducto(String matriculaCam, String rutCliente, int codProducto, int cant); 
     //pre:Sistema debe estar creado        post:Muestra todos los camiones registrados en lcam 
    public Retorno listarCamiones();
     //pre:Sistema debe estar creado y lc debe estar ordenado        post:Muestra los datos de los clientes existentes en lc ordenados ASC
    public Retorno listarClientesOrdenado(); 
     //pre:Sistema debe estar creado        post:Muestra los datos de los productos registrados en lp
    public Retorno listarProductos(); 
     //pre:Sistema debe estar creado        post:Muestra los datos del ultimo producto registrado en lp
    public Retorno ultimoProductoRegistrado();
     //pre:Sistema debe estar creado        post:Si existe el producto en lp muestra sus envios en le de manera recursiva
    public Retorno listarEnvíosDeProducto(int codProd);
     //pre:Sistema debe estar creado        post:Si existe el producto en lp muestra sus envios pendientes 
    public Retorno listarOrdenesPendientes(int codProd);
     //pre:Sistema debe estar creado        post:Muestra una matriz con la cantidad de unidades por producto enviadas a cada cliente
    public Retorno reporteDeEnviosDeProductos();
    
    public Retorno Productoconmayorcantidaddeenvios();
    public Retorno ListarCamionesconlamayorcanttoneladasMaxSoportadas();
}
