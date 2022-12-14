package sistemaDistribucion;

import interfaces.IObligatorio;

public class Obligatorio implements IObligatorio {

    LCliente lc;
    LProducto lp;
    LCamion lcam;
    LEnvio le;
    
    int capacidadCajas;
    int capacidadOcupada;
    
    @Override
    public Retorno crearSistemaDeDistribucion(int capacidadMax) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (capacidadMax > 0) {
            this.lc = new LCliente();
            this.lp = new LProducto();
            this.lcam = new LCamion();
            this.le = new LEnvio();
            //this.pc = new PCaja(capacidadMax)
            this.capacidadCajas = capacidadMax;
            this.capacidadOcupada = 0;
            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "Se pudo inicializar el sistema correctamente con capacidad "+capacidadMax;
        }else{
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "No se creo el sistema la capacidad de cajas es <= 0";
        }
        
        return ret;
    }

    @Override
    public Retorno agregarCliente(String nombre, String rut, int tel, String direccion) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        if (!lc.buscarelemento(rut)) {
            lc.agregarOrd(nombre, rut, tel, direccion);
            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "Se registra el cliente: "+nombre;
        }else{
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "No se registra, ya existe cliente con rut "+rut;
        }
        
        return ret;

    }

    @Override
    public Retorno eliminarCliente(String rut) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (lc.buscarelemento(rut)) {
            //si tiene envios relacionados enviar error 2
            if(le.obtenerCantidadByCliente(rut)){
                ret.resultado = Retorno.Resultado.ERROR_2;
                ret.valorString = "No se elimina. El cliente "+rut+" tiene entregas realizadas";
                return ret;
            }
            lc.borrarElemento(rut);
            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "Se elimina el cliente " + rut;
            
            
            
        }else{
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "No se elimina. No existe cliente con rut " + rut;
        }
        
        return ret;
    }

    @Override
    public Retorno agregarCamion(String matricula, int toneladasMaxSoportadas) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        
        if(lcam.buscarelemento(matricula)){
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "No se registra. Ya existe camion con matricula "+matricula;
            return ret;
        }
        
        if(toneladasMaxSoportadas <= 0)
        {
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "No se registra. La carga del camion es menor a 0";
            return ret;
        }
        
        lcam.agregarFinal(matricula, toneladasMaxSoportadas);
        
        ret.resultado = Retorno.Resultado.OK;
        ret.valorString = "Se registra el camion de matricula "+matricula;
            
        
        return ret;
    }

    @Override
    public Retorno eliminarCamion(String matricula) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if(lcam.buscarelemento(matricula) == false)
        {
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "No se elimina. No existe camion con matricula " + matricula; 
            return ret;
        }
        
        
        if (le.buscarelemento(matricula) == true)
        {
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "No se elimina. El camion " + matricula + " tiene entregas realizadas";     
            return ret;
        }
        
        lcam.borrarElemento(matricula);
        ret.resultado = Retorno.Resultado.OK;
        ret.valorString = "Se elimina el camionn "+matricula;
        return ret;
    }

    @Override
    public Retorno registrarProducto(String nombre, String descripcion) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (descripcion.isEmpty()) {
            ret.resultado = Retorno.Resultado.ERROR_2;  
            ret.valorString = "No se registra. Descripcion vacia.";
            return ret;
        }
        if (lp.buscarelemento(nombre)) {
            ret.resultado = Retorno.Resultado.ERROR_1;  
            ret.valorString = "No se registra. Ya existe un producto de nombre "+nombre;
        }else{
            lp.agregarFinal(nombre, descripcion);
            nodoProducto a = lp.getUltimo();
            a.pc.maximo = capacidadCajas;
            ret.resultado = Retorno.Resultado.OK;  
            ret.valorString = "Se registra el producto "+nombre;
        }
        return ret;
    }

    @Override
    public Retorno altaDeStockDeProducto(String matriculaCamion, int codigoProd, int nroCaja, int cantUnidades) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (!lcam.buscarelemento(matriculaCamion)) {
            ret.resultado = Retorno.Resultado.ERROR_1;  
            ret.valorString = "Error no existe cami??n con la matricula " + matriculaCamion;
            return ret;
        }
        if (!lp.buscarelemento(codigoProd)) {
            ret.resultado = Retorno.Resultado.ERROR_2;  
            ret.valorString ="No se registra. No existe el producto de codigo " + codigoProd;
            return ret;
        }
        if (cantUnidades <= 0) {
            ret.resultado = Retorno.Resultado.ERROR_3;  
            ret.valorString = "Error no cantidad de unidades menor o igual a cero";
            return ret;
        }
        
        
        if (lp.validarExistenciaCaja(nroCaja)) { 
            ret.resultado = Retorno.Resultado.ERROR_4;  
            ret.valorString = "No se registra. El numero de caja "+nroCaja+" ya existe ";
            return ret;
        }

        
        //si capacidad de fabrica esta llena se debe lanzar error
        if (this.capacidadOcupada >= this.capacidadCajas) {
            
         ret.resultado = Retorno.Resultado.ERROR_5;  
         ret.valorString = "No se registra. La fabrica tiene un tope de "+ this.capacidadCajas+" cajas";
         return ret;
        }
        
        //alta de stock
        //buscar producto => sumar stocktotal, agregar caja
            //sumar a capacidadOcupada de fabrica
        nodoProducto producto = lp.obtenerElemento(codigoProd);
        producto.stockTotal += cantUnidades;
        producto.pc.apilar(nroCaja, cantUnidades);
        this.capacidadOcupada +=1;
        
        //System.out.println("1- prod.stockTotal: "+ producto.stockTotal);
        if(producto.pc.cima() != null){
         //System.out.println("1- prod.apilar: "+ producto.pc.cima().getCantUnidades());
        }
        //System.out.println("1- prod.capacidadOcupada: "+ this.capacidadOcupada);
        
        //ver si hay ordenes en espera para ese producto y generar envio
        nodoEnvio ordenEspera = producto.ce.fondo();
        nodoCaja caja = producto.pc.cima();
        manejoOrdenREC(ordenEspera,caja);
        
        //System.out.println("2- prod.stockTotal: "+ producto.stockTotal);
        if(producto.pc.cima() != null){
         //System.out.println("2- prod.apilar: "+ producto.pc.cima().getCantUnidades()); 
        }
        //System.out.println("2- prod.capacidadOcupada: "+ this.capacidadOcupada);
        
        ret.resultado = Retorno.Resultado.OK;  
        ret.valorString = "Se Agregan "+ cantUnidades + " unidades de stock al producto "+ producto.nombre;
        
        return ret;
    }
    
    
    
    public void manejoOrdenREC(nodoEnvio ordenEspera,  nodoCaja caja){
        if(ordenEspera != null && caja != null){
            nodoEnvio ordenSiguiente = ordenEspera.getSiguiente();
            manejoCajasREC(caja, ordenEspera.getCantidadUnidades(), ordenEspera.getCamion(), ordenEspera.getCliente(), ordenEspera.getProducto(),true);
            
            //si la cantidad de unidades de la caja es mayor a cero 
                //llamar recursivo
                if(ordenEspera.getSiguiente() == null ){
                       manejoOrdenREC(ordenSiguiente,caja);
                }
        }
    }
    
    

    @Override
    public Retorno retiroDeProducto(String matriculaCam, String rutCliente, int codProducto, int cant) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
         if (!lcam.buscarelemento(matriculaCam)) {
            ret.resultado = Retorno.Resultado.ERROR_1;  
            ret.valorString = "No se realiza el retiro. No existe un camionn de matri??cula "+ matriculaCam;
            return ret;
        }
        if (!lc.buscarelemento(rutCliente)) {
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "No se realiza el retiro. No existe cliente de rut " + rutCliente;
            return ret;
        }
        if (!lp.buscarelemento(codProducto)) {
            ret.resultado = Retorno.Resultado.ERROR_3;  
            ret.valorString = "No se realiza el retiro. No existe un producto de codigo " + codProducto;
            return ret;
        }
         
        //Agregar envio de forma parcial o completa
        //buscar camion
        nodoCamion camion = lcam.obtenerElemento(matriculaCam);
        //buscar cliente
        nodoCliente cliente = lc.obtenerElemento(rutCliente);
        //buscar prod
        nodoProducto producto = lp.obtenerElemento(codProducto);
        
        
        //System.out.println("1- prod.stockTotal: "+ producto.stockTotal); 
        if(producto.pc.cima() != null){
         //System.out.println("1- prod.apilar: "+ producto.pc.cima().getCantUnidades());
        }
        //System.out.println("1- prod.capacidadOcupada: "+ this.capacidadOcupada);
        
        //buscar cantidad en ultima caja
        nodoCaja caja = producto.pc.cima();
        manejoCajasREC(caja, cant, camion, cliente, producto,false);

        //System.out.println("2- prod.stockTotal: "+ producto.stockTotal);
        if(producto.pc.cima() != null){
         //System.out.println("2- prod.apilar: "+ producto.pc.cima().getCantUnidades());
        }
        //System.out.println("2- prod.capacidadOcupada: "+ this.capacidadOcupada);
       
        ret.resultado = Retorno.Resultado.OK;  
        ret.valorString = "Se retiran "+ cant +" unidades del producto "+ producto.nombre;

        return ret;
    }
    
    //caja puede ser nulla
    public void manejoCajasREC(nodoCaja caja,int cant, nodoCamion camion, nodoCliente cliente, nodoProducto producto, boolean llamadaOE){
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        //si no hay stock o la caja es nula directamente se crea una orden de retiro en espera
        if(producto.stockTotal == 0 || caja == null){
            if(!llamadaOE){
             producto.ce.encolar(camion, cliente, producto, cant);
             ret.resultado = Retorno.Resultado.OK;  
             ret.valorString = "Se genera una orden pendiente por "+ cant +"unidades del producto "+ producto.nombre;
             
            }
            return;
        }
        
        int auxCant = cant;
        int cajaUnidades = caja.getCantUnidades();
        if (cajaUnidades > cant){
             le.agregarFinal(camion, cliente, producto, cant);
             caja.setCantUnidades(cajaUnidades - cant);
             producto.stockTotal -= cant; 
             
             if(llamadaOE){
                producto.ce.desencolar();
            }
             
        }
        
        if (cajaUnidades == cant){
             le.agregarFinal(camion, cliente, producto, cant);
             producto.pc.desapilar();
             producto.stockTotal -= cant; 
             this.capacidadOcupada -= 1;
             
             if(llamadaOE){
                producto.ce.desencolar();
            }
        }
        if (cajaUnidades < cant){
             le.agregarFinal(camion, cliente, producto, cajaUnidades);
             auxCant-=cajaUnidades;
             nodoCaja cajaSiguiente = producto.pc.cima().getSiguiente();
             producto.pc.desapilar();
             producto.stockTotal -= cajaUnidades; 
             this.capacidadOcupada -= 1;
             
             //si hay mas cajas
             if(cajaSiguiente != null){ 
                manejoCajasREC(cajaSiguiente, auxCant, camion, cliente, producto,llamadaOE);
             }else{
                //no hay mas cajas genero una orden de espera, por la cantidad actual
                if(llamadaOE){
                    producto.ce.fondo().setCantidadUnidades(auxCant);
                }else{
                    producto.ce.encolar(camion, cliente, producto, auxCant);
                }
                
                
                
             }
        }
        
        
          
    }
    

    @Override
    public Retorno listarCamiones() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.resultado = Retorno.Resultado.OK;
        ret.valorString="Se listan "+lcam.getCantnodos()+" camiones.";
        lcam.mostrarREC();
        return ret;
    }

    @Override
    public Retorno listarClientesOrdenado() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.resultado = Retorno.Resultado.OK;
        ret.valorString="Se listan "+lc.getCantnodos()+" clientes.";
        lc.mostrar();
        
        return ret;
    }

    @Override
    public Retorno listarProductos() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.resultado = Retorno.Resultado.OK;
        ret.valorString="Se listan "+lp.getCantnodos()+" productos.";
        
        lp.mostrar();
        return ret;
    }

    @Override
    public Retorno ultimoProductoRegistrado() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        nodoProducto prod = lp.getUltimo();
        ret.resultado = Retorno.Resultado.OK;
        ret.valorString="cod: "+prod.codigoProd+" nombre: "+prod.nombre + " descripcion: "+prod.descripcion;
        
        return ret;
    }
    @Override
    public Retorno listarEnv??osDeProducto(int codProd) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.resultado = Retorno.Resultado.OK;
        if (!lp.buscarelemento(codProd))
        {
             ret.resultado = Retorno.Resultado.ERROR_1;
             ret.valorString = "No existe codigo Producto";
             return ret;
        }
        nodoEnvio aux = le.getPrimero();
        le.obtenerElementoByCodigoProd(codProd, aux);
        //le.mostrar();
         
        ret.valorString = "Envios";
        
        
        return ret;
    }

    @Override
    public Retorno listarOrdenesPendientes(int codProd) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        nodoProducto a = lp.obtenerElemento(codProd);
        if (a !=null){
            ret.resultado = Retorno.Resultado.OK; 
            ret.valorString="Ordenes Pendientes";
            a.ce.mostrar();
            
            
        }
        else
        {
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "No se encuentra Producto";
            return ret;
        }
        return ret;
    }

    @Override
    public Retorno reporteDeEnviosDeProductos() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.resultado = Retorno.Resultado.OK;
        int FILAS = lp.cantElementos() + 1;
        int COLUMNAS = lc.cantElementos() + 1; 
        
        int[][] Matriz = new int[FILAS][COLUMNAS];
        int i;
        int j;
        
        
        nodoCliente cliente = lc.getPrimero();
        nodoProducto producto = lp.getPrimero(); 
        for (i = 0; i < FILAS; i++) {
            //0
          
            for (j = 0; j < COLUMNAS; j++) {
                
                if (i==0 && j>=1 ){
                Matriz[i][j] = Integer.parseInt(cliente.getRut());
                
                if (j+1 != COLUMNAS ){
                }
                    cliente = cliente.getSiguiente();
                
                }

                if(i>=1 && j==0){
                    Matriz[i][j] = producto.getCodigoProd();
                    producto = producto.getSiguiente();
                    
                }
                
                if(i>=1 && j>=1){
                   Matriz[i][j] = le.obtenerCantidadByClienteYProducto(Matriz[i][0], Matriz[0][j]);
                }
                
                
                
                
            }
        }
        for (i = 0; i < Matriz.length; i++) { 
          for (j = 0; j < Matriz[i].length; j++) {
              
              if(i==0){
                System.out.print(Matriz[i][j] + "     ");
              }else{
                if(i>=1 ){
                   System.out.print(Matriz[i][j] + "      ");
                }else{
                    System.out.print(Matriz[i][j] + " ");
                }
              }
                
          }
          System.out.println();
        }
        
        ret.resultado = Retorno.Resultado.OK;
        ret.valorString = "Se muestra el reporte de envios por productos";
        return ret;
    }

    @Override
    public Retorno Productoconmayorcantidaddeenvios() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.resultado = Retorno.Resultado.OK;
               
        
        nodoProducto p = lp.getPrimero();
        nodoProducto pMayorCantenvios = null;
        int cantMayor=0;
        calcularProductoMayorCantEnviosREC(p,cantMayor,pMayorCantenvios);
        
        
        return ret;
    }
    
    public void calcularProductoMayorCantEnviosREC(nodoProducto p, int cantMayor,nodoProducto pMayorCantEnvios){
        if (p != null) {
                int cantidad = le.obtenerCantidadByProducto(p.codigoProd);
                //System.out.println("producto: "+p.nombre+" cantidad: "+cantidad);
                
                if (cantidad > cantMayor) {
                    cantMayor = cantidad;
                    pMayorCantEnvios = p;
                }
                
                nodoProducto sigProducto = p.getSiguiente();
                if(sigProducto != null){
                    calcularProductoMayorCantEnviosREC(sigProducto,cantMayor,pMayorCantEnvios);
                }else{
                    System.out.println("Producto con mayor cantidad de envios:");
                    System.out.println("    Nombre: "+pMayorCantEnvios.nombre+" Envios: "+cantMayor);
                }
            }
    }

    @Override
    public Retorno ListarCamionesconlamayorcanttoneladasMaxSoportadas() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.resultado = Retorno.Resultado.OK;
        ret.valorString="Se listan "+lcam.getCantnodos()+" camiones.";
        lcam.MostrarCamionesConMaxToneladas();
        return ret;
    }
    

}
