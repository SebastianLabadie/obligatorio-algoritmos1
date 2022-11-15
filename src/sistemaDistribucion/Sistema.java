package sistemaDistribucion;

public class Sistema {

    public static void main(String[] args) {
        // TODO code application logic here
        Obligatorio s = new Obligatorio();
        Prueba p = new Prueba();
        juegodepruba(s, p);

    }

    public static void juegodepruba(Obligatorio s, Prueba p) {
        pruebasCreacionSistema_1(s, p);
        pruebasRegistroClientes(s, p);
        pruebasRegistroCamion(s, p);
        pruebasRegistroProducto(s, p);
        pruebasAltaSotck(s,p);
        pruebasRetiroDeProducto(s,  p);
        pruebasDeBaja(s,  p);
        pruebasDeReporteDeEnviosXProducto(s, p);

        p.imprimirResultadosPrueba();
    }

    public static void pruebasCreacionSistema_1(Obligatorio s, Prueba p) {

        p.ver(s.crearSistemaDeDistribucion(5).resultado, Retorno.Resultado.OK, "Se crea el sistema con capacidad 5");
        p.ver(s.crearSistemaDeDistribucion(-1).resultado, Retorno.Resultado.ERROR_1, "No se crea el sistema, capacidad <=0");
        p.ver(s.crearSistemaDeDistribucion(10).resultado, Retorno.Resultado.OK, "Se crea el sistema con capacidad 12");
    }

    public static void pruebasRegistroClientes(Obligatorio s, Prueba p) {
        p.ver(s.agregarCliente("Micaela PÃ©rez", "111", 99368826, "Lorenzo MartÃ­nez 123").resultado, Retorno.Resultado.OK, "Se registra el cliente: Micaela PÃ©rez");
        p.ver(s.agregarCliente("Romina Ã�lvarez", "222", 98999111, "Carlos Quijano 222").resultado, Retorno.Resultado.OK, "Se registra el cliente: Romina Ã�lvarez");
        p.ver(s.agregarCliente("Felipe MuÃ±oz", "333", 97333333, "Luis Franzini 333").resultado, Retorno.Resultado.OK, "Se registra el cliente: Felipe MuÃ±oz");
        p.ver(s.agregarCliente("Pedro GonzÃ¡lez", "111", 94222222, "Mercedes 888").resultado, Retorno.Resultado.ERROR_1, "Ya existe un cliente con rut 111");
        p.ver(s.agregarCliente("Pedro GonzÃ¡lez", "444", 94222222, "Mercedes 888").resultado, Retorno.Resultado.OK, "Se registra el cliente: Pedro GonzÃ¡lez");
        p.ver(s.agregarCliente("Ignacio Alcorta", "888", 91333123, "Uruguay 123").resultado, Retorno.Resultado.OK, "Se registra el cliente: Ignacio Alcorta");
        p.ver(s.agregarCliente("Nicole BaÃ±ales", "222", 92323111, "Carlos Berg 934").resultado, Retorno.Resultado.ERROR_1, "Ya existe un cliente con rut 222");

        p.ver(s.listarClientesOrdenado().resultado, Retorno.Resultado.OK, "Se listan 5 clientes");
        /*
        *********** Ejemplo de reporte de clientes listados ordenados alfabeticamente ****************
        Felipe MuÃ±oz - 333
        Ignacio Alcorta - 888
        Micaela PÃ©rez - 111
        Perdro GonzÃ¡lez - 444  
        Romina Ã�lvarez - 222
         */
    }

    public static void pruebasRegistroCamion(Obligatorio s, Prueba p) {
        p.ver(s.agregarCamion("MEC4452", 2000).resultado, Retorno.Resultado.OK, "Se registra el camiÃ³n de matrÃ­cula MEC4452");
        p.ver(s.agregarCamion("OOO1111", 4000).resultado, Retorno.Resultado.OK, "Se registra el camiÃ³n de matrÃ­cula OOO1111");
        p.ver(s.agregarCamion("WEC3234", 3000).resultado, Retorno.Resultado.OK, "Se registra el camiÃ³n de matrÃ­cula WEC3234");
        p.ver(s.agregarCamion("MEC4452", 1000).resultado, Retorno.Resultado.ERROR_1, "No se registra. Ya existe un camiÃ³n de matrÃ­cula MEC4452");
        p.ver(s.agregarCamion("TTT4500", 1000).resultado, Retorno.Resultado.OK, "Se registra el camiÃ³n de matrÃ­cula TTT4500");
        p.ver(s.agregarCamion("IOE2893", 0).resultado, Retorno.Resultado.ERROR_2, "No se registra. La carga del camion es <= 0");
        p.ver(s.agregarCamion("COC3100", 3000).resultado, Retorno.Resultado.OK, "Se registra el camiÃ³n de matrÃ­cula COC3100");

        p.ver(s.listarCamiones().resultado, Retorno.Resultado.OK, "Se listan 5 camiones");
        /*
        *********** Ejemplo de reporte de camiones listados ****************
        MEC4452 - 2000
        OOO1111 - 4000
        WEC3234 - 3000
        TTT4500 - 1000 
        COC3100 - 3000
         */
    }

    public static void pruebasRegistroProducto(Obligatorio s, Prueba p) {
        p.ver(s.registrarProducto("Shampoo Lor", "Shampoo de 1l").resultado, Retorno.Resultado.OK, "Se registra el producto Shampoo Lor");
        p.ver(s.registrarProducto("Candado St", "Candados de acero").resultado, Retorno.Resultado.OK, "Se registra el producto Candado St");
        p.ver(s.registrarProducto("Bicicleta Ronda", "Bicicleta rodado 20").resultado, Retorno.Resultado.OK, "Se registra el producto Bicicleta Ronda");
        p.ver(s.registrarProducto("TelevisiÃ³n Marc", "TelevisiÃ³n de 32 pulgadas").resultado, Retorno.Resultado.OK, "Se registra el producto TelevisiÃ³n Marc");
        p.ver(s.registrarProducto("Monopatin", "Monopatn para niÃ±os").resultado, Retorno.Resultado.OK, "Se registra el producto Monopatin");

        p.ver(s.registrarProducto("Candado St", "Candados de hierro").resultado, Retorno.Resultado.ERROR_1, "No se registra. Ya existe un producto de nombre Candado St");
        p.ver(s.registrarProducto("Laptop Stu", "").resultado, Retorno.Resultado.ERROR_2, "No se registra. La descripciÃ³n esta vacÃ­a");
        p.ver(s.registrarProducto("Laptop Stu", "Laptop de 17 pulgadas").resultado, Retorno.Resultado.OK, "Se registra el producto Laptop Stu");
        p.ver(s.registrarProducto("Barra de ejercicio", "Barra de ejercicio de hierro").resultado, Retorno.Resultado.OK, "Se registra el producto Barra de ejercicio");

        p.ver(s.listarProductos().resultado, Retorno.Resultado.OK, "Se listan 7 productos");
        /*
        *********** Ejemplo de reporte de productos listados con su stock ****************
        Cod. Prod: 1 - Shampoo Lor - 0 unidades
        Cod. Prod: 2 - Candado St - 0 unidades
        Cod. Prod: 3 - Bicicleta Ronda - 0 unidades
        Cod. Prod: 4 - TelevisiÃ³n Marc - 0 unidades
        Cod. Prod: 5 - Monopatin - 0 unidades
        Cod. Prod: 6 - Laptop Stu - 0 unidades
        Cod. Prod: 7 - Barra de ejercicio - 0 unidades
         */
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
        Cod. Prod: 2      0        0       0      3
        Cod. Prod: 3      0        0       1      0
        Cod. Prod: 4      0        0       0      0
        Cod. Prod: 5      0        0       0      0
        Cod. Prod: 6      1        0       0      0
        Cod. Prod: 7      0        0       0      0
         */
    }

}
