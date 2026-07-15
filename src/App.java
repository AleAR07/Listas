
public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("============PRUABS DE ARRAYLIST===========");
        ArrayList<String> lista = new ArrayList<>();
        // vacia y numero de elementos
        System.out.println("la lista esta vacia al iniciar " + lista.esVacia());
        System.out.println("numero de elementos al iniciar " + lista.numElementos());
        System.out.println("==============================================");
        //agregando 
        lista.agregarElemento("fisica");
        lista.agregarFinal("matematicas");
        lista.agregarInicio("calculo");
        lista.agregarPosicion("estructura", 2);
        System.out.println("==============ESTADO DE LA LISTA=============");
        System.out.println("esta vacia la lista " + lista.esVacia());
        System.out.println("numero de elementos en la lista " + lista.numElementos());
        //consultar posicion
        System.out.println("=====PROBANDO CONSULTAS=======");
        System.out.println("posicion 2 " + lista.consultar(2));
        System.out.println("posicion 1 " + lista.consultar(1));
        System.out.println("==========PROBANDO ELIMINACIONES ================");
        String eliminadaInicio = lista.eliminarElementoInicio();
        System.out.println("eliminar inicio " + eliminadaInicio);
        String eliminadaFinal = lista.eliminarElementoFinal();
        System.out.println("eliminar al final " + eliminadaFinal);
        String eliminadaPosicion = lista.eliminarElementoPosicion(0);
        System.out.println("eliminar posicion 0 " + eliminadaPosicion);
        System.out.println("==============ESTADO DE LA LISTA=============");
        System.out.println("esta vacia la lista " + lista.esVacia());
        System.out.println("numero de elementos en la lista " + lista.numElementos());
        //convertir arreglo 
        System.out.println("========CONVERSION A ARREGLO ===========");
        Object[] arreglo = lista.convertirArreglo();
        System.out.println("tamaño del arreglo " + arreglo.length);
        System.out.println("imprimir arreglo");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
        //limpiando lista
        System.out.println("===LIMPIAR LISTA===");
        lista.limpiarLista();
        System.out.println("esta vacia " + lista.esVacia());
        System.out.println("numero de elementos " + lista.numElementos());
        System.out.println("========SE ACABO CHAVALES ===========");
        System.out.println("Y SI SI?");
        //linked 

    }
}
