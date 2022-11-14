package sistemaDistribucion;


public class Sistema {

    public static void main(String[] args) {
        // TODO code application logic here
        Obligatorio o = new Obligatorio();
        Prueba p = new Prueba();
    
        juegodeprueba(o, p);
    }
    public static void juegodeprueba(Obligatorio o,Prueba p){
       
       //SISTEMA 
       Retorno r = o.crearSistemaDeDistribucion(0);
       p.ver(r.resultado, Retorno.Resultado.ERROR_1, "crearSistemaDeDistribucion(0) " + r.valorString);
     
       r = o.crearSistemaDeDistribucion(2);
       p.ver(r.resultado, Retorno.Resultado.OK, "crearSistemaDeDistribucion(10) " + r.valorString);
       
       
       
       //CLIENTES
       
       r = o.agregarCliente("PEPE","123",999,"dir1");
       p.ver(r.resultado, Retorno.Resultado.OK, "(o.agregarCliente(\"PEPE\",\"123\",999,\"dir1\") " + r.valorString);
       
       r = o.agregarCliente("PEPE","123",999,"dir1");
       p.ver(r.resultado, Retorno.Resultado.ERROR_1, "(o.agregarCliente(\"PEPE\",\"123\",999,\"dir1\") " + r.valorString);
       
       r = o.agregarCliente("PEPE","123",999,"dir1");
       p.ver(r.resultado, Retorno.Resultado.ERROR_1, "(o.agregarCliente(\"PEPE\",\"123\",999,\"dir1\") " + r.valorString);
         
       r = o.eliminarCliente("321");
       p.ver(r.resultado, Retorno.Resultado.ERROR_1, "o.eliminarCliente(\"321\") " + r.valorString);
       
       r = o.eliminarCliente("123");
       p.ver(r.resultado, Retorno.Resultado.OK, "o.eliminarCliente(\"123\") " + r.valorString);
       
       o.listarClientesOrdenado();
       
       o.agregarCliente("Analia","123",999,"dir1");
       o.agregarCliente("Pepe","321",999,"dir1");
       o.agregarCliente("Alberto","111",999,"dir1");
       o.agregarCliente("Juan","322",999,"dir1");
       o.agregarCliente("Damian","553",999,"dir1");
       
       o.listarClientesOrdenado();

       
       //PRODUCTOS
       o.listarProductos();
       r = o.registrarProducto("prod1","des1");
       p.ver(r.resultado, Retorno.Resultado.OK, "o.registrarProducto(\"prod1\",\"des1\"); " + r.valorString);
       
       r = o.registrarProducto("prod2","");
       p.ver(r.resultado, Retorno.Resultado.ERROR_3, "o.registrarProducto(\"prod1\",\"\"); " + r.valorString);
       
       r = o.registrarProducto("prod1","des1");
       p.ver(r.resultado, Retorno.Resultado.ERROR_2, "o.registrarProducto(\"prod1\",\"des1\"); " + r.valorString);
       o.listarProductos();
       
       r = o.registrarProducto("prod2","des2");
       p.ver(r.resultado, Retorno.Resultado.OK, "o.registrarProducto(\"prod2\",\"des2\"); " + r.valorString);
       
       o.ultimoProductoRegistrado();
         
//       String a="abc";
//       String b="abd";
//       System.out.println("test "+a.compareTo(b));
//     
       
       
       //CAMIONES
       r = o.agregarCamion("1234",10);
       p.ver(r.resultado, Retorno.Resultado.OK, "o.agregarCamion(\"1234\",10); " + r.valorString);
       
       r = o.agregarCamion("1234",10);
       p.ver(r.resultado, Retorno.Resultado.ERROR_1, "o.agregarCamion(\"1234\",10); " + r.valorString);
       
       r = o.agregarCamion("12345",0);
       p.ver(r.resultado, Retorno.Resultado.ERROR_2, "o.agregarCamion(\"12345\",0); " + r.valorString);
       
       
       //STOCK
       r = o.altaDeStockDeProducto("9999",1,1,10);
       p.ver(r.resultado, Retorno.Resultado.ERROR_1, "o.altaDeStockDeProducto(\"9999\",1,1,10); " + r.valorString);
       
       r = o.altaDeStockDeProducto("1234",9999,1,10);
       p.ver(r.resultado, Retorno.Resultado.ERROR_2, "o.altaDeStockDeProducto(\"1234\",9999,1,10); " + r.valorString);
       
       r = o.altaDeStockDeProducto("1234",1,1,0);
       p.ver(r.resultado, Retorno.Resultado.ERROR_3, "o.altaDeStockDeProducto(\"1234\",1,1,0); " + r.valorString);
       
       r = o.altaDeStockDeProducto("1234",1,1,10);
       p.ver(r.resultado, Retorno.Resultado.OK, "o.altaDeStockDeProducto(\"1234\",1,1,10); " + r.valorString);
       
       r = o.altaDeStockDeProducto("1234",1,1,10);
       p.ver(r.resultado, Retorno.Resultado.ERROR_4, "o.altaDeStockDeProducto(\"1234\",1,1,0); " + r.valorString);
       
       r = o.altaDeStockDeProducto("1234",1,2,5);
       p.ver(r.resultado, Retorno.Resultado.OK, "o.altaDeStockDeProducto(\"1234\",1,2,5); " + r.valorString);
       
       r = o.altaDeStockDeProducto("1234",1,3,10);
       p.ver(r.resultado, Retorno.Resultado.ERROR_5, "o.altaDeStockDeProducto(\"1234\",1,3,10); " + r.valorString);   
       
       
     
       
       //RETIRO
       r = o.retiroDeProducto("9999","123",1, 6);
       p.ver(r.resultado, Retorno.Resultado.ERROR_1, "o.retiroDeProducto(\"9999\",\"123\",1, 6); " + r.valorString); 
       
       r = o.retiroDeProducto("1234","9999",1, 6);
       p.ver(r.resultado, Retorno.Resultado.ERROR_2, "o.retiroDeProducto(\"1234\",\"9999\",1, 6); " + r.valorString);
       
       r = o.retiroDeProducto("1234","123",9999, 6);
       p.ver(r.resultado, Retorno.Resultado.ERROR_3, "o.retiroDeProducto(\"1234\",\"123\",9999, 6); " + r.valorString);
       
       r = o.retiroDeProducto("1234","123",1, 6);
       p.ver(r.resultado, Retorno.Resultado.OK, "o.retiroDeProducto(\"1234\",\"123\",9999, 6); " + r.valorString);
       
       
       System.out.println("sistemaDistribucion.Sistema.juegodeprueba()");
       r = o.retiroDeProducto("1234","123",1, 12);
       p.ver(r.resultado, Retorno.Resultado.OK, "o.retiroDeProducto(\"1234\",\"123\",9999, 12); " + r.valorString);
       
       
       r = o.altaDeStockDeProducto("1234",1,1,10);
       p.ver(r.resultado, Retorno.Resultado.OK, "o.altaDeStockDeProducto(\"1234\",1,1,10); " + r.valorString); 
       
       r = o.retiroDeProducto("1234","123",1, 7);
       p.ver(r.resultado, Retorno.Resultado.OK, "o.retiroDeProducto(\"1234\",\"123\",1, 7); " + r.valorString);
       
       r = o.retiroDeProducto("1234","123",1, 5);
       p.ver(r.resultado, Retorno.Resultado.OK, "o.retiroDeProducto(\"1234\",\"123\",1, 5); " + r.valorString);
       
       r = o.retiroDeProducto("1234","123",1, 5);
       p.ver(r.resultado, Retorno.Resultado.OK, "o.retiroDeProducto(\"1234\",\"123\",1, 5); " + r.valorString);
       
       r = o.altaDeStockDeProducto("1234",1,1,3);
       p.ver(r.resultado, Retorno.Resultado.OK, "o.altaDeStockDeProducto(\"1234\",1,1,3); " + r.valorString); 
       
       
       r = o.altaDeStockDeProducto("1234",1,1,8);
       p.ver(r.resultado, Retorno.Resultado.OK, "o.altaDeStockDeProducto(\"1234\",1,1,8); " + r.valorString); 
    }
    
}
