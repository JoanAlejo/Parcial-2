package GUI;

import javax.swing.*;


public class VentanaPrincipal extends JFrame {
    private JPanel panelPr;
    private JLabel titulo;
    private JLabel leyenda;
    private JButton botonMoto;
    private JButton botonCascco;
    private JButton botonSalir;

    public VentanaPrincipal() {
        setContentPane(panelPr);
        setTitle("Gestión de Motos y Cascos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
