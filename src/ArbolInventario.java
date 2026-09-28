public class ArbolInventario {
    private Producto raiz;

    // Inserta un producto ordenado por ID. Devuelve false si el ID ya existe.
    public boolean insertar(int id, String nombre) {
        if (buscar(id) != null) {
            return false;
        }
        raiz = insertarRecursivo(raiz, new Producto(id, nombre));
        return true;
    }

    private Producto insertarRecursivo(Producto actual, Producto nuevo) {
        if (actual == null) {
            return nuevo;
        }
        if (nuevo.id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, nuevo);
        } else {
            actual.derecho = insertarRecursivo(actual.derecho, nuevo);
        }
        return actual;
    }

    // Recorrido inorden: izquierdo -> nodo -> derecho (lista ordenada por ID)
    public void recorridoInorden() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
            return;
        }
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(Producto actual) {
        if (actual != null) {
            inordenRecursivo(actual.izquierdo);
            System.out.println("ID: " + actual.id + " | Nombre: " + actual.nombre);
            inordenRecursivo(actual.derecho);
        }
    }

    // Busca un producto por ID. Devuelve null si no existe.
    public Producto buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Producto buscarRecursivo(Producto actual, int id) {
        if (actual == null || actual.id == id) {
            return actual;
        }
        if (id < actual.id) {
            return buscarRecursivo(actual.izquierdo, id);
        }
        return buscarRecursivo(actual.derecho, id);
    }
}
