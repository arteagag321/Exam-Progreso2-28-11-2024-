import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThunderboltsGUI {
    private JTextField codigoField;
    private JTextField nombreField;
    private JTextField textField3;
    private JComboBox misionComboBox;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton agregarButton;
    private JTable thunderboltsTable;
    public ThunderboltsGUI() {
        // Configuración inicial de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Código", "Nombre", "Habilidad", "Redención", "Misión"});
        thunderboltsTable.setModel(model);

        // Acción para el botón "Agregar Thunderbolt"
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos
                String codigo = codigoField.getText();
                String nombre = nombreField.getText();
                String habilidad = (String) comboBox2.getSelectedItem();
                String redencion = (String) comboBox3.getSelectedItem();
                String mision = (String) misionComboBox.getSelectedItem();

                // Validar que no estén vacíos
                if (codigo.isEmpty() || nombre.isEmpty() || habilidad == null || redencion == null || mision == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.");
                    return;
                }

                // Verificar si el código ya existe en la tabla
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).equals(codigo)) {
                        JOptionPane.showMessageDialog(null, "El código ya existe. Usa otro código.");
                        return;
                    }
                }

                // Agregar el Thunderbolt a la tabla
                model.addRow(new Object[]{codigo, nombre, habilidad, redencion, mision});

                // Limpiar los campos después de agregar
                codigoField.setText("");
                nombreField.setText("");
                comboBox2.setSelectedIndex(-1); // Limpiar selección de ComboBox
                comboBox3.setSelectedIndex(-1);
                misionComboBox.setSelectedIndex(-1);

                JOptionPane.showMessageDialog(null, "Thunderbolt agregado exitosamente.");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Thunderbolts Manager");
        frame.setContentPane(new ThunderboltsGUI().createContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createContentPane() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Código"));
        panel.add(codigoField);
        panel.add(new JLabel("Nombre"));
        panel.add(nombreField);
        panel.add(new JLabel("Habilidad Principal"));
        panel.add(comboBox2);
        panel.add(new JLabel("Nivel de Redención"));
        panel.add(comboBox3);
        panel.add(new JLabel("Misión"));
        panel.add(misionComboBox);
        panel.add(agregarButton);
        panel.add(new JScrollPane(thunderboltsTable));
        return panel;
    }
}