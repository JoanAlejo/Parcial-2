package GUI;
import javax.swing.*;

import DAO.MotoDAO;
import Modelado.Casco;
import DAO.CascoDAO;
import javax.swing.JOptionPane;



public class VentanaCascos extends JFrame{
    private JPanel panelCascos;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtTalla;
    private JTextField txtPrecio;
    private JComboBox comboBoxTipo;
    private JButton btnAgregarCasco;
    private JButton btnConsultarTodas;
    private JButton btnConsultarUno;
    private JButton btnFiltrar;
    private JLabel DATABASELabel;
    private JTextArea txtResultados;
    private JScrollPane scrollResultado;
    private JLabel titulo;
    private JLabel Marca;
    private JLabel Modelo;
    private JLabel Talla;
    private JLabel Certificacion;
    private JLabel Precio;
    private CascoDAO cascoDAO = new CascoDAO();

    public VentanaCascos() {
        setContentPane(panelCascos);
        setTitle("Gestión de Motos");
        setSize(700,500);
        setLocationRelativeTo(null);
        comboBoxTipo.addItem("DOT");
        comboBoxTipo.addItem("ECE 22.06");
        comboBoxTipo.addItem("FIM");
        comboBoxTipo.addItem("Snell");
        btnAgregarCasco.addActionListener(e -> {

            try {

                String marca = txtMarca.getText();
                String modelo = txtModelo.getText();
                String talla = txtTalla.getText();
                int precio = Integer.parseInt(txtPrecio.getText()); //convertimos el texto del campo a entero para poder guardarlo en la BD
                String certificacion = comboBoxTipo.getSelectedItem().toString(); //obtenemos la certificacion seleccionada en el ComboBox

                Casco c = new Casco(
                        marca,
                        modelo,
                        talla,
                        certificacion,
                        precio
                );

                cascoDAO.insertarCasco(c); //usamos el DAO para insertar el casco en Neon

                JOptionPane.showMessageDialog(
                        this,
                        "Casco agregado correctamente"
                );

            } catch (Exception ex) { //captura errores como campos vacios o datos numericos mal digitados

                JOptionPane.showMessageDialog(
                        this,
                        "Verifique los datos ingresados"
                );

            }
        });

        btnConsultarTodas.addActionListener(e -> {

            StringBuilder resultado = new StringBuilder(); //StringBuilder permite concatenar muchos resultados de forma mas eficiente

            for (Casco casco : cascoDAO.consultarTodas()) {
                resultado.append(casco).append("\n\n");
            }

            if (resultado.isEmpty()) { //si el StringBuilder sigue vacio significa que no habia registros
                txtResultados.setText("No hay cascos registrados");
            } else {
                txtResultados.setText(resultado.toString());
            }

        });

        btnConsultarUno.addActionListener(e -> {

            try {

                String entrada = JOptionPane.showInputDialog(
                        this,
                        "Digite el ID del casco:"
                );

                int id = Integer.parseInt(entrada); //convertimos el ID digitado a entero para buscarlo en la BD

                Casco casco = cascoDAO.consultarUno(id);

                if (casco != null) { //si el DAO devuelve null significa que el ID no existe
                    txtResultados.setText(casco.toString());
                } else {
                    txtResultados.setText("Casco no encontrado");
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Digite un ID válido"
                );

            }

        });

        btnFiltrar.addActionListener(e -> {

            try {

                String entrada = JOptionPane.showInputDialog(
                        this,
                        "Digite su presupuesto máximo:"
                );

                int presupuesto = Integer.parseInt(entrada);

                StringBuilder resultado = new StringBuilder();

                //el DAO devuelve todos los cascos cuyo precio sea menor o igual al presupuesto digitado
                for (Casco casco : cascoDAO.filtrarPorPresupuesto(presupuesto)) {
                    resultado.append(casco).append("\n\n");
                }

                if (resultado.isEmpty()) { //si no se encontro ningun casco dentro del presupuesto informado
                    txtResultados.setText(
                            "No hay cascos por debajo de $" + presupuesto
                    );
                } else {
                    txtResultados.setText(resultado.toString());
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Digite un presupuesto válido"
                );

            }

        });
        setVisible(true);
    }
}
