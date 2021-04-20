/**
 * @author Juan Diego Avila
 */
public class Paciente implements Comparable<Paciente>{

    String nombre;
    String sintoma;
    String codigo;
    private Object ClassCastException;

    public Paciente(String n, String s, String c){
        this.nombre = n;
        this.sintoma = s;
        this.codigo = c;
    }
    public Paciente(){

    }

    /**
     * @param o the object que sera comparado.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Paciente o) { return codigo.compareTo(o.codigo); }

    @Override
    public String toString(){
        return "\n\tNombre: "+nombre+"\tSintoma: "+sintoma+"\tCodigo: "+codigo;
    }

}
