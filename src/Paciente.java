/**
 * @author Juan Diego Avila
 */
public class Paciente<E> implements Comparable<E>{
    /**
     * @param o the object que sera comparado.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(E o) {
        return 0;
    }
}
