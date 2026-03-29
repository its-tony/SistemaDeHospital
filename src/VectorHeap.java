import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private Vector<E> data;

    public VectorHeap() {
        data = new Vector<>();
    }

    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        E minimo = data.get(0);
        E ultimo = data.remove(data.size() - 1);

        if (!isEmpty()) {
            data.set(0, ultimo);
            pushDownRoot(0);
        }

        return minimo;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }

        return data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    private void percolateUp(int indice) {
        while (indice > 0) {
            int padre = (indice - 1) / 2;

            if (data.get(indice).compareTo(data.get(padre)) >= 0) {
                break;
            }

            intercambiar(indice, padre);
            indice = padre;
        }
    }

    private void pushDownRoot(int indice) {
        while (true) {
            int hijoIzquierdo = (indice * 2) + 1;
            int hijoDerecho = (indice * 2) + 2;
            int menor = indice;

            if (hijoIzquierdo < data.size()
                    && data.get(hijoIzquierdo).compareTo(data.get(menor)) < 0) {
                menor = hijoIzquierdo;
            }

            if (hijoDerecho < data.size()
                    && data.get(hijoDerecho).compareTo(data.get(menor)) < 0) {
                menor = hijoDerecho;
            }

            if (menor == indice) {
                break;
            }

            intercambiar(indice, menor);
            indice = menor;
        }
    }

    private void intercambiar(int indice1, int indice2) {
        E temporal = data.get(indice1);
        data.set(indice1, data.get(indice2));
        data.set(indice2, temporal);
    }
}
