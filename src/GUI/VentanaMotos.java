package GUI;

import javax.swing.*;
import DAO.MotoDAO;
import Modelado.Moto;
import javax.swing.JOptionPane;

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
    private MotoDAO motoDAO = new MotoDAO();

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
        btnAgregarMoto.addActionListener(e -> {

            try {

                String marca = txtMarca.getText();
                String modelo = txtModelo.getText();
                int cilindraje = Integer.parseInt(txtCilindraje.getText()); //convertimos el texto del campo a entero para poder almacenarlo en la BD
                int precio = Integer.parseInt(txtPrecio.getText()); //convertimos el precio digitado a entero
                String tipo = comboBoxTipo.getSelectedItem().toString(); //obtenemos el tipo de moto seleccionado en el ComboBox

                Moto m = new Moto(
                        marca,
                        modelo,
                        cilindraje,
                        precio,
                        tipo
                );

                motoDAO.insertarMoto(m); //usamos el DAO para insertar la moto en Neon

                JOptionPane.showMessageDialog(
                        this,
                        "Moto agregada correctamente"
                );

            } catch (Exception ex) { //captura errores como campos vacios o datos numericos mal digitados

                JOptionPane.showMessageDialog(
                        this,
                        "Verifique los datos ingresados"
                );

            }
        });

        btnConsultarTodas.addActionListener(e -> {

            StringBuilder resultado = new StringBuilder(); //StringBuilder permite concatenar todos los registros encontrados

            for (Moto moto : motoDAO.consultarTodas()) {
                resultado.append(moto).append("\n\n");
            }

            if (resultado.isEmpty()) { //si sigue vacio significa que no existen motos registradas
                txtResultados.setText("No hay motos registradas");
            } else {
                txtResultados.setText(resultado.toString());
            }

        });

        btnConsultarUno.addActionListener(e -> {

            try {

                String entrada = JOptionPane.showInputDialog(
                        this,
                        "Digite el ID de la moto:"
                );

                int id = Integer.parseInt(entrada); //convertimos el ID digitado a entero para realizar la consulta

                Moto moto = motoDAO.consultarUno(id);

                if (moto != null) { //si el DAO devuelve null significa que no existe una moto con ese ID
                    txtResultados.setText(moto.toString());
                } else {
                    txtResultados.setText("Moto no encontrada");
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Digite un ID válido"
                );

            }

        });

        btnFiltrar.addActionListener(e -> {

            String tipo = comboBoxTipo.getSelectedItem().toString(); //obtenemos el tipo de moto seleccionado para realizar el filtro

            StringBuilder resultado = new StringBuilder();

            for (Moto moto : motoDAO.filtrarPorTipo(tipo)) {
                resultado.append(moto).append("\n\n");
            }

            if (resultado.isEmpty()) { //si no hay resultados significa que no existen motos de ese tipo
                txtResultados.setText("No hay motos de tipo " + tipo);
            } else {
                txtResultados.setText(resultado.toString());
            }

        });
        setVisible(true);
    }

}
