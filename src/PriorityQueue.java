/**
 * @author Juan Diego Avila
 * @param <E> tipo de dato de la cola que es te tipo comparable.
 */
public interface PriorityQueue<E extends Comparable<E>>{

    /**
     * @pre no esta vacío
     * @post regresa el valor minimo en la cola
     */
    public E getFirst();

    /**
     * @pre no esta vacío
     * @post regresa y nelimi
     */
    public E remove();

    /**
     * @pre no esta vacío y es un elemento comparable
     * @post el valor es añadido a la cola.
     */
    public void add(E value);

    /**
     * @post regresa verdadero si no hay elementos en la cola.
     */
    public boolean isEmpty();

    /**
     * @post regresa el numero de elementos en la cola.
     */
    public int size();

    /**
     * @post elimina todos los elementos de la cola
     */
    public void clear();



}
