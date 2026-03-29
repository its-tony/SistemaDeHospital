import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class VectorHeapTest {

    @Test
    public void testAddColocaElMenorAlInicio() {
        VectorHeap<Integer> heap = new VectorHeap<>();

        heap.add(8);
        heap.add(3);
        heap.add(5);

        assertEquals(3, heap.getFirst());
        assertEquals(3, heap.size());
    }

    @Test
    public void testRemoveRetornaElementosEnOrden() {
        VectorHeap<Paciente> heap = new VectorHeap<>();

        heap.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        heap.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        heap.add(new Paciente("Carmen Sarmientos", "dolores de parto", 'B'));

        assertEquals("Maria Ramirez, apendicitis, A", heap.remove().toString());
        assertEquals("Carmen Sarmientos, dolores de parto, B", heap.remove().toString());
        assertEquals("Juan Perez, fractura de pierna, C", heap.remove().toString());
    }

    @Test
    public void testRemoveEnHeapVacio() {
        VectorHeap<Integer> heap = new VectorHeap<>();

        assertTrue(heap.isEmpty());
        assertNull(heap.remove());
    }
}
