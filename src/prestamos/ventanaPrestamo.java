package prestamos;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import logic.Sistema;

/**
 * @author Andrey Badilla && Kenneth Ibarra
 */
public class ventanaPrestamo extends javax.swing.JDialog {
    private boolean editar = true;
    private int numero = 0;
    
    public ventanaPrestamo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Sistema s = Sistema.getInstance();
        initComponents();
        setLocationRelativeTo(null);
        ArrayList<String> personas = s.personasToString();
        jComboBoxPersonas.setModel(new DefaultComboBoxModel(personas.toArray()));
        ArrayList<String> items = s.itemsToString();
        jComboBoxItemsS.setModel(new DefaultComboBoxModel(items.toArray()));
        jLabelDias.setVisible(false);
        jFormattedTextFieldDias.setVisible(false);
        jCheckBoxRecurrente.setVisible(false);
        jFormattedTextFieldCantidad.setVisible(false);
    }    
    public ventanaPrestamo(java.awt.Frame parent, boolean modal, int prestamo, boolean editar) {
        super(parent, modal);
        Sistema s = Sistema.getInstance();
        initComponents();
        setLocationRelativeTo(null);
        jLabelNumero.setText(String.valueOf(prestamo));
        jLabelDias.setVisible(false);
        jFormattedTextFieldDias.setVisible(false);
        jCheckBoxRecurrente.setVisible(false);
        jFormattedTextFieldCantidad.setVisible(false);
        if(!editar){
            jButtonAgregar.setEnabled(editar);
            jButtonEliminar.setEnabled(editar);
            jCheckBoxAlarma.setEnabled(editar);
            jCheckBoxRecurrente.setEnabled(editar);
            jComboBoxPersonas.setEnabled(editar);
            jFormattedTextFieldCantidad.setEnabled(editar);
            jFormattedTextFieldDias.setEnabled(editar);
            jListItemsP.setEnabled(editar);
        }
        cargarDatos();
    }
    public void cargarDatos() {
        try {
            numero = Integer.parseInt(jLabelNumero.getText());
            Sistema s = Sistema.getInstance();
            ArrayList<String> personas = s.personasToString();
            jComboBoxPersonas.setModel(new DefaultComboBoxModel(personas.toArray()));
            jComboBoxPersonas.setSelectedItem(s.prestamoToString(numero));
            ArrayList<String> items = s.itemsDisponibles();
            jComboBoxItemsS.setModel(new DefaultComboBoxModel(items.toArray()));
            DefaultListModel<String> listModel = new DefaultListModel();
            items = s.getItemsPrestamo(numero);
            for(String str : items)
                listModel.addElement(str);
            jListItemsP.setModel(listModel);
            if(s.tieneAlarma(numero)){
                jCheckBoxAlarma.setSelected(true);
                jLabelDias.setVisible(true);
                jLabelDias.setText(String.valueOf(s.getDiasAlarma(numero)));
                jFormattedTextFieldDias.setVisible(true);
                jCheckBoxRecurrente.setVisible(true);
                if(s.tieneAlarmaRecurrente(numero)){
                    jFormattedTextFieldCantidad.setVisible(true);
                    jFormattedTextFieldCantidad.setText(String.valueOf(s.getCantidadRecurrente(numero)));
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxItemsS = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListItemsP = new javax.swing.JList<>();
        jComboBoxPersonas = new javax.swing.JComboBox<>();
        jButtonAgregar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jCheckBoxAlarma = new javax.swing.JCheckBox();
        jCheckBoxRecurrente = new javax.swing.JCheckBox();
        jLabelDias = new javax.swing.JLabel();
        jFormattedTextFieldDias = new javax.swing.JFormattedTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelNumero = new javax.swing.JLabel();
        jFormattedTextFieldCantidad = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setText("Préstamo");

        jLabel2.setText("Persona:");

        jLabel3.setText("Items:");

        jListItemsP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListItemsPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListItemsP);

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jCheckBoxAlarma.setText("Alarma");
        jCheckBoxAlarma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxAlarmaMouseClicked(evt);
            }
        });

        jCheckBoxRecurrente.setText("Recurrente");
        jCheckBoxRecurrente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxRecurrenteMouseClicked(evt);
            }
        });

        jLabelDias.setText("Días:");

        jFormattedTextFieldDias.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jFormattedTextFieldCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNumero)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jComboBoxPersonas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEliminar))
                            .addComponent(jComboBoxItemsS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxAlarma)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDias)
                        .addGap(18, 18, 18)
                        .addComponent(jFormattedTextFieldDias, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxRecurrente)
                        .addGap(18, 18, 18)
                        .addComponent(jFormattedTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNumero))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxItemsS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAgregar)
                            .addComponent(jButtonEliminar))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxAlarma)
                    .addComponent(jLabelDias)
                    .addComponent(jFormattedTextFieldDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxRecurrente)
                    .addComponent(jFormattedTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        Sistema s = Sistema.getInstance();
        try {
            if(!s.existePrestamo(numero) || numero == 0)
                numero = s.crearPrestamo(jComboBoxPersonas.getSelectedItem().toString());
                jLabelNumero.setText(String.valueOf(numero));
            s.agregarItemPrestamo(jComboBoxItemsS.getSelectedItem().toString(), numero);
            cargarDatos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        Sistema s = Sistema.getInstance();
        try {
            s.eliminarItemPrestamo(jListItemsP.getSelectedValue(), Integer.parseInt(jLabelNumero.getText()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        cargarDatos();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        Sistema s = Sistema.getInstance();
        try {
            if(s.existePrestamo(numero)){
                if (editar)
                    s.modificarPrestamo(numero, jComboBoxPersonas.getSelectedItem().toString());
                dispose();
            }
            else{
                ListModel<String> items = jListItemsP.getModel();
                numero = s.crearPrestamo(jComboBoxPersonas.getSelectedItem().toString());
                jLabelNumero.setText(String.valueOf(numero));
                if(jCheckBoxAlarma.isSelected() && !jCheckBoxRecurrente.isSelected()){
                    s.crearAlarmaPrestamo(numero, jComboBoxPersonas.getSelectedItem().toString(), (int) jFormattedTextFieldDias.getValue());
                }else if(jCheckBoxAlarma.isSelected() && jCheckBoxRecurrente.isSelected()){
                    s.crearAlarmaPrestamo(numero, jComboBoxPersonas.getSelectedItem().toString(), (int) jFormattedTextFieldDias.getValue(), (int) jFormattedTextFieldCantidad.getValue());
                }
                if(items.getSize()<=0){
                    JOptionPane.showMessageDialog(null, "Debe agregar al menos un item", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    dispose();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jCheckBoxAlarmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxAlarmaMouseClicked
        if(jCheckBoxAlarma.isSelected()){
            jLabelDias.setVisible(true);
            jFormattedTextFieldDias.setVisible(true);
            jCheckBoxRecurrente.setVisible(true);
        }
        else{
            jLabelDias.setVisible(false);
            jFormattedTextFieldDias.setVisible(false);
            jCheckBoxRecurrente.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBoxAlarmaMouseClicked

    private void jCheckBoxRecurrenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxRecurrenteMouseClicked
        if(jCheckBoxRecurrente.isSelected()){
            jFormattedTextFieldCantidad.setVisible(true);
        }
        else{
            jFormattedTextFieldCantidad.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBoxRecurrenteMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        jButtonEliminar.setEnabled(false);
        Sistema sistema = Sistema.getInstance();
        String mensaje = sistema.revisarAlarmas();
        if(mensaje != null)
            JOptionPane.showMessageDialog(null, mensaje, "Alarma", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_formWindowGainedFocus

    private void jListItemsPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListItemsPMouseClicked
        if(!jListItemsP.isSelectionEmpty()){
            jButtonEliminar.setEnabled(true);
        }
    }//GEN-LAST:event_jListItemsPMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JCheckBox jCheckBoxAlarma;
    private javax.swing.JCheckBox jCheckBoxRecurrente;
    private javax.swing.JComboBox<String> jComboBoxItemsS;
    private javax.swing.JComboBox<String> jComboBoxPersonas;
    private javax.swing.JFormattedTextField jFormattedTextFieldCantidad;
    private javax.swing.JFormattedTextField jFormattedTextFieldDias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDias;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JList<String> jListItemsP;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
