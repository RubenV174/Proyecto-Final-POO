package proyectoFinal;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class TablaPagos extends JFrame {
    private JTextField txtClave;
    private JButton btnBuscar;
    private JTable tablaPagos;
    private DefaultTableModel model;

    // HashMap para almacenar la información de los pagos asociados a las claves
    private HashMap<String, String[]> pagos = new HashMap<>();

    public TablaPagos() {
        setTitle("Tabla de Pagos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar el HashMap con algunos datos de ejemplo
        pagos.put("123", new String[]{"Juan Pérez", "Enero"});
        pagos.put("456", new String[]{"María Gómez", "Febrero"});
        pagos.put("789", new String[]{"Pedro Rodríguez", "Marzo"});

        // Configuración de la tabla
        model = new DefaultTableModel(new Object[]{"Nombre", "Mes de Pago"}, 0);
        tablaPagos = new JTable(model);

        // Configuración de los campos de texto y el botón
        txtClave = new JTextField();
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String clave = txtClave.getText();
                String[] pago = pagos.get(clave);
                if (pago != null) {
                    model.setRowCount(0); // Limpiamos la tabla antes de agregar el nuevo resultado
                    model.addRow(pago);
                } else {
                    JOptionPane.showMessageDialog(null, "Clave no encontrada.");
                }
            }
        });

        // Configuración del diseño del JFrame
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Ingresa la clave:"));
        add(txtClave);
        add(btnBuscar);
        add(new JScrollPane(tablaPagos)); // Agregamos la tabla dentro de un JScrollPane

        setVisible(true);
    }

    public static void main(String[] args) {
        new TablaPagos();
    }
}
