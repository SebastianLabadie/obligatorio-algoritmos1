package sistemaDistribucion;

import interfaces.IObligatorio;

public class Obligatorio implements IObligatorio {

    LCliente lc;
    LProducto lp;
    LCamion lcam;
    LEnvio le;
    //PCaja pc;
    //Cola ce;
    
    
    int capacidadCajas;
    int capacidadOcupada;
    //listastack
        //nodostack => nodoproducto
        // caja,unidad,prod -> controlar la cant max
    
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
            ret.valorString = "Se pudo inicializar el sistema correctamente.";
        }else{
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "Error la capacidad de cajas es <= 0";
        }
        
        return ret;
    }

    @Override
    public Retorno agregarCliente(String nombre, String rut, int tel, String direccion) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        if (!lc.buscarelemento(rut)) {
            //lc.agregarFinal(nombre, rut, tel, direccion);
            lc.agregarOrd(nombre, rut, tel, direccion);
            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "Cliente agregado con exito.";
        }else{
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "Error ya existe un cliente con igual rut";
        }
        
        return ret;

    }

    @Override
    public Retorno eliminarCliente(String rut) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (lc.buscarelemento(rut)) {
            //si tiene envios relacionados enviar error 2
            
            
            lc.borrarElemento(rut);
            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "Cliente eliminado con exito.";
            
            
            
        }else{
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "Error cliente no existe.";
        }
        
        return ret;
    }

    @Override
    public Retorno agregarCamion(String matricula, int toneladasMaxSoportadas) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        
        if(lcam.buscarelemento(matricula)){
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "Camion ya existe";
            return ret;
        }
        
        if(toneladasMaxSoportadas <= 0)
        {
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "Toneladas no pueden ser menor o igual a 0";
            return ret;
        }
        
        lcam.agregarFinal(matricula, toneladasMaxSoportadas);
        
        ret.resultado = Retorno.Resultado.OK;
        ret.valorString = "Camion Agregado Correctamente";
            
        
        return ret;
    }

    @Override
    public Retorno eliminarCamion(String matricula) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if(lcam.buscarelemento(matricula) == false)
        {
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "Numero de matricula no esta asignado a ningun camion"; 
            return ret;
        }
        
        
        if (le.buscarelemento(matricula) == true)
        {
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "Camion Tiene entregas Realizadas";     
            return ret;
        }
        
        lcam.borrarElemento(matricula);
        ret.resultado = Retorno.Resultado.OK;
        ret.valorString = "Camion Eliminado Correctamente";
        return ret;
    }

    @Override
    public Retorno registrarProducto(String nombre, String descripcion) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (descripcion.isEmpty()) {
            ret.resultado = Retorno.Resultado.ERROR_2;  
            ret.valorString = "Error descripcion vacia.";
            return ret;
        }
        if (lp.buscarelemento(nombre)) {
            ret.resultado = Retorno.Resultado.ERROR_1;  
            ret.valorString = "Error ya existe un producto con el mismo nombre.";
        }else{
            lp.agregarFinal(nombre, descripcion);
            nodoProducto a = lp.getUltimo();
            a.pc.maximo = capacidadCajas;
            ret.resultado = Retorno.Resultado.OK;  
            ret.valorString = "Producto registrado con exito";
        }
        return ret;
    }

    @Override
    public Retorno altaDeStockDeProducto(String matriculaCamion, int codigoProd, int nroCaja, int cantUnidades) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (!lcam.buscarelemento(matriculaCamion)) {
            ret.resultado = Retorno.Resultado.ERROR_1;  
            ret.valorString = "Error no existe camión con esa matricula.";
            return ret;
        }
        if (!lp.buscarelemento(codigoProd)) {
            ret.resultado = Retorno.Resultado.ERROR_2;  
            ret.valorString = "Error no existe producto con ese codigo.";
            return ret;
        }
        if (cantUnidades <= 0) {
            ret.resultado = Retorno.Resultado.ERROR_3;  
            ret.valorString = "Error no cantidad de unidades menor o igual a cero";
            return ret;
        }
        
        
        if (lp.validarExistenciaCaja(nroCaja)) { 
            ret.resultado = Retorno.Resultado.ERROR_4;  
            ret.valorString = "Error ya existe ese número de caja. ";
            return ret;
        }

        //si capacidad de fabrica esta llena se debe lanzar error
        if (this.capacidadOcupada >= this.capacidadCajas) {
         ret.resultado = Retorno.Resultado.ERROR_5;  
         ret.valorString = "Error la capacidad total de la fabrica se encuentra ocupada.";
         return ret;
        }
        
        //alta de stock
        //buscar producto => sumar stocktotal, agregar caja
            //sumar a capacidadOcupada de fabrica
        nodoProducto producto = lp.obtenerElemento(codigoProd);
        producto.stockTotal += cantUnidades;
        producto.pc.apilar(nroCaja, cantUnidades);
        this.capacidadOcupada +=1;
        
       System.out.println("1- prod.stockTotal: "+ producto.stockTotal);
        if(producto.pc.cima() != null){
         System.out.println("1- prod.apilar: "+ producto.pc.cima().getCantUnidades());
        }
        System.out.println("1- prod.capacidadOcupada: "+ this.capacidadOcupada);
        
        //ver si hay ordenes en espera para ese producto y generar envio
        nodoEnvio ordenEspera = producto.ce.fondo();
        nodoCaja caja = producto.pc.cima();
        manejoOrdenREC(ordenEspera,caja);
        
        System.out.println("2- prod.stockTotal: "+ producto.stockTotal);
        if(producto.pc.cima() != null){
         System.out.println("2- prod.apilar: "+ producto.pc.cima().getCantUnidades()); 
        }
        System.out.println("2- prod.capacidadOcupada: "+ this.capacidadOcupada);
        
        ret.resultado = Retorno.Resultado.OK;  
        ret.valorString = "Caja despachada correctamente";
        
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
            ret.valorString = "Error no existe camión con esa matricula.";
            return ret;
        }
        if (!lc.buscarelemento(rutCliente)) {
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "Error no existe cliente con ese rut.";
            return ret;
        }
        if (!lp.buscarelemento(codProducto)) {
            ret.resultado = Retorno.Resultado.ERROR_3;  
            ret.valorString = "Error no existe producto con ese codigo.";
            return ret;
        }
         
        //Agregar envio de forma parcial o completa
        //buscar camion
        nodoCamion camion = lcam.obtenerElemento(matriculaCam);
        //buscar cliente
        nodoCliente cliente = lc.obtenerElemento(rutCliente);
        //buscar prod
        nodoProducto producto = lp.obtenerElemento(codProducto);
        
        
        System.out.println("1- prod.stockTotal: "+ producto.stockTotal); 
        if(producto.pc.cima() != null){
         System.out.println("1- prod.apilar: "+ producto.pc.cima().getCantUnidades());
        }
        System.out.println("1- prod.capacidadOcupada: "+ this.capacidadOcupada);
        
        //buscar cantidad en ultima caja
        nodoCaja caja = producto.pc.cima();
        manejoCajasREC(caja, cant, camion, cliente, producto,false);

        System.out.println("2- prod.stockTotal: "+ producto.stockTotal);
        if(producto.pc.cima() != null){
         System.out.println("2- prod.apilar: "+ producto.pc.cima().getCantUnidades());
        }
        System.out.println("2- prod.capacidadOcupada: "+ this.capacidadOcupada);
       
        ret.resultado = Retorno.Resultado.OK;  
        ret.valorString = "Retiro realizado correctamente.";

        return ret;
    }
    
    //caja puede ser nulla
    public void manejoCajasREC(nodoCaja caja,int cant, nodoCamion camion, nodoCliente cliente, nodoProducto producto, boolean llamadaOE){
        
        //si no hay stock o la caja es nula directamente se crea una orden de retiro en espera
        if(producto.stockTotal == 0 || caja == null){
            if(!llamadaOE){
             producto.ce.encolar(camion, cliente, producto, cant);
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
             //le.agregarFinal(camion, cliente, producto, cant);
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
        lcam.mostrarREC();
        return ret;
    }

    @Override
    public Retorno listarClientesOrdenado() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.resultado = Retorno.Resultado.OK;
        lc.mostrar();
        
        return ret;
    }

    @Override
    public Retorno listarProductos() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.resultado = Retorno.Resultado.OK;
        lp.mostrar();
        return ret;
    }

    @Override
    public Retorno ultimoProductoRegistrado() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        nodoProducto prod = lp.getUltimo();
        System.out.println("cod: "+prod.codigoProd+" nombre: "+prod.nombre + " descripcion: "+prod.descripcion);
        return ret;
    }
    @Override
    public Retorno listarEnvíosDeProducto(int codProd) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (lp.buscarelemento(codProd) == false)
        {
             ret.resultado = Retorno.Resultado.ERROR_1;
             ret.valorString = "No existe codigo Producto";
             return ret;
        }
        nodoEnvio aux = le.getPrimero();
        le.obtenerElementoByCodigoProd(codProd, aux);
        le.mostrar();
        ret.resultado = Retorno.Resultado.OK;  
        ret.valorString = "Envios";
        
        
        return ret;
    }

    @Override
    public Retorno listarOrdenesPendientes(int codProd) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        nodoProducto a = lp.obtenerElemento(codProd);
        if (a !=null){
            a.ce.mostrar();
        }
        return ret;
    }

    @Override
    public Retorno reporteDeEnviosDeProductos() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        return ret;
    }

}
