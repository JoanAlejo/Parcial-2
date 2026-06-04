package GUI;

import javax.swing.*;


public class VentanaPrincipal extends JFrame {
    private JPanel panelPr;
    private JLabel titulo;
    private JLabel leyenda;
    private JButton botonMotos;
    private JButton botonCascos;
    private JButton botonSalir;

    public VentanaPrincipal() {
        setContentPane(panelPr);
        setTitle("Gestión de Motos y Cascos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setLocationRelativeTo(null);
        botonSalir.addActionListener(e -> System.exit(0));//funcion que cierra la ventana cuando oprimimos salir
        //Funciones para abrir las otras ventanas
        botonMotos.addActionListener(e -> {new VentanaMotos();});
        botonCascos.addActionListener(e -> {new VentanaCascos();});
        setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}