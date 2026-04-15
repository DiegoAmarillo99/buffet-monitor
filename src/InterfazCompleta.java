import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;

public class InterfazCompleta extends JFrame {

    private JComboBox<String> comboPlatillos;
    private JComboBox<String> comboEstado;
    private JComboBox<String> comboTemperatura;
    private JTextPane areaHistorial;
    private JPanel panelPrincipal;
    private JPanel panelTop;
    private boolean modoOscuro = false;

    public InterfazCompleta() {

        setTitle("Wok Garden - Monitor Buffet");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelPrincipal = new JPanel(new BorderLayout());
        add(panelPrincipal);

        panelTop = new JPanel(new GridLayout(5, 2, 10, 10));
        panelTop.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        String[] platillos = {
                "Pollo Agridulce", "Arroz Frito", "Fideos Chow Mein",
                "Rollitos Primavera", "Costillas BBQ", "Pizza",
                "Nigiri Salmón", "Nigiri Atún", "Nigiri Camarón",
                "Rollo Empanizado Pollo", "Rollo Empanizado Res", "Rollo Empanizado Camarón",
                "Rollo California", "Rollo Vegetariano", "Rollo Atún",
                "Rollo Camarón", "Rollo Surimi", "Rollo Salmón",
                "Fideo Ramen", "Caldo Ramen", "Sides Ramen"
        };

        comboPlatillos = new JComboBox<>(platillos);
        comboEstado = new JComboBox<>(new String[]{"Lleno", "Medio", "Vacío"});
        comboTemperatura = new JComboBox<>(new String[]{"Caliente", "Frío"});

        JLabel lblPlatillo = label("Platillo:");
        JLabel lblEstado = label("Estado:");
        JLabel lblTemp = label("Temperatura:");

        panelTop.add(lblPlatillo);
        panelTop.add(comboPlatillos);

        panelTop.add(lblEstado);
        panelTop.add(comboEstado);

        panelTop.add(lblTemp);
        panelTop.add(comboTemperatura);

        JButton btnRegistrar = new JButton("Registrar");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnModo = new JButton("Modo Oscuro 🌙");

        estiloBoton(btnRegistrar);
        estiloBoton(btnLimpiar);
        estiloBoton(btnModo);

        panelTop.add(btnRegistrar);
        panelTop.add(btnLimpiar);
        panelTop.add(btnModo);

        panelPrincipal.add(panelTop, BorderLayout.NORTH);

        areaHistorial = new JTextPane();
        areaHistorial.setEditable(false);
        areaHistorial.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        panelPrincipal.add(new JScrollPane(areaHistorial), BorderLayout.CENTER);

        aplicarModoClaro();
        cargarHistorial();

        // EVENTOS
        btnRegistrar.addActionListener(e -> registrar());
        btnLimpiar.addActionListener(e -> limpiar());

        btnModo.addActionListener(e -> {
            modoOscuro = !modoOscuro;

            animarCambioModo(modoOscuro);

            if (modoOscuro) {
                btnModo.setText("Modo Claro");
            } else {
                btnModo.setText("Modo Oscuro");
            }
        });
    }

    private JLabel label(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return lbl;
    }

    private void estiloBoton(JButton btn) {
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
    }

    // 🌞 MODO CLARO
    private void aplicarModoClaro() {

        panelPrincipal.setBackground(new Color(245,245,245));
        panelTop.setBackground(new Color(245,245,245));

        for (Component c : panelTop.getComponents()) {

            if (c instanceof JLabel) {
                c.setForeground(Color.BLACK);
            }

            if (c instanceof JComboBox) {
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
            }

            if (c instanceof JButton) {
                c.setBackground(new Color(52,152,219));
                c.setForeground(Color.WHITE);
            }
        }

        areaHistorial.setBackground(Color.WHITE);
        areaHistorial.setForeground(Color.BLACK);
    }

    // 🌙 MODO OSCURO
    private void aplicarModoOscuro() {

        panelPrincipal.setBackground(new Color(34,34,34));
        panelTop.setBackground(new Color(40,40,40));

        for (Component c : panelTop.getComponents()) {

            if (c instanceof JLabel) {
                c.setForeground(Color.WHITE);
            }

            if (c instanceof JComboBox) {
                c.setBackground(new Color(60,60,60));
                c.setForeground(Color.WHITE);
            }

            if (c instanceof JButton) {
                c.setBackground(new Color(70,130,180));
                c.setForeground(Color.WHITE);
            }
        }

        areaHistorial.setBackground(new Color(45,45,45));
        areaHistorial.setForeground(Color.WHITE);
    }

    // 🎬 ANIMACIÓN
    private void animarCambioModo(boolean oscuro) {

        Timer timer = new Timer(10, null);

        final int pasos = 20;
        final int[] contador = {0};

        timer.addActionListener(e -> {

            float t = (float) contador[0] / pasos;

            Color inicio = oscuro ? new Color(245,245,245) : new Color(34,34,34);
            Color fin = oscuro ? new Color(34,34,34) : new Color(245,245,245);

            Color actual = mezclarColores(inicio, fin, t);

            panelPrincipal.setBackground(actual);
            panelTop.setBackground(actual);

            contador[0]++;

            if (contador[0] > pasos) {
                timer.stop();

                if (oscuro) aplicarModoOscuro();
                else aplicarModoClaro();
            }
        });

        timer.start();
    }

    private Color mezclarColores(Color c1, Color c2, float t) {

        int r = (int) (c1.getRed() + t * (c2.getRed() - c1.getRed()));
        int g = (int) (c1.getGreen() + t * (c2.getGreen() - c1.getGreen()));
        int b = (int) (c1.getBlue() + t * (c2.getBlue() - c1.getBlue()));

        return new Color(r, g, b);
    }

    private void registrar() {
        String platillo = comboPlatillos.getSelectedItem().toString();
        String estado = comboEstado.getSelectedItem().toString();
        String temp = comboTemperatura.getSelectedItem().toString();

        String texto;

        if (estado.equals("Vacío")) {
            texto = "ALERTA: Reponer " + platillo;
        } else if (estado.equals("Medio")) {
            texto = "Atención: Nivel medio en " + platillo;
        } else {
            texto = platillo + " está en buen estado";
        }

        texto += " | Temp: " + temp;

        mostrar(texto, estado);
        guardar(texto);
    }

    private void mostrar(String texto, String estado) {
        StyledDocument doc = areaHistorial.getStyledDocument();
        Style style = areaHistorial.addStyle("style", null);

        if (estado.equals("Vacío")) {
            StyleConstants.setForeground(style, new Color(231,76,60));
        } else if (estado.equals("Medio")) {
            StyleConstants.setForeground(style, new Color(241,196,15));
        } else {
            StyleConstants.setForeground(style, new Color(46,204,113));
        }

        try {
            doc.insertString(doc.getLength(), texto + "\n", style);
        } catch (Exception e) {}
    }

    private void guardar(String texto) {
        try (FileWriter fw = new FileWriter("historial.txt", true)) {
            fw.write(texto + "\n");
        } catch (Exception e) {}
    }

    private void cargarHistorial() {
        try (BufferedReader br = new BufferedReader(new FileReader("historial.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                mostrar(linea, detectar(linea));
            }
        } catch (Exception e) {}
    }

    private String detectar(String texto) {
        if (texto.contains("ALERTA")) return "Vacío";
        if (texto.contains("Atención")) return "Medio";
        return "Lleno";
    }

    private void limpiar() {
        areaHistorial.setText("");
        try (FileWriter fw = new FileWriter("historial.txt")) {
            fw.write("");
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        new InterfazCompleta().setVisible(true);
    }
}