import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();
        int opcion = -1;

        do {
            System.out.println("\n===== INVENTARIO =====");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID: ");
                    try {
                        int id = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Ingrese el nombre: ");
                        String nombre = sc.nextLine().trim();
                        if (inventario.insertar(id, nombre)) {
                            System.out.println("Producto registrado correctamente.");
                        } else {
                            System.out.println("Ya existe un producto con el ID " + id + ".");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("El ID debe ser un numero entero.");
                    }
                    break;
                case 2:
                    System.out.println("--- Inventario (ordenado por ID) ---");
                    inventario.recorridoInorden();
                    break;
                case 3:
                    System.out.print("Ingrese el ID a buscar: ");
                    try {
                        int idBuscar = Integer.parseInt(sc.nextLine().trim());
                        Producto p = inventario.buscar(idBuscar);
                        if (p != null) {
                            System.out.println("El producto existe: " + p.nombre + " (ID " + p.id + ").");
                        } else {
                            System.out.println("El producto con ID " + idBuscar + " no existe.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("El ID debe ser un numero entero.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
