import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BuffetSystem sistema = new BuffetSystem();

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE MONITOREO BUFFET =====");
            System.out.println("1. Registrar estado de alimento");
            System.out.println("2. Ver historial");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese estado (lleno/medio/vacio): ");
                    String estado = scanner.nextLine();

                    String resultado = sistema.verificarEstado(estado);
                    System.out.println(resultado);
                    break;

                case 2:
                    sistema.mostrarHistorial();
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 3);

        scanner.close();
    }
}