import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    @org.junit.jupiter.api.Test
    void remove() {
        VectorHeap<String> heap = new VectorHeap<>();
        heap.add("Primero");
        heap.add("Segundo");
        heap.remove();
        assertEquals("Segundo",heap.getFirst());
    }

    @org.junit.jupiter.api.Test
    void add() {
        VectorHeap<String> heap = new VectorHeap<>();
        heap.add("Primero");

        assertEquals("Primero",heap.getFirst());
    }
}