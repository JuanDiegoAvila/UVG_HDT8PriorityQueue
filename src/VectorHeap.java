import java.util.Vector;

/**
 * @author Juan Diego Avila
 * @param <E> tipo de datos que manejará el VectorHeap que es de tipo comparable.
 */

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    protected Vector<E> datos;//Vector que contendra todos los valores de la cola.

    /**
     * @post crea una nueva cola.
     */
    public VectorHeap(){
        datos = new Vector<E>();
    }

    /**
     * @post crea una nueva cola de un vector que no esta ordenado.
     */
    public VectorHeap(Vector<E> v){
        datos = new Vector<E>(v.size());
        for (E e : v) {
            add(e);
        }
    }

    /**
     * @pre 0 <= i < size
     * @param i posicion en la que se encunetra el nodo.
     * @return el padre del nodo que se encuentra en la posicion i.
     */
    protected static int parent(int i)
    {
        return (i-1)/2;
    }

    /**
     * @pre 0 <= i < size
     * @param i posicion en la que se encunetra el nodo.
     * @return índice del hijo izquierdo del nodo que se encuentra en la posicion i.
     */
    protected static int left(int i)
    {
        return 2*i+1;
    }

    /**
     * @pre 0 <= i < size
     * @param i posicion en la que se encunetra el nodo.
     * @return índice del hijo derecho del nodo que se encuentra en la posicion i.
     */
    protected static int right(int i)
    {
        return 2*(i+1);
    }

    /**
     * @pre 0 <= i < size
     * @param leaf indice en el que se encuentra actualmente.
     * @post mueve el nodo en indice leaf a una posicion apropiada.
     */
    protected void percolateUp(int leaf)
    {
        int parent = parent(leaf);
        E value = datos.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(datos.get(parent)) < 0))
        {
            datos.set(leaf,datos.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        datos.set(leaf,value);
    }

    /**
     * @pre 0 <= root < size
     * @param root indice
     * @post mueve el nodo en el indice root a una posicion apropiada debajo.
     */
    protected void pushDownRoot(int root)
    {
        int heapSize = datos.size();
        E value = datos.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((datos.get(childpos+1)).compareTo
                                (datos.get(childpos)) < 0))
                {
                    childpos++;
                }
// Assert: childpos indices menores de los dos hijos
                if ((datos.get(childpos)).compareTo
                        (value) < 0)
                {
                    datos.set(root,datos.get(childpos));
                    root = childpos; // sigue bajando
                } else { // encuentra el lugar adecuado
                    datos.set(root,value);
                    return;
                }
            } else { // en la hoja, que lo agregue.
                datos.set(root,value);
                return;
            }
        }
    }


    /**
     * @pre no esta vacío
     * @post regresa el valor minimo en la PriorityQueue
     */
    public E getFirst() {
        return null;
    }

    /**
     * @pre no esta vacío
     * @post regresa y nelimi
     */
    public E remove() {
        E minVal = getFirst();
        datos.set(0,datos.get(datos.size()-1));
        datos.setSize(datos.size()-1);
        if (datos.size() > 1) pushDownRoot(0);
        return minVal;

    }

    /**
     * @param value
     * @pre no esta vacío y es un elemento comparable
     * @post el valor es añadido a la cola.
     */
    public void add(E value) {
        datos.add(value);
        percolateUp(datos.size()-1);
    }

    /**
     * @post regresa verdadero si no hay elementos en la cola.
     */
    public boolean isEmpty() {
        return datos.isEmpty();
    }

    /**
     * @post regresa el numero de elementos en la cola.
     */
    public int size() {
        return datos.size();
    }

    /**
     * @post elimina todos los elementos de la cola
     */
    public void clear() {
        datos = new Vector<E>();
    }
}
