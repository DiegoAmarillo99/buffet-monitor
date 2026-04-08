public class BuffetSystem {

    public String verificarEstado(String estado) {
        if (estado.equalsIgnoreCase("vacio")) {
            return "ALERTA: Reponer platillo";
        } else if (estado.equalsIgnoreCase("medio")) {
            return "Atención: Nivel medio";
        } else if (estado.equalsIgnoreCase("lleno")) {
            return "Estado OK";
        } else {
            return "Estado inválido";
        }
    }
}