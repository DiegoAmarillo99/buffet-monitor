import java.util.ArrayList;

public class BuffetSystem {

    private ArrayList<String> historial = new ArrayList<>();

    public String verificarEstado(String estado) {
        String resultado;

        switch (estado.toLowerCase()) {
            case "vacio":
                resultado = "ALERTA: Reponer platillo";
                break;
            case "medio":
                resultado = "Atención: Nivel medio";
                break;
            case "lleno":
                resultado = "Estado OK";
                break;
            default:
                resultado = "Estado inválido";
        }

        historial.add(estado);
        return resultado;
    }

    public void mostrarHistorial() {
        System.out.println("\n===== HISTORIAL =====");
        if (historial.isEmpty()) {
            System.out.println("No hay registros.");
        } else {
            for (String h : historial) {
                System.out.println("- " + h);
            }
        }
    }
}