import java.io.File;
import java.util.*;

/**
 * @author Juan Diego Avila
 */
public class Main {

    /* Clase que utiliza la interfaz creada de VectorHeap.*/
    public static void main(String[]args){
        //leer archivo y crear arbol.
        Vector<Paciente> pacientes = new Vector<>();
        try {
            Scanner input = new Scanner(new File("Pacientes.txt"));
            int cont = 0;
            while (input.hasNextLine()) {

                List<String> temp = Arrays.asList(input.nextLine().split(","));
                Paciente temporal = new Paciente(temp.get(0), temp.get(1), temp.get(2));
                pacientes.add(temporal);
            }
        }catch (Exception ignored){ }

        System.out.println("\n Los pacientes ingresados al sistema son -> ");
        PriorityQueue<Paciente> heap = new PriorityQueue<>();
        for(Paciente i: pacientes){
            heap.add(i);
            System.out.println(i.toString());
        }

        for(int i = 0; i<pacientes.size();i++){

            Paciente atendido = new Paciente();
            System.out.println("\n El siguiente paciente es: ");
            atendido = heap.remove();
            System.out.println(atendido.toString());

        }



    }


}
