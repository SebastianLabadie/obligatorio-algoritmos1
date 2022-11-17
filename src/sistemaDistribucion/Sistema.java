package sistemaDistribucion;

public class Sistema {

    public static void main(String[] args) {
        // TODO code application logic here
        Obligatorio s = new Obligatorio();
        Prueba p = new Prueba();
        juegodepruba(s, p);

    }

    public static void juegodepruba(Obligatorio s, Prueba p) {
        pruebasCreacionSistema(s, p);
        pruebasRegistroClientes(s, p);
        pruebasRegistroCamion(s, p);
        pruebasRegistroProducto(s, p);
        pruebasAltaSotck(s,p);
        pruebasRetiroDeProducto(s,  p);
        pruebasDeBaja(s,  p);
        pruebasDeReporteDeEnviosXProducto(s, p);

        p.imprimirResultadosPrueba();
    }

    public static void pruebasCreacionSistema(Obligatorio s, Prueba p) {

        Retorno r = s.crearSistemaDeDistribucion(5);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r = s.crearSistemaDeDistribucion(-1);
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        
        
        r = s.crearSistemaDeDistribucion(10);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
    }

    public static void pruebasRegistroClientes(Obligatorio s, Prueba p) {
        Retorno r = s.agregarCliente("Sebastian Labadie", "111", 91843200, "Palmar 441");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r = s.agregarCliente("Oliva Cruz", "222", 92199411, "Chana 224");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r = s.agregarCliente("Gregorio Osuna", "333", 92349461, "Maldonado 224");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r = s.agregarCliente("Gregorio Osuna", "111", 92349461, "Guri 224");
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        
        r = s.agregarCliente("Maria Esperanza Chaparro", "444", 92199411, "Gaboto 224");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r = s.agregarCliente("Simon Saez", "888", 92199411, "La Paz 224");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r = s.agregarCliente("Dina Murillo", "222", 92199411, "Cabildo 224");
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
      
        r = s.listarClientesOrdenado();
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
       
    }

    public static void pruebasRegistroCamion(Obligatorio s, Prueba p) {
        Retorno r=s.agregarCamion("MEC4452", 2000);
        p.ver(r.resultado, Retorno.Resultado.OK,r.valorString);
        
        r = s.agregarCamion("OOO1111", 4000);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        
        r = s.agregarCamion("WEC3234", 1000);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r = s.agregarCamion("MEC4452", 2500);
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        
        r = s.agregarCamion("TTT4500", 3000);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r = s.agregarCamion("IOE2893", 1200);
        p.ver(r.resultado, Retorno.Resultado.ERROR_2, r.valorString);
        
        r = s.agregarCamion("COC3100", 100);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.listarCamiones();
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
       
    }

    public static void pruebasRegistroProducto(Obligatorio s, Prueba p) {
        Retorno r=s.registrarProducto("IPhone 14", "IPhone 14 64 GB,negro");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.registrarProducto("Garmin Venu", "Reloj inteligente GPS");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        
        
        r=s.registrarProducto("Nike Pegasus 38", "Calzado deportivo");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.registrarProducto("Ray-Ban rb4324", "Lentes de cristal no polarizados con proteccion UV");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.registrarProducto("Apple AirPods", "Configuración sin esfuerzo, detección en el oído y cambio automático para una experiencia mágica. Comparte audio fácilmente entre dos juegos de AirPods en tu iPhone, iPad, iPod touch o Apple TV");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.registrarProducto("Apple AirPods", "dddd");
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        
        r=s.registrarProducto("Termo Stanley", "");
        p.ver(r.resultado, Retorno.Resultado.ERROR_2, r.valorString);
        
        r=s.registrarProducto("Aostirmotor Electric MTB", "Adaptarse a una variedad de terrenos. Nuestras bicicletas eléctricas de montaña para adultos están equipadas con neumáticos gruesos de 26*4 pulgadas, que pueden ayudar a una conducción suave. La buena adaptabilidad le permite disfrutar montando en playas de arena y terrenos nevados.");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.registrarProducto("2020 Apple MacBook Pro", "Laptop");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r = s.listarProductos();
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
       
    }

    public static void pruebasAltaSotck(Obligatorio s, Prueba p) {
        p.ver(s.altaDeStockDeProducto("MEC4452", 1, 50, 1000).resultado, Retorno.Resultado.OK, "Se agregan 1000 unidades de stock al producto Shampoo Lor");
        p.ver(s.altaDeStockDeProducto("OOO1111", 1, 60, 2000).resultado, Retorno.Resultado.OK, "Se agregan 2000 unidades de stock al producto Shampoo Lor");

        p.ver(s.altaDeStockDeProducto("MEC4452", 8, 70, 1000).resultado, Retorno.Resultado.ERROR_2, "No se registra. No existe el producto de cÃ³digo 8");
        p.ver(s.altaDeStockDeProducto("MEC4452", 3, 2, 20).resultado, Retorno.Resultado.OK, "Se agregan 20 unidades de stock al producto Bicicleta Ronda");
        p.ver(s.altaDeStockDeProducto("OOO1111", 6, 17, 50).resultado, Retorno.Resultado.OK, "Se agregan 50 unidades de stock al producto Laptop Stu");

        p.ver(s.altaDeStockDeProducto("XCX5622", 1, 11, 50).resultado, Retorno.Resultado.ERROR_1, "No se registra. No existe el camion de matricula XCX5622");
        p.ver(s.altaDeStockDeProducto("WEC3234", 2, 13, 1500).resultado, Retorno.Resultado.OK, "Se agregan 1500 unidades de stock al producto Candado St");
        p.ver(s.altaDeStockDeProducto("WEC3234", 2, 14, 500).resultado, Retorno.Resultado.OK, "Se agregan 500 unidades de stock al producto Candado St");

        p.ver(s.altaDeStockDeProducto("WEC3234", 2, 19, 0).resultado, Retorno.Resultado.ERROR_3, "No se registra. Las unidades no puedes ser <=3");
        p.ver(s.altaDeStockDeProducto("TTT4500", 5, 99, 30).resultado, Retorno.Resultado.OK, "Se agregan 30 unidades de stock al producto Monopatin");

        p.ver(s.altaDeStockDeProducto("WEC3234", 2, 50, 90).resultado, Retorno.Resultado.ERROR_4, "No se registra. El nÃºmero de caja 50 ya existe");
        p.ver(s.altaDeStockDeProducto("TTT4500", 4, 108, 10).resultado, Retorno.Resultado.OK, "Se agregan 10 unidades de stock al producto TelevisiÃ³n Marc");
        p.ver(s.altaDeStockDeProducto("TTT4500", 4, 109, 10).resultado, Retorno.Resultado.OK, "Se agregan 10 unidades de stock al producto TelevisiÃ³n Marc");
        p.ver(s.altaDeStockDeProducto("TTT4500", 4, 110, 10).resultado, Retorno.Resultado.OK, "Se agregan 10 unidades de stock al producto TelevisiÃ³n Marc");

        p.ver(s.altaDeStockDeProducto("TTT4500", 4, 111, 10).resultado, Retorno.Resultado.ERROR_5, "No se registra. La fabrica tiene un tope de 10 cajas");

        p.ver(s.listarProductos().resultado, Retorno.Resultado.OK, "Se listan 7 productos");

        /*
        *********** Ejemplo de reporte de productos listados con su stock ****************
        Cod. Prod: 1 - Shampoo Lor - 3000 unidades
        Cod. Prod: 2 - Candado St - 2000 unidades
        Cod. Prod: 3 - Bicicleta Ronda - 20 unidades
        Cod. Prod: 4 - TelevisiÃ³n Marc - 30 unidades
        Cod. Prod: 5 - Monopatin - 30 unidades
        Cod. Prod: 6 - Laptop Stu - 50 unidades
        Cod. Prod: 7 - Barra de ejercicio - 0 unidades
         */
    }

    public static void pruebasRetiroDeProducto(Obligatorio s, Prueba p) {

        p.ver(s.retiroDeProducto("MEC4452", "111", 1, 2200).resultado, Retorno.Resultado.OK, "Se retiran 2200 unidades del producto Shampoo Lor");
        p.ver(s.retiroDeProducto("MEC4452", "111", 1, 600).resultado, Retorno.Resultado.OK, "Se retiran 600 unidades del producto Shampoo Lor");

        p.ver(s.retiroDeProducto("OOO1111", "222", 2, 2000).resultado, Retorno.Resultado.OK, "Se retiran 2000 unidades del producto Candado St");
        p.ver(s.retiroDeProducto("OOO1111", "222", 2, 1000).resultado, Retorno.Resultado.OK, "Se genera una orden pendiente por 1000 unidades del producto Candado St");

        p.ver(s.retiroDeProducto("MEC4452", "333", 6, 40).resultado, Retorno.Resultado.OK, "Se retiran 40 unidades del producto Laptop Stu");

        p.ver(s.retiroDeProducto("VND2344", "333", 6, 40).resultado, Retorno.Resultado.ERROR_1, "No se realiza el retiro. No existe un camiÃ³n de matrÃ­cula VND2344");
        p.ver(s.retiroDeProducto("MEC4452", "190", 6, 40).resultado, Retorno.Resultado.ERROR_2, "No se realiza el retiro. No existe cliente de rut 190");
        p.ver(s.retiroDeProducto("MEC4452", "333", 10, 40).resultado, Retorno.Resultado.ERROR_3, "No se realiza el retiro. No existe un producto de cÃ³digo 10");

        p.ver(s.retiroDeProducto("TTT4500", "444", 7, 1000).resultado, Retorno.Resultado.OK, "Se genera una orden pendiente por 1000 unidades del producto Barra de ejercicio");
        p.ver(s.retiroDeProducto("TTT4500", "444", 3, 30).resultado, Retorno.Resultado.OK, "Se retiran 20 unidades del producto Bicicleta Ronda. Se genera una orden pendiente por 10 unidades del producto Bicicleta Ronda");
        p.ver(s.retiroDeProducto("TTT4500", "444", 3, 30).resultado, Retorno.Resultado.OK, "Se genera una orden pendiente por 30 unidades del producto Bicicleta Ronda");

        p.ver(s.listarProductos().resultado, Retorno.Resultado.OK, "Se listan 7 productos");

        /*
        *********** Ejemplo de reporte de productos listados con su stock ****************
        Cod. Prod: 1 - Shampoo Lor - 200 unidades
        Cod. Prod: 2 - Candado St - 0 unidades
        Cod. Prod: 3 - Bicicleta Ronda - 0 unidades
        Cod. Prod: 4 - TelevisiÃ³n Marc - 30 unidades
        Cod. Prod: 5 - Monopatin - 30 unidades
        Cod. Prod: 6 - Laptop Stu - 10 unidades
        Cod. Prod: 7 - Barra de ejercicio - 0 unidades
         */
        p.ver(s.listarOrdenesPendientes(1).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 1: No hay");
        p.ver(s.listarOrdenesPendientes(2).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 2: Orden pendiente:1000u");
        p.ver(s.listarOrdenesPendientes(3).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 3: Orden pendiente:10u - Orden pendiente:30u");
        p.ver(s.listarOrdenesPendientes(4).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 4: No hay");
        p.ver(s.listarOrdenesPendientes(5).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 5: No hay");
        p.ver(s.listarOrdenesPendientes(6).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 6: No hay");
        p.ver(s.listarOrdenesPendientes(7).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 7: Orden pendiente:1000u");
        p.ver(s.listarOrdenesPendientes(11).resultado, Retorno.Resultado.ERROR_1, "No existe el producto de cÃ³digo 11");

        p.ver(s.ultimoProductoRegistrado().resultado, Retorno.Resultado.OK, "Producto: Cod. Prod: 7 - Barra de ejercicio - 0 unidades");

        p.ver(s.altaDeStockDeProducto("MEC4452", 2, 194, 2000).resultado, Retorno.Resultado.OK, "Se agregan 2000 unidades de stock al producto Candado St. Se hace retiro pendiente de 1000u ");
        p.ver(s.listarOrdenesPendientes(2).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 2: No hay");
        p.ver(s.listarProductos().resultado, Retorno.Resultado.OK, "Se listan 7 productos");

        /*
        *********** Ejemplo de reporte de productos listados con su stock ****************
        Cod. Prod: 1 - Shampoo Lor - 200 unidades
        Cod. Prod: 2 - Candado St - 1000 unidades
        Cod. Prod: 3 - Bicicleta Ronda - 0 unidades
        Cod. Prod: 4 - TelevisiÃ³n Marc - 30 unidades
        Cod. Prod: 5 - Monopatin - 30 unidades
        Cod. Prod: 6 - Laptop Stu - 10 unidades
        Cod. Prod: 7 - Barra de ejercicio - 0 unidades
         */
    }

    public static void pruebasDeBaja(Obligatorio s, Prueba p) {

        p.ver(s.eliminarCamion("COC3100").resultado, Retorno.Resultado.OK, "Se elimina el camiÃ³n COC3100");

        p.ver(s.eliminarCamion("TUT3100").resultado, Retorno.Resultado.ERROR_1, "No se elimina. No existe camion con matricula TUT3100");
        p.ver(s.eliminarCamion("MEC4452").resultado, Retorno.Resultado.ERROR_2, "No se elimina. El camion MEC4452 tiene enttregas realizadas");
        p.ver(s.eliminarCamion("OOO1111").resultado, Retorno.Resultado.ERROR_2, "No se elimina. El camion OOO1111 tiene enttregas realizadas");

        p.ver(s.listarCamiones().resultado, Retorno.Resultado.OK, "Se listan 4 camiones");
        /*
        *********** Ejemplo de reporte de camiones listados ****************
        MEC4452 - 2000
        OOO1111 - 4000
        WEC3234 - 3000
        TTT4500 - 1000 
         */

        p.ver(s.eliminarCliente("888").resultado, Retorno.Resultado.OK, "Se elimina el cliente 888");

        p.ver(s.eliminarCliente("123").resultado, Retorno.Resultado.ERROR_1, "No se elimina. No existe cliente con rut 123");
        p.ver(s.eliminarCliente("111").resultado, Retorno.Resultado.ERROR_2, "No se elimina. El cliente 111 tiene entregas realizadas");

        p.ver(s.listarClientesOrdenado().resultado, Retorno.Resultado.OK, "Se listan 5 clientes");
        /*
        *********** Ejemplo de reporte de clientes listados ordenados alfabeticamente ****************
        Felipe MuÃ±oz - 333
        Micaela PÃ©rez - 111
        Perdro GonzÃ¡lez - 444  
        Romina Ã�lvarez - 222
         */
    }

    public static void pruebasDeReporteDeEnviosXProducto(Obligatorio s, Prueba p) {

        p.ver(s.reporteDeEnviosDeProductos().resultado, Retorno.Resultado.OK, "Se muestra el reporte de evÃ­os por productos");

        /*
        *********** Ejemplo de reporte de envÃ­os por producto a cliente ****************
        
        
                         333      111     444    222
        Cod. Prod: 1      0        2       0      0
        Cod. Prod: 2      0        0       0      2
        Cod. Prod: 3      0        0       1      0
        Cod. Prod: 4      0        0       0      0
        Cod. Prod: 5      0        0       0      0
        Cod. Prod: 6      1        0       0      0
        Cod. Prod: 7      0        0       0      0
         */
    }

}
