
import java.util.Iterator;

public class LinkedList<E> implements Lista<E> {

    private class Nodo<E> {

        private Nodo<E> siguiente = null;

        private E info = null;

        Nodo(Nodo<E> siguiente, E info) {
            this.siguiente = siguiente;
            this.info = info;
        }

        Nodo<E> getSiguiente() {
            return siguiente;
        }

        void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        E getInfo() {
            return info;
        }

        void setInfo(E info) {
            this.info = info;
        }
    }

    private Nodo<E> primero = null;
    private Nodo<E> ultimo = null;
    private int tamanio = 0;

    private Nodo<E> nodoEnPosicion(int posicion) {
        Nodo<E> aux = primero;
        for (int i = 0; i < posicion; i++) {
            aux = aux.getSiguiente();
        }
        return aux;
    }

    @Override
    public void agregarElemento(E e) {

        Nodo<E> aux = new Nodo<E>(null, e);
        if (esVacia()) {
            agregarInicio(e);
        } else {
            ultimo.setSiguiente(aux);
            ultimo = aux;
            tamanio++;
        }

    }

    @Override
    public void agregarInicio(E e) {
        Nodo<E> aux = new Nodo<E>(null, e);
        if (esVacia()) {
            primero = aux;
            ultimo = aux;
        } else {
            aux.setSiguiente(primero);
            primero = aux;
        }
        tamanio++;

    }

    @Override
    public void agregarFinal(E e) {
        Nodo<E> nuevo = new Nodo<E>(null, e);
        if (esVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        tamanio++;
    }

    @Override
    public void agregarPosicion(E e, int posicion) {

        if (posicion >= 0 && posicion <= tamanio) {
            if (posicion == 0) {
                agregarInicio(e);
            } else {
                if (posicion == tamanio) {
                    agregarFinal(e);
                } else {
                    Nodo<E> iterador = primero;
                    Nodo<E> aux = new Nodo<E>(null, e);

                    for (int i = 0; i < (posicion - 1); i++) {
                        iterador = iterador.getSiguiente();
                    }
                    aux.setSiguiente(iterador.getSiguiente());
                    iterador.setSiguiente(aux);
                    tamanio++;
                }
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E eliminarElemento() {

        return eliminarElementoFinal();

    }

    @Override
    public E eliminarElementoInicio() {

        E auxI = null;
        Nodo<E> auxN = null;
        if (!esVacia()) {
            if (primero == ultimo) {

                auxI = primero.getInfo();
                primero.setInfo(null);
                primero = ultimo = null;
            } else {
                auxI = primero.getInfo();
                auxN = primero;
                primero = primero.getSiguiente();
                auxN.setInfo(null);
                auxN.setSiguiente(null);
            }
            tamanio--;
            return auxI;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public E eliminarElementoFinal() {
        Nodo<E> auxN = null;
        E auxI = null;
        if (!esVacia()) {

            if (primero == ultimo) {

                return eliminarElementoInicio();
            } else {

                for (auxN = primero; auxN.getSiguiente().getSiguiente() != null; auxN = auxN.getSiguiente()) {
                }
                auxI = ultimo.getInfo();
                ultimo.setInfo(null);
                auxN.setSiguiente(null);
                ultimo = auxN;
                tamanio--;
                return auxI;
            }
        } else {

            throw new NullPointerException();
        }
    }

    @Override
    public E eliminarElementoPosicion(int posicion) {
        if (esVacia()) {
            throw new NullPointerException();
        }
        if (posicion < 0 || posicion >= tamanio) {
            throw new IndexOutOfBoundsException();
        }
        if (posicion == 0) {
            return eliminarElementoInicio();
        }
        if (posicion == tamanio - 1) {
            return eliminarElementoFinal();
        }
        Nodo<E> anterior = nodoEnPosicion(posicion - 1);
        Nodo<E> actual = anterior.getSiguiente();
        E elemento = actual.getInfo();
        anterior.setSiguiente(actual.getSiguiente());
        actual.setInfo(null);
        actual.setSiguiente(null);
        tamanio--;
        return elemento;
    }

    @Override
    public boolean esVacia() {
        return tamanio == 0;
    }

    @Override
    public int numElementos() {
        // TODO Auto-generated method stub
        return tamanio;
    }

    @Override
    public void limpiarLista() {
        Nodo<E> aux = primero;
        while (aux != null) {
            Nodo<E> siguiente = aux.getSiguiente();
            aux.setInfo(null);
            aux.setSiguiente(null);
            aux = siguiente;
        }
        primero = null;
        ultimo = null;
        tamanio = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] convertirArreglo() {

        Object[] arreglo = new Object[tamanio];
        Nodo<E> aux = primero;
        for (int i = 0; aux != null; i++) {
            arreglo[i] = aux.getInfo();
            aux = aux.getSiguiente();
        }

        return (E[]) arreglo;
    }

    @Override

    public E consultar(int posicion) {

        if (esVacia()) {

            throw new NullPointerException();

        }

        if (posicion < 0 || posicion >= tamanio) {

            throw new IndexOutOfBoundsException();

        }

        return nodoEnPosicion(posicion).getInfo();

    }

    @Override

    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Nodo<E> nodo = primero;

            @Override
            public boolean hasNext() {
                return nodo != null;
            }

            @Override
            public E next() {
                E tmp = nodo.getInfo();
                nodo = nodo.getSiguiente();
                return tmp;
            }

        };
    }

}
