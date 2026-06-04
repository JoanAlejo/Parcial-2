package GUI;

import javax.swing.*;

public class VentanaMotos extends JFrame {
    private JPanel panelMotos;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtCilindraje;
    private JTextField txtPrecio;
    private JComboBox comboBoxTipo;
    private JButton btnAgregarMoto;
    private JButton btnConsultarTodas;
    private JButton btnConsultarUno;
    private JButton btnFiltrar;
    private JLabel DATABASELabel;
    private JTextArea txtResultados;
    private JScrollPane scrollResultado;
    private JLabel titulo;
    private JLabel Marca;
    private JLabel Modelo;
    private JLabel Cilindraje;
    private JLabel TIpo;
    private JLabel Precio;

    public VentanaMotos() {
        setContentPane(panelMotos);
        setTitle("Gestión de Motos");
        setSize(700,500);
        setLocationRelativeTo(null);
        comboBoxTipo.addItem("Naked");
        comboBoxTipo.addItem("Deportiva");
        comboBoxTipo.addItem("Adventure");
        comboBoxTipo.addItem("Cruiser");
        comboBoxTipo.addItem("Touring");
        setVisible(true);
    }

}
