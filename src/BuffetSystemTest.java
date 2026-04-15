// trigger build
import org.junit.Test;
import static org.junit.Assert.*;

public class BuffetSystemTest {

    @Test
    public void testEstadoVacio() {
        BuffetSystem sistema = new BuffetSystem();
        String resultado = sistema.verificarEstado("vacio");
        assertEquals("ALERTA: Reponer platillo", resultado);
    }

    @Test
    public void testEstadoLleno() {
        BuffetSystem sistema = new BuffetSystem();
        String resultado = sistema.verificarEstado("lleno");
        assertEquals("Estado OK", resultado);
    }
}