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
        
        
        r = s.crearSistemaDeDistribucion(9);
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
        
        //este
        r = s.agregarCamion("IOE2893", 0);
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
        Retorno r = s.altaDeStockDeProducto("MEC4452", 1, 50, 1000);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        System.out.println("sistemaDistribucion.Sistema.pruebasAltaSotck()");
        
        r = s.altaDeStockDeProducto("MEC4452", 8, 70, 1000);
        p.ver(r.resultado, Retorno.Resultado.ERROR_2, r.valorString);
       

        r = s.altaDeStockDeProducto("MEC4452", 3, 2, 20);
        p.ver(r.resultado, Retorno.Resultado.OK,r.valorString);
        
        r = s.altaDeStockDeProducto("OOO1111", 6, 17, 50);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);

        r=s.altaDeStockDeProducto("XCX5622", 1, 11, 50);
        p.ver(r.resultado, Retorno.Resultado.ERROR_1,r.valorString);
        
        r=s.altaDeStockDeProducto("WEC3234", 2, 13, 1500);
        p.ver(r.resultado, Retorno.Resultado.OK,r.valorString);
         
        r = s.altaDeStockDeProducto("WEC3234", 2, 14, 500);
        p.ver(r.resultado, Retorno.Resultado.OK,r.valorString);
        
        r =s.altaDeStockDeProducto("WEC3234", 2, 19, 0);
        p.ver(r.resultado, Retorno.Resultado.ERROR_3,r.valorString);
        
        r=s.altaDeStockDeProducto("TTT4500", 5, 99, 30);
        p.ver(r.resultado, Retorno.Resultado.OK,r.valorString);
        
         
        r=s.altaDeStockDeProducto("WEC3234", 2, 50, 90);
        p.ver(r.resultado, Retorno.Resultado.ERROR_4,r.valorString);
        
        r=s.altaDeStockDeProducto("TTT4500", 4, 108, 10);
        p.ver(r.resultado, Retorno.Resultado.OK,r.valorString);
        
        r=s.altaDeStockDeProducto("TTT4500", 4, 109, 10);
        p.ver(r.resultado, Retorno.Resultado.OK,r.valorString);
        
        r= s.altaDeStockDeProducto("TTT4500", 4, 110, 10);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.altaDeStockDeProducto("TTT4500", 4, 111, 10);
        p.ver(r.resultado, Retorno.Resultado.ERROR_5, r.valorString);

        r=s.listarProductos();
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);

       
    }

    public static void pruebasRetiroDeProducto(Obligatorio s, Prueba p) {
        Retorno r = s.retiroDeProducto("MEC4452", "111", 1, 2200);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.retiroDeProducto("MEC4452", "111", 1, 600);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        System.out.println("sistemaDistribucion.Sistema.pruebasRetiroDeProducto()");

        r=s.retiroDeProducto("OOO1111", "222", 2, 2000);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.retiroDeProducto("OOO1111", "222", 2, 1000);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);

        r=s.retiroDeProducto("MEC4452", "333", 6, 40);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);

        r=s.retiroDeProducto("VND2344", "333", 6, 40);
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        
        r=s.retiroDeProducto("MEC4452", "190", 6, 40);
        p.ver(r.resultado, Retorno.Resultado.ERROR_2,r.valorString);
        
        r=s.retiroDeProducto("MEC4452", "333", 10, 40);
        p.ver(r.resultado, Retorno.Resultado.ERROR_3,r.valorString);

        r=s.retiroDeProducto("TTT4500", "444", 7, 1000);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.retiroDeProducto("TTT4500", "444", 3, 30);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.retiroDeProducto("TTT4500", "444", 3, 30);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.listarProductos();
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);

       
        r=s.listarOrdenesPendientes(1);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.listarOrdenesPendientes(2);
        p.ver(r.resultado, Retorno.Resultado.OK,r.valorString);
        
        r=s.listarOrdenesPendientes(3);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
       
        r=s.listarOrdenesPendientes(4);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.listarOrdenesPendientes(5);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.listarOrdenesPendientes(6);
        p.ver(r.resultado, Retorno.Resultado.OK,r.valorString);
        
        r=s.listarOrdenesPendientes(7);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.listarOrdenesPendientes(11);
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        
        r=s.ultimoProductoRegistrado();
        p.ver(r.resultado, Retorno.Resultado.OK,r.valorString);

        r=s.altaDeStockDeProducto("MEC4452", 2, 194, 2000);
        p.ver(r.resultado, Retorno.Resultado.OK,r.valorString);
        
        r=s.listarOrdenesPendientes(2);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.listarProductos();
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);

       
    }

    public static void pruebasDeBaja(Obligatorio s, Prueba p) {
        
        Retorno r = s.retiroDeProducto("MEC4452", "111", 1, 2200);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.eliminarCamion("COC3100");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        
        r=s.eliminarCamion("TUT3100");
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        
        r=s.eliminarCamion("MEC4452");
        p.ver(r.resultado, Retorno.Resultado.ERROR_2, r.valorString);
        
        r=s.eliminarCamion("OOO1111");
        p.ver(r.resultado, Retorno.Resultado.ERROR_2,r.valorString);
        
        r=s.listarCamiones();
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
       
        

        r=s.eliminarCliente("888");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);

        r=s.eliminarCliente("123");
        p.ver(r.resultado, Retorno.Resultado.ERROR_1,r.valorString);
        
        r=s.eliminarCliente("111");
        p.ver(r.resultado, Retorno.Resultado.ERROR_2,r.valorString);
        
        r=s.listarClientesOrdenado();
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
       
        
    }

    public static void pruebasDeReporteDeEnviosXProducto(Obligatorio s, Prueba p) {
        Retorno r =s.reporteDeEnviosDeProductos();
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);

       
    }

}
